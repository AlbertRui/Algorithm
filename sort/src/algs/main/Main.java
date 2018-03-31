package algs.main;

import algs.heap.sort.HeapSort1;
import algs.util.SortTestHelper;

/**
 * @author AlbertRui
 * @date 2018-03-29 17:07
 */
public class Main {
    /**
     * 程序的入口
     *
     * @param args
     */
    public static void main(String[] args) {
//        Character[] num = SortTestHelper.getArray();
//        SortTestHelper.printNum(num);
//        BubbleSort.bubbleSort3(num);
//        SortTestHelper.printNum(num);
        // 测试排序算法辅助函数
        int N = 20000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
//        Integer[] arr = SortTestHelper.generateNearlyOrderedArray(10000, 10);
//        SelectionSort.sort(arr);
        SortTestHelper.testSort(HeapSort1.class, "sort2", new Class[]{Comparable[].class}, new Object[]{arr});
        SortTestHelper.printArrayLn(arr, 20000);
    }
}
