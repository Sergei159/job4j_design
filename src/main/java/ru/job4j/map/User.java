package ru.job4j.map;

import java.util.*;

public class User {
    private String name;

    private int children;

    private Calendar birthday;

    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass())  {
            return false;
        }
        User user = (User) o;
        return children == user.children && Objects.equals(name, user.name) && Objects.equals(birthday, user.birthday);
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + children;
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{"
                + "name='" + name + '\''
                + ", children=" + children
                + ", birthday=" + birthday
                + '}';
    }

    private static void printCollection(Collection collection) {
        for (Object obj : collection) {
            System.out.println(obj.toString());
        }
    }

    public static void main(String[] args) {
        Map<User, Object> users = new HashMap<User, Object>();
        Calendar dot = Calendar.getInstance();
        dot.set(1980, 12, 20);
        User user1 = new User("user1", 2, dot);
        User user2 = new User("user1", 2, dot);
        users.put(user1, new Object());
        users.put(user2, new Object());
        System.out.println("user1 hashCode: " + user1.hashCode());
        System.out.println("user2 hashCode: " + user2.hashCode() + '\n');
        printCollection(users.entrySet());

    }
}
