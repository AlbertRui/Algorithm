package algs.sequential.search;

import algs.binary.search.util.Queue;

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
    }

    public Iterable<Key> keys()  {
        Queue<Key> queue = new Queue<Key>();
        for (Node x = first; x != null; x = x.next)
            queue.enqueue(x.key);
        return queue;
    }

}
