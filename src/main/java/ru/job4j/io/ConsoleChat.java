package ru.job4j.io;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ConsoleChat {
    private final String path;
    private final String botAnswers;
    private static final String OUT = "exit";
    private static final String STOP = "stop";
    private static final String CONTINUE = "continue";
    private List<String> log = new ArrayList();


    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
    }

    public void run() {
        System.out.println(
                "Welcome to the console Chat"
                        + System.lineSeparator()
                        + "choose the action :"
                        + System.lineSeparator()
                        + "continue"
                        + System.lineSeparator()
                        + "stop"
                        + System.lineSeparator()
                        + "exit"
                        + System.lineSeparator()
        );
        Scanner scanner = new Scanner(System.in);
        String condition;
        boolean isWorking = true;
        while (scanner.hasNextLine()) {
            condition = scanner.nextLine();
            log.add("you: " + condition);
            if (OUT.equals(condition)) {
                scanner.close();
                break;
            }
            if (STOP.equals(condition)) {
                isWorking = false;
            }
            if (CONTINUE.equals(condition) && !isWorking) {
                isWorking = true;
            }
            if (isWorking) {
                writeAnswer();
            }
        }
        saveLog(log);
    }

    private List<String> readPhrases() throws FileNotFoundException {
        List<String> result = new ArrayList();
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

    private void writeAnswer()  {
        List<String> rsl = new ArrayList();
        try {
            rsl = readPhrases();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int index = new Random().nextInt(rsl.size());
        System.out.println(rsl.get(index));
        log.add("bot: " + rsl.get(index));
    }

    private void saveLog(List<String> log) {
        try (var out = new PrintWriter(
                new FileWriter(path, StandardCharsets.UTF_8, true))) {
            for (String string : log) {
                out.println(string + System.lineSeparator());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ConsoleChat cc = new ConsoleChat("savedLog.txt", "phrases.txt");
        cc.run();
    }
}
