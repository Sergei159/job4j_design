package ru.job4j.collection;

public class SimpleStack<T> {
    private Node<T> head;
    private int size;
    private  ForwardLinked<T>  linked = new ForwardLinked<T>();

    public T pop() {
        size--;
        return linked.deleteLast();
    }

    public void push(T value) {
        linked.addFirst(value);
        size++;
    }

    public boolean isEmpty() {
        return size == 0;
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

