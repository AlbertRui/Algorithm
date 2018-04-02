package algs.graph.direct.depth.cycle;

import algs.graph.direct.Digraph;
import algs.util.Stack;

/**
 * 寻找有向环
 *
 * @author AlbertRui
 * @date 2018-04-02 9:20
 */
public class DirectedCycle {

    private boolean[] marked;
    private boolean[] onStack;//递归调用栈，保存相反的路径
    private int[] edgeTo;
    private Stack<Integer> cycle;

    public DirectedCycle(Digraph digraph) {
        onStack = new boolean[digraph.V()];
        marked = new boolean[digraph.V()];
        edgeTo = new int[digraph.V()];
        for (int v = 0; v < digraph.V(); v++) {
            if (!marked[v]) {
                dfs(digraph, v);
            }
        }
    }

    private void dfs(Digraph digraph, int v) {
        onStack[v] = true;
        marked[v] = true;//相当于入栈
        for (int w : digraph.adj(v)) {
            if (this.hasCycle()) {
                return;
            } else if (!marked[w]) {
                edgeTo[w] = v;
                dfs(digraph, w);
            } else if (onStack[w]) {
                cycle = new Stack<>();
                for (int x = v; x != w; x = edgeTo[x]) {
                    cycle.push(x);
                }
                cycle.push(w);
                cycle.push(v);
            }
        }
        onStack[v] = false;//相当于出栈
    }

    public boolean hasCycle() {
        return cycle != null;
    }

    public Iterable<Integer> cycle() {
        return cycle;
    }

}
