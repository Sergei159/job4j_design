package ru.job4j.io;

import java.io.FileInputStream;

public class EvenNumberFile {
    public static void main(String[] args) {
        StringBuilder text = new StringBuilder();
        try (FileInputStream in = new FileInputStream("even.txt")) {
            int read;
            while ((read = in.read()) != -1) {
                text.append((char) read);
            }
            System.out.println("original text: "
                    + System.lineSeparator()
                    + text);
        } catch (Exception e) {
            e.printStackTrace();
        }

        String[] lines = text.toString().split(System.lineSeparator());
        System.out.println("even numbers:");
        boolean rsl;
        for (String line : lines) {
            int value = Integer.parseInt(line);
            rsl = (value & 1)  == 0;
            if (rsl) {
                System.out.println(value);
            }
        }

    }
}
