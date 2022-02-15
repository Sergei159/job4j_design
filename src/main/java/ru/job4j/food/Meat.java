package ru.job4j.food;

import java.util.Date;

public class Meat extends Food {
    public Meat() {
    }

    public Meat(String name, Date expiryDate, Date createDate,
                double price, double discount) {
        super(name, expiryDate, createDate, price, discount);
    }
}
