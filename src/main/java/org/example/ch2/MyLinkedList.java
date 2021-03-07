package org.example.ch2;

import java.util.Iterator;

public class MyLinkedList<T> implements Iterable<T> {
    private int size;//this for reduce time complex from O(N) to O(1).
    private int modCount = 0;
    private Node<T> head;
    private Node<T> rear;

    public MyLinkedList() {
        doClear();
    }

    public void clear() {
        doClear();
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    //insert at rear
    public boolean add(T x) {
        add(size, x);
        return true;
    }

    public void add(int idx, T x) {
        addBefore(getNode(idx, 0, size), x);
    }

    public T get(int idx) {
        return getNode(idx).data;
    }

    public T set(int idx, T newVal) {
        Node<T> p = getNode(idx);
        T oldVal = p.data;
        p.data = newVal;
        return oldVal;
    }

    public T remove(int idx) {
        return remove(getNode(idx));
    }

    private void addBefore(Node<T> node, T x) {
        Node<T> newNode = new Node<>(x, node.previous, node);
        node.previous.next = newNode;
        node.previous = newNode;
        size++;
        modCount++;



    }
    private Node<T> getNode(int idx) {
        return getNode(idx, 0, size - 1);
    }

    private Node<T> getNode(int idx, int from, int to) {
        Node<T> p;
        if (idx < from || idx > to)
            throw new IndexOutOfBoundsException();

        if (idx < size / 2) {
            p = head.next;
            for (int i = 0; i < idx; i++) {
                p = p.next;
            }
        } else {
            p = rear.previous;
            for (int i = size - 1; i > idx; i--) {
                p = p.previous;
            }
        }
        return p;
    }

    private T remove(Node<T> node) {
        node.previous.next = node.next;
        node.next.previous = node.previous;
        size--;
        modCount++;
        return node.data;
    }

    private void doClear() {
        head = new Node<>(null, null, null);
        rear = new Node<>(null, head, null);
        head.next = rear;
        size = 0;
        modCount++;//record change times since from list created.


    }


    public Iterator iterator() {
        return new MyListIterator();
    }

    private static class Node<T> {
        public Node<T> previous;
        public Node<T> next;
        public T data;

        public Node(T data, Node<T> previous, Node<T> next) {
            this.data = data;
            this.previous = previous;
            this.next = next;
        }
    }

    private class MyListIterator<T> implements Iterator<T> {

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public T next() {
            return null;
        }
    }
}
