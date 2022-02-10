package ru.job4j.cache;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 *
 */

public class DirFileCache extends AbstractCache<String, String> {
    /**
     * Директория,в которой находятся файлы для кеширования
     */
    private final String cachingDir;

    public DirFileCache(String cachingDir) {
        this.cachingDir = cachingDir;
    }

    /**
     *  метод загружает данные из файла в директории cachingDir
     * @param key имя файла
     * @return загруженный файл в строковом виде
     */
    @Override
    protected String load(String key) {
        String result = null;
            try {
                result = Files.readString(Path.of(cachingDir, key));
            } catch (IOException e) {
                e.printStackTrace();
            }
        System.out.println(result);
        return result;
    }

}
