package org.example.ch2;

public class NodeList<T extends Comparable> {
    private int size;
    private final Node<T> head;
    //private Node<T> tail;

    public NodeList() {
        size = 0;
        head = new Node<>();
        //tail = head;
    }

    @SafeVarargs
    public NodeList(T... dataPoints) {
        this();
        for (T data : dataPoints) {
            insertAtLast(data);
        }
    }

    public void insertAtLast(T data) {
        Node<T> temp = new Node<>();
        temp.data = data;
        Node<T> tail = head;
        while(tail.next != null) {
            tail = tail.next;
        }
        tail.next = temp;
        //tail = temp;
        size++;
    }

    public Node<T> locate(T data) {
        Node<T> result;
        result = head;
        while (result.next != null) {
            if (result.next.data == data) {
                break;
            }
            result = result.next;
        }
        return result.next;
    }

    public void insert(T data, Node<T> node) {
        if (node.next == null) {
            insertAtLast(data);
            return;
        }
        Node<T> temp = new Node<>();
        temp.data = data;
        temp.next = node.next;
        node.next = temp;
        size++;
    }

    public void insertAt(T data, int index) {
        T dataAtIndex = getData(index);
        Node<T> node = locate(dataAtIndex);
        insert(data, node);
    }

    public void deleteAt(int index) {
        if (index < 1 || index > size) {
            throw new IndexOutOfBoundsException("index should between 1 to " + size);
        }

        int position = 1;
        Node<T> current = head;
        while (current != null && position < index) {
            current = current.next;
            position++;
        }
        if (current != null) {
            current.next = current.next.next;
            size--;
        }
    }

    public T getData(int index) {
        if (index < 1 || index > size) {
            throw new IndexOutOfBoundsException("index should between 1 to " + size);
        }
        T data = null;
        int i = 1;
        Node<T> current = head.next;
        while (current != null) {
            if (i < index) {
                current = current.next;
                i++;
            }
            if (i == index) {
                data = current.data;
                break;
            }
        }
        return data;
    }

    public int getSize() {
        return size;
    }

    public NodeList<T> merge(NodeList<T> lb) {
        NodeList<T> la = this;
        NodeList<T> lc = new NodeList<>();
        Node<T> pa = la.head.next;
        Node<T> pb = lb.head.next;
        Node<T> pc = lc.head;

        while (pa.next != null && pb.next != null) {
            if (pa.data.equals(pb.data)) {
                pc.next = pa;
                pc = pa;
                pa = pa.next;
                pb = pb.next;
            } else if (pa.data.compareTo(pb.data) < 0) {
                pc.next = pa;
                pc = pa;
                pa = pa.next;
            } else {
                pc.next = pb;
                pc = pb;
                pb = pb.next;
            }
        }

        if (pa.next != null) {
            pc.next = pa;
        }

        if (pb.next != null) {
            pc.next = pb;
        }

        Node<T> current = lc.head;
        while (current.next != null) {
            lc.size++;
            current = current.next;
        }
        return lc;
    }
}

/**
 * node list class.
 * @param <T> node element data type
 */
class Node<T> {
    T data;
    Node<T> next;
}
