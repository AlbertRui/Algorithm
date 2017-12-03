package com.algs4.alganaly;

/**
 * 测试类
 * @author ZhangRui
 * 2017年10月21日,下午12:55:08
 */
public class ClassTest {

	/**
	 * 入口方法
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
