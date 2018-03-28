package algs.stack.array;

/**
 * 基于数组实现定容栈
 *
 * @author AlbertRui
 * @date 2018-03-28 17:59
 */
@SuppressWarnings("ALL")
public class FixedCapacityStack<Item> {

    private Item[] a;
    private int N;

    public FixedCapacityStack(int cap) {
        a = (Item[]) new Object[cap];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void push(Item item) {
        a[N++] = item;
    }

    public Item pop() {
        return a[--N];
    }

}
