package algs.graph.undirect.mst.kruskal;

import algs.graph.undirect.weight.Edge;
import algs.graph.undirect.weight.EdgeWeightedGraph;
import algs.util.MinPQ;
import algs.util.Queue;

/**
 * 最小生成树的Kruskal算法
 *
 * @author AlbertRui
 * @date 2018-04-02 22:46
 */
public class KruskalMST {

    private Queue<Edge> mst;
    public KruskalMST(EdgeWeightedGraph graph) {
        mst = new Queue<>();
        MinPQ<Edge> pq = new MinPQ<>();
        for (Edge edge : graph.edges()) {
            pq.insert(edge);
        }
    }

}
