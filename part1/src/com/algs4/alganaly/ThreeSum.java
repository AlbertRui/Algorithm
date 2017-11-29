package com.algs4.alganaly;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * �㷨����
 * @author ZhangRui
 * 2017��10��21��,����12:56:44
 */
public class ThreeSum {

	/**
	 * ͳ��һ���ļ��У����к�Ϊ�������������
	 * @param a
	 * @return
	 */
	public int count(int[] a) {
		int cnt = 0;
		for (int i = 0; i < a.length; i++) {
			for (int j = i + 1; j < a.length; j++) {
				for (int k = j + 1; k < a.length; k++) {
					if (a[i] + a[j] + a[k] == 0) {
						cnt++;
					}
				}
			}
		}
		return cnt;
	}

	/**
	 * ��ȡָ���ļ�
	 * @return
	 */
	public int[] readAllInt() {
		int[] num = new int[1000];
		int i = 0;
		try {
			FileReader fileReader = new FileReader("E:/code/Java/algs4-data/1Kints.txt");
			BufferedReader buf = new BufferedReader(fileReader);
			String readLine = "";
			while ((readLine = buf.readLine()) != null)
				num[i++] = Integer.parseInt(readLine.trim());
			System.out.println("=====================");
			System.out.println("������" + i + "������");
			fileReader.close();
			buf.close();
		} catch (FileNotFoundException e) {
			System.out.println("û���ҵ��ļ�������");
			e.printStackTrace();
		} catch (NumberFormatException | IOException e) {
			System.out.println("�ļ���ȡʧ�ܣ�����");
			e.printStackTrace();
		}
		return num;
	}

	/**
	 * ��ӡ����������
	 * @param array
	 */
	public void printNum(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}
}
