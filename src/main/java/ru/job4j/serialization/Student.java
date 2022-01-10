package ru.job4j.serialization;

import java.util.Arrays;

public class Student {
    private boolean isStudying;
    private int age;
    private String name;
    private Contact studentContact;
    private String[] achievements;


    public Student(boolean isStudying, int age, String name,
                   Contact studentContact, String[] achievements) {
        this.isStudying = isStudying;
        this.age = age;
        this.name = name;
        this.studentContact = studentContact;
        this.achievements = achievements;
    }

    @Override
    public String toString() {
        return "Student{"
                + "isStudying=" + isStudying
                + ", age=" + age
                + ", name='" + name + '\''
                + ", studentContact=" + studentContact
                + ", achievements=" + Arrays.toString(achievements)
                + '}';
    }
}
