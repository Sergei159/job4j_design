package ru.job4j.io;

import java.io.*;

/**
 * This class reads the file with server information and writes the information
 * of not-working server time into the file
 */
public class Analysis {

    /**
     * reads the info from source file and writes the file with information
     * about exceeding 400 of the first value in a line of a source file
     * @param source - source file to read
     * @param target = target file to write
     */
    public void unavailable(String source, String target) {
        try (BufferedReader in = new BufferedReader(new FileReader(source));
             BufferedWriter out = new BufferedWriter(new FileWriter(target))) {
            String[] previous = {"0", "0"};
            StringBuilder result = new StringBuilder();
            String nextLine = in.readLine();
            while (nextLine != null) {
                String[] current = nextLine.split(" ");
                boolean currentEqualsTo400or500 = "400".equals(current[0])
                    || "500".equals(current[0]);
                boolean previousEqualsTo400or500 = "400".equals(previous[0])
                    || "500".equals(previous[0]);

                if (currentEqualsTo400or500 && !previousEqualsTo400or500) {
                    result.append(current[1]).append(";");
                    previous = current;

                }
                if (!currentEqualsTo400or500 && previousEqualsTo400or500) {
                    result.append(current[1])
                            .append(";").append(System.lineSeparator());
                    previous = current;
                }
                nextLine = in.readLine();
            }
            out.write(result.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Analysis analysis = new Analysis();
        analysis.unavailable("server.log", "serverResult.txt");
    }
}
