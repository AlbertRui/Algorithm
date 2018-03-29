package algs.quick.identicalKeys;

/**
 * @author AlbertRui
 * @date 2018-03-18 22:13
 */
@SuppressWarnings("ALL")
public class QuickSort {
    public <T extends Comparable<T>> void quickSort(T[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private <T extends Comparable<T>> void quickSort(T[] arr, int left, int right) {
        if (right - left <= 15) {
            insertionSort(arr, left, right);
            return;
        }
        int p = partition(arr, left, right);
        quickSort(arr, left, p - 1);
        quickSort(arr, p + 1, right);
    }

    private <T extends Comparable<T>> void insertionSort(T[] arr, int left, int right) {
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

    private <T extends Comparable<T>> int partition(T[] arr, int left, int right) {
        // 随机在arr[l...r]的范围中, 选择一个数值作为标定点pivot
        swap(arr, left, (int) (Math.random() * (right - left + 1)) + left);
        T v = arr[left];
        int i = left + 1;
        int j = right;
        while (true) {
            while (i <= right && arr[i].compareTo(v) < 0) i++;
            while (j >= left + 1 && arr[j].compareTo(v) > 0) j--;
            if (i > j) break;
            swap(arr, i, j);
            i++;
            j--;
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

