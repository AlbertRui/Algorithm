package algs.util;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * @author AlbertRui
 * @date 2018-03-28 17:06
 */
public class Bag<Item> implements Iterable<Item> {
    private Node<Item> first;    // beginning of algs.bag
    private int n;               // number of elements in algs.bag

    // helper linked list class
    private static class Node<Item> {
        private Item item;
        private Node<Item> next;
    }

    /**
     * Initializes an empty algs.bag.
     */
    public Bag() {
        first = null;
        n = 0;
    }

    /**
     * Returns true if this algs.bag is empty.
     *
     * @return {@code true} if this algs.bag is empty;
     * {@code false} otherwise
     */
    public boolean isEmpty() {
        return first == null;
    }

    /**
     * Returns the number of items in this algs.bag.
     *
     * @return the number of items in this algs.bag
     */
    public int size() {
        return n;
    }

    /**
     * Adds the item to this algs.bag.
     *
     * @param item the item to add to this algs.bag
     */
    public void add(Item item) {
        Node<Item> oldfirst = first;
        first = new Node<Item>();
        first.item = item;
        first.next = oldfirst;
        n++;
    }


    /**
     * Returns an iterator that iterates over the items in this algs.bag in arbitrary order.
     *
     * @return an iterator that iterates over the items in this algs.bag in arbitrary order
     */
    public Iterator<Item> iterator() {
        return new ListIterator<Item>(first);
    }

    // an iterator, doesn't implement remove() since it's optional
    private class ListIterator<Item> implements Iterator<Item> {
        private Node<Item> current;

        public ListIterator(Node<Item> first) {
            current = first;
        }

        public boolean hasNext() {
            return current != null;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    /**
     * Unit tests the {@code Bag} data type.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        Bag<String> bag = new Bag<String>();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String item = scanner.next();
            bag.add(item);
        }

        System.out.println("size of algs.bag = " + bag.size());
        for (String s : bag) {
            System.out.println(s);
        }
    }

}

