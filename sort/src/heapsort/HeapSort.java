package com.algs4.heapsort;

/**
 * 堆排序算法
 * @author ZhangRui
 * @date 2017年10月24日
 * @time 下午7:35:55
 */
public class HeapSort {

	/**
	 * 堆排序
	 * @param num
	 */
	public void heapSort(char[] num) {
		int len = num.length - 1;
		
		//for循环构造堆
		for (int k = (len + 1) / 2 - 1; k >= 0; k--) {
			sink(num, k, len);
		}

		//while进行堆下沉排序
		while (len > 0) {
			exch(num, 0, len--);
			sink(num, 0, len);
		}
	}

	/**
	 * 交换元素
	 * @param num
	 * @param i
	 * @param j
	 */
	private void exch(char[] num, int i, int j) {
		char temp = num[i];
		num[i] = num[j];
		num[j] = temp;
	}

	/**
	 * 下沉排序
	 * @param num
	 * @param k
	 * @param len
	 */
	private void sink(char[] num, int k, int len) {
		while (2 * k < len) {
			int j = 2 * k + 1;
			if (j < len && less(num, j, j + 1))
				j++;
			if (!less(num, k, j))
				break;
			exch(num, k, j);
			k = j;
		}
	}

	/**
	 * 比较俩个元素的大小
	 * @param num
	 * @param j
	 * @param i
	 * @return
	 */
	private boolean less(char[] num, int j, int i) {
		return num[j] - num[i] < 0;
	}
}
