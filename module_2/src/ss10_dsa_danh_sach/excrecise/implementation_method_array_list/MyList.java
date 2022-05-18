package ss10_dsa_danh_sach.excrecise.implementation_method_array_list;

import java.util.Arrays;

public class MyList<E> {
    protected int size = 0;
    static final int DEFAULT_CAPACITY = 10;
    private Object data[];

    public MyList() {
    }

    public MyList(int capacity) {
        data = new Object[capacity];
    }

    public boolean add(E element) {
        if (size == data.length) {
            ensureCapacity();
        }
        data[size++] = element;
        return true;
    }

    public void add(int index, E element) {
        ensureCapacity();
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = element;
        size++;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("index " + index + " out of bounds");
    }

    public E remove(int index) {
        checkIndex(index);
        E element = (E) data[index];
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        data[size - 1] = null;
        size--;
        return element;
    }

    public int size() {
        return size;
    }

    public boolean contains(Object element) {
        for (int i = 0; i < size; i++)
            if (element.equals(data[i]))
                return true;
        return false;
    }

    public int indexOf(Object element) {
        for (int i = 0; i < size; i++)
            if (element.equals(data[i])) return i;
        return -1;
    }

    public void ensureCapacity() {
        if (size >= data.length) {
            Object[] newData = new Object[size * 2 + 1];
            System.arraycopy(data, 0, newData, 0, size);
            data = newData;
        }
    }

    public E get(int i) {
        if (i >= size || i < 0) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size: " + i);
        }
        return (E) data[i];
    }

    public void clear() {
        data = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    @Override
    public String toString() {
        return "MyList{" +
                "size=" + size +
                ", data=" + Arrays.toString(data) +
                '}';
    }
}
