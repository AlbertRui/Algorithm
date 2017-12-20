package com.algs4.linkedlist;

/**
 * ��ѹ��ջ������ʵ��
 * @author ZhangRui
 * 2017��10��20��,����11:51:42
 * @param <Item>
 */
public class LinkedList<Item> {

	private Node first;
	private int n = 0;
	
	/**
	 * ������Ƕ����
	 * @author ZhangRui
	 * 2017��10��20��,����11:52:40
	 */
	private class Node {
		Item item;
		Node next;
	}
	
	/**
	 * ��ջ�����Ԫ��
	 * @param item
	 */
	public void push(Item item) {
		Node oldFirst = first;
		first = new Node();
		first.item = item;
		first.next = oldFirst;
		n ++;
	}
	
	/**
	 * Ԫ�س�ջ
	 * @return
	 */
	public Item pop() {
		Item item = first.item;
		first = first.next;
		n --;
		return item;
	}
	
	/**
	 * ��ӡջ
	 */
	public void printStack() {
		for (Node node = first; node != null; node = node.next) {
			System.out.println(node.item);
		}
	}
	
	/**
	 * ��ȡ������
	 * @return
	 */
	public int getLength() {
		return n;
	}
}
