package algs.heap.sort;

import algs.util.SortTestHelper;

/**
 * 堆排序(对构造数组索引从零开始)
 *
 * @author AlbertRui
 * @date 2018-03-21 22:04
 */
@SuppressWarnings("JavaDoc")
public class HeapSort<T extends Comparable<T>> {
    /**
     * 堆排序入口方法
     *
     * @param arr
     */
    public void heapSort(T[] arr) {

        int len = arr.length;

        /*
          注意：最后一个元素的索引是n-1
          它的父节点时是（n-1-1）
         */
        for (int i = (len - 2) / 2; i >= 0; i--) {
            sink(arr, i, len);
        }
        for (int i = len - 1; i > 0; i--) {
            swap(arr, 0, i);
            sink(arr, 0, i);
        }
    }

    /**
     * 元素下沉（最大堆）
     *
     * @param arr
     * @param k
     * @param n
     */
    private void sink(T[] arr, int k, int n) {
        while (2 * k + 1 < n) {
            int j = 2 * k + 1;
            if (j + 1 < n && less(arr, j, j + 1)) {
                j++;
            }
            if (!less(arr, k, j)) {
                break;
            }
            swap(arr, k, j);
            k = j;
        }
    }

    /**
     * 交换两个元素的值
     *
     * @param arr
     * @param i
     * @param j
     */
    private void swap(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * 比较两个元素的大小
     *
     * @param arr
     * @param i
     * @param j
     * @return
     */
    private boolean less(T[] arr, int i, int j) {
        return arr[i].compareTo(arr[j]) < 0;
    }

    public static void main(String[] args) {
        HeapSort<Integer> heapSort = new HeapSort<>();
        Integer[] arr = SortTestHelper.generateRandomArray(100, 0, 100);
        heapSort.heapSort(arr);
        SortTestHelper.printArrayLn(arr, 10);
    }
}
