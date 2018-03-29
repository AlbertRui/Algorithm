package com.algs4.search;

/**
 * 二分查找，基于有序数组
 * 
 * @author ZhangRui
 * @date 2017年10月25日
 * @time 上午11:02:12
 * @param <Key>
 * @param <Value>
 */
public class BinarySearch<Key extends Comparable<Key>, Value> {

	private Key[] keys;
	private Value[] values;
	private int n;

	/**
	 * 初始化keys和values;
	 * 
	 * @param capacity
	 */
	@SuppressWarnings("unchecked")
	public BinarySearch(int capacity) {
		keys = (Key[]) new Comparable[capacity];
		values = (Value[]) new Object[capacity];
	}

	/**
	 * 获取数组长度
	 * 
	 * @return
	 */
	public int size() {
		return n;
	}

	/**
	 * 获取键所对应的值
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
	 * 查找键，找到则更新其值，否则创建新的元素
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
	 * 基于有序数组的二分查找
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
	 * 判空
	 * 
	 * @return
	 */
	private boolean isEmpty() {
		return size() == 0;
	}
}
