package ru.job4j.ood.food;

import java.time.LocalDate;

public class Bakery extends Food {
    public Bakery() {
    }

    public Bakery(String name, LocalDate createDate, LocalDate expiryDate,
                  double price, double discount) {
        super(name, createDate, expiryDate, price, discount);
    }
}
