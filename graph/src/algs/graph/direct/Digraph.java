package algs.graph.direct;

import algs.util.Bag;

import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * 有向图
 *
 * @author ZhangRui
 * @date 2017年10月31日
 * @time 下午5:40:18
 */
@SuppressWarnings("ALL")
public class Digraph {

    private final int V;//顶点数目
    private int E;//边的数目
    private Bag<Integer>[] adj;//领接表
    private int[] indegree;//indegree[v]指节点v的入度

    /**
     * 创建一个含有V个顶点，单没有边的有向图
     *
     * @param V
     */
    public Digraph(int V) {
        this.V = V;
        this.E = 0;
        adj = (Bag<Integer>[]) new Bag[V];//创建领接表
        for (int v = 0; v < V; v++) {//经所有链表初始化为空
            adj[v] = new Bag<Integer>();
        }
    }

    /**
     * Initializes a digraph from the specified input stream.
     * The format is the number of vertices <em>V</em>,
     * followed by the number of edges <em>E</em>,
     * followed by <em>E</em> pairs of vertices, with each entry separated by whitespace.
     *
     * @param in the input stream
     * @throws IllegalArgumentException if the endpoints of any edge are not in prescribed range
     * @throws IllegalArgumentException if the number of vertices or edges is negative
     * @throws IllegalArgumentException if the input stream is in the wrong format
     */
    public Digraph(Scanner scanner) {
        try {
            this.V = scanner.nextInt();
            if (V < 0) throw new IllegalArgumentException("number of vertices in a Digraph must be nonnegative");
            indegree = new int[V];
            adj = (Bag<Integer>[]) new Bag[V];
            for (int v = 0; v < V; v++) {
                adj[v] = new Bag<Integer>();
            }
            int E = scanner.nextInt();
            if (E < 0) throw new IllegalArgumentException("number of edges in a Digraph must be nonnegative");
            for (int i = 0; i < E; i++) {
                int v = scanner.nextInt();
                int w = scanner.nextInt();
                addEdge(v, w);
            }
        } catch (NoSuchElementException e) {
            throw new IllegalArgumentException("invalid input format in Digraph constructor", e);
        }
    }

    /**
     * 从控制台中中读取一幅图
     */
    public Digraph() {
        Scanner in = new Scanner(System.in);
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
     *
     * @param v
     * @param w
     */
    public void addEdge(int v, int w) {
        adj[v].add(w);
        indegree[w]++;
        E++;
    }

    /**
     * 由v指出的边所连接的所有顶点
     *
     * @param v
     * @return
     */
    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    /**
     * 顶点总数
     *
     * @return
     */
    public int V() {
        return V;
    }

    /**
     * 边的总数
     *
     * @return
     */
    public int E() {
        return E;
    }

    /**
     * 该图的反向图
     *
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
