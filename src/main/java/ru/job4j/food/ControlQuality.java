package ru.job4j.food;

import java.time.LocalDate;

public class ControlQuality {

    public static void defineQuality(Food product) {
        LocalDate now = LocalDate.now();
        LocalDate created = product.getCreateDate();
        LocalDate expired = product.getExpiryDate();
        double rottenness = ((double) (now.getDayOfYear() - created.getDayOfYear()) / (double) (expired.getDayOfYear() - created.getDayOfYear()));
        sort(product, rottenness);
    }

    private static void sort(Food product, double rottenness) {
        if (rottenness >= 0.25 &&  1 > rottenness) {
            Shop shop = new Shop();
            shop.add(product, rottenness);
        } else if (rottenness < 0.25 && 0 <= rottenness) {
            Warehouse wh = new Warehouse();
            wh.add(product, rottenness);
        } else {
            Trash trash = new Trash();
            trash.add(product, rottenness);
        }
    }

}

