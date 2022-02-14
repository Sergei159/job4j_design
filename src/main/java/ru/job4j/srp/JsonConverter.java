package ru.job4j.srp;

import com.google.gson.GsonBuilder;

import java.util.List;

public class JsonConverter implements Converter {

    @Override
    public String convert(List<Employee> workers) {
        var lib = new GsonBuilder().create();
        return lib.toJson(workers);
    }
}
