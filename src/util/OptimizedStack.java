package util;

public class OptimizedStack<E> {

    private MyLinkedList<E> data; // util.Stack has a LinkedList

    public E pop() {
        return data.removeLast();
    }

    public void push(E e) {
        data.addLast(e);
    }

    public boolean empty() {
        return data.isEmpty();
    }

    public E peek() {
        return data.peekLast();
    }
}
