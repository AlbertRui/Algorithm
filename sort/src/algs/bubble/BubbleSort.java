package algs.bubble;

/**
 * @author AlbertRui
 * @date 2018-03-28 22:02
 */
@SuppressWarnings("ALL")
public class BubbleSort {
    /**
     * 经典冒泡排序法，升序
     *
     * @param num
     */
    public static void bubbleSort1(char[] num) {
        System.out.println("==========经典冒泡排序法，升序============");
        char temp;
        for (int i = 0; i < num.length; i++) {
            for (int j = 1; j < num.length - i; j++) {
                if (num[j] < num[j - 1]) {
                    temp = num[j];
                    num[j] = num[j - 1];
                    num[j - 1] = temp;
                }
            }
        }
    }

    /**
     * 对其进行优化，设置一个标志，如果这一趟发生了交换，则为true，否则为false。
     * 明显如果有一趟没有发生交换，说明排序已经完成。
     *
     * @param num
     */
    public static void bubbleSort2(char[] num) {
        System.out.println("=========优化的冒泡排序法，降序===========");
        char temp;
        boolean flag = true;
        int k = num.length;
        while (flag) {
            flag = false;
            for (int i = 1; i < k; i++) {
                if (num[i] > num[i - 1]) {
                    temp = num[i];
                    num[i] = num[i - 1];
                    num[i - 1] = temp;
                    flag = true;
                }
            }
            k--;
        }
    }

    /**
     * 最优冒泡排序法，升序 做进一步的优化。如果有100个数的数组，仅前面10个无序，后面90个都已排好序且都大于前面10个数字，
     * 那么在第一趟遍历后，最后发生交换的位置必定小于10，且这个位置之后的数据必定已经有序了，
     * 记录下这位置，第二次只要从数组头部遍历到这个位置就可以了。
     *
     * @param num
     */
    public static <T extends Comparable<T>> void bubbleSort3(T[] num) {
        System.out.println("============最优冒泡排序法，升序===========");
        int flag = num.length;
        int k = 0;
        T temp;
        while (flag > 0) {
            k = flag;
            flag = 0;
            for (int i = 1; i < k; i++) {
                if (num[i].compareTo(num[i - 1]) < 0) {
                    temp = num[i];
                    num[i] = num[i - 1];
                    num[i - 1] = temp;
                    flag = i;
                }
            }
        }
    }

}
