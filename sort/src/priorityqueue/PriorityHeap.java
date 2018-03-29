//package com.algs4.priorityqueue;
//
//import java.util.Arrays;
//
///**
// * ���ȶ����ࣨ������ȶ��У�
// * @author http://www.cnblogs.com/luoxn28/p/5616101.html
// * @date 2017��10��22��
// * @time ����10:40:22
// */
//public class PriorityHeap {
//
//	// ------------------------------ Instance Variables
//
//	private int[] arr;
//	private int size;
//
//	// ------------------------------ Constructors
//
//	/**
//	 * ���ȶ�������Ĭ�ϴ�СΪ64
//	 */
//	public PriorityHeap() {
//		this(64);
//	}
//
//	public PriorityHeap(int initSize) {
//		if (initSize <= 0) {
//			initSize = 64;
//		}
//		this.arr = new int[initSize];
//		this.size = 0;
//	}
//
//	// ------------------------------ Public methods
//
//	public int max() {
//		return this.arr[0];
//	}
//
//	public int maxAndRemove() {
//		int t = max();
//
//		this.arr[0] = this.arr[--size];
//		sink(0);
//		return t;
//	}
//
//	public void add(int data) {
//		resize(1);
//		this.arr[size++] = data;
//		pop(size - 1);
//	}
//
//	// ------------------------------ Private methods
//
//	/**
//	 * key�³�����
//	 */
//	private void sink(int i) {
//		while (2 * i <= this.size - 1) {
//			int child = 2 * i;
//			if (child < this.size - 1 && this.arr[child] < this.arr[child + 1]) {
//				child++;
//			}
//			if (this.arr[i] >= this.arr[child]) {
//				break;
//			}
//
//			swap(i, child);
//			i = child;
//		}
//	}
//
//	/**
//	 * key�ϸ�����
//	 */
//	private void pop(int i) {
//		while (i > 0) {
//			int parent = i / 2;
//			if (this.arr[i] <= this.arr[parent]) {
//				break;
//			}
//			swap(i, parent);
//			i = parent;
//		}
//	}
//
//	/**
//	 * ���µ��������С
//	 */
//	private void resize(int increaseSize) {
//		if ((this.size + increaseSize) > this.arr.length) {
//			int newSize = (this.size + increaseSize) > 2 * this.arr.length ? (this.size + increaseSize)
//					: 2 * this.arr.length;
//			int[] t = this.arr;
//
//			this.arr = Arrays.copyOf(t, newSize);
//		}
//	}
//
//	/**
//	 * Swaps arr[a] with arr[b].
//	 */
//	private void swap(int a, int b) {
//		int t = this.arr[a];
//		this.arr[a] = this.arr[b];
//		this.arr[b] = t;
//	}
//}
