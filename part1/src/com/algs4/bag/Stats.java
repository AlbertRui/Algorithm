package com.algs4.bag;

import java.util.Scanner;

import edu.princeton.cs.algs4.Bag;

/**
 * 背包用例
 * @author Administrator
 * 2017年10月20日,下午7:21:08
 */
public class Stats {

	public static void main(String[] args) {
		Bag<Double> numbers = new Bag<Double>();
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.println("请您输入整数：");
		int i = 0;
		while (input.hasNext()) {
			double num = input.nextDouble();
			numbers.add(num);
			i++;
			if (i == 10)
				break;
		}
		int N = numbers.size();

		double sum = 0.0;
		for (double x : numbers)
			sum += x;
		double mean = sum / N;

		sum = 0.0;
		for (double x : numbers)
			sum += (x - mean) * (x - mean);
		double std = Math.sqrt(sum / (N - 1));

		System.out.printf("Mean: %.2f\n", mean);
		System.out.printf("std dev: %.2f\n", std);
	}
}
