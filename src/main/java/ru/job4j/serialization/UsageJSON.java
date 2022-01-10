package ru.job4j.serialization;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class UsageJSON {
    public static void main(String[] args) {
        final Student student = new Student(true,
                 23,
                "Alex",
                new Contact("11-111"),
                new String[] {"1st place Math", "2nd place Physics"});
        final Gson gson = new GsonBuilder().create();
        System.out.println(gson.toJson(student));

        final String studentJson =
                "{"
                        + "\"isStudying\":true,"
                        + "\"age\":23,"
                        + "\"name\":Alex,"
                        + "\"studentContact\":"
                        + "{"
                        + "\"phone\":\"11-111\""
                        + "},"
                        + "\"achievements\":"
                        + "[\"1st place Math\",\"2nd place Physics\"]"
                        + "}";
        final Student studentMod = gson.fromJson(studentJson, Student.class);
        System.out.println(studentMod);
    }
}

