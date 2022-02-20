package ru.job4j.ood.food;

import java.time.LocalDate;

public class Vegetables extends Food {
    public Vegetables() {
    }

    public Vegetables(String name, LocalDate createDate, LocalDate expiryDate,
                      double price, double discount) {
        super(name, createDate, expiryDate, price, discount);
    }
}
