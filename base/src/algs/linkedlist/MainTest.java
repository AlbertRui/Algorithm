package com.algs4.linkedlist;

/**
 * ��ѹ��ջ������ʵ�֣�������
 * @author ZhangRui
 * 2017��10��21��,����12:28:59
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
