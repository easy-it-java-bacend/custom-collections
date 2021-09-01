public abstract class AbstractList<E> implements
        List<E>, Collection<E> {

    @Override
    public boolean isEmpty() {
        return size() == 0;
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
