package ru.job4j.cache;

import java.util.Scanner;

public class Emulator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter the directory to cache: ");
        String askDir = scanner.nextLine();
        System.out.println("enter the file to get: ");
        String askFile = scanner.nextLine();
        AbstractCache abstractCache = new DirFileCache(askDir);
        abstractCache.load(askFile);
    }


}
