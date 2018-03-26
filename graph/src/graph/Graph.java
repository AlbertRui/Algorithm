package com.algs4.graph;

import java.util.Scanner;

import edu.princeton.cs.algs4.Bag;

/**
 * ����һ��ͼ
 * @author ZhangRui
 * @date 2017��10��28��
 * @time ����11:03:27
 */
public class Graph {

	private int V; //������Ŀ
	private int E;//�ߵ���Ŀ
	private Bag<Integer>[] adj;//��ӱ�
	
	/**
	 * ����һ������V����㵫�����бߵ�ͼ
	 * @param V
	 */
	@SuppressWarnings("unchecked")
	public Graph(int V) {
		this.V = V;
		this.E = 0;
		adj = (Bag<Integer>[]) new Bag[V];//������ӱ�
		for (int v = 0; v < V; v++) {//��������ӱ��ʼ��Ϊ��
			adj[v] = new Bag<Integer>();
		}
	}
	
	/**
	 * �ӱ�׼������In����һ��ͼ
	 * @param in
	 */
	@SuppressWarnings({ "unchecked", "resource" })
	public Graph() {
		Scanner in = new Scanner(System.in);
		System.out.println("��ȡv����ͼ��ʼ��");
		this.V = in.nextInt();//��ȡV����ͼ��ʼ��
		adj = (Bag<Integer>[]) new Bag[V];//������ӱ�
		for (int v = 0; v < V; v++) {//��������ӱ��ʼ��Ϊ��
			adj[v] = new Bag<Integer>();
		}
		System.out.println("��ȡE");
		int E = in.nextInt();//��ȡE
		for (int i = 0; i < E; i++) {
			System.out.println("��ȡһ������");
			int v = in.nextInt();//��ȡһ������
			System.out.println("��ȡ��һ������");
			int w = in.nextInt();//��ȡ��һ������
			addEdge(v, w);//���һ���������ǵı�
		}
	}
	
	/**
	 * ������
	 * @return
	 */
	public int V() {
		return V;
	}
	
	/**
	 * ����
	 * @return
	 */
	public int E() {
		return E;
	}
	
	/**
	 * ��ͼ�����һ����v-w
	 * @param v
	 * @param w
	 */
	public void addEdge(int v, int w) {
		adj[v].add(w);//��w��ӵ�v��������
		adj[w].add(v);//��v��ӵ�w��������
		E++;
	}
	
	/**
	 * ��v���ڵ����ж���
	 * @param v
	 * @return
	 */
	public Iterable<Integer> adj(int v) {
		return adj[v];
	}
}

