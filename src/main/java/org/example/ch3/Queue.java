package org.example.ch3;

/**
 * queue
 * @param <T> element type
 */
public class Queue<T> {
    //front pointer: always point to the head of queue
    QueueNode<T> front;
    //rear pointer: always point to the tail of queue
    QueueNode<T> rear;
    //queue head
    QueueNode<T> head;

    /**
     * constructor.
     */
    public Queue() {
        // create empty queue. front and rear both point to head.
        front = rear = head = new QueueNode<>();
    }

    /**
     * if it is an empty queue.
     * @return <code>true</code> if front and rear both point to head
     */
    public boolean isEmpty() {
        return front == head && rear == head;
    }

    /**
     * put element into queue.
     * @param data data needs to input into queue
     */
    public void enQueue(T data) {
        QueueNode<T> newNode = new QueueNode<>();
        newNode.data = data;
        rear.next = newNode;
        rear = newNode;
    }

    /**
     * pull out element from queue.
     * @return element
     */
    public QueueNode<T> deQueue() {
        QueueNode result = null;
        if (!this.isEmpty()) {
            result = front.next;
            QueueNode<T> newHead = result.next;
            //if it is the last element in queue, after pull out, set the queue to be empty
            if (newHead == null) {
                rear = front;
            }
            front.next = newHead;
        }
        return result;
    }

    /**
     * number of elements in queue.
     * @return size of queue
     */
    public int getQueueSize() {
        int size = 0;
        if (!this.isEmpty()) {
            QueueNode<T> current = front;
            while (current != rear) {
                current = current.next;
                size++;
            }
        }
        return size;
    }

    /**
     * clear queue.
     */
    public void clear() {
        //set queue at the status of initiation
        front = rear = head;
        head.next = null;
    }

    public static void main(String[] args) {
        Queue<String> queue = new Queue<>();
        queue.enQueue("a");
        queue.enQueue("b");
        System.out.println(queue.getQueueSize());
        System.out.println(queue.deQueue().data);
        System.out.println(queue.isEmpty());
        System.out.println(queue.getQueueSize());

    }
}

class QueueNode<T> {
    T data;
    QueueNode next;
}
