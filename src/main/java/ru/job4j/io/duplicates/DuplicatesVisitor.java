package ru.job4j.io.duplicates;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;


public class DuplicatesVisitor extends SimpleFileVisitor<Path> {

    private List<FileProperty>  fileList = new ArrayList<>();

    private Set<FileProperty> resultList = new HashSet<>();


    @Override
    public FileVisitResult visitFile(
            Path file, BasicFileAttributes attrs) throws IOException {
        FileProperty fileProperty = new FileProperty(
                file.toFile().length(),
                file.getFileName().toString()
        );
        fileList.add(fileProperty);

        for (int i = 0; i < fileList.size(); i++) {
            FileProperty theFirstFile = fileList.get(i);
            for (int j = 0; j < fileList.size(); j++) {
                if (i == j) {
                    continue;
                }
                FileProperty theSecondFile = fileList.get(j);
                if (theFirstFile.equals(theSecondFile)) {
                    resultList.add(theSecondFile);
                }
            }
        }

        return super.visitFile(file, attrs);
    }

    public Set<FileProperty> getResultList() {
        return resultList;
    }
}