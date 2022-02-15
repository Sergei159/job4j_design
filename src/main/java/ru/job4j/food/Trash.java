package ru.job4j.food;

import java.util.ArrayList;
import java.util.List;

public class Trash implements FoodStore {
    private static List<Food> trashStore = new ArrayList<>();;

    public static List<Food> get() {
        return trashStore;
    }

    @Override
    public void add(Food product, double rottenness) {
        trashStore.add(product);

    }
}
