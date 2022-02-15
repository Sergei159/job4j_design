package ru.job4j.food;

import java.util.ArrayList;
import java.util.List;

public class Warehouse implements FoodStore {
    private static List<Food> wareHouseStore = new ArrayList<>();;

    public static List<Food> get() {
        return wareHouseStore;
    }


    @Override
    public void add(Food product, double percentOfFreshness) {
        wareHouseStore.add(product);

    }

}
