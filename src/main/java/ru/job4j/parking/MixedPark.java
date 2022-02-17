package ru.job4j.parking;

import java.util.ArrayList;
import java.util.List;

public class MixedPark implements Parking {
    private int carPlaces;
    private int truckPlaces;

    private List<Transport> transportList;

    public List<Transport> get() {
        return new ArrayList<>(transportList);
    }

    public MixedPark(int carPlaces, int truckPlaces) {
        this.carPlaces = carPlaces;
        this.truckPlaces = truckPlaces;
    }


    @Override
    public boolean park(Transport transport) {
        return true;
    }
}
