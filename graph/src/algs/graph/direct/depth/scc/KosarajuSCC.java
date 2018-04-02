package algs.graph.direct.depth.scc;

import algs.graph.direct.Digraph;
import algs.graph.direct.depth.order.DepathFirstOrder;

/**
 * 计算强连通分量的kosaraju算法
 *
 * @author AlbertRui
 * @date 2018-04-02 11:03
 */
public class KosarajuSCC {

    private boolean[] marked;
    private int[] id;
    private int count;

    public KosarajuSCC(Digraph digraph) {
        marked = new boolean[digraph.V()];
        id = new int[digraph.V()];
        DepathFirstOrder order = new DepathFirstOrder(digraph.reverse());
        for (int s : order.reversePost()) {
            if (!marked[s]) {
                dfs(digraph, s);
                count++;
            }
        }
    }

    private void dfs(Digraph digraph, int v) {
        marked[v] = true;
        id[v] = count;
        for (int w : digraph.adj(v)) {
            if (!marked[w]) {
                dfs(digraph, w);
            }
        }
    }

    public boolean stronglyConnected(int v, int w) {
        return id[v] == id[w];
    }

    public int id(int v) {
        return id[v];
    }

    public int count() {
        return count;
    }

}
