package ru.job4j.question;

import java.util.*;

public class Analyze {

    public  static Info diff(Set<User> previous, Set<User> current) {
        int counter = 0;
        Info info = new Info();
        HashMap<Integer, User> currentList = new HashMap<>();
        for (User u : current) {
            currentList.put(u.getId(), u);
        }
        for (User u : previous) {
            if (currentList.containsKey(u.getId())
            && currentList.get(u.getId()).equals(u)) {
                counter++;
            }
            if (currentList.containsKey(u.getId())
                    && !currentList.get(u.getId()).equals(u)) {
                info.changed++;
            }
        }
        info.added = current.size() - counter - info.changed;
        info.deleted = previous.size() - counter - info.changed;
        return info;
    }

}