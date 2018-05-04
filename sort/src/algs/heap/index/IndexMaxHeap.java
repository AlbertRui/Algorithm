package algs.heap.index;

/**
 * 普通索引堆
 *
 * @author AlbertRui
 * @date 2018-03-22 15:58
 */
@SuppressWarnings("ALL")
public class IndexMaxHeap<Item extends Comparable<Item>> {
    private Item[] data;
    private int[] indexes;
    private int count;
    private int capacity;

    /**
     * 根据堆的容量建堆
     *
     * @param capacity
     */
    public IndexMaxHeap(int capacity) {
        data = (Item[]) new Comparable[capacity + 1];
        indexes = new int[capacity + 1];
        this.count = 0;
        this.capacity = capacity;
    }

    /**
     * 根据数组建堆
     *
     * @param arr
     */
    public IndexMaxHeap(Item[] arr) {
        int len = arr.length;
        data = (Item[]) new Comparable[len + 1];
        capacity = len;
        for (int i = 0; i < arr.length; i++) {
            data[i + 1] = arr[i];
        }
        count = len;
        for (int i = count / 2; i > 0; i--) {
            sink(i);
        }
    }

    /**
     * 得到堆中元素的个数
     *
     * @return
     */
    public int size() {
        return count;
    }

    /**
     * 判断堆是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return count == 0;
    }

    /**
     * 在堆中插入一个元素
     * 传入的i对用户而言，是从零开始的
     *
     * @param item
     */
    public void insert(int i, Item item) {
        assert count < capacity;
        assert i >= 0 && i < capacity;
        data[++i] = item;
        indexes[++count] = i;
        swim(count);
    }

    /**
     * 取出最大元素
     *
     * @return
     */
    public Item extractMax() {
        assert count > 0;
        Item ret = data[indexes[1]];
        swap(1, count--);
        sink(1);
        return ret;
    }

    /**
     * 得到最大元素所对应的索引
     *
     * @return
     */
    public int extractMaxIndex() {
        assert count > 0;
        int ret = indexes[1] - 1;
        swap(1, count--);
        sink(1);
        return ret;
    }

    /**
     * 根据索引值返回元素的值
     *
     * @param index
     * @return
     */
    public Item getItem(int index) {
        return data[index + 1];
    }

    /**
     * 将索引为index的元素的值改变为item
     *
     * @param index
     * @param item
     */
    public void changeItemByIndex(int index, Item item) {
        data[++index] = item;
        //i代表元素data[index]在堆中的位置
        for (int i = 1; i <= count; i++) {
            if (indexes[i] == index) {
                swim(i);
                sink(i);
                return;
            }
        }
    }

    /**
     * 上浮操作
     *
     * @param k
     */
    private void swim(int k) {
        while (k > 1 && less(k / 2, k)) {
            swap(k / 2, k);
            k /= 2;
        }
    }

    /**
     * 下沉操作
     *
     * @param k
     */
    private void sink(int k) {
        while (2 * k <= count) {
            int j = 2 * k;
            if (j < count && less(j, j + 1)) {
                j++;
            }
            if (!less(k, j)) {
                break;
            }
            swap(j, k);
            k = j;
        }
    }

    /**
     * 比较两个元素的大小
     * 注意：根据索引取值
     *
     * @param i
     * @param j
     * @return
     */
    private boolean less(int i, int j) {
        return data[indexes[i]].compareTo(data[indexes[j]]) < 0;
    }

    /**
     * 交换下标所对应的索引
     *
     * @param i
     * @param j
     */
    private void swap(int i, int j) {
        int temp = indexes[i];
        indexes[i] = indexes[j];
        indexes[j] = temp;
    }

}
