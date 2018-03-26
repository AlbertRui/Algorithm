package com.algs4.mergesort;

import java.util.Arrays;

/**
 * �鲢����
 * @author http://www.cnblogs.com/chengxiao/p/6194356.html
 * @date 2017��10��22��
 * @time ����8:21:20
 */
public class MergeSort {

	/**
	 * main������������
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = { 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		sort(arr);
		System.out.println("============�鲢����===========");
		System.out.println(Arrays.toString(arr));
	}

	/**
	 * �鲢����
	 * 
	 * @param arr
	 */
	public static void sort(int[] arr) {
		int[] temp = new int[arr.length];// ������ǰ���Ƚ���һ�����ȵ���ԭ���鳤�ȵ���ʱ���飬����ݹ���Ƶ�����ٿռ�
		sort(arr, 0, arr.length - 1, temp);
	}

	/**
	 * �ݹ���ý��й鲢����
	 * @param arr
	 * @param left
	 * @param right
	 * @param temp
	 */
	private static void sort(int[] arr, int left, int right, int[] temp) {
		if (left < right) {
			int mid = (left + right) / 2;
			sort(arr, left, mid, temp);// ��߹鲢����ʹ��������������
			sort(arr, mid + 1, right, temp);// �ұ߹鲢����ʹ��������������
			merge(arr, left, mid, right, temp);// ����������������ϲ�����
			System.out.println(Arrays.toString(arr));
		}
	}

	/**
	 * ������������������кϲ�
	 * 
	 * @param arr
	 *            ����������
	 * @param left
	 *            ��ǰ����������Ԫ���±�
	 * @param mid
	 *            ��ǰ�����м�Ԫ���±�
	 * @param right
	 *            ��ǰ�����ұ�Ԫ���±�
	 * @param temp
	 *            ��ʱ����
	 */
	private static void merge(int[] arr, int left, int mid, int right, int[] temp) {
		int i = left;// ������ָ��
		int j = mid + 1;// ������ָ��
		int t = 0;// ��ʱ����ָ��
		while (i <= mid && j <= right) {
			if (arr[i] <= arr[j]) {
				temp[t++] = arr[i++];
			} else {
				temp[t++] = arr[j++];
			}
		}
		while (i <= mid) {// �����ʣ��Ԫ������temp��
			temp[t++] = arr[i++];
		}
		while (j <= right) {// ��������ʣ��Ԫ������temp��
			temp[t++] = arr[j++];
		}
		t = 0;
		// ��temp�е�Ԫ��ȫ��������ԭ������
		while (left <= right) {
			arr[left++] = temp[t++];
		}
	}
}
