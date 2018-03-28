package algs.select;

/**
 * @author AlbertRui
 * @date 2018-03-28 22:15
 */
@SuppressWarnings("ALL")
public class SelectionSort {

    /**
     * 使用选择排序法对数组元素进行排序,升序
     *
     * @param num
     */
    public static void selection(char[] num) {
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
     * 优化后的版本
     *
     * @param arr
     * @param <T>
     */
    public static <T extends Comparable<T>> void sort(T[] arr) {

        int n = arr.length;
        for (int i = 0; i < n; i++) {
            // 寻找[i, n)区间里的最小值的索引
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                // 使用compareTo方法比较两个Comparable对象的大小
                if (arr[j].compareTo(arr[minIndex]) < 0) {
                    minIndex = j;
                }
            }

            if (i != minIndex) {
                swap(arr, i, minIndex);
            }
        }
    }

    private static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

}
