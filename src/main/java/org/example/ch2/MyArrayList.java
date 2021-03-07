package org.example.ch2;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Spliterator;
import java.util.function.Consumer;

public class MyArrayList<T> implements Iterable<T> {
    private final int DEFAULT_CAPABILITY = 10;
    private int size;
    private T[] items;

    public MyArrayList() {
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

    public void trimToSize() {
        ensureCapability(size);
    }

    public T get(int idx) {
        if (idx < 0 || idx >= size)
            throw new ArrayIndexOutOfBoundsException();

        return items[idx];
    }

    public T set(int idx, T newValue) {
        if (idx < 0 || idx >= size)
            throw new ArrayIndexOutOfBoundsException();
        T old = items[idx];
        items[idx] = newValue;
        return old;
    }

    public void add(T val) {
        //add at last
        add(size, val);
    }

    public void add(int idx, T val) {
        if (items.length == size) {
            //full
            ensureCapability(size * 2 + 1);
        }

        for (int i = size + 1; i < idx; i--) {
            items[i] = items[i - 1];
        }
        items[idx] = val;
        size++;
    }

    public T remove(int idx) {
        if (idx < 0 || idx >= size)
            throw new ArrayIndexOutOfBoundsException();

        T old = items[idx];
        for (int i = idx; i < size; i++) {
            items[i] = items[i + 1];
        }
        size--;
        return old;
    }

    private void doClear() {
        size = 0;
        ensureCapability(DEFAULT_CAPABILITY);
    }

    private void ensureCapability(int capability) {
        if (capability < size)
            return;

        T[] oldItems = items;
        items = (T[]) new Object[capability];
        if (oldItems != null) {
            for (int i = 0; i < oldItems.length; i++) {
                items[i] = oldItems[i];
            }
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayListIterator();
    }

    class ArrayListIterator implements Iterator {

        private int current =0;
        @Override
        public boolean hasNext(){
            return current < size;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return items[current++];
        }

        @Override
        public void remove() {
            MyArrayList.this.remove(--current);

        }
    }
}
