package ru.job4j.serialization;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ParsingJSON {
    public static void main(String[] args) {
        JSONObject jsonContact = new JSONObject(
                 "{\"phone\":\"11-111\"}");
        List<String> list = new ArrayList<>();
        list.add("1st place Math ");
        list.add("2nd place Physics");
        JSONArray jsonAchievements = new JSONArray(list);

        final Student student = new Student(true,
                23,
                "Alex",
                new Contact("11-111"),
                new String[] {"1st place Math", "2nd place Physics"});
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("isStudying", student.isStudying());
        jsonObject.put("age", student.getAge());
        jsonObject.put("name", student.getName());
        jsonObject.put("Contact", jsonContact);
        jsonObject.put("achievements", jsonAchievements);

        System.out.println(jsonObject.toString());
        System.out.println(new JSONObject(student).toString());
    }
}
