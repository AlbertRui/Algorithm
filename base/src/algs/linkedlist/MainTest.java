package com.algs4.linkedlist;

/**
 * 下压堆栈，链表实现，测试类
 * @author ZhangRui
 * 2017年10月21日,上午12:28:59
 */
public class MainTest {

	public static void main(String[] args) {
		LinkedList<Integer> linkedList = new LinkedList<Integer>();
		linkedList.push(1);
		linkedList.push(2);
		linkedList.push(3);
		System.out.println(linkedList.getLength());
		System.out.println("===================");
		linkedList.printStack();
		System.out.println("===================");
		linkedList.pop();
		linkedList.printStack();
	}
}
