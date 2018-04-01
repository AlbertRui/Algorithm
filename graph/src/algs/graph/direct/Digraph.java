package algs.graph.direct;

import algs.util.Bag;

import java.util.Scanner;

/**
 * 有向图
 * @author ZhangRui
 * @date 2017年10月31日
 * @time 下午5:40:18
 */
public class Digraph {

	private final int V;//顶点数目
	private int E;//边的数目
	private Bag<Integer>[] adj;//领接表
	private Scanner in = null;
	
	/**
	 * 创建一个含有V个顶点，单没有边的有向图
	 * @param V
	 */
	@SuppressWarnings("unchecked")
	public Digraph(int V) {
		this.V = V;
		this.E = 0;
		adj = (Bag<Integer>[])new Bag[V];//创建领接表
		for (int v = 0; v < V; v++) {//经所有链表初始化为空
			adj[v] = new Bag<Integer>();
		}
	}
	
	/**
	 * 在输入流中读取一幅图
	 */
	public Digraph() {
		in = new Scanner(System.in);
		this.V = in.nextInt();//读取V并将图初始化
		this.E = in.nextInt();//读取E
		for (int i = 0; i < E; i++) {
			int v = in.nextInt();
			int w = in.nextInt();
			addEdge(v, w);
		}
	}
	
	/**
	 * 享有向图中添加一条v——w的边
	 * @param v
	 * @param w
	 */
	public void addEdge(int v, int w) {
		adj[v].add(w);
		E++;
	}

	/**
	 * 由v指出的边所连接的所有顶点
	 * @param v
	 * @return
	 */
	public Iterable<Integer> adj(int v) {
		return adj[v];
	}
	
	/**
	 * 顶点总数
	 * @return
	 */
	public int V() {
		return V;
	}
	
	/**
	 * 边的总数
	 * @return
	 */
	public int E() {
		return E;
	}
	
	/**
	 * 该图的反向图
	 * @return
	 */
	public Digraph reverse() {
		Digraph R = new Digraph(V);
		for (int v = 0; v < V; v++) {
			for (int w : adj[v]) {
				R.addEdge(w, v);
			}
		}
		return R;
	}
}
