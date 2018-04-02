package algs.graph.direct.depth.order.topo;

import algs.graph.direct.Digraph;
import algs.graph.direct.depth.cycle.DirectedCycle;
import algs.graph.direct.depth.order.DepathFirstOrder;

/**
 * 拓扑排序
 *
 * @author AlbertRui
 * @date 2018-04-02 10:12
 */
public class Topological {

    //顶点的拓扑排序
    public Iterable<Integer> order;

    public Topological(Digraph digraph) {
        DirectedCycle cyclefinder = new DirectedCycle(digraph);
        if (!cyclefinder.hasCycle()) {
            order = new DepathFirstOrder(digraph).reversePost();
        }
    }

    public Iterable<Integer> getOrder() {
        return order;
    }

    /**
     * 判断是不是有向无环图
     *
     * @return
     */
    public boolean isDAG() {
        return order != null;
    }

}
