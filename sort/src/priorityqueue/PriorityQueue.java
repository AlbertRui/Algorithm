package com.algs4.priorityqueue;

/**
 * 基于二叉堆的优先队列，根节点的值最大
 * 
 * @author ZhangRui
 * @date 2017年10月23日
 * @time 下午8:40:55
 * @param <Key>
 */
public class PriorityQueue<Key extends Comparable<Key>> {

	private Key[] pq;
	private int size;

	/**
	 * 创建一个优先队列，默认初始容量为1
	 */
	public PriorityQueue() {
		this(1);
	}

	/**
	 * 创建一个容量为maxSize的优先队列,二叉堆实现
	 * 
	 * @param maxSize
	 */
	@SuppressWarnings("unchecked")
	public PriorityQueue(int maxSize) {
		pq = (Key[]) new Object[maxSize + 1];
		size = 0;
	}

	/**
	 * 返回队列是否为空
	 * 
	 * @return
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * 返回优先队列中的元素个数
	 * 
	 * @return
	 */
	public int size() {
		return size;
	}

	/**
	 * 向优先队列中插入元素，默认在最右边的孩子插入
	 * 
	 * @param v
	 */
	public void insert(Key v) {
		pq[++size] = v;
		swim(size);
	}

	/**
	 * 删除并返回最大元素
	 * 
	 * @return
	 */
	public Key delMax() {
		Key max = pq[1];
		exch(1, size--);
		pq[size + 1] = null;
		sink(1);
		return max;
	}

	/**
	 * 元素下沉
	 * 
	 * @param k
	 */
	private void sink(int k) {
		while (2 * k <= size) {
			int j = 2 * k;
			if (j < size && less(j, j + 1)) {
				j++;
			}
			if (!less(k, j)) {
				break;
			}
			exch(k, j);
			k = j;
		}
	}

	/**
	 * 元素上浮
	 * 
	 * @param k
	 */
	private void swim(int k) {
		while (k > 1 && less(k / 2, k)) {
			exch(k / 2, k);
			k = k / 2;
		}
	}

	/**
	 * 交换下表分别是i，j的元素
	 * 
	 * @param i
	 * @param j
	 */
	private void exch(int i, int j) {
		Key temp = pq[i];
		pq[i] = pq[j];
		pq[j] = temp;
	}

	/**
	 * 比较两个元素的大小
	 * 
	 * @param i
	 * @param j
	 * @return
	 */
	private boolean less(int i, int j) {
		return pq[i].compareTo(pq[j]) < 0;
	}
}
