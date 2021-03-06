package ru.job4j.io;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Predicate;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * class archives the single file or a group of files
 */

public class Zip {

    /**
     * archives a group of files
     * @param sources files to be archived
     * @param target the final way of archived files
     */

    public static void packFiles(List<Path> sources, Path target) {
        try (var zip = new ZipOutputStream(new BufferedOutputStream(
                new FileOutputStream(String.valueOf(target))))) {
            for (Path source : sources) {
                zip.putNextEntry(new ZipEntry(source.toFile().getPath()));
                try (BufferedInputStream out = new BufferedInputStream(
                        new FileInputStream(String.valueOf(source)))) {
                    zip.write(out.readAllBytes());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param args array of Strings to be validated -
     * it must contain 3 elements
     * 1. Directory to be archived
     * 2. file format
     * 3. final way of archived file
     */

    public static void validationOfSize(String[] args) {
        if (args.length != 3) {
            throw new IllegalArgumentException(
                    System.lineSeparator()
                            + "String[] args must contain: "
                            + System.lineSeparator()
                            + "1. Directory to be archived"
                            + System.lineSeparator()
                            + "2. file format"
                            + System.lineSeparator()
                            + "3. final way of archived file"
            );
        }
    }

    /**
     * checks the first element is a directory
     * @param args arrays of strings to be checked
     */

    public static void isDirectoryCheck(String[] args) {
        File file = new File(args[0]);
        if (!file.isDirectory()) {
            throw new IllegalArgumentException(
                    String.format("Not directory %s", file.getAbsoluteFile()));
        }
    }

    public static void main(String[] args) throws IOException {
        validationOfSize(args);
        ArgsName argsName = ArgsName.of(args);
        String[] values  = {
                argsName.get("d"),
                argsName.get("e"),
                argsName.get("o")
        };
        isDirectoryCheck(values);
        Path start = Paths.get(values[0]);
        Path target = Paths.get(values[2]);
        List<Path> source = Search.search(
                start, p -> !p.toFile().getName().endsWith(values[1]));
        packFiles(source, target);


    }
}