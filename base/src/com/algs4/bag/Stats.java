package com.algs4.bag;

import java.util.Scanner;

import edu.princeton.cs.algs4.Bag;

/**
 * ��������
 * @author Administrator
 * 2017��10��20��,����7:21:08
 */
public class Stats {

	public static void main(String[] args) {
		Bag<Double> numbers = new Bag<Double>();
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.println("��������������");
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
