package ru.job4j.food;

import java.util.ArrayList;
import java.util.List;

public class Trash implements FoodStore {

    private static final List<Food> TRASH_STORE = new ArrayList<>();;

    /**
     * @return метод возвращает копию листа с продуктами, находящихся
     * в хранилище данного класса
     */

    public static List<Food> get() {
        List<Food> copy = new ArrayList<>();
        for (Food food : TRASH_STORE) {
            copy.add(food);
        }
        return copy;
    }

    @Override
    public boolean add(Food food) {
        boolean result = false;
        if (accept(food)) {
            TRASH_STORE.add(food);
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
