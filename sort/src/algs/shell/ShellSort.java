package algs.shell;

/**
 * @author AlbertRui
 * @date 2018-03-28 23:24
 */
public class ShellSort {

    /**
     * 基于移动插入法的希尔排序
     *
     * @param arr
     * @param <T>
     */
    public <T extends Comparable<T>> void shellSort(T[] arr) {

        System.out.println("==============ShellSort use move=============");

        //增量gap，并逐步缩小增量
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            //从第gap个元素，逐个对其所在组进行直接插入排序操作
            for (int i = gap; i < arr.length; i++) {
                //寻找元素arr[i]插入的位置
                T e = arr[i];
                //定义元素arr[i]应该插入的位置
                int j;
                for (j = i; (j >= gap) && (arr[j - gap].compareTo(e) > 0); j -= gap) {
                    arr[j] = arr[j - gap];
                }
//                int j = i;
//                while (j - gap >= 0 && (arr[j - gap].compareTo(e) > 0)) {
//                    arr[j] = arr[j - gap];
//                    j -= gap;
//                }
                arr[j] = e;
            }
        }
    }

    /**
     * 基于交换插入法的希尔排序
     *
     * @param <T>
     */
    public <T extends Comparable<T>> void shellSort2(T[] arr) {

        System.out.println("===========Shell Sort use exchange============");

        //增量gap，并逐步缩小增量
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            //从第gap个元素，直接对其所在组进行插入排序操作
            for (int i = gap; i < arr.length; i++) {
                //寻找元素arr[i] 的插入位置j
                int j = i;
                while (j >= gap && (arr[j].compareTo(arr[j - gap]) < 0)) {
                    swap(arr, j, j - gap);
                    j -= gap;
                }
            }
        }
    }

    private <T extends Comparable<T>> void swap(T[] arr, int j, int i) {
        T temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }
}

