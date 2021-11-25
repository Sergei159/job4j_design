package ru.job4j.io;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Predicate;

/**
 * Class search files by a predicate and output them in a console
 */


public class Search  {

    public static void main(String[] args) throws IOException {
        validation(args);
        Path start = Paths.get(args[0]);
        search(start, p -> p.toFile().getName().endsWith(args[1])).forEach(System.out::println);
    }

    /**
     *
     * @param root the directory in which rhe searching is occurred
     * @param condition the condition of the researching
     * @return List of the files that stand up to  condition
     */

    public static List<Path> search(Path root, Predicate<Path> condition) throws IOException {
        SearchFiles searcher = new SearchFiles(condition);
        Files.walkFileTree(root, searcher);
        return searcher.getPaths();
    }

    /**
     * method checks  that the args array has two elements and the first
     * one is a directory
     * throw IllegalArgumentException if array length is not
     * equal two
     * @param args - arguments to be validated

     */

    public static void validation(String[] args) {
        if (args.length != 2) {
            throw new IllegalArgumentException(
                    System.lineSeparator()
                            + "String[] args must contain two elements: "
                            + System.lineSeparator()
                            + "1. Directory of the file to find"
                            + System.lineSeparator()
                            + "2. file format"
            );

        }
        File file = new File(args[0]);
        if (!file.isDirectory()) {
            throw new IllegalArgumentException(
                    String.format("Not directory %s", file.getAbsoluteFile()));
        }
    }

}