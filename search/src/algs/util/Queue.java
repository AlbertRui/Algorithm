package algs.util;

import java.util.Iterator;

/**
 * 基于链表实现队列
 *
 * @author AlbertRui
 * @date 2018-03-28 17:34
 */
public class Queue<Item> implements Iterable<Item> {

    //指向最早添加的节点的链接
    private Node first;
    //指向最近添加的节点的链接
    private Node last;
    //队列中元素数量
    private int N;

    /**
     * 定义结点的嵌套类
     */
    private class Node {
        Item item;
        Node next;
    }

    /**
     * 获取队列中元素的个数
     *
     * @return
     */
    public int size() {
        return N;
    }

    /**
     * 判断队列是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return first == null;//或N==0；
    }

    /**
     * 向表尾中添加元素
     *
     * @param item
     */
    public void enqueue(Item item) {
        Node oldlast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()) {
            first = last;
        } else {
            oldlast.next = last;
        }
        N++;
    }

    /**
     * 从表头删除元素
     *
     * @return
     */
    public Item dequeue() {
        Item item = first.item;
        first = first.next;
        if (isEmpty()) {
            last = null;
        }
        N--;
        return item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    /**
     * 实现迭代
     */
    private class ListIterator implements Iterator<Item> {

        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        public void remove() {

        }

        @Override
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

}
