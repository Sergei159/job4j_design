package ru.job4j.collection.list;

import java.util.*;

public class SimpleLinkedList<E> implements List<E> {

    private int modCount;
    private int size;
    private Node<E> first;
    private Node<E> last;

    private static class Node<E> {
        E item;
        Node<E> next;

        Node(E element, Node<E> next) {
            this.item = element;
            this.next = next;
        }
    }

    @Override
    public void add(E value) {
        final Node<E> last = this.last;
        final Node<E> newNode = new Node<>(value, null);
        this.last = newNode;
        if (last == null) {
            first = newNode;
        } else {
            last.next = newNode;
        }
        size++;
        modCount++;
    }

    @Override
    public E get(int index) {
        Objects.checkIndex(index, size);
        Node<E> rsl;
        rsl = first;
        for (int i = 0; i < index; i++) {
            rsl = rsl.next;
        }
        return rsl.item;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private Node<E> next = first;
            private int nextIndex = 0;
            private int expectedModCount = modCount;

            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return nextIndex < size;
            }

            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                Node<E> lastReturned = next;
                next = next.next;
                nextIndex++;
                return lastReturned.item;
            }
        };
    }

}
