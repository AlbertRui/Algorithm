package algs.graph.undirect.mst.prim;

import algs.graph.undirect.weight.Edge;
import algs.graph.undirect.weight.EdgeWeightedGraph;
import algs.util.IndexMinPQ;
import algs.util.Queue;

/**
 * 最小生成树的prim算法
 *
 * @author AlbertRui
 * @date 2018-04-02 21:46
 */
public class PrimMST {

    private Edge[] edgeTo;//距离书最近的边
    private double[] distTo;//distTo[w] = edgeTo[w].weight();
    private boolean[] marked;//如果v在树中则为true
    private IndexMinPQ<Double> pq;//有效的横切边

    public PrimMST(EdgeWeightedGraph graph) {
        edgeTo = new Edge[graph.V()];
        distTo = new double[graph.V()];
        marked = new boolean[graph.V()];
        for (int v = 0; v < graph.V(); v++) {
            distTo[v] = Double.POSITIVE_INFINITY;
        }
        pq = new IndexMinPQ<>(graph.V());

        //用顶点零和权重零初始化pq
        distTo[0] = 0.0;
        pq.insert(0, 0.0);

        while (!pq.isEmpty()) {
            visit(graph, pq.delMin());//将最近的顶点添加到树中
        }
    }

    /**
     * 将顶点v添加到树中，更新数据
     *
     * @param graph
     * @param v
     */
    private void visit(EdgeWeightedGraph graph, int v) {
        marked[v] = true;
        for (Edge edge : graph.adj(v)) {
            int w = edge.other(v);
            //v-w失效
            if (marked[v]) {
                continue;
            }
            //连接w和树的最佳边Edge变为edge
            if (edge.getWeight() < distTo[w]) {
                edgeTo[w] = edge;

                distTo[w] = edge.getWeight();
                if (pq.contains(w)) {
                    pq.change(w, distTo[w]);
                } else {
                    pq.insert(w, distTo[w]);
                }
            }
        }
    }

    /**
     * Returns the edges in a minimum spanning tree (or forest).
     *
     * @return the edges in a minimum spanning tree (or forest) as
     * an iterable of edges
     */
    public Iterable<Edge> edges() {
        Queue<Edge> mst = new Queue<Edge>();
        for (int v = 0; v < edgeTo.length; v++) {
            Edge e = edgeTo[v];
            if (e != null) {
                mst.enqueue(e);
            }
        }
        return mst;
    }

    public double getTotalWeight() {
        double weight = 0.0;
        for (Edge edge : edges())
            weight += edge.getWeight();
        return weight;
    }

}
