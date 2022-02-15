package ru.job4j.food;

import java.util.Date;

public class Bakery extends Food {
    public Bakery() {
    }

    public Bakery(String name, Date expiryDate, Date createDate,
                  double price, double discount) {
        super(name, expiryDate, createDate, price, discount);
    }
}
