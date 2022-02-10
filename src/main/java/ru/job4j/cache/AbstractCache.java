package ru.job4j.cache;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractCache<K, V> {

    protected final Map<K, SoftReference<V>> cache = new HashMap<>();

    public void put(K key, V value) {
        SoftReference<V> ref = new SoftReference<>(value);
        cache.put(key, ref);
    }

    public V get(K key) {
        V result = null;
        V value = cache.get(key).get();
        if (value != null) {
            result = value;
        } else {
            V ref = load(key);
            put(key, ref);
            result = cache.getOrDefault(key, new SoftReference<>(null)).get();
        }
        return result;
    }


    protected abstract V load(K key);

}