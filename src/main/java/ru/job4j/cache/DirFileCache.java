package ru.job4j.cache;


import java.io.IOException;
import java.lang.ref.SoftReference;
import java.nio.file.Files;
import java.nio.file.Path;


public class DirFileCache extends AbstractCache<String, String> {

    private final String cachingDir;

    public DirFileCache(String cachingDir) {
        this.cachingDir = cachingDir;
    }

    @Override
    protected String load(String key) {
        String result = null;
        if (cache.get(key) == null) {
            try {
                result = Files.readString(Path.of(cachingDir, key));
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
