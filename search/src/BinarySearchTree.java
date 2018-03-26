package com.algs4.search;

/**
 * ���ڶ���������ķ��ű�
 * 
 * @author ZhangRui
 * @date 2017��10��25��
 * @time ����1:02:48
 * @param <Key>
 * @param <Value>
 */
public class BinarySearchTree<Key extends Comparable<Key>, Value> {
	public Node root;// ����������ĸ��ڵ�

	/**
	 * �������
	 * 
	 * @author ZhangRui
	 * @date 2017��10��25��
	 * @time ����1:02:23
	 */
	private class Node {
		private Key key; // ��
		private Value value; // ֵ
		private Node left, right; // ָ������������
		private int n; // �Ըýڵ�Ϊ���������еĽ������

		/**
		 * ��㹹����
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
	 * ��ȡ�������н������
	 * 
	 * @return
	 */
	public int size() {
		return size(root);
	}

	/**
	 * ��ȡ���ֵ
	 * 
	 * @param key
	 * @return
	 */
	public Value get(Key key) {
		return get(root, key);
	}

	/**
	 * ���Ҽ����ҵ������ֵ�����򴴽���Ԫ��
	 * 
	 * @param key
	 * @param value
	 */
	public void put(Key key, Value value) {
		root = put(root, key, value);
	}

	/**
	 * ������С��
	 */
	public Key min() {
		return min(root).key;
	}

	/**
	 * С�ڵ���key������
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
	 * ��������Ϊk�Ľ��
	 * 
	 * @param k
	 * @return
	 */
	public Key select(int k) {
		return select(root, k).key;
	}

	/**
	 * ���ظ�����������
	 * 
	 * @param key
	 * @return
	 */
	public int rank(Key key) {
		return rank(root, key);
	}

	/**
	 * ɾ������������е���С���
	 */
	public void delMin() {
		root = delMin(root);
	}

	/**
	 * ɾ�������� ��ָ�򼴽���ɾ���Ľ������ӱ���Ϊtemp ��nodeָ�����ĺ�̽��min��t.right��
	 * ��node��������ָ��delMin��t.right�� ��node����������Ϊt.left��
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
	 * �Ըý��Ϊ���������еĽ�������������ý�㣩
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
	 * ����nodeΪ���ڵ�������в��Ҳ�����key����Ӧ��ֵ ����Ҳ������򷵻�null
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
	 * ���key��������nodeΪ���ڵ�����������������ֵ ������key��valueΪ��ֵ�Ե��½����뵽��������
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
