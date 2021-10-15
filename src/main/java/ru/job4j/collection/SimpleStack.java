package ru.job4j.collection;

import java.util.NoSuchElementException;
import java.util.LinkedList;

public class SimpleStack<T> {
    private Node<T> head;
    private Node<T> tail;
    private  ForwardLinked<T>  linked = new ForwardLinked<T>();

    public T pop() {
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

    public void push(T value) {
        Node<T> node = new Node<T>(value, null);
        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
    }

    public boolean isEmpty() {
        return head == null;
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

