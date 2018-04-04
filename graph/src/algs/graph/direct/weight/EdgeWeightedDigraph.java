package algs.graph.direct.weight;

import algs.util.Bag;

/**
 * 加权有向图的数据类型
 *
 * @author AlbertRui
 * @date 2018-04-04 15:41
 */
public class EdgeWeightedDigraph {

    private final int V;//顶点总数
    private int E;//边的总数
    private Bag<DirectedEdge>[] adj;//领接表

    /**
     * 含有v个顶点的空有向图
     *
     * @param V
     */
    public EdgeWeightedDigraph(int V) {
        this.V = V;
        this.E = 0;
        adj = (Bag<DirectedEdge>[]) new Bag[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<>();
        }
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
     * 将edge添加到该有向图中
     *
     * @param edge
     */
    public void addEdge(DirectedEdge edge) {
        adj[edge.from()].add(edge);
        E++;
    }

    /**
     * 从v指出的边
     *
     * @param v
     * @return
     */
    public Iterable<DirectedEdge> adj(int v) {
        return adj[v];
    }

    /**
     * 该有向图中的所有边
     *
     * @return
     */
    public Iterable<DirectedEdge> edges() {
        Bag<DirectedEdge> edges = new Bag<>();
        for (int v = 0; v < V; v++) {
            for (DirectedEdge edge : adj[v]) {
                edges.add(edge);
            }
        }
        return edges;
    }

}
