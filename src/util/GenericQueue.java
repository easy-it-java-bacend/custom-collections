package util;

public class GenericQueue<E> {

    private MyLinkedList<E> data;

    public void enqueue(E e) {
        data.addLast(e);
    }

    public E dequeue() {
        return data.removeFirst();
    }

    public int getSize() {
        return data.size();
    }

    @Override
    public String toString() {
        return "util.Queue: " + data.toString();
    }

}
