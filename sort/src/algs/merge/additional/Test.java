package algs.merge.additional;

import algs.util.SortTestHelper;

/**
 * @author AlbertRui
 * @date 2018-03-29 17:03
 */
public class Test {
    /**
     * 递归的归并排序，升序
     *
     * @param workSpace
     * 辅助排序的数组
     * @param lowerBound
     * 欲归并数组段的最小下标
     * @param upperBound
     * 欲归并数组段的最大下标
     */
    char[] array = SortTestHelper.getArray();

    public void recursiveMergeSort(char[] workSpace, int lowerBound, int upperBound) {
        if (lowerBound == upperBound) { // 该段只有一个元素，不用排序
            return;
        } else {
            int mid = (lowerBound + upperBound) / 2;
            recursiveMergeSort(workSpace, lowerBound, mid); // 对低位段归并排序
            recursiveMergeSort(workSpace, mid + 1, upperBound); // 对高位段归并排序
            merge(workSpace, lowerBound, mid, upperBound);
            SortTestHelper.printNum(array);
        }
    }

    /**
     * 对数组array中的两段进行合并，lowerBound~mid为低位段，mid+1~upperBound为高位段
     *
     * @param workSpace  辅助归并的数组，容纳归并后的元素
     * @param lowerBound 合并段的起始下标
     * @param mid        合并段的中点下标
     * @param upperBound 合并段的结束下标
     */
    private void merge(char[] workSpace, int lowerBound, int mid, int upperBound) {
        int lowBegin = lowerBound; // 低位段的起始下标
        int lowEnd = mid; // 低位段的结束下标
        int highBegin = mid + 1; // 高位段的起始下标
        int highEnd = upperBound; // 高位段的结束下标
        int j = 0; // workSpace的下标指针
        int n = upperBound - lowerBound + 1; // 归并的元素总数

        while (lowBegin <= lowEnd && highBegin <= highEnd) {
            if (array[lowBegin] < array[highBegin]) {// 将两者较小的那个放到workSpace中
                workSpace[j++] = array[lowBegin++];
            } else {
                workSpace[j++] = array[highBegin++];
            }
        }

        while (lowBegin <= lowEnd) {
            workSpace[j++] = array[lowBegin++];
        }

        while (highBegin <= highEnd) {
            workSpace[j++] = array[highBegin++];
        }

        for (j = 0; j < n; j++) { // 将归并好的元素复制到array中
            array[lowerBound++] = workSpace[j];
        }

    }
}
