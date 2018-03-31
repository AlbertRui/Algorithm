package algs.hash;

import algs.binary.search.util.Queue;
import algs.sequential.search.SequentialSearch;

/**
 * 基于拉链法的散列表
 *
 * @author AlbertRui
 * @date 2018-03-31 20:00
 */
public class SeparateChainingHashST<Key, Value> {

    private static final int INIT_CAPACITY = 4;

    private int N;//键值对总数
    private int M;//散列表大小
    private SequentialSearch<Key, Value>[] st;//存放链表对象的数组

    public SeparateChainingHashST() {
        this(INIT_CAPACITY);
    }

    public SeparateChainingHashST(int M) {
        this.M = M;//创建M条链表
        st = (SequentialSearch<Key, Value>[]) new SequentialSearch[M];
        for (int i = 0; i < M; i++) {
            st[i] = new SequentialSearch<>();
        }
    }

    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Returns true if this symbol table contains the specified key.
     *
     * @param key the key
     * @return {@code true} if this symbol table contains {@code key};
     * {@code false} otherwise
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public boolean contains(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to contains() is null");
        return getValue(key) != null;
    }

    /**
     * Inserts the specified key-value pair into the symbol table, overwriting the old
     * value with the new value if the symbol table already contains the specified key.
     * Deletes the specified key (and its associated value) from this symbol table
     * if the specified value is {@code null}.
     *
     * @param key the key
     * @param val the value
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public void put(Key key, Value val) {
        if (key == null) throw new IllegalArgumentException("first argument to put() is null");
        if (val == null) {
            delete(key);
            return;
        }

        // double table size if average length of list >= 10
        if (N >= 10 * M) resize(2 * M);

        int i = hash(key);
        if (!st[i].contains(key)) N++;
        st[i].put(key, val);
    }

    /**
     * Removes the specified key and its associated value from this symbol table
     * (if the key is in this symbol table).
     *
     * @param key the key
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public void delete(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to delete() is null");

        int i = hash(key);
        if (st[i].contains(key)) N--;
        st[i].delete(key);

        // halve table size if average length of list <= 2
        if (M > INIT_CAPACITY && N <= 2 * M) resize(M / 2);
    }

    // resize the hash table to have the given number of chains,
    // rehashing all of the keys
    private void resize(int chains) {
        SeparateChainingHashST<Key, Value> temp = new SeparateChainingHashST<Key, Value>(chains);
        for (int i = 0; i < M; i++) {
            for (Key key : st[i].keys()) {
                temp.put(key, st[i].getValue(key));
            }
        }
        this.M = temp.M;
        this.N = temp.N;
        this.st = temp.st;
    }

    private int hash(Key key) {
        //这里想与是为了去掉符号位
        return (key.hashCode() & 0x7fffffff) % M;
    }

    public Value getValue(Key key) {
        return st[hash(key)].getValue(key);
    }

    public Iterable<Key> keys() {
        Queue<Key> queue = new Queue<Key>();
        for (int i = 0; i < M; i++) {
            for (Key key : st[i].keys())
                queue.enqueue(key);
        }
        return queue;
    }

}
