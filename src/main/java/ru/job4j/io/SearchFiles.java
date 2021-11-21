package ru.job4j.io;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import static java.nio.file.FileVisitResult.CONTINUE;

/**
 * the class filter files by a predicate
 */

public class SearchFiles extends SimpleFileVisitor<Path> {

    private Predicate<Path> predicate;
    private List<Path> resultList = new ArrayList<>();

    public SearchFiles(Predicate predicate) {
        this.predicate = predicate;
    }

    @Override
    public FileVisitResult visitFile(
            Path file, BasicFileAttributes attrs) throws IOException {

        if (predicate.test(file.getFileName())) {
            resultList.add(file);
        }

        return CONTINUE;
    }

    /**
     *
     * @return List of the files that stand up to  condition
     */

    public List<Path> getPaths() {
        return resultList;
    }


}
