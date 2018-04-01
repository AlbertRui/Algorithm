package algs.graph.undirect.depth.cc;

import algs.graph.undirect.Graph;

/**
 * 基于深度优先搜索，找出一幅图中的所有连通分量
 *
 * @author AlbertRui
 * @date 2018-04-01 20:06
 */
public class ConnectedComponent {

    private boolean[] marked;//标记是否被访问过
    private int[] id;//保存连通分量的数组(在同一个连通分量中的元素的id值相同)
    private int count;//连通分量的个数

    public ConnectedComponent(Graph graph) {
        marked = new boolean[graph.V()];
        id = new int[graph.V()];
        for (int s = 0; s < graph.V(); s++) {
            if (!marked[s]) {
                dfs(graph, s);
                count++;
            }
        }
    }

    private void dfs(Graph graph, int v) {
        marked[v] = true;
        id[v] = count;
        for (int w : graph.adj(v)) {
            if (!marked[w]) {
                dfs(graph, w);
            }
        }
    }

    public boolean connected(int v, int w) {
        return id[v] == id[w];
    }

    public int id(int v) {
        return id[v];
    }

    public int getCount() {
        return count;
    }

}
