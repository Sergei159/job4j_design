package ru.job4j.parking;

public class MixedPark implements Parking {
    private int countOfPlaces;

    public MixedPark(int countOfPlaces) {
        this.countOfPlaces = countOfPlaces;
    }

    @Override
    public boolean create(Transport transport) {
        return true;
    }
}
