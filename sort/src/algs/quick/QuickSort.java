package algs.quick;

/**
 * 一般的快速排序
 *
 * @author AlbertRui
 * @date 2018-03-18 19:27
 */
public class QuickSort {
    public <T extends Comparable<T>> void quickSort(T[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private <T extends Comparable<T>> void quickSort(T[] arr, int left, int right) {

        if (right <= left) {
            return;
        }

        int p = partition(arr, left, right);
        quickSort(arr, left, p - 1);
        quickSort(arr, p + 1, right);
    }

    private <T extends Comparable<T>> int partition(T[] arr, int left, int right) {
        T v = arr[left];
        int j = left;
        for (int i = left + 1; i <= right; i++) {
            if (arr[i].compareTo(v) < 0) {
                j++;
                swap(arr, i, j);
            }
        }
        swap(arr, left, j);
        return j;
    }

    private <T extends Comparable<T>> void swap(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
