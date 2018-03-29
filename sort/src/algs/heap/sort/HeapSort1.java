package algs.heap.sort;

import algs.heap.max.MaxHeap;
import algs.util.SortTestHelper;

/**
 * @author AlbertRui
 * @date 2018-03-21 20:38
 */
public class HeapSort1 {

    public <T extends Comparable<T>> void sort1(T[] arr) {

        MaxHeap<T> maxHeap = new MaxHeap<T>(arr.length);
        for (int i = 0; i < arr.length; i++) {
            maxHeap.insert(arr[i]);
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            arr[i] = maxHeap.extractMax();
        }
    }

    public <T extends Comparable<T>> void sort2(T[] arr) {
        MaxHeap<T> maxHeap = new MaxHeap<>(arr);
        for (int i = arr.length - 1; i >= 0; i--) {
            arr[i] = maxHeap.extractMax();
        }
    }

    public static void main(String[] args) {
        HeapSort1 heapSort1 = new HeapSort1();
        Integer[] arr = SortTestHelper.generateRandomArray(100, 0, 100);
        heapSort1.sort2(arr);
        SortTestHelper.printArrayLn(arr, 10);
    }
}
