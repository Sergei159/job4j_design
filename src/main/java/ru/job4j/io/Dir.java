package ru.job4j.io;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Class shows the name and size of the file
 */

public class Dir {
    public static void main(String[] args) {
        List<String> result = new ArrayList<>();
        File file = new File("C:\\projects\\job4j_design");
        if (!file.exists()) {
            throw new IllegalArgumentException(String.format("Not exist %s", file.getAbsoluteFile()));
        }
        if (!file.isDirectory()) {
            throw new IllegalArgumentException(String.format("Not directory %s", file.getAbsoluteFile()));
        }
        System.out.println(String.format("size : %s", file.length()));
        System.out.println(file.getName());
    }
}