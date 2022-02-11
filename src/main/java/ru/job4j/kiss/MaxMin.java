package ru.job4j.kiss;

import java.util.Comparator;
import java.util.List;


/**
 * Класс реализует методы для нахождения минимального
 * и максимального значения из list<T>
 */
public class MaxMin {
    public <T> T max(List<T> value, Comparator<T> comparator) {
        return maxValue(value, comparator);
    }

    public <T> T min(List<T> value, Comparator<T> comparator) {
        return maxValue(value, comparator.reversed());
    }

    public <T> T maxValue(List<T> value,  Comparator<T> comparator) {
        T result = value.get(0);
        for (T el : value) {
            if (comparator.compare(el, result) > 0) {
                result = el;
            }
        }
        return result;
    }
}