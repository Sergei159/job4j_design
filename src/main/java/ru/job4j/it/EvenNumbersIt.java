package ru.job4j.it;

import java.util.Iterator;
        import java.util.NoSuchElementException;

public class EvenNumbersIt implements Iterator<Integer> {

    private int[] data;
    private int index;

    public EvenNumbersIt(int[] data) {
        this.data = data;
    }

    /**
     *Returns true if the iteration has more even elements
     * @return true if the iteration has more even elements
     */
    @Override
    public boolean hasNext() {
        while (index < data.length) {
            if (data[index] % 2 == 0) {
                return true;
            }
            index++;
        }
        return false;
    }

    /**
     * Returns the next even element in the iteration.
     * @return the next even element in the iteration.
     * Throws: NoSuchElementException – if the iteration has no more even elements
     */

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return data[index++];
    }
}