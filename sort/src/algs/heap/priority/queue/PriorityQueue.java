package algs.heap.priority.queue;

/**
 * 基于堆的优先队列
 *
 * @param <Key>
 * @author ZhangRui
 * @date 2017年10月23日
 * @time 下午8:40:55
 */
public class PriorityQueue<Key extends Comparable<Key>> {

    //基于堆的完全二叉树
    private Key[] pq;
    //存储于pq[1..N]中，pq[0]没有使用
    private int N = 0;

    /**
     * 初始化一个大小为maxN的堆
     */
    public PriorityQueue(int maxN) {
        pq = (Key[]) new Comparable[maxN + 1];
    }

    /**
     * 判断有限队列是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return N == 0;
    }

    /**
     * 返回优先队列中元素的个数
     *
     * @return
     */
    public int size() {
        return N;
    }

    /**
     * 向优先队列中插入元素
     *
     * @param v
     */
    public void insert(Key v) {
        pq[++N] = v;
        swim(N);
    }

    /**
     * 最大元素出队
     *
     * @return
     */
    public Key delMax() {
        Key max = pq[1];
        exch(1, N--);
        pq[N + 1] = null;
        sink(1);
        return max;
    }

    /**
     * 元素下沉
     *
     * @param k
     */
    private void sink(int k) {
        while (2 * k <= N) {
            int j = 2 * k;
            if (j < N && less(j, j + 1)) {
                j++;
            }
            if (!less(k, j)) {
                break;
            }
            exch(k, j);
            k = j;
        }
    }

    /**
     * 元素上浮
     *
     * @param k
     */
    private void swim(int k) {
        while (k > 1 && less(k / 2, k)) {
            exch(k / 2, k);
            k = k / 2;
        }
    }

    /**
     * 元素交换
     *
     * @param i
     * @param j
     */
    private void exch(int i, int j) {
        Key temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }

    /**
     * 比较元素大小
     *
     * @param i
     * @param j
     * @return
     */
    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }
}
