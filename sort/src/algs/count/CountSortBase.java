package algs.count;

/**
 * @author AlbertRui
 * @date 2018-05-04 9:40
 */
public class CountSortBase {
    private static int[] countSort(int[] array, int k) {
        int[] C = new int[k + 1];//构造C数组
        int length = array.length;//获取A数组大小用于构造B数组
        int[] B = new int[length];//构造B数组
        // 统计A中各元素个数，存入C数组
        for (int anArray : array) C[anArray] += 1;
        //修改C数组
        for (int i = 1; i < k + 1; i++) C[i] += C[i - 1];
        //遍历A数组，构造B数组
        for (int i = length - 1; i >= 0; i--) {
            B[C[array[i]] - 1] = array[i];//将A中该元素放到排序后数组B中指定的位置
            C[array[i]]--;//将C中该元素-1，方便存放下一个同样大小的元素
        }
        return B;//将排序好的数组返回，完成排序
    }

    public static void Sort(int[] A, int k) {
        int[] C = new int[k + 1];
        for (int aA : A) C[aA]++;
        int z = 0;
        for (int i = 0; i <= k; i++)
            while (C[i]-- > 0)
                A[z++] = i;
    }

    public static void main(String[] args) {
        int[] A = new int[]{2, 5, 3, 0, 2, 3, 0, 3};
        Sort(A, 5);
//        int[] B = countSort(A, 5);
        for (int i = 0; i < A.length; i++) {
            System.out.println((i + 1) + "th:" + A[i]);
        }
    }
}
