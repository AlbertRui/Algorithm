package com.algs4.graph;

import java.util.Scanner;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

/**
 * 使用深度优先搜索查找图中的路径
 * @author ZhangRui
 * @date 2017年10月28日
 * @time 下午11:28:55
 */
public class DepthFirstPaths {

	private boolean[] marked;//这个顶点上调用过dfs了嘛
	private int[] edgeTo; //从起点到顶点已知路径上的最后一个顶点
	private final int s;//起点
	
	public DepthFirstPaths(Graph G, int s) {
		marked = new boolean[G.V()];
		edgeTo = new int[G.V()];
		this.s = s;
		dfs(G, s);
	}

	/**
	 * 是否调用过dfs嘛
	 * @param v
	 * @return
	 */
	public boolean hasPathTo(int v) {
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
	
	/**
	 * 任意起点v倒w的路径
	 * @param g
	 * @param v
	 */
	private void dfs(Graph g, int v) {

		marked[v] = true;
		for (int w : g.adj(v)) {
			if(!marked[w]) {
				edgeTo[w] = v;
				dfs(g, w);
			}
		}
	}
	
	public static void main(String[] args) {
		Graph G = new Graph();
		Scanner in = new Scanner(System.in);
		System.out.println("请输入起点s:");
		int s = in.nextInt();
		DepthFirstPaths search = new DepthFirstPaths(G, s);
		for (int v = 0; v < G.V(); v++) {
			StdOut.print(s + "to" + v + ":");
			if(search.hasPathTo(v))
				for (int x : search.pathTo(v)) {
					if(x == s)
						StdOut.print(x);
					else
						StdOut.print("-" + x);
				}
			StdOut.println();
		}
		in.close();
	}
}
