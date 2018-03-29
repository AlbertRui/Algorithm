//package com.algs4.priorityqueue;
//
///**
// * ���ڶ���ѵ����ȶ��У����ڵ��ֵ���
// *
// * @author ZhangRui
// * @date 2017��10��23��
// * @time ����8:40:55
// * @param <Key>
// */
//public class PriorityQueue<Key extends Comparable<Key>> {
//
//	private Key[] pq;
//	private int size;
//
//	/**
//	 * ����һ�����ȶ��У�Ĭ�ϳ�ʼ����Ϊ1
//	 */
//	public PriorityQueue() {
//		this(1);
//	}
//
//	/**
//	 * ����һ������ΪmaxSize�����ȶ���,�����ʵ��
//	 *
//	 * @param maxSize
//	 */
//	@SuppressWarnings("unchecked")
//	public PriorityQueue(int maxSize) {
//		pq = (Key[]) new Object[maxSize + 1];
//		size = 0;
//	}
//
//	/**
//	 * ���ض����Ƿ�Ϊ��
//	 *
//	 * @return
//	 */
//	public boolean isEmpty() {
//		return size == 0;
//	}
//
//	/**
//	 * �������ȶ����е�Ԫ�ظ���
//	 *
//	 * @return
//	 */
//	public int size() {
//		return size;
//	}
//
//	/**
//	 * �����ȶ����в���Ԫ�أ�Ĭ�������ұߵĺ��Ӳ���
//	 *
//	 * @param v
//	 */
//	public void insert(Key v) {
//		pq[++size] = v;
//		swim(size);
//	}
//
//	/**
//	 * ɾ�����������Ԫ��
//	 *
//	 * @return
//	 */
//	public Key delMax() {
//		Key max = pq[1];
//		exch(1, size--);
//		pq[size + 1] = null;
//		sink(1);
//		return max;
//	}
//
//	/**
//	 * Ԫ���³�
//	 *
//	 * @param k
//	 */
//	private void sink(int k) {
//		while (2 * k <= size) {
//			int j = 2 * k;
//			if (j < size && less(j, j + 1)) {
//				j++;
//			}
//			if (!less(k, j)) {
//				break;
//			}
//			exch(k, j);
//			k = j;
//		}
//	}
//
//	/**
//	 * Ԫ���ϸ�
//	 *
//	 * @param k
//	 */
//	private void swim(int k) {
//		while (k > 1 && less(k / 2, k)) {
//			exch(k / 2, k);
//			k = k / 2;
//		}
//	}
//
//	/**
//	 * �����±�ֱ���i��j��Ԫ��
//	 *
//	 * @param i
//	 * @param j
//	 */
//	private void exch(int i, int j) {
//		Key temp = pq[i];
//		pq[i] = pq[j];
//		pq[j] = temp;
//	}
//
//	/**
//	 * �Ƚ�����Ԫ�صĴ�С
//	 *
//	 * @param i
//	 * @param j
//	 * @return
//	 */
//	private boolean less(int i, int j) {
//		return pq[i].compareTo(pq[j]) < 0;
//	}
//}
