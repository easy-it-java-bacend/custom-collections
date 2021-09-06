import java.util.Iterator;

public abstract class AbstractList<E> implements
        List<E>, Collection<E> {

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    protected void checkRangeAdd(int index) {
        if (index > size() || index < 0) {
            throw new ArrayIndexOutOfBoundsException("For index = " + index + ", size = " + size());
        }
    }

    protected void checkRange(int index) {
        if (index >= size() || index < 0) {
            throw new ArrayIndexOutOfBoundsException("For index = " + index + ", size = " + size());
        }
    }

    @Override
    public boolean contains(Object o) {
        Iterator<E> iterator = iterator();
        while (iterator.hasNext()) {
            E element = iterator.next();
            if (element.equals(o)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<? extends E> collection) {
        for (E e : collection) {
            if (!this.contains(e)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends E> collection) {
        for (E e : collection) {
            this.add(e);
        }
        return false;
    }

    @Override
    public boolean removeAll(Collection<? extends E> collection) {
        int prevSize = size();
        for (E e : collection) {
            this.remove(e);
        }
        return prevSize != size();
    }

    @Override
    public boolean retainAll(Collection<? extends E> collection) {
        int prevSize = size();
        for (E e : collection) {
            if (!this.contains(e)) {
                this.remove(e);
            }
        }
        return prevSize != size();
    }

    @Override
    public boolean add(E e) {
        add(size(), e);
        return true;
    }


}
