package algs.util;

import java.lang.reflect.Method;

/**
 * @author AlbertRui
 * @date 2018-03-17 15:33
 */
@SuppressWarnings("ALL")
public class SortTestHelper {

    // SortTestHelper不允许产生任何实例
    private SortTestHelper() {
    }

    /**
     * 生成一个包含n个元素的随机数。随机范围在[rangeL, rangeR]
     *
     * @param n
     * @param rangeL
     * @param rangeR
     */
    public static Integer[] generateRandomArray(Integer n, Integer rangeL, Integer rangeR) {
        // 生成有n个元素的随机数组,每个元素的随机范围为[rangeL, rangeR]

        assert rangeL <= rangeR;

        Integer[] arr = new Integer[n];

        for (int i = 0; i < n; i++) {
            arr[i] = (int) (Math.random() * (rangeR - rangeL + 1) + rangeL);
        }
        return arr;

    }


    /**
     * 打印arr数组的所有内容
     *
     * @param arr
     */
    public static void printArray(Object arr[]) {

        for (Object anArr : arr) {
            System.out.print(anArr);
            System.out.print(' ');
        }

    }

    /**
     * 换行打印arr数组的所有内容
     *
     * @param arr
     */
    public static void printArrayLn(Object arr[], int n) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            System.out.print(' ');
            if ((i + 1) % n == 0) {
                System.out.println();
            }
        }
    }

    /**
     * 判断arr数组是否有序
     *
     * @param arr
     */
    public static <T extends Comparable<T>> boolean isSorted(T[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1].compareTo(arr[i]) > 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 测试sortClassName所对应的排序算法排序arr数组所得到结果的正确性和算法运行时间
     *
     * @param clazz
     * @param params
     */
    public static void testSort(Class<?> clazz, String methodName, Class<?>[] parameterTypes, Object[] params) {
        try {
            Method method = clazz.getMethod(methodName, parameterTypes);
            method.setAccessible(true);
            System.out.println(method);
            long startTime = System.currentTimeMillis();
            method.invoke(clazz.newInstance(), params);
            long endTime = System.currentTimeMillis();
            long time = endTime - startTime;
            System.out.println("The method " + methodName + " execution use " + time + "ms");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 生成一个近乎有序的数组
     * 首先生成一个含有[0...n-1]的完全有序数组, 之后随机交换swapTimes对数据
     * swapTimes定义了数组的无序程度:
     * swapTimes == 0 时, 数组完全有序
     * swapTimes 越大, 数组越趋向于无序
     */
    public static Integer[] generateNearlyOrderedArray(int n, int swapTimes) {

        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++)
            arr[i] = i;

        for (int i = 0; i < swapTimes; i++) {
            int a = (int) (Math.random() * n);
            int b = (int) (Math.random() * n);
            int t = arr[a];
            arr[a] = arr[b];
            arr[b] = t;
        }

        return arr;
    }

    /**
     * 生成一个完全有序的数组
     *
     * @param n
     * @return
     */
    public static Integer[] generateOrderedArray(int n) {

        return generateNearlyOrderedArray(n, 0);
    }

    /**
     * 生成一个完全逆序的数组
     *
     * @param n
     * @return
     */
    public static Integer[] generateInversedArray(int n) {

        Integer[] arr = generateOrderedArray(n);
        for (int i = n / 2 - 1; i >= 0; i--) {
            Integer t = arr[i];
            arr[i] = arr[n - i - 1];
            arr[n - i - 1] = t;
        }
        return arr;
    }

    // 将数组arr随机化
    public static void shuffleArray(Object[] arr) {

        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int j = (int) (Math.random() * (n - i)) + i;

            Object t = arr[i];
            arr[i] = arr[j];
            arr[j] = t;
        }
    }
}
