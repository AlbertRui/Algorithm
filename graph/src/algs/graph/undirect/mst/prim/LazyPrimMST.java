package algs.graph.undirect.mst.prim;

import algs.graph.undirect.weight.Edge;
import algs.graph.undirect.weight.EdgeWeightedGraph;
import algs.util.MinPQ;
import algs.util.Queue;

/**
 * 最小生成树的prim算法的延时实现
 * 现将无效的边保留在优先队列中，
 * 等到再删除他们的时候再检查边的有效性
 *
 * @author AlbertRui
 * @date 2018-04-02 19:46
 */
public class LazyPrimMST {

    private double weight;//最小生成树的总权重
    private boolean[] marked;//最小生成树的顶点
    private Queue<Edge> mst;//最小生成树的边
    private MinPQ<Edge> pq;//横切边（包括失效的边）

    public LazyPrimMST(EdgeWeightedGraph graph) {
        pq = new MinPQ<>();
        marked = new boolean[graph.V()];
        mst = new Queue<>();

        visit(graph, 0);//假设graph是联通的
        while (!pq.isEmpty()) {
            Edge edge = pq.delMin();//从pq中得到权重最小的值
            int v = edge.either();
            int w = edge.other(v);
            //跳过失效的边
            if (marked[v] && marked[w]) {
                continue;
            }
            mst.enqueue(edge);//将边添加到最小生成树中
            weight += edge.getWeight();
            //将顶点v或w添加到树中
            if (!marked[v]) {
                visit(graph, v);
            }
            if (!marked[w]) {
                visit(graph, w);
            }
        }

    }

    /**
     * 标记顶点v，并将连接v和未被标记的顶点的边加入到pq
     *
     * @param graph
     * @param v
     */
    private void visit(EdgeWeightedGraph graph, int v) {
        marked[v] = true;
        for (Edge edge : graph.adj(v)) {
            if (!marked[edge.other(v)]) {
                pq.insert(edge);
            }
        }
    }

    public Iterable<Edge> edges() {
        return mst;
    }

    public double getTotalWeight() {
        return weight;
    }

}
