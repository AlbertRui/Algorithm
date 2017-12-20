package com.algs4.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

/**
 * 后进先出旳栈
 * @author ZhangRui
 * 2017年10月20日,下午11:13:19
 */
public class Stack {

	public static void main(String[] args) {
		Deque<Integer> stack = new ArrayDeque<Integer>();
		stack.offer(1);
		stack.offer(2);
		stack.offer(3);
		Iterator<Integer> iterator = stack.iterator();
		while (iterator.hasNext()) {
			Integer integer = (Integer) iterator.next();
			System.out.println(integer);
		}
		stack.pollLast();
		System.out.println("====================");
		while (iterator.hasNext()) {
			Integer integer = (Integer) iterator.next();
			System.out.println(integer);
		}
		System.out.println("===========================");
		for (Integer integer : stack) {
			System.out.println(integer);
		}
	}
	
}
