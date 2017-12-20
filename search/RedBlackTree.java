package com.algs4.search;

/**
 * 红黑二叉查找树
 * 
 * @author ZhangRui
 * @date 2017年10月27日
 * @time 下午9:31:58
 * @param <Key>
 * @param <Value>
 */
public class RedBlackTree<Key extends Comparable<Key>, Value> {

	private static final boolean RED = true;
	private static final boolean BLACK = false;

	private Node root;

	/**
	 * 定义结点
	 * 
	 * @author ZhangRui
	 * @date 2017年10月27日
	 * @time 下午9:31:38
	 */
	private class Node {
		Key key;
		@SuppressWarnings("unused")
		Value value;
		Node left, right;
		int n;
		boolean color;

		/**
		 * 节点构造器
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
	 * 获取结点总数
	 * 
	 * @return
	 */
	public int size() {
		return size(root);
	}

	/**
	 * 查找key，找到则更新其值，否则为他创建一个新的结点
	 * 
	 * @param key
	 * @param value
	 */
	public void put(Key key, Value value) {
		root = put(root, key, value);
		root.color = BLACK;
	}

	private Node put(Node node, Key key, Value value) {
		if (node == null) // 标准的插入操作，和父节点用红链接相连
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
	 * 左旋转h的右链接
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
	 * 有旋转h的左链接
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
	 * 颜色转换
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
