package org.example.ch3;

/**
 * circular queue.
 * @param <T> element type
 */
public class CircularQueue<T> {
    T[] elements;
    int front;
    int rear;
    // max size
    private final int CAPABILITY = 7;

    /**
     * constructor.
     * create an empty queue.
     */
    public CircularQueue() {
        elements = (T[]) new Object[CAPABILITY];
        front = rear = 0;
    }

    /**
     * identify if queue is full.
     * @return <code>true</code> if full
     */
    public boolean isFull() {
        // +1 for placeholder
        return (rear + 1) % CAPABILITY == front;
    }

    /**
     * identify if queue is empty
     * @return
     */
    public boolean isEmpty() {
        return rear == front;
    }

    /**
     * put element into queue.
     * @param data data
     * @return <code>true</code> if success
     */
    public boolean enQueue(T data) {
        if (!this.isFull()) {
            elements[rear] = data;
            rear++;
            return true;
        }
        return false;
    }

    /**
     * pull element from queue
     * @return data
     */
    public T deQueue() {
        if(!this.isEmpty()) {
            T result = elements[front];
            front++;
            return result;
        }
        return null;
    }

    public int getSize() {
        return (rear - front + CAPABILITY) % CAPABILITY;
    }

    public static void main(String[] args) {
        CircularQueue<String> queue = new CircularQueue<>();
        queue.enQueue("a");
        queue.enQueue("b");
        queue.enQueue("c");
        queue.enQueue("d");
        queue.enQueue("e");
        queue.enQueue("f");
        System.out.println(queue.enQueue("g"));

        System.out.println(queue.deQueue());
        System.out.println(queue.enQueue("g"));
        System.out.println(queue.deQueue());

        System.out.println(queue.getSize());
    }
}
