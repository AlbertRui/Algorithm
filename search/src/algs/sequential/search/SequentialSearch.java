package algs.sequential.search;

import algs.binary.search.util.Queue;

/**
 * 顺序查找，基于无序链表
 *
 * @param <Key>
 * @param <Value>
 * @author ZhangRui
 * @date 2017年10月24日
 * @time 下午11:08:07
 */
public class SequentialSearch<Key, Value> {

    private Node first; //链表首节点

    /**
     * 定义链表节点
     *
     * @author ZhangRui
     * @date 2017年10月24日
     * @time 下午11:04:15
     */
    private class Node {
        Key key;
        Value value;
        Node next;

        public Node(Key key, Value value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    /**
     * 查找给定的键，返回其value值
     *
     * @param key
     * @return
     */
    public Value getValue(Key key) {
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key))
                return x.value;
        }
        return null;
    }

    /**
     * 查找给定的键，找到则更新其值，否则在首节点新建结点
     *
     * @param key
     * @param value
     */
    public void put(Key key, Value value) {
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                x.value = value;
                return;
            }
        }
        first = new Node(key, value, first);
    }

    public Iterable<Key> keys()  {
        Queue<Key> queue = new Queue<Key>();
        for (Node x = first; x != null; x = x.next)
            queue.enqueue(x.key);
        return queue;
    }

}
