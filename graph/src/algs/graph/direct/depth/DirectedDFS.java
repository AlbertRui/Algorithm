package algs.graph.direct.depth;

import algs.graph.direct.Digraph;

/**
 * 有向图的可达性
 *
 * @author AlbertRui
 * @date 2018-04-01 22:45
 */
public class DirectedDFS {

    private boolean[] marked;

    public DirectedDFS(Digraph digraph, int s) {
        marked = new boolean[digraph.V()];
        dfs(digraph, s);
    }

    public DirectedDFS(Digraph digraph, Iterable<Integer> sources) {
        marked = new boolean[digraph.V()];
        for (int s : sources) {
            if (!marked[s]) {
                dfs(digraph, s);
            }
        }
    }

    private void dfs(Digraph digraph, int v) {
        marked[v] = true;
        for (int w : digraph.adj(v)) {
            if (!marked[w]) {
                dfs(digraph, w);
            }
        }
    }

    public boolean marked(int v) {
        return marked[v];
    }

}
