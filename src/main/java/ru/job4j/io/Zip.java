package ru.job4j.io;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {

    public static void packFiles(List<Path> sources, Path target) {
        for (Path source : sources) {
           packSingleFile(source, target);
            }

        }


    public static void packSingleFile(Path source, Path target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(String.valueOf(target))))) {
            zip.putNextEntry(new ZipEntry(source.toFile().getPath()));
            try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(String.valueOf(source)))) {
                zip.write(out.readAllBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void validation(String[] args) {
        if (args.length != 3) {
            throw new IllegalArgumentException(
                    System.lineSeparator()
                            + "String[] args must contain: "
                            + System.lineSeparator()
                            + "1. Directory to be archived"
                            + System.lineSeparator()
                            + "2. file format"
                            + System.lineSeparator()
                            + "3. file format"
            );
        }
        File file = new File(args[0]);
        if (!file.isDirectory()) {
            throw new IllegalArgumentException(
                    String.format("Not directory %s", file.getAbsoluteFile()));
        }
    }

    public static void main(String[] args) throws IOException {
        ArgsName argsName = ArgsName.of(args);
        String[] values  = {
                argsName.get("d"),
                argsName.get("e"),
                argsName.get("o")
        };
        validation(values);
        Path start = Paths.get(values[0]);
        Path target = Paths.get(values[2]);
        List<Path> source = Search.search(
                start, p -> p.toFile().getName().endsWith(values[1]));
        packFiles(source, target);


    }
}