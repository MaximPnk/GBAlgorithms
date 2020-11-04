package hw4;

import hw3.queue.MyQueue;

public class MyLinkedQueueImpl<E> implements MyQueue<E> {

    private TwoSideLinkedList<E> list;

    public MyLinkedQueueImpl() {
        list = new TwoSideLinkedListImpl<>();
    }

    @Override
    public boolean insert(E value) {
        list.insertLast(value);
        return true;
    }

    @Override
    public E remove() {
        return list.removeFirst();
    }

    @Override
    public E peekHead() {
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
