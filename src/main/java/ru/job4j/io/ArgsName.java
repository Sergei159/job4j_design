package ru.job4j.io;

import java.util.HashMap;
import java.util.Map;

/**
 * Class gets a string, split it by "=" and put in a hashMap
 */
public class ArgsName {

    private final Map<String, String> values = new HashMap<>();

    /**
     *
     * @param key key of the couple
     * @return value of relevant key
     */
    public String get(String key) {
        return values.get(key);
    }

    /**
     * gets string, split it and put couple key - value in a hashMap
     * @param args args to be parsed
     */
    private void parse(String[] args) {
        if (args.length == 0) {
            throw new IllegalArgumentException("args array is empty!");
        }
        String first = args[0].substring(1);
        String[] firstArray = validation(first);
        values.put(firstArray[0], firstArray[1]);

        String second = args[1].substring(1);
        String[] secondArray = validation(second);
        values.put(secondArray[0], secondArray[1]);

    }

    /**
     *
     * @param string string to be spilt and checked
     * @return String couple key - value
     */

    public static String[] validation(String string) {
        String[] result = string.split("=");
        if (result.length < 2) {
            throw new IllegalArgumentException("value is empty!");
        }
        return result;
    }

    public static ArgsName of(String[] args) {
        ArgsName names = new ArgsName();
        names.parse(args);
        return names;
    }

    public static void main(String[] args) {
        ArgsName jvm = ArgsName.of(new String[] {"-Xmx=512", "-encoding=UTF-8"});
        System.out.println(jvm.get("Xmx"));

        ArgsName zip = ArgsName.of(new String[] {"-out=project.zip", "-encoding=UTF-8"});
        System.out.println(zip.get("out"));

    }
}