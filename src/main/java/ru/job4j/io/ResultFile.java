package ru.job4j.io;

import java.io.FileOutputStream;

/**
 * Class writes to .txt format file the multiplication table
 *  @author  Sergei Sandrakov
 */
public class ResultFile {
    /**
     *
     * @param size  size of the multiplication table
     * @return string that contains the multiplication table
     */
        public static String multiple(int size) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                result.append((i + 1) * (j + 1)).append(" ");
            }
            result.append(System.lineSeparator());
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String result = (multiple(5));
        try (FileOutputStream out = new FileOutputStream("result.txt")) {
            out.write(result.getBytes());
            out.write(System.lineSeparator().getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}