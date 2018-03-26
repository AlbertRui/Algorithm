package com.algs4.sort;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * 排序算法
 * 
 * @author ZhangRui
 * @date 2017年10月21日
 * @time 下午5:47:22
 */
public class SortAnalyse {

	/**
	 * 读取文件并存入数组中
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
			System.out.println("找不到文件！！！");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("文件读取失败！！！");
			e.printStackTrace();
		}
		return num;
	}

	/**
	 * 打印数组元素
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
	 * 使用选择排序法对数组元素进行排序,升序
	 * 
	 * @param num
	 */
	public void selection(char[] num) {
		System.out.println("==========选择排序法升序==========");
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
	 * 直接插入排序法，降序
	 * 
	 * @param num
	 */
	public void insertDirect(char[] num) {
		System.out.println("==========直接插入排序法降序==========");
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
	 * 二分（折半）插入排序,升序
	 * 
	 * @param num
	 */
	public void insertMiddle(char[] num) {
		System.out.println("================二分（折半）插入排序,升序================");
		for (int i = 1; i < num.length; i++) {
			int left = 0;
			int right = i - 1;
			char temp = num[i];
			while (left <= right) { // 利用折半查找插入位置
				int mid = (left + right) / 2; // 取中点
				if (num[mid] > temp) // 插入值小于中点值
					right = mid - 1; // 向左缩小区间
				else
					left = mid + 1; // 向右缩小区间
			}
			// left即为找到的要插入的位置，所以下边的循环将left-(i-1)位置的元素依次向后移动
			for (int j = i - 1; j >= left; j--) {
				num[j + 1] = num[j];
			}
			num[left] = temp; // 将temp插入到left位置
		}
	}

	/**
	 * 希尔排序法，降序
	 * 
	 * @param num
	 */
	public void ShellSort(char[] num) {
		System.out.println("===========希尔排序法，降序============");
		// 增量gap，并逐步缩小增量
		for (int gap = num.length / 2; gap > 0; gap /= 2) {
			// 从第gap个元素，逐个对其所在组进行直接插入排序操作
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
	 * 经典冒泡排序法，升序
	 * 
	 * @param num
	 */
	public void bubbleSort1(char[] num) {
		System.out.println("==========经典冒泡排序法，升序============");
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
	 * 对其进行优化，设置一个标志，如果这一趟发生了交换，则为true，否则为false。 明显如果有一趟没有发生交换，说明排序已经完成。
	 * 
	 * @param num
	 */
	public void bubbleSort2(char[] num) {
		System.out.println("=========优化的冒泡排序法，降序===========");
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
	 * 最优冒泡排序法，升序 做进一步的优化。如果有100个数的数组，仅前面10个无序，后面90个都已排好序且都大于前面10个数字，
	 * 那么在第一趟遍历后，最后发生交换的位置必定小于10，且这个位置之后的数据必定已经有序了，
	 * 记录下这位置，第二次只要从数组头部遍历到这个位置就可以了。
	 * 
	 * @param num
	 */
	public void bubbleSort3(char[] num) {
		System.out.println("============最优冒泡排序法，升序===========");
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
	 * 递归的归并排序，升序
	 * 
	 * @param workSpace
	 *            辅助排序的数组
	 * @param lowerBound
	 *            欲归并数组段的最小下标
	 * @param upperBound
	 *            欲归并数组段的最大下标
	 */
	char[] array = getArray();

	public void recursiveMergeSort(char[] workSpace, int lowerBound, int upperBound) {
		if (lowerBound == upperBound) { // 该段只有一个元素，不用排序
			return;
		} else {
			int mid = (lowerBound + upperBound) / 2;
			recursiveMergeSort(workSpace, lowerBound, mid); // 对低位段归并排序
			recursiveMergeSort(workSpace, mid + 1, upperBound); // 对高位段归并排序
			merge(workSpace, lowerBound, mid, upperBound);
			printNum(array);
		}
	}

	/**
	 * 对数组array中的两段进行合并，lowerBound~mid为低位段，mid+1~upperBound为高位段
	 * 
	 * @param workSpace
	 *            辅助归并的数组，容纳归并后的元素
	 * @param lowerBound
	 *            合并段的起始下标
	 * @param mid
	 *            合并段的中点下标
	 * @param upperBound
	 *            合并段的结束下标
	 */
	private void merge(char[] workSpace, int lowerBound, int mid, int upperBound) {
		int lowBegin = lowerBound; // 低位段的起始下标
		int lowEnd = mid; // 低位段的结束下标
		int highBegin = mid + 1; // 高位段的起始下标
		int highEnd = upperBound; // 高位段的结束下标
		int j = 0; // workSpace的下标指针
		int n = upperBound - lowerBound + 1; // 归并的元素总数

		while (lowBegin <= lowEnd && highBegin <= highEnd) {
			if (array[lowBegin] < array[highBegin]) {// 将两者较小的那个放到workSpace中
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

		for (j = 0; j < n; j++) { // 将归并好的元素复制到array中
			array[lowerBound++] = workSpace[j];
		}

	}

	/**
	 * 快速排序算法，升序
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
				// high下标位置开始，向左边遍历，查找不大于基准数的元素
				while (low < high && num[high] >= key) {
					high--;
				}
				if (low < high) {// 找到小于准基数key的元素
					num[low] = num[high];// 赋值给low下标位置，low下标位置元素已经与基准数对比过了
					low++;// low下标后移
				} else {// 没有找到比准基数小的元素
					// 说明high位置右边元素都不小于准基数
					break;
				}
				// low下标位置开始，向右边遍历，查找不小于基准数的元素
				while (low < high && num[low] <= key) {
					low++;
				}
				if (low < high) {// 找到比基准数大的元素
					num[high] = num[low];// 赋值给high下标位置，high下标位置元素已经与基准数对比过了
					high--;// high下标前移，
				} else {// 没有找到比基准数小的元素
					// 说明low位置左边元素都不大于基准数
					break;
				}
			}
			num[low] = key;// low下标赋值基准数
			quickSort(num, left, low - 1);
			quickSort(num, low + 1, right);
		}
	}
}
