package ru.job4j.food;

import java.util.ArrayList;
import java.util.List;

public class Trash implements FoodStore {

    private List<Food> trashStore = new ArrayList<>();;

    /**
     * @return метод возвращает копию листа с продуктами, находящихся
     * в хранилище данного класса
     */
    @Override
    public List<Food> get() {
        return new ArrayList<>(trashStore);
    }

    @Override
    public boolean add(Food food) {
        boolean result = false;
        if (accept(food)) {
            trashStore.add(food);
            result = true;
        }
        return result;
    }

    /**
     * Метод проверяет условие, подходит ли продукт для хранилища данного класса.
     * Условие - Срок годности истек.
     */
    @Override
    public boolean accept(Food food) {
        boolean result = false;
        double restOfFreshness = defineRestOfTheFreshness(food);
        if (restOfFreshness >= 1) {
            result = true;
        }
        return result;
    }
}
