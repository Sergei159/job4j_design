package ru.job4j.cache;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

/**
 *
 *  Программа cчитывает текстовые файлы из системы и выдавает текст при запросе имени файла.
 *  Если в кеше файла нет. Кеш должен загрузить себе данные.
 * @param <K> ключ
 * @param <V> значение
 */
public abstract class AbstractCache<K, V> {
    /**
     * Карта ,в которой каждому ключу соответствует мягкая ссылка
     * на значение загруженного файла
     */
    protected final Map<K, SoftReference<V>> cache = new HashMap<>();

    /**
     * Добавляет данные из файла в карту cache
     * @param key имя файла
     * @param value содержимое файла
     */
    public void put(K key, V value) {
        SoftReference<V> ref = new SoftReference<>(value);
        cache.put(key, ref);
    }

    /**
     * Метод возвращает данные из файла по имени файла.
     * Если данных нет, то метод загружает их в cache и возвращает
     * @param key имя файла
     * @return данные из файл
     */
    public V get(K key) {
        V value = cache.getOrDefault(key, new SoftReference<>(null)).get();
        if (value == null) {
           value = load(key);
           put(key, value);
        }
        return value;
    }

    /**
     * абстрактный метод, который реализуется в наследуемых классах
     * @param key
     * @return
     */
    protected abstract V load(K key);

}