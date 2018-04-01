package algs.graph.direct;

import algs.util.Bag;

import java.util.Scanner;

/**
 * ����ͼ
 * @author ZhangRui
 * @date 2017��10��31��
 * @time ����5:40:18
 */
public class Digraph {

	private final int V;//������Ŀ
	private int E;//�ߵ���Ŀ
	private Bag<Integer>[] adj;//��ӱ�
	private Scanner in = null;
	
	/**
	 * ����һ������V�����㣬��û�бߵ�����ͼ
	 * @param V
	 */
	@SuppressWarnings("unchecked")
	public Digraph(int V) {
		this.V = V;
		this.E = 0;
		adj = (Bag<Integer>[])new Bag[V];//������ӱ�
		for (int v = 0; v < V; v++) {//�����������ʼ��Ϊ��
			adj[v] = new Bag<Integer>();
		}
	}
	
	/**
	 * ���������ж�ȡһ��ͼ
	 */
	public Digraph() {
		in = new Scanner(System.in);
		this.V = in.nextInt();//��ȡV����ͼ��ʼ��
		this.E = in.nextInt();//��ȡE
		for (int i = 0; i < E; i++) {
			int v = in.nextInt();
			int w = in.nextInt();
			addEdge(v, w);
		}
	}
	
	/**
	 * ������ͼ�����һ��v����w�ı�
	 * @param v
	 * @param w
	 */
	public void addEdge(int v, int w) {
		adj[v].add(w);
		E++;
	}

	/**
	 * ��vָ���ı������ӵ����ж���
	 * @param v
	 * @return
	 */
	public Iterable<Integer> adj(int v) {
		return adj[v];
	}
	
	/**
	 * ��������
	 * @return
	 */
	public int V() {
		return V;
	}
	
	/**
	 * �ߵ�����
	 * @return
	 */
	public int E() {
		return E;
	}
	
	/**
	 * ��ͼ�ķ���ͼ
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
