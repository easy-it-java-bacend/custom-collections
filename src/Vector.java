import java.util.Arrays;
import java.util.Iterator;
import java.util.ListIterator;

public class Vector<E> extends AbstractList<E> implements
                            List<E>, Collection<E> {


    private int size;

    private E[] data;

    private static final int DEFAULT_CAPACITY = 10;

    public Vector() {
        this(DEFAULT_CAPACITY);
    }

    public Vector(int initialCapacity) {
        data = (E[]) new Object[initialCapacity];
    }

    @Override
    public void clear() {
        data = (E[]) new Object[size()];
        size = 0;
    }

    public void trimToSize() {
        data = Arrays.copyOf(data, size());
    }

    @Override
    public synchronized boolean remove(Object o) {
        int index = this.indexOf((E) o);
        if (index == -1) {
            return false;
        }
        remove(index);
        return true;
    }

    @Override
    public synchronized int size() {
        return size;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public void add(int index, E element) {
        checkRangeAdd(index);
        ensureCapacity();

        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = element;
        size++;
    }

    private void ensureCapacity() {
        if (size == data.length) {
            data = Arrays.copyOf(data, data.length * 2 + 1);
        }
    }

    @Override
    public E get(int index) {
        checkRange(index);
        return data[index];
    }

    @Override
    public E set(int index, E element) {
        checkRange(index);
        E temp = data[index];
        data[index] = element;
        return temp;
    }

    @Override
    public E remove(int index) {
        checkRange(index);

        E e = data[index];
        for (int i = index; i + 1 < size(); i++) {
            data[i] = data[i + 1];
        }
        data[--size] = null;
        return e;
    }

    @Override
    public int indexOf(E element) {
        for (int i = 0; i < size(); i++) {
            if (data[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(E element) {
        for (int i = size - 1; i > 0; i--) {
            if (data[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        for (int i = 0; i < size(); i++) {
            result.append(data[i]);
            if (i < size() - 1) {
                result.append(", ");
            }
        }
        result.append("]");
        return result.toString();
    }

    @Override
    public Iterator<E> iterator() {
        return new MyArrayList.IteratorImpl();
    }

    private class IteratorImpl implements Iterator<E> {

        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < size;
        }

        @Override
        public E next() {
            return data[currentIndex++];
        }
    }
}
