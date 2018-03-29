package algs.quick.additional;

/**
 * @author AlbertRui
 * @date 2018-03-29 16:56
 */
public class QuickSort {

    /**
     * 快速排序算法，升序
     *
     * @param num
     * @param left
     * @param right
     */
    public void quickSort(char[] num, int left, int right) {
        if (left < right) {
            char key = num[left];
            int low = left;
            int high = right;
            while (low < high) {
                // high下标位置开始，向左边遍历，查找不大于基准数的元素
                while (low < high && num[high] >= key) {
                    high--;
                }
                if (low < high) {// 找到小于准基数key的元素
                    num[low] = num[high];// 赋值给low下标位置，low下标位置元素已经与基准数对比过了
                    low++;// low下标后移
                } else {// 没有找到比准基数小的元素
                    // 说明high位置右边元素都不小于准基数
                    break;
                }
                // low下标位置开始，向右边遍历，查找不小于基准数的元素
                while (low < high && num[low] <= key) {
                    low++;
                }
                if (low < high) {// 找到比基准数大的元素
                    num[high] = num[low];// 赋值给high下标位置，high下标位置元素已经与基准数对比过了
                    high--;// high下标前移，
                } else {// 没有找到比基准数小的元素
                    // 说明low位置左边元素都不大于基准数
                    break;
                }
            }
            num[low] = key;// low下标赋值基准数
            quickSort(num, left, low - 1);
            quickSort(num, low + 1, right);
        }
    }

}
