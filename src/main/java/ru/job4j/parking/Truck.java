package ru.job4j.parking;

public class Truck implements Transport {
    private int size;


    public Truck(int size) {
        this.size = size;
    }

    @Override
    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
