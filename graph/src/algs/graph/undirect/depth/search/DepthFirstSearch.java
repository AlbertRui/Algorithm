package algs.graph.undirect.depth.search;

import algs.graph.undirect.Graph;

/**
 * 深度优先搜索
 * 遍历包含s节点的所有路径
 *
 * @author ZhangRui
 * @date 2017年10月28日
 * @time 下午10:59:01
 */
public class DepthFirstSearch {

    private boolean[] marked;
    private int count;//节点访问计数器

    public DepthFirstSearch(Graph G, int s) {
        marked = new boolean[G.V()];
        dfs(G, s);
    }

    private void dfs(Graph g, int v) {
        marked[v] = true;
        count++;
        for (int w : g.adj(v)) {
            //如果没有访问过w节点，就以w节点为顶点进行递归搜索
            if (!marked[w])
                dfs(g, w);
        }
    }

    /**
     * 标记访问过的节点
     *
     * @param w
     * @return
     */
    public boolean marked(int w) {
        return marked[w];
    }

    /**
     * 与s联通的顶点总数（包括s）
     *
     * @return
     */
    public int count() {
        return count;
    }
}