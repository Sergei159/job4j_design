package ru.job4j.ood.food;

import java.time.LocalDate;

public class Meat extends Food {
    public Meat() {
    }

    public Meat(String name, LocalDate createDate, LocalDate expiryDate,
                double price, double discount) {
        super(name, createDate, expiryDate, price, discount);
    }
}
