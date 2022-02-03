package ru.job4j.io.duplicates;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;


/**
 * class finds duplicate files
 */

public class DuplicatesFinder {
    public static void main(String[] args) throws IOException {
        Path start = Paths.get(".");
        search(start);

    }

    /**
     * создание объекта DuplicatesVisitor, реализующий интерфейс  SimpleFileVisitor<Path>
     * @param root
     * @throws IOException
     */
    public static void search(Path root) throws IOException {
        DuplicatesVisitor searcher = new DuplicatesVisitor();
        Files.walkFileTree(root, searcher);
        List<Path> result = searcher.getDuplicated();
        if (result.isEmpty()) {
            System.out.println("duplicated haven't found");
        } else {
            System.out.println("duplicates are: ");
            result.forEach(System.out::println);
        }
    }
}