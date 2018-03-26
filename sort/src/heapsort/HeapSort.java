package com.algs4.heapsort;

/**
 * �������㷨
 * @author ZhangRui
 * @date 2017��10��24��
 * @time ����7:35:55
 */
public class HeapSort {

	/**
	 * ������
	 * @param num
	 */
	public void heapSort(char[] num) {
		int len = num.length - 1;
		
		//forѭ�������
		for (int k = (len + 1) / 2 - 1; k >= 0; k--) {
			sink(num, k, len);
		}

		//while���ж��³�����
		while (len > 0) {
			exch(num, 0, len--);
			sink(num, 0, len);
		}
	}

	/**
	 * ����Ԫ��
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
	 * �³�����
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
	 * �Ƚ�����Ԫ�صĴ�С
	 * @param num
	 * @param j
	 * @param i
	 * @return
	 */
	private boolean less(char[] num, int j, int i) {
		return num[j] - num[i] < 0;
	}
}
