package hw4;

import hw3.stack.MyStack;

public class MyLinkedStackImpl<E> implements MyStack<E> {

    private MyLinkedList<E> list;

    public MyLinkedStackImpl() {
        this.list = new MyLinkedListImpl<>();
    }

    @Override
    public void push(E value) {
        list.insertFirst(value);
    }

    @Override
    public E pop() {
        return list.removeFirst();
    }

    @Override
    public E peek() {
        return list.getFirst();
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isFull() {
        return false;
    }
}
