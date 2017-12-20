package com.algs4.search;

/**
 * ��ڶ��������
 * 
 * @author ZhangRui
 * @date 2017��10��27��
 * @time ����9:31:58
 * @param <Key>
 * @param <Value>
 */
public class RedBlackTree<Key extends Comparable<Key>, Value> {

	private static final boolean RED = true;
	private static final boolean BLACK = false;

	private Node root;

	/**
	 * ������
	 * 
	 * @author ZhangRui
	 * @date 2017��10��27��
	 * @time ����9:31:38
	 */
	private class Node {
		Key key;
		@SuppressWarnings("unused")
		Value value;
		Node left, right;
		int n;
		boolean color;

		/**
		 * �ڵ㹹����
		 * 
		 * @param key
		 * @param value
		 * @param n
		 * @param color
		 */
		public Node(Key key, Value value, int n, boolean color) {
			this.key = key;
			this.value = value;
			this.n = n;
			this.color = color;
		}
	}

	/**
	 * ��ȡ�������
	 * 
	 * @return
	 */
	public int size() {
		return size(root);
	}

	/**
	 * ����key���ҵ��������ֵ������Ϊ������һ���µĽ��
	 * 
	 * @param key
	 * @param value
	 */
	public void put(Key key, Value value) {
		root = put(root, key, value);
		root.color = BLACK;
	}

	private Node put(Node node, Key key, Value value) {
		if (node == null) // ��׼�Ĳ���������͸��ڵ��ú���������
			return new Node(key, value, 1, RED);
		int cmp = key.compareTo(node.key);
		if (cmp < 0)
			node.left = put(node.left, key, value);
		else if (cmp > 0)
			node.right = put(node.right, key, value);
		else
			node.value = value;
		if (isRed(node.right) && !isRed(node.left))
			node = rotateLeft(node);
		if (isRed(node.left) && isRed(node.left.left))
			node = rotateRight(node);
		if (isRed(node.left) && isRed(node.right))
			flipColors(node);
		node.n = size(node.left) + size(node.right) + 1;
		return node;
	}

	/**
	 * ����תh��������
	 * 
	 * @param h
	 * @return
	 */
	private Node rotateLeft(Node h) {
		Node node = h.right;
		h.right = node.left;
		node.left = h;
		node.color = h.color;
		node.n = h.n;
		h.n = size(h.left) + size(h.right) + 1;
		return node;
	}

	/**
	 * ����תh��������
	 * 
	 * @param h
	 * @return
	 */
	private Node rotateRight(Node h) {
		Node node = h.left;
		h.left = node.right;
		node.right = h;
		node.color = h.color;
		node.n = h.n;
		h.n = size(h.left) + size(h.right) + 1;
		return node;
	}

	/**
	 * ��ɫת��
	 * 
	 * @param h
	 */
	private void flipColors(Node h) {
		h.color = RED;
		h.left.color = BLACK;
		h.right.color = BLACK;
	}

	private int size(Node node) {
		if (node == null)
			return 0;
		else
			return node.n;
	}

	private boolean isRed(Node node) {
		if (node == null)
			return false;
		return node.color == RED;
	}

}
