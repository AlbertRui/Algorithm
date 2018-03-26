package com.algs4.search;

/**
 * 基于二叉查找树的符号表
 * 
 * @author ZhangRui
 * @date 2017年10月25日
 * @time 下午1:02:48
 * @param <Key>
 * @param <Value>
 */
public class BinarySearchTree<Key extends Comparable<Key>, Value> {
	public Node root;// 二叉查找树的根节点

	/**
	 * 建立结点
	 * 
	 * @author ZhangRui
	 * @date 2017年10月25日
	 * @time 下午1:02:23
	 */
	private class Node {
		private Key key; // 键
		private Value value; // 值
		private Node left, right; // 指向子树的链接
		private int n; // 以该节点为根的子树中的结点总数

		/**
		 * 结点构造器
		 * 
		 * @param key
		 * @param value
		 * @param n
		 */
		public Node(Key key, Value value, int n) {
			this.key = key;
			this.value = value;
			this.n = n;
		}
	}

	/**
	 * 获取二叉树中结点总数
	 * 
	 * @return
	 */
	public int size() {
		return size(root);
	}

	/**
	 * 获取结点值
	 * 
	 * @param key
	 * @return
	 */
	public Value get(Key key) {
		return get(root, key);
	}

	/**
	 * 查找键，找到则更新值，否则创建新元素
	 * 
	 * @param key
	 * @param value
	 */
	public void put(Key key, Value value) {
		root = put(root, key, value);
	}

	/**
	 * 查找最小键
	 */
	public Key min() {
		return min(root).key;
	}

	/**
	 * 小于等于key的最大键
	 * 
	 * @param key
	 * @return
	 */
	public Key floor(Key key) {
		Node node = floor(root, key);
		if (node == null)
			return null;
		return node.key;
	}

	/**
	 * 返回排名为k的结点
	 * 
	 * @param k
	 * @return
	 */
	public Key select(int k) {
		return select(root, k).key;
	}

	/**
	 * 返回给定键的排名
	 * 
	 * @param key
	 * @return
	 */
	public int rank(Key key) {
		return rank(root, key);
	}

	/**
	 * 删除二叉查找树中的最小结点
	 */
	public void delMin() {
		root = delMin(root);
	}

	/**
	 * 删除结点操作 将指向即将被删除的结点的链接保存为temp 将node指向它的后继结点min（t.right）
	 * 将node的右链接指向delMin（t.right） 将node的左链接设为t.left。
	 * 
	 * @param key
	 */
	public void delete(Key key) {
		root = delete(root, key);
	}

	private Node delete(Node node, Key key) {
		if (node == null)
			return null;
		int cmp = key.compareTo(node.key);
		if (cmp < 0)
			node.left = delete(node.left, key);
		else if (cmp > 0)
			node.right = delete(node.right, key);
		else {
			if (node.left == null)
				return node.right;
			if (node.right == null)
				return node.left;
			Node temp = node;
			node = min(temp.right);
			node.right = delMin(temp.right);
			node.left = temp.left;
		}
		node.n = size(node.left) + size(node.right) + 1;
		return node;
	}

	private Node delMin(Node node) {
		if (node.left == null)
			return node.right;
		node.left = delMin(node.left);
		node.n = size(node.left) + size(node.right) + 1;
		return node;
	}

	private int rank(Node node, Key key) {
		if (node == null)
			return 0;
		int cmp = key.compareTo(node.key);
		if (cmp < 0)
			return rank(node.left, key);
		else if (cmp > 0)
			return 1 + size(node.left) + rank(node.right, key);
		else
			return size(node.left);
	}

	private Node select(Node node, int k) {
		if (node == null)
			return null;
		int t = size(node.left);
		if (t > k)
			return select(node.left, k);
		else if (t < k)
			return select(node.right, k - t - 1);
		else
			return node;
	}

	private Node floor(Node node, Key key) {
		if (node == null)
			return null;
		int cmp = key.compareTo(node.key);
		if (cmp == 0)
			return node;
		if (cmp < 0)
			return floor(node.left, key);
		Node t = floor(node.right, key);
		if (t != null)
			return t;
		else
			return node;
	}

	private Node min(Node node) {
		if (node.left == null)
			return null;
		return min(node.left);
	}

	/**
	 * 以该结点为根的子树中的结点总数（包括该结点）
	 * 
	 * @param node
	 * @return
	 */
	private int size(Node node) {
		if (node == null)
			return 0;
		else
			return node.n;
	}

	/**
	 * 在以node为根节点的子树中查找并返回key所对应的值 如果找不到，则返回null
	 * 
	 * @param node
	 * @param key
	 * @return
	 */
	private Value get(Node node, Key key) {
		if (node == null)
			return null;
		int cmp = key.compareTo(node.key);
		if (cmp < 0)
			return get(node.left, key);
		else if (cmp > 0)
			return get(node.right, key);
		else
			return node.value;
	}

	/**
	 * 如果key存在于以node为根节点的子树中则更新它的值 否则将以key和value为键值对的新结点插入到该子树中
	 * 
	 * @param node
	 * @param key
	 * @param value
	 * @return
	 */
	private Node put(Node node, Key key, Value value) {
		if (node == null)
			return new Node(key, value, 1);
		int cmp = key.compareTo(node.key);
		if (cmp < 0)
			node.left = put(node.left, key, value);
		else if (cmp > 0)
			node.right = put(node.right, key, value);
		else
			node.value = value;
		node.n = size(node.left) + size(node.right) + 1;
		return node;
	}

}
