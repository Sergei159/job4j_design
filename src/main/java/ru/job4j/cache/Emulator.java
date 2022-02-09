package ru.job4j.cache;

public class Emulator {
    public static void main(String[] args) {
        AbstractCache abstractCache = new DirFileCache(".");
        abstractCache.load("Address.txt");
    }


}
