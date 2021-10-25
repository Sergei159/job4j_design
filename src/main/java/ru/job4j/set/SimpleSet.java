package ru.job4j.set;

import ru.job4j.collection.SimpleArrayList;

import java.util.Iterator;
import java.util.Objects;

public class SimpleSet<T> implements Set<T> {

    private int capacity = 10;

    private SimpleArrayList<T> set = new SimpleArrayList<>(capacity);

    @Override
    public boolean add(T value) {
        boolean rsl = !contains(value);
         if (rsl) {
             set.add(value);
             rsl = true;
         }
         return rsl;
    }

    @Override
    public boolean contains(T value) {
        boolean rsl = false;
        for (int i = 0; i < set.size(); i++) {
            if (Objects.equals(value, set.get(i))) {
                rsl = true;
                break;
            }
        }
        return rsl;
    }

    @Override
    public Iterator<T> iterator() {
        return set.iterator();
    }
}