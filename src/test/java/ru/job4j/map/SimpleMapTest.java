package ru.job4j.map;

import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

public class SimpleMapTest {

    @Test
    public void whenPutTheSameKeyTwiceThenFalse() {
        SimpleMap<Integer, String> map = new SimpleMap<>();
        assertTrue(map.put(11111, "first"));
        assertFalse(map.put(11111, "first"));
    }

    @Test
    public void whenMultiplePut() {
        SimpleMap<Integer, String> map = new SimpleMap<>();
        assertTrue(map.put(11111, "first"));
        assertTrue(map.put(11112, "second"));
    }

    @Test
    public void whenGetKey() {
        SimpleMap<Integer, String> map = new SimpleMap<>();
        assertTrue(map.put(11111, "first"));
        assertThat(map.get(11111), is("first"));
    }

    @Test
    public void whenGetWrongKey() {
        SimpleMap<Integer, String> map = new SimpleMap<>();
        assertTrue(map.put(11111, "first"));
        assertNull(map.get(12222222));
    }

    @Test
    public void whenRemove() {
        SimpleMap<Integer, String> map = new SimpleMap<>();
        assertTrue(map.put(11111, "first"));
        assertTrue(map.remove(11111));
    }

    @Test
    public void whenRemoveWrongKey() {
        SimpleMap<Integer, String> map = new SimpleMap<>();
        assertTrue(map.put(11111, "first"));
        assertFalse(map.remove(67890));
    }


    @Test(expected = NoSuchElementException.class)
    public void whenHasNextIsFalse() {
        SimpleMap<Integer, String> map = new SimpleMap<>();
        Iterator<Integer> it = map.iterator();
        assertFalse(it.hasNext());
        it.next();
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenPutAfterGetIteratorThenMustBeException() {
        SimpleMap<Integer, String> map = new SimpleMap<>();
        assertTrue(map.put(11111, "first"));
        Iterator<Integer> it = map.iterator();
        map.put(11112, "second");
        it.next();
    }

    @Test
    public void whenExpand() {
        SimpleMap<Integer, String> map = new SimpleMap<>();
        map.put(11111, "first");
        map.put(11112, "second");
        map.put(11113, "third");
        map.put(11114, "fourth");
        map.put(11115, "fifth");
        map.put(11116, "sixth");
        map.put(11117, "seventh");
        map.put(11118, "eight");
        map.put(11119, "ninth");
        map.put(11110, "tenth");
        map.put(11112, "eleventh");
        assertThat(map.get(11111), is("first"));
    }
} 