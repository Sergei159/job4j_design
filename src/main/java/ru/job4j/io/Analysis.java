package ru.job4j.io;

import java.io.*;

public class Analysis {
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
                previous = current;

                if (currentEqualsTo400or500 && !previousEqualsTo400or500) {
                    result.append(current[1]).append(";");
                }
                if (!currentEqualsTo400or500 && previousEqualsTo400or500) {
                    result.append(current[1])
                            .append(";").append(System.lineSeparator());
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
