package ru.job4j.collection;

import java.util.NoSuchElementException;
import java.util.LinkedList;

public class SimpleStack<T> {
    private Node<T> head;
    private Node<T> tail;
    private  ForwardLinked<T>  linked = new ForwardLinked<T>();

    public T pop() {
        return linked.deleteLast();
    }

    public void push(T value) {
        linked.addFirst(value);
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

