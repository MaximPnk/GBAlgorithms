package hw4;

import java.util.Iterator;

public class MyLinkedListImpl<E> implements MyLinkedList<E> {

    protected int size;
    protected Node<E> firstElement;

    public MyCustomIterator getIterator() {
        return new MyCustomIterator(this);
    }

    @Override
    public Iterator<E> iterator() {
        return new MyCustomIterator(this);
    }

    class MyCustomIterator implements Iterator<E> {
        private Node<E> current;
        private Node<E> previous;
        private MyLinkedList<E> list;

        public MyCustomIterator(MyLinkedList<E> list){
            this.list = list;
            this.reset();
        }

        public void reset(){
            current = firstElement;
            previous = null;
        }

        public boolean atEnd(){
            return (current.next == null);
        }

        public void nextLink(){
            previous = current;
            current = current.next;
        }

        public Node<E> getCurrent(){
            return current;
        }

        public void insertAfter(E value){
            Node<E> newLink = new Node<>(value, this.current.next);
            if (list.isEmpty()) {
                firstElement = newLink;
                current = firstElement;
            } else {
                newLink.next = current.next;
                current.next = newLink;
                nextLink();
            }
        }

        public void insertBefore(E value){
            Node<E> newLink = new Node<>(value, this.current);
            if (previous == null){
                firstElement = newLink;
                reset();
            }
            else{
                newLink.next = previous.next;
                previous.next = newLink;
                current = newLink;
            }
        }

        public E deleteCurrent(){
            E value = current.item;
            if (previous == null){
                firstElement = current.next;
            } else {
                previous.next = current.next;
                if (atEnd()){
                    reset();
                } else {
                    current = current.next;
                }
            }

            return value;
        }


        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            E value = current.item;
            nextLink();
            return value;
        }
    }

    @Override
    public void insertFirst(E value) {
        Node<E> newNode = new Node<>(value, firstElement);
        firstElement = newNode;
        size++;
    }

    @Override
    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }

        Node<E> removedElement = firstElement;
        E data = removedElement.item;

        firstElement = firstElement.next;
        removedElement.next = null;
        removedElement.item = null;

        size--;
        return data;
    }

    @Override
    public boolean remove(E value) {
        Node<E> current = firstElement;
        Node<E> previous = null;
        while (current != null) {
            if (current.item.equals(value)) {
                break;
            }
            previous = current;
            current = current.next;
        }

        if (current == null) {
            return false;
        }

        if (current == firstElement) {
            firstElement = firstElement.next;
        }
        else {
            previous.next = current.next;
        }

        current.next = null;
        current.item = null;

        size--;
        return true;
    }

    @Override
    public boolean contains(E value) {
        Node<E> current = firstElement;
        while (current != null) {
            if (current.item.equals(value)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void display() {
        System.out.println("-----------");
        Node<E> current = firstElement;
        while (current != null) {
            System.out.println(current.item);
            current = current.next;
        }
        System.out.println("-----------");
    }

    @Override
    public E getFirst() {
        return firstElement.item;
    }
}
