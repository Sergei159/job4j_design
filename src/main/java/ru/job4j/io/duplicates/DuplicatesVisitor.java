package ru.job4j.io.duplicates;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;


public class DuplicatesVisitor extends SimpleFileVisitor<Path> {

    private Map<FileProperty, List<Path>>  result = new HashMap<>();


    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
            throws IOException {
        FileProperty fileProperty = new FileProperty(
                file.toFile().length(),
                file.getFileName().toString()
        );

        if (result.containsKey(fileProperty)) {
           List<Path> duplicates = new ArrayList<>(result.get(fileProperty));
           duplicates.add(file);
           result.put(fileProperty, duplicates);
        } else {
            List<Path> duplicates = new ArrayList<>();
            duplicates.add(file);
            result.put(fileProperty, duplicates);
        }
        return super.visitFile(file, attrs);
    }


    public List<Path> getDuplicated() {
        List<Path> duplicates = new ArrayList<>();
        result.values().stream()
                .filter(value -> value.size() > 1)
                .forEach(duplicates :: addAll);
        return duplicates;
    }
}