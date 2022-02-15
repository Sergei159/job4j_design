package ru.job4j.food;

import java.util.Date;

public class Vegetables extends Food {
    public Vegetables() {
    }

    public Vegetables(String name, Date expiryDate, Date createDate,
                double price, double discount) {
        super(name, expiryDate, createDate, price, discount);
    }
}
