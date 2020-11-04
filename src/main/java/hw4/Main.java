package hw4;

import hw3.queue.MyQueue;
import hw3.stack.MyStack;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
//        testLinkedList();
//        testStack();
//        testQueue();
        testForEach();
//        testMyIterator();
    }

    private static void testMyIterator() {
        MyLinkedListImpl<Integer> list = new MyLinkedListImpl<>();
        list.insertFirst(1);
        list.insertFirst(2);
        list.insertFirst(3);
        list.display();

        MyLinkedListImpl<Integer>.MyCustomIterator iterator = list.getIterator();
        iterator.insertBefore(0);
        iterator.nextLink();
        iterator.nextLink();
        iterator.insertBefore(0);
        iterator.nextLink();
        iterator.insertAfter(0);
        iterator.nextLink();
        iterator.insertAfter(0);
        list.display();

        iterator.reset();
        while (!iterator.atEnd()) {
            iterator.insertAfter(5);
            iterator.nextLink();
        }
        list.display();
    }

    private static void testForEach() {
        List<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);

        for (Integer integer : arrayList) {
            System.out.println(integer);
        }

        MyLinkedList<Integer> linkedList = new MyLinkedListImpl<>();
        linkedList.insertFirst(1);
        linkedList.insertFirst(2);
        linkedList.insertFirst(3);
        linkedList.insertFirst(4);

        linkedList.display();

        for(Integer value: linkedList) {
            System.out.println(value);
        }
    }

    private static void testLinkedList() {
        MyLinkedList<Integer> linkedList = new MyLinkedListImpl<>();

        linkedList.insertFirst(1);
        linkedList.insertFirst(2);
        linkedList.insertFirst(3);
        linkedList.insertFirst(4);
//        linkedList.insertLast(5);

        linkedList.display();

        System.out.println("Find 2: " + linkedList.contains(2));
        System.out.println("Find 1: " + linkedList.contains(1));
        System.out.println("Find 4: " + linkedList.contains(4));
        System.out.println("Find 4444: " + linkedList.contains(4444));

        linkedList.removeFirst();
        linkedList.remove(2);

        linkedList.display();
    }

    private static void testStack() {
        MyStack<Integer> stack = new MyLinkedStackImpl<>();

        System.out.println("Add value 1");
        stack.push(1);
        System.out.println("Add value 2");
        stack.push(2);
        System.out.println("Add value 3");
        stack.push(3);
        System.out.println("Add value 4");
        stack.push(4);
        System.out.println("Add value 5");
        stack.push(5);
        System.out.println("Add value 6");
        stack.push(6);

        System.out.println("Stack size: " + stack.size());
        System.out.println("Stack top: " + stack.peek());

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }

    private static void testQueue() {
//        Queue<Integer> queue = new QueueImpl<>(5);
//        Queue<Integer> queue = new PriorityQueue<>(5);
        MyQueue<Integer> queue = new MyLinkedQueueImpl<>();
        System.out.println(queue.insert(3));
        System.out.println(queue.insert(5));
        System.out.println(queue.insert(1));
        System.out.println(queue.insert(2));
        System.out.println(queue.insert(6));
        System.out.println(queue.insert(4));

        System.out.println("Queue peek: " + queue.peekHead());
        System.out.println("Queue size: " + queue.size());
        System.out.println("Queue is full: " + queue.isFull());

        while (!queue.isEmpty()) {
            System.out.println(queue.remove());
        }
    }
}
