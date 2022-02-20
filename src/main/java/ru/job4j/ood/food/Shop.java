package ru.job4j.ood.food;

import java.util.ArrayList;
import java.util.List;

public class Shop implements FoodStore {


    private List<Food> shopStore = new ArrayList<>();


    /**
     * @return метод возвращает копию листа с продуктами, находящихся
     * в хранилище данного класса
     */
    @Override
    public List<Food> get() {
        return new ArrayList<>(shopStore);
    }

    @Override
    public void clear() {
        shopStore.clear();
    }


    @Override
    public boolean add(Food food) {
        boolean result = false;
        if (accept(food)) {
            double restOfFreshness = defineRestOfTheFreshness(food);
            if (restOfFreshness >= 0.75) {
                food.setPrice(food.getPrice() - food.getPrice() * food.getDiscount() * 0.01);
            }
            shopStore.add(food);
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
        if (restOfFreshness >= 0.25 && 1 > restOfFreshness) {
            result = true;
        }
        return result;
    }
}

