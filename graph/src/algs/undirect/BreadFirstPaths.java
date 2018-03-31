package algs.undirect;

import algs.util.Queue;
import algs.util.Stack;

/**
 * 广度优先搜索
 * @author ZhangRui
 * @date 2017年10月29日
 * @time 下午12:46:13
 */
public class BreadFirstPaths {

	private boolean[] marked;//到达该丁点的最短路径已知吗？
	private int[] edgeTo;//到达该顶点的已知路径上的最后一个顶点
	private final int s;//起点

	public BreadFirstPaths(Graph G, int s) {
		marked = new boolean[G.V()];
		edgeTo = new int[G.V()];
		this.s = s;
		bfs(G, s);
	}

	private void bfs(Graph g, int s) {
		Queue<Integer> queue = new Queue<Integer>();
		marked[s] = true;//标记起点
		queue.enqueue(s);// 将它加入队列
		while(!queue.isEmpty()) {
			int v = queue.dequeue(); //从队列中删去下一个顶点
			for (int w : g.adj(v)) {
				if(!marked[w]) {//对于每个未被标记的响铃顶点
					edgeTo[w] = v;//保存最短路径的最后一条边
					marked[w] = true;//标记他，因为最短路径已知
					queue.enqueue(w);//并将它添加到队列中
				}
			}
		}
	}

	public boolean hasPathTo(int v){
		return marked[v];
	}

	public Iterable<Integer> pathTo(int v) {
		if(!hasPathTo(v))
			return null;
		Stack<Integer> path = new Stack<Integer>();
		for (int x = v; x != s; x = edgeTo[x]) {
			path.push(x);
		}
		path.push(s);
		return path;
	}
}