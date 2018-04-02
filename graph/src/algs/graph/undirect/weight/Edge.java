package algs.graph.undirect.weight;

/**
 * 带权重的边
 *
 * @author AlbertRui
 * @date 2018-04-02 17:34
 */
public class Edge implements Comparable<Edge> {

    private final int v;//顶点之一
    private final int w;//另一个顶点
    private final double weight;//边的权重

    public Edge(int v, int w, int weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public int either() {
        return v;
    }

    public int other(int vertex) {
        if (vertex == v) {
            return w;
        } else if (vertex == w) {
            return v;
        } else {
            throw new RuntimeException("inconsistent edge");
        }
    }

    @Override
    public int compareTo(Edge that) {
        return Double.compare(this.getWeight(), that.getWeight());
    }

    @Override
    public String toString() {
        return String.format("%d-%d %.2f", v, w, weight);
    }

}
