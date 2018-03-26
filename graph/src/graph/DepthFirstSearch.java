package com.algs4.graph;

/**
 * 深度优先搜索
 * 
 * @author ZhangRui
 * @date 2017年10月28日
 * @time 下午10:59:01
 */
public class DepthFirstSearch {

	private boolean[] marked;
	private int count;

	public DepthFirstSearch(Graph G, int s) {
		marked = new boolean[G.V()];
		dfs(G, s);
	}

	private void dfs(Graph g, int v) {
		marked[v] = true;
		count++;
		for (int w : g.adj(v)) {
			if (!marked[w])
				dfs(g, w);
		}
	}

	/**
	 * v和s是联通的吗？
	 * 
	 * @param w
	 * @return
	 */
	public boolean marked(int w) {
		return marked[w];
	}

	/**
	 * 与s联通的顶点总数
	 * 
	 * @return
	 */
	public int count() {
		return count;
	}
}
