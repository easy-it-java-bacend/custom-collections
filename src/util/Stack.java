package util;

public class Stack<E> extends Vector<E> { // util.Stack is a util.Vector -> extends

    public E pop() {
        return remove(size() - 1);
    }

    public void push(E e) {
        add(e);
    }

    public boolean empty() {
        return isEmpty();
    }

    public E peek() {
        return get(size() - 1);
    }

}
