package ru.job4j.kiss;

import org.junit.Test;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class MaxMinTest {

    @Test
    public void maxOfIntegerList() {
        MaxMin maxMin = new MaxMin();
        List<Integer> input = List.of(1, 3, 4, 5, 2);
        Integer result = 5;
        assertThat(maxMin.max(input, Integer::compareTo), is(result));
    }

    @Test
    public void minOfIntegerList() {
        MaxMin maxMin = new MaxMin();
        List<Integer> input = List.of(1, 3, 4, 5, 2);
        Integer result = 1;
        assertThat(maxMin.min(input, Integer::compareTo), is(result));
    }

    @Test
    public void maxOfStringList() {
        MaxMin maxMin = new MaxMin();
        List<String> input = List.of("AA", "BB", "CC");
        String result = "CC";
        assertThat(maxMin.max(input, String::compareTo), is(result));
    }

    @Test
    public void minOfStringList() {
        MaxMin maxMin = new MaxMin();
        List<String> input = List.of("AA", "BB", "CC");
        String result = "AA";
        assertThat(maxMin.min(input, String::compareTo), is(result));
    }

}