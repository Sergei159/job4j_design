package ru.job4j.food;

import java.util.ArrayList;
import java.util.List;

public class Shop implements FoodStore {

    private static  List<Food> shopStore = new ArrayList<>();

    public static final double DISCOUNT_PERCENT = 0.5;

    public  static List<Food> get() {
        return shopStore;
    }

    @Override
    public void add(Food product, double rottenness) {
        if (rottenness > 0.25 && 0.75 > rottenness) {
            shopStore.add(product);
        } else {
            product.setDiscount(product.getPrice() * DISCOUNT_PERCENT);
            shopStore.add(product);
        }


    }

}
