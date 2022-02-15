package ru.job4j.food;

import java.util.List;

public class Warehouse implements FoodStore {
    private List<Food> wareHouseStore;

    public void get() {
        wareHouseStore.forEach(System.out::println);
        }


    @Override
    public boolean control(Food product) {
        boolean result = false;

        return result;
    }

}
