package com.algs4.search;

/**
 * ���ֲ��ң�������������
 * 
 * @author ZhangRui
 * @date 2017��10��25��
 * @time ����11:02:12
 * @param <Key>
 * @param <Value>
 */
public class BinarySearch<Key extends Comparable<Key>, Value> {

	private Key[] keys;
	private Value[] values;
	private int n;

	/**
	 * ��ʼ��keys��values;
	 * 
	 * @param capacity
	 */
	@SuppressWarnings("unchecked")
	public BinarySearch(int capacity) {
		keys = (Key[]) new Comparable[capacity];
		values = (Value[]) new Object[capacity];
	}

	/**
	 * ��ȡ���鳤��
	 * 
	 * @return
	 */
	public int size() {
		return n;
	}

	/**
	 * ��ȡ������Ӧ��ֵ
	 * 
	 * @param key
	 * @return
	 */
	public Value get(Key key) {
		if (isEmpty())
			return null;
		int i = rank(key);
		if (i < n && keys[i].compareTo(key) == 0)
			return values[i];
		return null;
	}

	/**
	 * ���Ҽ����ҵ��������ֵ�����򴴽��µ�Ԫ��
	 * 
	 * @param key
	 * @param value
	 */
	public void put(Key key, Value value) {
		int i = rank(key);
		if (i < n && keys[i].compareTo(key) == 0) {
			values[i] = value;
			return;
		}
		for (int j = n; j > i; j--) {
			keys[j] = keys[j - 1];
			values[j] = values[j - 1];
		}
		keys[i] = key;
		values[i] = value;
		n++;
	}

	/**
	 * ������������Ķ��ֲ���
	 * 
	 * @param key
	 * @return
	 */
	private int rank(Key key) {
		int low = 0, high = n - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			int cmp = key.compareTo(keys[mid]);
			if (cmp < 0)
				high = mid - 1;
			else if (cmp > 0)
				low = mid + 1;
			else
				return mid;
		}
		return low;
	}

	/**
	 * �п�
	 * 
	 * @return
	 */
	private boolean isEmpty() {
		return size() == 0;
	}
}
