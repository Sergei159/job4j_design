package ru.job4j.ood.food;

import java.time.LocalDate;

public class Fish extends Food {
    public Fish() {
    }

    public Fish(String name, LocalDate createDate, LocalDate expiryDate,
                double price, double discount) {
        super(name, createDate, expiryDate, price, discount);
    }

}


