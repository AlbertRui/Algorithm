package com.algs4.sort;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * �����㷨
 * 
 * @author ZhangRui
 * @date 2017��10��21��
 * @time ����5:47:22
 */
public class SortAnalyse {

	/**
	 * ��ȡ�ļ�������������
	 * 
	 * @return
	 */
	public char[] getArray() {
		char[] num = new char[11];
		File file = null;
		FileReader fileReader = null;
		try {
			file = new File("E:\\code\\Java\\algs4-data\\tiny.txt");
			fileReader = new FileReader(file);
			int i = 0;
			int n = 0;
			while ((n = fileReader.read()) != -1) {
				if (((char) n != ' ') && ((char) n != '\n'))
					num[i++] = (char) n;
			}
			fileReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("�Ҳ����ļ�������");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("�ļ���ȡʧ�ܣ�����");
			e.printStackTrace();
		}
		return num;
	}

	/**
	 * ��ӡ����Ԫ��
	 * 
	 * @param num
	 */
	public void printNum(char[] num) {
		for (char c : num) {
			System.out.print(c + " ");
		}
		System.out.println();
	}

	/**
	 * ʹ��ѡ�����򷨶�����Ԫ�ؽ�������,����
	 * 
	 * @param num
	 */
	public void selection(char[] num) {
		System.out.println("==========ѡ����������==========");
		char temp;
		for (int i = 0; i < num.length; i++) {
			for (int j = i + 1; j < num.length; j++) {
				if (num[i] > num[j]) {
					temp = num[i];
					num[i] = num[j];
					num[j] = temp;
				}
			}
		}
	}

	/**
	 * ֱ�Ӳ������򷨣�����
	 * 
	 * @param num
	 */
	public void insertDirect(char[] num) {
		System.out.println("==========ֱ�Ӳ������򷨽���==========");
		for (int i = 1; i < num.length; i++) {
			int j = i;
			char insertWait = num[i];
			while (j > 0 && insertWait > num[j - 1]) {
				num[j] = num[j - 1];
				j--;
			}
			num[j] = insertWait;
		}
	}

	/**
	 * ���֣��۰룩��������,����
	 * 
	 * @param num
	 */
	public void insertMiddle(char[] num) {
		System.out.println("================���֣��۰룩��������,����================");
		for (int i = 1; i < num.length; i++) {
			int left = 0;
			int right = i - 1;
			char temp = num[i];
			while (left <= right) { // �����۰���Ҳ���λ��
				int mid = (left + right) / 2; // ȡ�е�
				if (num[mid] > temp) // ����ֵС���е�ֵ
					right = mid - 1; // ������С����
				else
					left = mid + 1; // ������С����
			}
			// left��Ϊ�ҵ���Ҫ�����λ�ã������±ߵ�ѭ����left-(i-1)λ�õ�Ԫ����������ƶ�
			for (int j = i - 1; j >= left; j--) {
				num[j + 1] = num[j];
			}
			num[left] = temp; // ��temp���뵽leftλ��
		}
	}

	/**
	 * ϣ�����򷨣�����
	 * 
	 * @param num
	 */
	public void ShellSort(char[] num) {
		System.out.println("===========ϣ�����򷨣�����============");
		// ����gap��������С����
		for (int gap = num.length / 2; gap > 0; gap /= 2) {
			// �ӵ�gap��Ԫ�أ�����������������ֱ�Ӳ����������
			for (int i = gap; i < num.length; i++) {
				int j = i;
				char waitInsert = num[i];
				while (j - gap >= 0 && waitInsert > num[j - gap]) {
					num[j] = num[j - gap];
					j -= gap;
				}
				num[j] = waitInsert;
			}
		}
	}

	/**
	 * ����ð�����򷨣�����
	 * 
	 * @param num
	 */
	public void bubbleSort1(char[] num) {
		System.out.println("==========����ð�����򷨣�����============");
		char temp;
		for (int i = 0; i < num.length; i++) {
			for (int j = 1; j < num.length - i; j++) {
				if (num[j] < num[j - 1]) {
					temp = num[j];
					num[j] = num[j - 1];
					num[j - 1] = temp;
				}
			}
		}
	}

	/**
	 * ��������Ż�������һ����־�������һ�˷����˽�������Ϊtrue������Ϊfalse�� ���������һ��û�з���������˵�������Ѿ���ɡ�
	 * 
	 * @param num
	 */
	public void bubbleSort2(char[] num) {
		System.out.println("=========�Ż���ð�����򷨣�����===========");
		char temp;
		boolean flag = true;
		int k = num.length;
		while (flag) {
			flag = false;
			for (int i = 1; i < k; i++) {
				if (num[i] > num[i - 1]) {
					temp = num[i];
					num[i] = num[i - 1];
					num[i - 1] = temp;
					flag = true;
				}
			}
			k--;
		}
	}

