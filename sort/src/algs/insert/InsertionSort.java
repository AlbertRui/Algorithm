package algs.insert;

/**
 * @author AlbertRui
 * @date 2018-03-28 22:59
 */
public class InsertionSort {

    /**
     * 最基本的插入排序法
     *
     * @param arr
     * @param <T>
     */
    public static <T extends Comparable<T>> void insertBase(T[] arr) {
        for (int i = 1; i < arr.length; i++) {
            //寻找元素arr[i]合适的插入位置
            for (int j = i; j > 0 && (arr[j].compareTo(arr[j - 1]) < 0); j--) {
                swap(arr, j, j - 1);
            }
        }
    }

    private static <T extends Comparable<T>> void swap(T[] arr, int j, int i) {
        T temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }

    /**
     * 直接插入排序法，降序
     *
     * @param num
     */
    public static <T extends Comparable<T>> void insertDirect(T[] num) {
        System.out.println("==========直接插入排序法降序==========");
        for (int i = 1; i < num.length; i++) {
            int j = i;
            T insertWait = num[i];
//            for (j = i; j > 0 && (num[j - 1].compareTo(insertWait) < 0); j--) {
//                num[j] = num[j - 1];
//            }
            while (j > 0 && insertWait.compareTo(num[j - 1]) > 0) {
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
    public static <T extends Comparable<T>> void insertMiddle(T[] num) {
        System.out.println("================二分（折半）插入排序,升序================");
        for (int i = 1; i < num.length; i++) {
            int left = 0;
            int right = i - 1;
            T temp = num[i];
            while (left <= right) { // 利用折半查找插入位置
                int mid = (left + right) / 2; // 取中点
                if (num[mid].compareTo(temp) > 0) // 插入值小于中点值
                    right = mid - 1; // 向左缩小区间
                else
                    left = mid + 1; // 向右缩小区间
            }
            // left即为找到的要插入的位置，所以下边的循环将left-(i-1)位置的元素依次向后移动
            for (int j = i; j > left; j--) {
                num[j] = num[j - 1];
            }
            num[left] = temp; // 将temp插入到left位置
        }
    }

}
