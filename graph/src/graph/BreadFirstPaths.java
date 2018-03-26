package com.algs4.graph;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;

/**
 * �����������
 * @author ZhangRui
 * @date 2017��10��29��
 * @time ����12:46:13
 */
public class BreadFirstPaths {

	private boolean[] marked;//����ö�������·����֪��
	private int[] edgeTo;//����ö������֪·���ϵ����һ������
	private final int s;//���
	
	public BreadFirstPaths(Graph G, int s) {
		marked = new boolean[G.V()];
		edgeTo = new int[G.V()];
		this.s = s;
		bfs(G, s);
	}

	private void bfs(Graph g, int s) {
		Queue<Integer> queue = new Queue<Integer>();
		marked[s] = true;//������
		queue.enqueue(s);// �����������
		while(!queue.isEmpty()) {
			int v = queue.dequeue(); //�Ӷ�����ɾȥ��һ������
			for (int w : g.adj(v)) {
				if(!marked[w]) {//����ÿ��δ����ǵ����嶥��
					edgeTo[w] = v;//�������·�������һ����
					marked[w] = true;//���������Ϊ���·����֪
					queue.enqueue(w);//��������ӵ�������
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
