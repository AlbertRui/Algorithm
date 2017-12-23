package com.algs4.graph;

import java.util.Scanner;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

/**
 * ʹ�����������������ͼ�е�·��
 * @author ZhangRui
 * @date 2017��10��28��
 * @time ����11:28:55
 */
public class DepthFirstPaths {

	private boolean[] marked;//��������ϵ��ù�dfs����
	private int[] edgeTo; //����㵽������֪·���ϵ����һ������
	private final int s;//���
	
	public DepthFirstPaths(Graph G, int s) {
		marked = new boolean[G.V()];
		edgeTo = new int[G.V()];
		this.s = s;
		dfs(G, s);
	}

	/**
	 * �Ƿ���ù�dfs��
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
	 * �������v��w��·��
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
		System.out.println("���������s:");
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
