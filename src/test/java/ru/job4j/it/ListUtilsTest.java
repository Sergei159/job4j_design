package ru.job4j.it;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

public class ListUtilsTest {

    @Test
    public void whenAddBefore() {
        List<Integer> input =  new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addBefore(input, 1, 2);

        assertThat(input, is(Arrays.asList(1, 2, 3)));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenAddBeforeWithInvalidIndex() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addBefore(input, 3, 2);
    }

    @Test
    public void whenAddAfterLast() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2));
        ListUtils.addAfter(input, 2, 3);

        assertThat(input, is(Arrays.asList(0, 1, 2, 3)));
    }

    @Test
    public void whenRemovePositive() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, -1, 2, -5, 7, 14, -16, -6, -9));
        ListUtils.removeIf(input,  x -> x >= 0);
        assertThat(input, is(Arrays.asList(-1, -5, -16, -6, -9)));
    }

    @Test
    public void whenRemoveEven() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2, -5, -7, 14, -16));
        ListUtils.removeIf(input,  x -> (x & 1) == 0);
        assertThat(input, is(Arrays.asList(1, -5, -7)));
    }

    @Test
    public void whenReplaceEvenWithZero() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2, -5, -7, 14, -16));
        ListUtils.replaceIf(input,  x -> (x & 1) == 0, 0);
        assertThat(input, is(Arrays.asList(0, 1, 0, -5, -7, 0, 0)));
    }

    @Test
    public void whenReplaceNegativeWithZero() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2, -5, -7, 14, -16));
        ListUtils.replaceIf(input,  x -> x < 0, 0);
        assertThat(input, is(Arrays.asList(0, 1, 2, 0, 0, 14, 0)));
    }

    @Test
    public void whenReplaceNothing() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2, -5, -7, 14, -16));
        ListUtils.replaceIf(input,  x -> x % 3 == 0, 0);
        assertThat(input, is(Arrays.asList(0, 1, 2, -5, -7, 14, -16)));
    }

    @Test
    public void whenRemoveAllEven() {
        List<Integer> list = new ArrayList<>(Arrays.asList(
                0, 4, 2, 6, -7, 14, -16, null, 22, 20, 21
        ));
        List<Integer> elements = new ArrayList<>(Arrays.asList(
                0, 4, 2, 6, 14, -16, 22, 20
        ));
        ListUtils.removeAll(list, elements);
        assertThat(list, is(Arrays.asList(-7, null, 21)));
    }

    @Test
    public void whenRemoveNegative() {
        List<Integer> list = new ArrayList<>(Arrays.asList(
                null, 2, 3, 4, 5, -6, 6, -7, 7, 8, null
        ));
        List<Integer> elements = new ArrayList<>(Arrays.asList(
                -7, -6
        ));
        ListUtils.removeAll(list, elements);
        assertThat(list, is(Arrays.asList(
                null, 2, 3, 4, 5, 6, 7, 8, null
        )));
    }

}