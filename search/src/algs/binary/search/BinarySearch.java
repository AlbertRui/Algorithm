package algs.binary.search;

import java.util.NoSuchElementException;

/**
 * 二分查找，基于有序数组
 *
 * @param <Key>
 * @param <Value>
 * @author ZhangRui
 * @date 2017年10月25日
 * @time 上午11:02:12
 */
public class BinarySearch<Key extends Comparable<Key>, Value> {

    private Key[] keys;
    private Value[] values;
    private int n;

    /**
     * 初始化keys和values;
     *
     * @param capacity
     */
    @SuppressWarnings("unchecked")
    public BinarySearch(int capacity) {
        keys = (Key[]) new Comparable[capacity];
        values = (Value[]) new Object[capacity];
    }

    /**
     * 获取数组长度
     *
     * @return
     */
    public int size() {
        return n;
    }

    /**
     * 获取键所对应的值
     *
     * @param key
     * @return
     */
    public Value get(Key key) {
        if (isEmpty())
            return null;
        int i = rank(key);
        if (i < n && keys[i].compareTo(key) == 0)
            return values[i];
        return null;
    }

    /**
     * 键key是否存在于表中
     *
     * @param key
     * @return
     */
    public boolean contains(Key key) {
        return get(key) != null;
    }

    /**
     * 查找键，找到则更新其值，否则创建新的元素
     *
     * @param key
     * @param value
     */
    public void put(Key key, Value value) {
        int i = rank(key);
        if (i < n && keys[i].compareTo(key) == 0) {
            values[i] = value;
            return;
        }
        for (int j = n; j > i; j--) {
            keys[j] = keys[j - 1];
            values[j] = values[j - 1];
        }
        keys[i] = key;
        values[i] = value;
        n++;
    }

    /**
     * 基于有序数组的二分查找
     *
     * @param key
     * @return
     */
    private int rank(Key key) {
        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int cmp = key.compareTo(keys[mid]);
            if (cmp < 0)
                high = mid - 1;
            else if (cmp > 0)
                low = mid + 1;
            else
                return mid;
        }
        return low;
    }

    public Key min() {
        if (isEmpty()) throw new NoSuchElementException("called min() with empty symbol table");
        return keys[0];
    }

    /**
     * Returns the largest key in this symbol table.
     *
     * @return the largest key in this symbol table
     * @throws NoSuchElementException if this symbol table is empty
     */
    public Key max() {
        if (isEmpty()) throw new NoSuchElementException("called max() with empty symbol table");
        return keys[n - 1];
    }

    /**
     * Return the kth smallest key in this symbol table.
     *
     * @param k the order statistic
     * @return the {@code k}th smallest key in this symbol table
     * @throws IllegalArgumentException unless {@code k} is between 0 and
     *                                  <em>n</em>â€“1
     */
    public Key select(int k) {
        if (k < 0 || k >= size()) {
            throw new IllegalArgumentException("called select() with invalid argument: " + k);
        }
        return keys[k];
    }

    /**
     * Returns the largest key in this symbol table less than or equal to {@code key}.
     *
     * @param key the key
     * @return the largest key in this symbol table less than or equal to {@code key}
     * @throws NoSuchElementException   if there is no such key
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public Key floor(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to floor() is null");
        int i = rank(key);
        if (i < n && key.compareTo(keys[i]) == 0) return keys[i];
        if (i == 0) return null;
        else return keys[i - 1];
    }

    /**
     * Returns the smallest key in this symbol table greater than or equal to {@code key}.
     *
     * @param key the key
     * @return the smallest key in this symbol table greater than or equal to {@code key}
     * @throws NoSuchElementException   if there is no such key
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public Key ceiling(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to ceiling() is null");
        int i = rank(key);
        if (i == n) return null;
        else return keys[i];
    }

    /**
     * 判空
     *
     * @return
     */
    private boolean isEmpty() {
        return size() == 0;
    }
}