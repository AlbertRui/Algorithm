package algs.merge.bottom;

import java.util.Arrays;

/**
 * 自底向上的归并排序
 *
 * @author AlbertRui
 * @date 2018-03-18 15:35
 */
@SuppressWarnings("ALL")
public class MergeSortBU {
    public <T extends Comparable<T>> void mergeSort(T[] arr) {
        int n = arr.length;
        //每循环一次，变换size：1-1、2-2、3-3.。。。。。。。。。
        for (int size = 1; size < n; size += size) {
            /**
             *每循环一次，对相邻的size大小的的两个数组归并一次
             * 其中i < n - size保证第二部分数组的存在
             */
            for (int i = 0; i < n - size; i += (size + size)) {
                merge(arr, i, i + size - 1, Math.min(i + size + size - 1, n - 1));
            }
        }
    }

    /**
     * 优化版本
     *
     * @param arr
     * @param <T>
     */
    public <T extends Comparable<T>> void mergeSort2(T[] arr) {
        int n = arr.length;

        for (int i = 0; i < n; i += 16) {
            insertSort(arr, i, Math.min(i + 15, n - 1));
        }

        //每循环一次，变换size：1-1、2-2、3-3.。。。。。。。。。
        for (int size = 16; size < n; size += size) {
            /**
             *每循环一次，对相邻的size大小的的两个数组归并一次
             * 其中i < n - size保证第二部分数组的存在
             */
            for (int i = 0; i < n - size; i += (size + size)) {
                if (arr[i + size - 1].compareTo(arr[i + size]) > 0) {
                    merge(arr, i, i + size - 1, Math.min(i + size + size - 1, n - 1));
                }
            }
        }
    }

    private <T extends Comparable<T>> void insertSort(T[] arr, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            int j = i;
            T e = arr[i];
            while (j > left && (arr[j - 1].compareTo(e) > 0)) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = e;
        }
    }

    /**
     * 归并：if语句不能合并，否则会抛出数组下标越界异常
     *
     * @param arr
     * @param left
     * @param middle
     * @param right
     * @param <T>
     */
    private <T extends Comparable<T>> void merge(T[] arr, int left, int middle, int right) {
        T[] aux = Arrays.copyOfRange(arr, left, right + 1);

        // 初始化，i指向左半部分的起始索引位置l；j指向右半部分起始索引位置mid+1
        int i = left, j = middle + 1;
        for (int k = left; k <= right; k++) {
            if (i > middle) {
                arr[k] = aux[j - left];
                j++;
            } else if (j > right) {
                arr[k] = aux[i - left];
                i++;
            } else if (aux[i - left].compareTo(aux[j - left]) > 0) {
                arr[k] = aux[j - left];
                j++;
            } else {
                arr[k] = aux[i - left];
                i++;
            }
        }
    }
}
