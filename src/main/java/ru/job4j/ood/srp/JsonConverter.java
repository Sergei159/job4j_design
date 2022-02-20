package ru.job4j.ood.srp;

import com.google.gson.GsonBuilder;

import java.util.function.Predicate;

public class JsonConverter implements Report {

    private Store store;

    public JsonConverter(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        var lib = new GsonBuilder().create();
        return lib.toJson(store.findBy(filter));
    }

}