	/**
	 * ����ð�����򷨣����� ����һ�����Ż��������100���������飬��ǰ��10�����򣬺���90�������ź����Ҷ�����ǰ��10�����֣�
	 * ��ô�ڵ�һ�˱����������������λ�ñض�С��10�������λ��֮������ݱض��Ѿ������ˣ�
	 * ��¼����λ�ã��ڶ���ֻҪ������ͷ�����������λ�þͿ����ˡ�
	 * 
	 * @param num
	 */
	public void bubbleSort3(char[] num) {
		System.out.println("============����ð�����򷨣�����===========");
		int flag = num.length;
		int k = 0;
		char temp;
		while (flag > 0) {
			k = flag;
			flag = 0;
			for (int i = 1; i < k; i++) {
				if (num[i] < num[i - 1]) {
					temp = num[i];
					num[i] = num[i - 1];
					num[i - 1] = temp;
					flag = i;
				}
			}
		}
	}

	/**
	 * �ݹ�Ĺ鲢��������
	 * 
	 * @param workSpace
	 *            �������������
	 * @param lowerBound
	 *            ���鲢����ε���С�±�
	 * @param upperBound
	 *            ���鲢����ε�����±�
	 */
	char[] array = getArray();

	public void recursiveMergeSort(char[] workSpace, int lowerBound, int upperBound) {
		if (lowerBound == upperBound) { // �ö�ֻ��һ��Ԫ�أ���������
			return;
		} else {
			int mid = (lowerBound + upperBound) / 2;
			recursiveMergeSort(workSpace, lowerBound, mid); // �Ե�λ�ι鲢����
			recursiveMergeSort(workSpace, mid + 1, upperBound); // �Ը�λ�ι鲢����
			merge(workSpace, lowerBound, mid, upperBound);
			printNum(array);
		}
	}

	/**
	 * ������array�е����ν��кϲ���lowerBound~midΪ��λ�Σ�mid+1~upperBoundΪ��λ��
	 * 
	 * @param workSpace
	 *            �����鲢�����飬���ɹ鲢���Ԫ��
	 * @param lowerBound
	 *            �ϲ��ε���ʼ�±�
	 * @param mid
	 *            �ϲ��ε��е��±�
	 * @param upperBound
	 *            �ϲ��εĽ����±�
	 */
	private void merge(char[] workSpace, int lowerBound, int mid, int upperBound) {
		int lowBegin = lowerBound; // ��λ�ε���ʼ�±�
		int lowEnd = mid; // ��λ�εĽ����±�
		int highBegin = mid + 1; // ��λ�ε���ʼ�±�
		int highEnd = upperBound; // ��λ�εĽ����±�
		int j = 0; // workSpace���±�ָ��
		int n = upperBound - lowerBound + 1; // �鲢��Ԫ������

		while (lowBegin <= lowEnd && highBegin <= highEnd) {
			if (array[lowBegin] < array[highBegin]) {// �����߽�С���Ǹ��ŵ�workSpace��
				workSpace[j++] = array[lowBegin++];
			} else {
				workSpace[j++] = array[highBegin++];
			}
		}

		while (lowBegin <= lowEnd) {
			workSpace[j++] = array[lowBegin++];
		}

		while (highBegin <= highEnd) {
			workSpace[j++] = array[highBegin++];
		}

		for (j = 0; j < n; j++) { // ���鲢�õ�Ԫ�ظ��Ƶ�array��
			array[lowerBound++] = workSpace[j];
		}

	}

	/**
	 * ���������㷨������
	 * 
	 * @param num
	 * @param left
	 * @param right
	 */
	public void quickSort(char[] num, int left, int right) {
		if (left < right) {
			char key = num[left];
			int low = left;
			int high = right;
			while (low < high) {
				// high�±�λ�ÿ�ʼ������߱��������Ҳ����ڻ�׼����Ԫ��
				while (low < high && num[high] >= key) {
					high--;
				}
				if (low < high) {// �ҵ�С��׼����key��Ԫ��
					num[low] = num[high];// ��ֵ��low�±�λ�ã�low�±�λ��Ԫ���Ѿ����׼���Աȹ���
					low++;// low�±����
				} else {// û���ҵ���׼����С��Ԫ��
					// ˵��highλ���ұ�Ԫ�ض���С��׼����
					break;
				}
				// low�±�λ�ÿ�ʼ�����ұ߱��������Ҳ�С�ڻ�׼����Ԫ��
				while (low < high && num[low] <= key) {
					low++;
				}
				if (low < high) {// �ҵ��Ȼ�׼�����Ԫ��
					num[high] = num[low];// ��ֵ��high�±�λ�ã�high�±�λ��Ԫ���Ѿ����׼���Աȹ���
					high--;// high�±�ǰ�ƣ�
				} else {// û���ҵ��Ȼ�׼��С��Ԫ��
					// ˵��lowλ�����Ԫ�ض������ڻ�׼��
					break;
				}
			}
			num[low] = key;// low�±긳ֵ��׼��
			quickSort(num, left, low - 1);
			quickSort(num, low + 1, right);
		}
	}
}
