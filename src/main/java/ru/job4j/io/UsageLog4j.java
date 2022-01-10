package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {

    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void consoleOutput() {
        byte age = 23;
        short value = 25;
        int number = 1234;
        long id = 45622L;
        float weight = 80.2f;
        double distance = 5600d;
        char symbol = 'a';
        boolean isWorking = true;
        LOG.debug(
                "User info age : {}, value: {}, number : {}, id : {}, weight : {}, distance : {}, symbol : {}, isWorking : {}",
                age, value, number, id, weight, distance, symbol, isWorking);

    }
    public static void main(String[] args) {
        LOG.trace("trace message");
        LOG.debug("debug message");
        LOG.info("info message");
        LOG.warn("warn message");
        LOG.error("error message");
        consoleOutput();
    }
}
