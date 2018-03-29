package algs.merge.additional;

import java.util.Arrays;

/**
 * 归并排序
 *
 * @author http://www.cnblogs.com/chengxiao/p/6194356.html
 * @date 2017年10月22日
 * @time 下午8:21:20
 */
public class MergeSort {

    /**
     * main方法程序的入口
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        sort(arr);
        System.out.println("============归并排序===========");
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 归并排序
     *
     * @param arr
     */
    public static void sort(int[] arr) {
        // 在排序前，先建好一个长度等于原数组长度的临时数组，避免递归中频繁开辟空间
        int[] temp = new int[arr.length];
        sort(arr, 0, arr.length - 1, temp);
    }

    /**
     * 递归调用进行归并排序
     *
     * @param arr
     * @param left
     * @param right
     * @param temp
     */
    private static void sort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            sort(arr, left, mid, temp);// 左边归并排序，使得左子序列有序
            sort(arr, mid + 1, right, temp);// 右边归并排序，使得右子序列有序
            merge(arr, left, mid, right, temp);// 将两个有序子数组合并操作
            System.out.println(Arrays.toString(arr));
        }
    }

    /**
     * 将两个有序子数组进行合并
     *
     * @param arr   待排序数组
     * @param left  当前数组的最左边元素下标
     * @param mid   当前数组中间元素下标
     * @param right 当前数组右边元素下标
     * @param temp  临时数组
     */
    private static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;// 左序列指针
        int j = mid + 1;// 右序列指针
        int t = 0;// 临时数组指针
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[t++] = arr[i++];
            } else {
                temp[t++] = arr[j++];
            }
        }
        while (i <= mid) {// 将左边剩余元素填充进temp中
            temp[t++] = arr[i++];
        }
        while (j <= right) {// 将右序列剩余元素填充进temp中
            temp[t++] = arr[j++];
        }
        t = 0;
        // 将temp中的元素全部拷贝到原数组中
        while (left <= right) {
            arr[left++] = temp[t++];
        }
    }
}
