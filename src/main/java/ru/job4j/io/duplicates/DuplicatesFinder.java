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

    public static void search(Path root) throws IOException {
        DuplicatesVisitor searcher = new DuplicatesVisitor();
        Files.walkFileTree(root, searcher);
}
}