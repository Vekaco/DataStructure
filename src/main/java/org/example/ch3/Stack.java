package org.example.ch3;

/**
 * stack
 * @param <T> element type
 */
public class Stack<T> {
    // capability of stack
    private static int MAX_SIZE = 20;
    private int size;
    private T[] elements;

    /**
     * initiate empty stack.
     */
    public Stack() {
        size = 0;
        elements = (T[]) new Object[MAX_SIZE];
    }

    /**
     * push data into stack
     * @param data data
     * @return <code>true</code> if push success
     */
    public boolean push(T data) {
        //outage of stack
        if (size > MAX_SIZE) {
            return false;
        }

        elements[size++] = data;
        return true;
    }

    /**
     * pop data from stack.
     * @return data from top of stack
     */
    public T pop() {
        if (size == 0) {
            return null;
        }
        return elements[--size];
    }

    /**
     * read top of stack.
     * @return data of the stack
     */
    public T getTop() {
        if (size > 0) {
            return elements[size - 1];
        }
        return null;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        size = 0;
    }

    public int getSize() {
        return size;
    }
}
