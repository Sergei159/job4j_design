package ru.job4j.io;


import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Class reads the files and outputs to console strings that contains "404"
 * * as a  penultimate word
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
            for (String line = in.readLine(); line != null; line = in.readLine()) {
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

    public static void main(String[] args) {
        List<String> log = filter("log.txt");
        for (String string : log) {
            System.out.println(string);
        }
    }
}