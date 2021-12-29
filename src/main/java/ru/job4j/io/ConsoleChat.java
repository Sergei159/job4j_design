package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleChat {
    private final String path;
    private final String botAnswers;
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";


    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
    }

    public void run() {
        System.out.println(
                "Welcome to ta console Chat"
                + System.lineSeparator()
                + "choose the action :"
                + System.lineSeparator()
                + "continue"
                + System.lineSeparator()
                + "pause"
                + System.lineSeparator()
                + "stop"
        );
        Scanner scanner = new Scanner(System.in);
        String condition = scanner.nextLine();
        while (!"stop".equals(condition)) {

        }
    }

    private List<String> readPhrases() throws FileNotFoundException {
        List result = new ArrayList();
        BufferedReader in = new BufferedReader(new FileReader(botAnswers));
        try {
            String nextLine = in.readLine();
            while (nextLine != null) {
                result.add(nextLine);
                nextLine = in.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    private void saveLog(List<String> log) {

    }

    public static void main(String[] args) {
        ConsoleChat cc = new ConsoleChat("", "");
        cc.run();
    }
}
