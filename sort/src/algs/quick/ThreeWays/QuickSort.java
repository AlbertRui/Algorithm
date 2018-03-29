package algs.quick.ThreeWays;

/**
 * @author AlbertRui
 * @date 2018-03-19 17:25
 */
public class QuickSort {
    public <T extends Comparable<T>> void quickSort(T[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private <T extends Comparable<T>> void quickSort(T[] arr, int left, int right) {
        if (right - left < 16) {
            insertionSort(arr, left, right);
            return;
        }
        swap(arr, left, (int) (Math.random() * (right - left + 1)) + left);
        T v = arr[left];
        int lt = left;//arr[left + 1, lt] < v
        int gt = right + 1;//[gt, right] > V
        int i = left + 1;//[lt + 1, i) == v
        while (i < gt) {
            if (arr[i].compareTo(v) < 0) {
                swap(arr, i, lt + 1);
                //交换后arr[i] = v;
                i++;
                lt++;
            } else if (arr[i].compareTo(v) > 0) {
                swap(arr, i, gt - 1);
                //交换后i的元素的值不确定，所以不需要i++
                gt--;
            } else {
                i++;
            }
        }
        swap(arr, left, lt);
        //由于交换后arr[lt] = v,已经有序了，所以不需要纳入到循环中
        quickSort(arr, left, lt - 1);
        quickSort(arr, gt, right);
    }

    private <T extends Comparable<T>> void swap(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private <T extends Comparable<T>> void insertionSort(T[] arr, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            int j = i;
            T e = arr[i];
            while (j > left && arr[j - 1].compareTo(e) > 0) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = e;
        }
    }
}
