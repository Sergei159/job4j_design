package ru.job4j.io;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Class reads the files and saves strings that contains "404"
 *  * * as a  penultimate word in a new file
 * @author  Sergei Sandrakov
 */
public class LogFilter {
    /**
     * @param file file to read
     * @return List of strings that contains "404"
     * * as a  penultimate word
     */
    public static List<String> filter(String file) {
        List<String> result = new ArrayList<>();
        try (var in = new BufferedReader(new FileReader(file))) {
            String line;
            while (in.ready()) {
                line = in.readLine();
                String[] str = line.split(" ");
                if ("404".equals(str[str.length - 2])) {
                    result.add(line);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     *
     * @param log list of Strings to write in a file
     * @param file name of the file to be written
     */
    public static void save(List<String> log, String file) {
        try (var out = new PrintWriter(
                new BufferedOutputStream(
                        new FileOutputStream(file)
                ))) {
            for (String string : log) {
                out.println(string + System.lineSeparator());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        List<String> log = filter("log.txt");
        save(log, "404.txt");

    }
}