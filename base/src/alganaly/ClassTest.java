package com.algs4.alganaly;

/**
 * ������
 * @author ZhangRui
 * 2017��10��21��,����12:55:08
 */
public class ClassTest {

	/**
	 * ��ڷ���
	 * @param args
	 */
	public static void main(String[] args) {
		ThreeSum threeSum = new ThreeSum();
		int[] num = threeSum.readAllInt();
		System.out.println(threeSum.count(num));
		System.out.println("=========================");
		threeSum.printNum(num);
	}
}
