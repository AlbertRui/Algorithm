package com.algs4.graph;

import java.util.Scanner;

import edu.princeton.cs.algs4.Bag;

/**
 * 建立一个图
 * @author ZhangRui
 * @date 2017年10月28日
 * @time 下午11:03:27
 */
public class Graph {

	private int V; //顶点数目
	private int E;//边的数目
	private Bag<Integer>[] adj;//领接表
	
	/**
	 * 创建一个含有V个结点但不含有边的图
	 * @param V
	 */
	@SuppressWarnings("unchecked")
	public Graph(int V) {
		this.V = V;
		this.E = 0;
		adj = (Bag<Integer>[]) new Bag[V];//创建领接表
		for (int v = 0; v < V; v++) {//将所有领接表初始化为空
			adj[v] = new Bag<Integer>();
		}
	}
	
	/**
	 * 从标准输入流In读入一幅图
	 * @param in
	 */
	@SuppressWarnings({ "unchecked", "resource" })
	public Graph() {
		Scanner in = new Scanner(System.in);
		System.out.println("读取v并将图初始化");
		this.V = in.nextInt();//读取V并将图初始化
		adj = (Bag<Integer>[]) new Bag[V];//创建领接表
		for (int v = 0; v < V; v++) {//将所有领接表初始化为空
			adj[v] = new Bag<Integer>();
		}
		System.out.println("读取E");
		int E = in.nextInt();//读取E
		for (int i = 0; i < E; i++) {
			System.out.println("读取一个顶点");
			int v = in.nextInt();//读取一个顶点
			System.out.println("读取另一个顶点");
			int w = in.nextInt();//读取另一个顶点
			addEdge(v, w);//添加一条连接他们的边
		}
	}
	
	/**
	 * 顶点数
	 * @return
	 */
	public int V() {
		return V;
	}
	
	/**
	 * 边数
	 * @return
	 */
	public int E() {
		return E;
	}
	
	/**
	 * 向图中添加一条边v-w
	 * @param v
	 * @param w
	 */
	public void addEdge(int v, int w) {
		adj[v].add(w);//将w添加到v的链表中
		adj[w].add(v);//将v添加到w的链表中
		E++;
	}
	
	/**
	 * 和v相邻的所有顶点
	 * @param v
	 * @return
	 */
	public Iterable<Integer> adj(int v) {
		return adj[v];
	}
}

