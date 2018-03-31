package algs.hash;

import algs.binary.search.util.Queue;
import algs.sequential.search.SequentialSearch;

/**
 * @author AlbertRui
 * @date 2018-03-31 20:00
 */
public class SeparateChainingHashST<Key, Value> {

    private int N;//键值对总数
    private int M;//散列表大小
    private SequentialSearch<Key, Value>[] st;//存放链表对象的数组

    public SeparateChainingHashST() {
        this(997);
    }

    public SeparateChainingHashST(int M) {
        this.M = M;//创建M条链表
        st = (SequentialSearch<Key, Value>[]) new SequentialSearch[M];
        for (int i = 0; i < M; i++) {
            st[i] = new SequentialSearch<>();
        }
    }

    private int hash(Key key) {
        //这里想与是为了去掉符号位
        return (key.hashCode() & 0x7fffffff) % M;
    }

    public Value get(Key key) {
        return st[hash(key)].getValue(key);
    }

    public void put(Key key, Value value) {
        st[hash(key)].put(key, value);
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
