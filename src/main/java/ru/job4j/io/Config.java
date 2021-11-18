package ru.job4j.io;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;
/**
 * This class loads a file by this.path and save into a map pairs
 * split by "="
 */
public class Config {
    private final String path;
    private final Map<String, String> values = new HashMap<String, String>();
    public Config(final String path) {
        this.path = path;
    }
    /**
     * loads the file from this.path and save the relevant pairs  into
     * the Map<String, String> values by splitting with "="
     * Strings mustn't be a comment
     */
    public void load() {
        try (BufferedReader in = new BufferedReader(new FileReader(path))) {
            in.lines()
                    .filter(s ->  s.length() > 0 && !s.startsWith("#"))
                    .forEach(str -> {
                        String[] pair = str.split("=");
                        if (pair.length != 2) {
                            throw new IllegalArgumentException();
                        }
                        values.put(pair[0], pair[1]);
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     *
     * @param key Key of the value to be found
     * @return value to be associated with the specified key
     * of the Map<String, String> if founded
     * otherwise throws UnsupportedOperationException
     * @throws UnsupportedOperationException
     */
    public String value(String key) {
        return values.get(key);
    }
    @Override
    public String toString() {
        StringJoiner out = new StringJoiner(System.lineSeparator());
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            read.lines().forEach(out::add);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return out.toString();
    }

    public static void main(String[] args) {
    }

} 