package search.binary;

/**
 * 二分查找法
 *
 * @author AlbertRui
 * @date 2018-03-22 19:47
 */
@SuppressWarnings({"javadoc", "unused"})
public class BinarySearch<T extends Comparable<T>> {
    /**
     * 二分查找，返回要查找元素的索引位置
     * 如果没有找到返回-1
     *
     * @param arr
     * @param target
     * @return
     */
    public int binarySearch(T[] arr, T target) {
        int left = 0;
        int right = arr.length - 1;
        //在arr[left, right]中查找
        while (left <= right) {
            //这样写实防止溢出，等同于（left + right） /2
            int middle = left + (right - left) / 2;
            if (target.compareTo(arr[middle]) == 0) {
                return middle;
            } else if (target.compareTo(arr[middle]) < 0) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return -1;
    }

    /**
     * 使用递归的方式实现二分查找[left, right]
     *
     * @param arr
     * @param target
     * @return
     */
    public int binarySearchByRecursive(T[] arr, T target, int left, int right) {
        if (left > right) {
            return -1;
        }
        int middle = left + (right - left) / 2;
        if (target.compareTo(arr[middle]) == 0) {
            return middle;
        } else if (target.compareTo(arr[middle]) < 0) {
            return binarySearchByRecursive(arr, target, left, middle - 1);
        } else {
            return binarySearchByRecursive(arr, target, middle + 1, right);
        }
    }
}
