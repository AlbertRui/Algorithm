package algs.heap.max;

/**
 * @author AlbertRui
 * @date 2018-03-21 19:33
 */
public class MaxHeap<Item extends Comparable> {
    protected Item[] data;
    protected int count;
    private int capacity;

    /**
     * 根据堆的容量建堆
     *
     * @param capacity
     */
    public MaxHeap(int capacity) {
        data = (Item[]) new Comparable[capacity + 1];
        this.count = 0;
        this.capacity = capacity;
    }

    /**
     * 根据数组建堆
     *
     * @param arr
     */
    public MaxHeap(Item[] arr) {
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
     *
     * @param item
     */
    public void insert(Item item) {
        assert count < capacity;
        data[++count] = item;
        swim(count);
    }

    /**
     * 取出最大元素
     *
     * @return
     */
    public Item extractMax() {
        assert count > 0;
        Item ret = data[1];
        swap(1, count--);
        sink(1);
        return ret;
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
     *
     * @param i
     * @param j
     * @return
     */
    private boolean less(int i, int j) {
        return data[i].compareTo(data[j]) < 0;
    }

    /**
     * 交换下标所对应的元素
     *
     * @param i
     * @param j
     */
    private void swap(int i, int j) {
        Item temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    public static void main(String[] args) {
        MaxHeap<Integer> maxHeap = new MaxHeap<>(15);
        System.out.println(maxHeap.size());

        for (int i = 0; i < maxHeap.capacity; i++) {
            maxHeap.insert((int) (Math.random() * 100));
        }
        System.out.println(maxHeap.size());
        for (int i = 0; i < maxHeap.capacity; i++) {
            System.out.print(maxHeap.extractMax() + " ");
            if ((i + 1) % 10 == 0) {
                System.out.println();
            }
        }
        System.out.println();
        System.out.println(maxHeap.size());
    }
}
