package ru.job4j.collection;

import ru.job4j.list.List;

import java.util.*;

public class SimpleArrayList<T> implements List<T> {

    private T[] container;

    private int size = 0;

    private int modCount = 0;

    public SimpleArrayList(int capacity) {
        this.container = (T[]) new Object[capacity];
    }

    @Override
    public void add(T value) {
        modCount++;
        if (size >= container.length - 1) {
            increaseCapacity();
        }
        container[size++] = value;
    }

    @Override
    public T set(int index, T newValue) {
        T replaced = container[index];
        container[index] = newValue;
        modCount++;
        Objects.checkIndex(index, container.length);
        return replaced;
    }

    @Override
    public T remove(int index) {
        T removed = container[index];
        System.arraycopy(
                container,
                index + 1,
                container,
                index,
                container.length - index - 1
        );
        container[container.length - 1] = null;
        size--;
        modCount++;
        Objects.checkIndex(index, container.length);
        return removed;
    }

    @Override
    public T get(int index) {
        Objects.checkIndex(index, container.length);
        return container[index];
    }

    @Override
    public int size() {
        return size;
    }

    public void increaseCapacity() {
        container = Arrays.copyOf(container, container.length * 2);
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int cursor;
            int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return cursor != size;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return  container[cursor++];
            }
        };
    }
}