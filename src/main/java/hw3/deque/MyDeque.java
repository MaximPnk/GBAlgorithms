package hw3.deque;

import hw3.queue.MyQueue;

public interface MyDeque<E> extends MyQueue<E> {

    boolean insertLeft(E value);

    boolean insertRight(E value);

    E removeLeft();

    E removeRight();

}
