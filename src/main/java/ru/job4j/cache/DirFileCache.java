package ru.job4j.cache;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

public class DirFileCache extends AbstractCache<String, String> {

    private final String cachingDir;

    public DirFileCache(String cachingDir) {
        this.cachingDir = cachingDir;
    }

    @Override
    protected String load(String key) {
        StringBuilder read = new StringBuilder();
        String result = null;
        if (cache.get(key) == null) {
            try (BufferedReader in = new BufferedReader(
                    new FileReader(cachingDir + "/" + key))) {
                    String nextLine = in.readLine();
                    while (nextLine != null) {
                        read.append(nextLine).append(" ");
                        nextLine = in.readLine();
                    }
                    result = String.valueOf(read);
                cache.put(key, new SoftReference<>(result));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
           result = cache.get(key).get();
        }
        System.out.println(result);
        return result;
    }

}