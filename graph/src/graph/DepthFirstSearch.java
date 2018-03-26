package com.algs4.graph;

/**
 * �����������
 * 
 * @author ZhangRui
 * @date 2017��10��28��
 * @time ����10:59:01
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
	 * v��s����ͨ����
	 * 
	 * @param w
	 * @return
	 */
	public boolean marked(int w) {
		return marked[w];
	}

	/**
	 * ��s��ͨ�Ķ�������
	 * 
	 * @return
	 */
	public int count() {
		return count;
	}
}
