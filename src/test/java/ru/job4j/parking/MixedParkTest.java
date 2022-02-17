package ru.job4j.parking;

import org.junit.Ignore;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
@Ignore
public class MixedParkTest {

    @Test
    public void onlyCars() {
        MixedPark mixedPark = new MixedPark(3, 0);
        Transport car1 = new GeneralCar();
        Transport car2 = new GeneralCar();
        Transport car3 = new GeneralCar();
        Transport truck1 = new Truck(2);
        mixedPark.park(car1);
        mixedPark.park(car2);
        mixedPark.park(car3);
        mixedPark.park(truck1);

        List<Transport> expected = List.of(
                car1, car2, car3);
        assertThat(mixedPark.get(), is(expected));
    }

    @Test
    public void onlyTrucks() {
        MixedPark mixedPark = new MixedPark(3, 1);
        Transport truck1 = new Truck(3);
        Transport truck2 = new Truck(2);
        Transport truck3 = new Truck(2);
        mixedPark.park(truck1);
        mixedPark.park(truck2);
        mixedPark.park(truck3);

        List<Transport> expected = List.of(
                truck1, truck2);
        assertThat(mixedPark.get(), is(expected));
    }

    @Test
    public void onlyGeneralCarsAndTrucks() {
        MixedPark mixedPark = new MixedPark(3, 1);
        Transport car1 = new GeneralCar();
        Transport truck1 = new Truck(2);
        Transport truck2 = new Truck(2);
        Transport truck3 = new Truck(2);
        mixedPark.park(car1);
        mixedPark.park(truck1);
        mixedPark.park(truck2);
        mixedPark.park(truck3);

        List<Transport> expected = List.of(
                car1, truck1, truck2);
        assertThat(mixedPark.get(), is(expected));
    }

    @Test
    public void whenTruckPlacesAreOccupied() {
        MixedPark mixedPark = new MixedPark(3, 1);
        Transport car1 = new GeneralCar();
        Transport truck1 = new Truck(3);
        Transport truck2 = new Truck(3);
        mixedPark.park(car1);
        mixedPark.park(truck1);
        mixedPark.park(truck2);

        List<Transport> expected = List.of(
                car1, truck1);
        assertThat(mixedPark.get(), is(expected));
    }

    @Test
    public void whenGeneralCarPlacesAreOccupied() {
        MixedPark mixedPark = new MixedPark(2, 1);
        Transport car1 = new GeneralCar();
        Transport car2 = new GeneralCar();
        Transport car3 = new GeneralCar();
        mixedPark.park(car1);
        mixedPark.park(car2);
        mixedPark.park(car3);

        List<Transport> expected = List.of(
                car1, car2);
        assertThat(mixedPark.get(), is(expected));
    }

}