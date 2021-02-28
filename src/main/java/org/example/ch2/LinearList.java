package org.example.ch2;

public class LinearList<T> {
    // number of elements in list.
    int length;
    //elements
    T[] items;

    /**
     * dynamic arguments constructor.
     * @param t elements list
     */
    public LinearList(T... t) {
        length = t.length;
        items = t;
    }

    /**
     * non-argument constructor.
     */
    public LinearList() {}

    /**
     * initiate empty linear list.
     * @param size size of initialized list
     */
    public void initiate(int size) {
        length = 0;
        items = (T[]) new Object[size];
    }

    /**
     * enlarge size of list as double of the length.
     */
    public void enlarge() {
        enlarge(length);
    }

    /**
     * enlarge size of list with specific.
     * @param expendSize
     */
    public void enlarge(int expendSize) {
        T[] temp = items;
        items = (T[]) new Object[items.length + expendSize];
        for (int idx = 0; idx < length; idx++) {
            items[idx] = temp[idx];
        }
    }

    /**
     * get length of the list.
     * @return length
     */
    public int getLength() {
        return length;
    }

    /**
     * get the element of specific index.
     * @param idx specific index
     * @return element
     */
    public T get(int idx) {
        if (idx >= 0 && idx < length) {
            return items[idx];
        } else {
            throw new IndexOutOfBoundsException("index:" + idx + " is not valid, index should be between 0 to (not include) length:" + length);
        }
    }

    /**
     * get the prior element of the specific index.
     * @param idx specific index
     * @return prior element
     */
    public T getPrior(int idx) {
        if (idx > 0 && idx < length) {
            return items[idx - 1];
        }
        return null;
    }

    /**
     * get the next element of the specific index
     * @param idx specific index
     * @return next element
     */
    public T getNext(int idx) {
        if (idx >= 0 && idx < length - 1) {
            return items[idx + 1];
        }
        return null;
    }

    /**
     * get the index of the specific element.
     * @param t element needs locate
     * @return the index of the specific element
     */
    public int locate(T t) {
        for (int idx = 0; idx < length; idx++) {
            if (items[idx].equals(t)) {
                return idx;
            }
        }
        return -1;
    }

    /**
     * insert element at specific position.
     * @param idx the index to insert
     * @param t the element to be insert
     */
    public void insert(int idx, T t) {
        if (length == items.length) {
            enlarge();
        }
        if (idx >= 0 && idx <= length) {
            T[] temp = (T[]) new Object[length - idx];
            for (int i = 0, j = idx; j < length; i++, j++) {
                temp[i] = items[j];
            }
            items[idx] = t;
            length += 1;
            for (int i = 0, j = idx + 1; i < temp.length; i++, j++) {
                items[j] = temp[i];
            }
        }
    }

    /**
     * insert at tail
     * @param t the element to be insert
     */
    public void insert(T t) {
        insert(length, t);
    }

    /**
     * delete element at specific position.
     * @param idx specific index
     * @return the deleted element
     */
    public T delete(int idx) {
        if (idx >= 0 && idx < length) {
            T t = items[idx];
            for (int i = idx; i < length - 1; i++) {
                items[i] = items[i + 1];
            }
            length -= 1;
            return t;
        }
        return null;
    }

    /**
     * if the list is empty.
     * @return true or false
     */
    public boolean isEmpty() {
        return length == 0 ? true : false;
    }

    /**
     * set list as empty.
     */
    public void clear() {
        for (int i = 0; i < length; i++) {
            items[i] = null;
        }
        length = 0;
    }

    /**
     * merge lists
     * @param l2 another list
     * @return new list contains l1 and l2 non-duplicated elements
     */
    public LinearList<T> union(LinearList<T> l2) {
        LinearList<T> temp = this;// new LinearList<>();
        //temp.initiate(this.length + l2.length);
        temp.enlarge(l2.length);
        for (int l2Idx = 0; l2Idx < l2.length; l2Idx++) {
            T element = l2.get(l2Idx);
            if(temp.locate(element) == -1) {
                temp.insert(element);
            }
        }
        return temp;
    }

    @Override
    public String toString() {
        String elements = "";
        for (int idx=0; idx< length;idx++) {
            elements += items[idx] + " ";
        }
        return elements;
    }
}
