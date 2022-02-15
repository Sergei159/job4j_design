package ru.job4j.food;

import java.util.Date;

public class Fish extends Food {
    public Fish() {
    }

    public Fish(String name, Date expiryDate, Date createDate,
                double price, double discount) {
        super(name, expiryDate, createDate, price, discount);
    }

}


