package ru.job4j.it;

import java.util.Iterator;
        import java.util.NoSuchElementException;

public class EvenNumbersIt implements Iterator<Integer> {

    private int[] data;
    private int index;

    public EvenNumbersIt(int[] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        int count = 0;
        for (int i = index; i < data.length; i++) {
            if (data[i] % 2 == 0) {
                index = i;
                count++;
                break;
            }
        }
        return count > 0;

    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return data[index++];
    }

}