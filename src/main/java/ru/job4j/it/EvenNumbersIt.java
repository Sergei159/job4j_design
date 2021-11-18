package ru.job4j.it;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * this class implements even number iterator behavior
 */
public class EvenNumbersIt implements Iterator<Integer> {

    private int[] data;
    private int index;

    public EvenNumbersIt(int[] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        while (index < data.length && data[index] % 2 != 0) {
            index++;
        }
        return index < data.length;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
            return  data[index++];
        }

}