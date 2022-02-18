package ru.job4j.parking;

import java.util.ArrayList;
import java.util.List;

public class MixedPark implements Parking {
    private int carPlaces;
    private int truckPlaces;

    private List<Transport> transportList = new ArrayList<>();

    public List<Transport> get() {
        return new ArrayList<>(transportList);
    }

    public MixedPark(int carPlaces, int truckPlaces) {
        this.carPlaces = carPlaces;
        this.truckPlaces = truckPlaces;
    }


    @Override
    public boolean park(Transport transport) {
        boolean result = false;
        if (transport.getSize() == GeneralCar.SIZE && carPlaces != 0) {
            transportList.add(transport);
            carPlaces--;
            result = true;
        }
        if (transport.getSize() > GeneralCar.SIZE) {
            if (truckPlaces > 0) {
               transportList.add(transport);
               truckPlaces--;
               result = true;
            } else if (transport.getSize() <= carPlaces) {
                transportList.add(transport);
                carPlaces -= transport.getSize();
                result = true;
            }
        }
        return result;
    }
}
