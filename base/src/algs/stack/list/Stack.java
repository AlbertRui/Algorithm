package algs.stack.list;

import java.util.Iterator;

/**
 * 基于链表实现下压堆栈
 *
 * @author AlbertRui
 * @date 2018-03-28 19:04
 */
@SuppressWarnings("ALL")
public class Stack<Item> implements Iterable<Item> {

    //栈顶，最近添加的元素
    private Node first;
    //元素数量
    private int N;

    /**
     * 定义结点的嵌套类
     */
    private class Node {
        Item item;
        Node next;
    }

    /**
     * 判断栈是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return first == null;//或N==0
    }

    /**
     * 获取栈中元素个数
     *
     * @return
     */
    public int size() {
        return N;
    }

    /**
     * 向栈顶添加元素
     *
     * @param item
     */
    public void push(Item item) {

        Node oldfirst = first;

        first = new Node();
        first.item = item;
        first.next = oldfirst;

        N++;

    }

    /**
     * 从栈顶删除元素
     *
     * @return
     */
    public Item pop() {

        Item item = first.item;
        first = first.next;

        N--;

        return item;

    }

    /**
     * 打印栈
     */
    public void printStack() {
        for (Node node = first; node != null; node = node.next) {
            System.out.println(node.item);
        }
    }

    /**
     * 返回一个可以迭代栈中元素的迭代器
     *
     * @return
     */
    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

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
