package org.example.ch2;

/**
 * circular list.
 * @param <T> element type
 */
public class CircularNodeList<T extends Comparable> {
    private int size;
    private Node2<T> head = new Node2<>();

    /**
     * constructor. create an empty list.
     */
    public CircularNodeList() {
        size = 0;
        head.next = head;
        head.previous = head;
    }

    /**
     * identify if list is empty.
     * @return <code>true</code> if empty
     */
    public boolean isEmpty() {
        return head.next == head && head.previous == head;
    }

    /**
     * find element node by specific position.
     * @param position position specific
     * @return the node
     */
    public Node2<T> find(int position) {
        if (position < 1 || position > size) {
            throw new IndexOutOfBoundsException("position should between 1 to " + size);
        }
        Node2<T> current = head;
        int idx = 0;

        while (idx < position) {
            current = current.next;
            idx++;
        }

        if (current != head) {
            return current;
        }
        return null;
    }

    /**
     * insert at list tail.
     * @param data data of the node to be insert
     */
    public void insert(T data) {
        insert(data, size + 1);
    }

    /**
     * insert new node at specific position.
     * @param data new node data
     * @param position specific position
     */
    public void insert(T data, int position) {
        Node2<T> newNode = new Node2<>();
        newNode.data = data;

        // if it is to be insert at list tail
        if (position == size + 1) {
            newNode.previous = head.previous.next;
            head.previous.next = newNode;
            newNode.next = head;
            head.previous = newNode;
            size++;
            return;
        }
        // if it is to be insert in the existing list.
        Node2<T> node = find(position);
        if (node != null) {
            node.previous.next = newNode;
            newNode.previous = node.previous;
            node.previous = newNode;
            newNode.next = node;
            size++;
        }
    }

    /**
     * delete node at specific position from list
     * @param position specific position
     * @return the data deleted
     */
    public T delete(int position) {
        T data = null;
        if (position < 1 || position > size) {
            throw new IndexOutOfBoundsException("position should between 1 to " + size);
        }
        Node2<T> node = find(position);
        if (node != null) {
            node.previous.next = node.next;
            node.next.previous = node.previous;
            size--;
            data = node.data;
        }
        return data;
    }

    /**
     * get the prior of the specific position node.
     * @param position specific position
     * @return the prior of the specific node
     */
    public Node2<T> getPrior(int position) {
        Node2<T> node = find(position);
        return node.previous;
    }

    /**
     * get the next of the specific position node.
     * @param position specific position
     * @return the next of th specific node
     */
    public Node2<T> getNext(int position) {
        Node2<T> node = find(position);
        return node.next;
    }

    public int getSize() {
        return this.size;
    }
 
}

class Node2<T> {
    T data;
    Node2<T> next;
    Node2<T> previous;
}