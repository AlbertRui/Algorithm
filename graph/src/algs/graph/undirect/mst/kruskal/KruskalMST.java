package algs.graph.undirect.mst.kruskal;

import algs.graph.undirect.weight.Edge;
import algs.graph.undirect.weight.EdgeWeightedGraph;
import algs.util.MinPQ;
import algs.util.Queue;
import algs.util.UnionFind;

/**
 * 最小生成树的Kruskal算法
 *
 * @author AlbertRui
 * @date 2018-04-02 22:46
 */
public class KruskalMST {

    private double weight;
    private Queue<Edge> mst;

    public KruskalMST(EdgeWeightedGraph graph) {
        mst = new Queue<>();
        MinPQ<Edge> pq = new MinPQ<>();
        for (Edge edge : graph.edges()) {
            pq.insert(edge);
        }
        UnionFind unionFind = new UnionFind(graph.V());

        while (!pq.isEmpty() && mst.size() < graph.V() - 1) {
            //从pq中得到权重最小的边和它的顶点
            Edge edge = pq.delMin();
            int v = edge.either();
            int w = edge.other(v);
            if (unionFind.connected(v, w)) {
                continue;//忽略失效的边
            }
            unionFind.union(v, w);//合并分量
            mst.enqueue(edge);//将边添加到最小生成树中
            weight += edge.getWeight();
        }
    }

    public Iterable<Edge> edges() {
        return mst;
    }

    public double getTotalWeight() {
        return weight;
    }

}
