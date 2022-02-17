package ru.job4j.food;

import java.util.ArrayList;
import java.util.List;

public class Warehouse implements FoodStore {
    private  List<Food> warehouseStore = new ArrayList<>();;

    /**
     * @return метод возвращает копию листа с продуктами, находящихся
     * в хранилище данного класса
     */


    public List<Food> get() {
            return new ArrayList<>(warehouseStore);
        }


    @Override
    public boolean add(Food food) {
        boolean result = false;
        if (accept(food)) {
            warehouseStore.add(food);
            result = true;
        }
        return result;
    }

    /**
     * Метод проверяет условие, подходит ли продукт для хранилища данного класса.
     * Условие - Продукт испорчен не более чем на 25% от срока годности.
     */

    @Override
    public boolean accept(Food food) {
        boolean result = false;
        double restOfFreshness = defineRestOfTheFreshness(food);
        if (restOfFreshness < 0.25 &&  0 <= restOfFreshness) {
            result = true;
        }
        return result;
    }

}
