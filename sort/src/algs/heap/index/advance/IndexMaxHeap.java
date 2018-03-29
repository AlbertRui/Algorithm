package algs.heap.index.advance;

/**
 * 索引堆,添加reverse数组优化
 * 用户索引从零开始
 *
 * @author AlbertRui
 * @date 2018-03-22 15:58
 */
@SuppressWarnings("ALL")
public class IndexMaxHeap<Item extends Comparable<Item>> {
    //堆中的元素
    private Item[] data;
    //在堆中i位置元素的索引indexes[i]
    private int[] indexes;
    //堆中元素的个数
    private int count;
    //堆的容量
    private int capacity;
    //索引i在堆中的位置reverse[i]
    private int[] reverse;

    /**
     * 根据堆的容量建堆
     *
     * @param capacity
     */
    public IndexMaxHeap(int capacity) {
        this.data = (Item[]) new Comparable[capacity + 1];
        this.indexes = new int[capacity + 1];
        this.reverse = new int[capacity + 1];
        //对reverse显示的进行初始化{实际上不必，java默认初始化int型数组元素为零}
        for (int i = 0; i <= capacity; i++) {
            reverse[i] = 0;
        }
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
        reverse[i] = count;
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
     * 对于用户而言，索引从零开始
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
     * 对于用户而言，索引从零开始
     *
     * @param index
     * @return
     */
    public Item getItem(int index) {
        assert (contain(index));
        return data[index + 1];
    }

    /**
     * 将索引为index的元素的值改变为item
     * index这个索引由用户调用，面向用户从零开始
     *
     * @param index
     * @param item
     */
    public void changeItemByIndex(int index, Item item) {
        assert (contain(index));
        data[++index] = item;
        //i代表元素data[index]在堆中的位置
        int i = reverse[index];
        swim(i);
        sink(i);
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
     * 同时维护reverse数组
     *
     * @param i
     * @param j
     */
    private void swap(int i, int j) {
        int temp = indexes[i];
        indexes[i] = indexes[j];
        indexes[j] = temp;
        reverse[indexes[i]] = i;
        reverse[indexes[j]] = j;
    }

    /**
     * 判断索引值所对饮的元素是否在堆中
     * 注意：用户索引从零开始
     *
     * @param index
     * @return
     */
    private boolean contain(int index) {
        assert (index >= 0 && index < capacity);
        return reverse[index + 1] != 0;
    }

}
