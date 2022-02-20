package ru.job4j.ood.parking;

import java.util.ArrayList;
import java.util.List;

/**
 * Легковая машина может занять только место, предназначенное для легковой машины.
 * Грузовая машина может разместиться на месте, предназначенном для грузовых машин,
 * либо на N парковочных мест для легковых машин, стоящих рядом.
 *
 * Легковой считается машина у которой размер равен 1, а грузовой - размер > 1.
 */

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
        boolean isTruck = transport.getSize() > GeneralCar.SIZE;
        if (transport.getSize() == GeneralCar.SIZE && carPlaces != 0) {
            transportList.add(transport);
            carPlaces--;
            result = true;
        } else if (isTruck && truckPlaces > 0)  {
           transportList.add(transport);
           truckPlaces--;
           result = true;
        } else if (isTruck && transport.getSize() <= carPlaces) {
            transportList.add(transport);
            carPlaces -= transport.getSize();
            result = true;
        }
        return result;
    }
}
