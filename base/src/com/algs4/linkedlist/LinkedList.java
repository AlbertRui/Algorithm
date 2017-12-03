package com.algs4.linkedlist;

/**
 * 下压堆栈，链表实现
 * @author ZhangRui
 * 2017年10月20日,下午11:51:42
 * @param <Item>
 */
public class LinkedList<Item> {

	private Node first;
	private int n = 0;
	
	/**
	 * 定义结点嵌套类
	 * @author ZhangRui
	 * 2017年10月20日,下午11:52:40
	 */
	private class Node {
		Item item;
		Node next;
	}
	
	/**
	 * 想栈顶添加元素
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
	 * 元素出栈
	 * @return
	 */
	public Item pop() {
		Item item = first.item;
		first = first.next;
		n --;
		return item;
	}
	
	/**
	 * 打印栈
	 */
	public void printStack() {
		for (Node node = first; node != null; node = node.next) {
			System.out.println(node.item);
		}
	}
	
	/**
	 * 获取链表长度
	 * @return
	 */
	public int getLength() {
		return n;
	}
}
