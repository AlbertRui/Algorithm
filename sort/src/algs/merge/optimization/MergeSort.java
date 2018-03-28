package algs.merge.optimization;

import java.util.Arrays;

/**
 * 归并排序
 *
 * @author AlbertRui
 * @date 2018-03-17 22:19
 */
@SuppressWarnings("ALL")
public class MergeSort {
    public <T extends Comparable<T>> void mergeSort(T[] arr) {
        System.out.println("==============merge sort optimization excution with descending order===============");
        mergeSort(arr, 0, arr.length - 1);
    }

    /**
     * 递归使用归并排序,对arr[l...r]的范围进行排序
     *
     * @param arr
     * @param left
     * @param right
     * @param <T>
     */
    private <T extends Comparable<T>> void mergeSort(T[] arr, int left, int right) {
        //对于小规模数组, 使用插入排序
        if (right - left <= 15) {
            insertionSort(arr, left, right);
            return;
        }

        int middle = (left + right) / 2;
        mergeSort(arr, left, middle);
        mergeSort(arr, middle + 1, right);
        if (arr[middle].compareTo(arr[middle + 1]) > 0) {
            merge(arr, left, middle, right);
        }
    }

    private <T extends Comparable<T>> void insertionSort(T[] arr, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            T e = arr[i];
            int j = i;
            while (j > left && (arr[j - 1].compareTo(e) > 0)) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = e;
        }
    }

    /**
     * 数组合并
     *
     * @param arr
     * @param left
     * @param middle
     * @param right
     * @param <T>
     */
    private <T extends Comparable<T>> void merge(T[] arr, int left, int middle, int right) {
        T[] aux = Arrays.copyOfRange(arr, left, right + 1);
        int i = left;
        int j = middle + 1;
        for (int k = left; k <= right; k++) {
            if (i > middle) {
                //如果左边部分已经全部处理完毕（注意，有left个偏移量）
                arr[k] = aux[j - left];
                j++;
            } else if (j > right) {
                //如果右边部分已经全部处理完毕
                arr[k] = aux[i - left];
                i++;
            } else if (aux[i - left].compareTo(aux[j - left]) < 0) {
                //左边部分小于右边部分
                arr[k] = aux[i - left];
                i++;
            } else {
                //右边部分小于左边部分
                arr[k] = aux[j - left];
                j++;
            }
        }
    }
}