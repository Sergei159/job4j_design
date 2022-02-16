package ru.job4j.food;

import java.util.ArrayList;
import java.util.List;

public class Shop implements FoodStore {

    private static final List<Food> SHOP_STORE = new ArrayList<>();

    public static final double DISCOUNT_PERCENT = 0.5;

    /**
     * @return метод возвращает копию листа с продуктами, находящихся
     * в хранилище данного класса
     */
    public  static List<Food> get() {
        List<Food> copy = new ArrayList<>();
        for (Food food : SHOP_STORE) {
            copy.add(food);
        }
        return copy;
    }

    @Override
    public boolean add(Food food) {
        boolean result = false;
        if (accept(food)) {
            SHOP_STORE.add(food);
            result = true;
        }
        return result;
    }

    /**
     * Метод проверяет условие, подходит ли продукт для хранилища данного класса.
     * Условие - Продукт испорчен более чем на 25% от срока годности.
     * Если продукт испорчен более чем на 75%, то продукту присваивается скидка
     * DISCOUNT_PERCENT в процентах от стоимости товара.
     */

    @Override
    public boolean accept(Food food) {
        boolean result = false;
        double restOfFreshness = defineRestOfTheFreshness(food);
        if (restOfFreshness >= 0.25 &&  0.75 > restOfFreshness) {
            result = true;
        } else if (restOfFreshness >= 0.75 &&  1 > restOfFreshness) {
            food.setDiscount(food.getPrice() * DISCOUNT_PERCENT);
            result = true;
        }
          return result;
        }

}
