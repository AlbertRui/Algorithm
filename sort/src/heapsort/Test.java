package com.algs4.heapsort;

import com.algs4.sort.SortAnalyse;

/**
 * 堆排序测试类
 * @author ZhangRui
 * @date 2017年10月24日
 * @time 下午7:37:48
 */
public class Test {

	public static void main(String[] args) {
		SortAnalyse sortAnalyse = new SortAnalyse();
		char[] num = sortAnalyse.getArray();
		HeapSort heapSort = new HeapSort();
		heapSort.heapSort(num);
		sortAnalyse.printNum(num);
	}
}
