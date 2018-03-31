package algs.sequential.search;

import algs.util.Queue;

/**
 * ˳����ң�������������
 *
 * @param <Key>
 * @param <Value>
 * @author ZhangRui
 * @date 2017��10��24��
 * @time ����11:08:07
 */
public class SequentialSearch<Key, Value> {

    private int n;//˳����м�ֵ�Եĸ���
    private Node first; //�����׽ڵ�

    /**
     * ��������ڵ�
     *
     * @author ZhangRui
     * @date 2017��10��24��
     * @time ����11:04:15
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
     * ����˳����м�ֵ�Եĸ���
     *
     * @return
     */
    public int size() {
        return n;
    }

    /**
     * �п�
     *
     * @return
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean contains(Key key) {
        return getValue(key) != null;
    }

    /**
     * ���Ҹ����ļ���������valueֵ
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
     * ���Ҹ����ļ����ҵ��������ֵ���������׽ڵ��½����
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
        n++;
    }

    public Iterable<Key> keys() {
        Queue<Key> queue = new Queue<Key>();
        for (Node x = first; x != null; x = x.next)
            queue.enqueue(x.key);
        return queue;
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
        first = delete(first, key);
    }

    // delete key in linked list beginning at Node x
    // warning: function call stack too large if table is large
    private Node delete(Node x, Key key) {
        if (x == null) return null;
        if (key.equals(x.key)) {
            n--;
            return x.next;
        }
        x.next = delete(x.next, key);
        return x;
    }

}
