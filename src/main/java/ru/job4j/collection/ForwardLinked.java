package ru.job4j.collection;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ForwardLinked<T> implements Iterable<T> {
    private int modCount;
    private int size;
    private Node<T> tail;
    private Node<T> head;

    public void addLast(T value) {
        Node<T> node = new Node<T>(value, null);
        if (head == null) {
            head = node;
        } else {
            Node<T> tail = head;
            while (tail.next != null) {
                tail = tail.next;
            }
            tail.next = node;
        }
        size++;
        modCount++;
    }

    public void addFirst(T value) {
        Node<T> node = new Node<T>(value, null);
        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
    }

    public T deleteFirst() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        final T element = head.value;
        final Node<T> next = head.next;
        head.next = null;
        head = next;
        size--;
        modCount++;
        return element;
    }

    public T deleteLast() {
        if (tail == null) {
            throw new NoSuchElementException();
        }
        final T deleted = tail.value;
        if (tail == head) {
            head = null;
            tail = null;
        } else {
            Node<T> newTail = head;
            while (newTail.next != tail) {
                newTail = newTail.next;
            }
            newTail.next = null;
            tail = newTail;
        }
        return deleted;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node<T> node = head;
            int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return node != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T value = node.value;
                node = node.next;
                return value;
            }
        };
    }

    private static class Node<T> {
        T value;
        Node<T> next;

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }
}