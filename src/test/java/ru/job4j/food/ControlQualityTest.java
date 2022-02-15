package ru.job4j.food;

import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

public class ControlQualityTest {



    @Test
    public void whenIsInWareHouse() {
        Food potato = new Vegetables(
                "potato",
                LocalDate.of(2022, 02, 10),
                LocalDate.of(2022, 04, 20),
                500,
                0
        );
        ControlQuality.defineQuality(potato);
        List<Food> expected = new ArrayList<>();
        expected.add(new Vegetables(
                "potato",
                LocalDate.of(2022, 02, 10),
                LocalDate.of(2022, 04, 20),
                500,
                0
        ));
        assertThat(expected, is(Warehouse.get()));
    }

    @Test
    public void whenIsInTrash() {
        Food chicken = new Meat(
                "chicken",
                LocalDate.of(2022, 02, 02),
                LocalDate.of(2022, 02, 15),
                500,
                0
        );
        Food bacon = new Meat(
                "bacon",
                LocalDate.of(2022, 02, 02),
                LocalDate.of(2022, 02, 13),
                700,
                0
        );
        ControlQuality.defineQuality(chicken);
        ControlQuality.defineQuality(bacon);
        List<Food> expected = new ArrayList<>();
        expected.add(new Meat(
                "chicken",
                LocalDate.of(2022, 02, 02),
                LocalDate.of(2022, 02, 15),
                500,
                0
        ));
        expected.add(new Meat(
                "bacon",
                LocalDate.of(2022, 02, 02),
                LocalDate.of(2022, 02, 13),
                700,
                0
                ));

        assertThat(expected, is(Trash.get()));
    }

    @Test
    public void whenDiscount() {
        Food fish = new Fish(
                "fish",
                LocalDate.of(2022, 02, 10),
                LocalDate.of(2022, 02, 18),
                500,
                0
        );
        ControlQuality.defineQuality(fish);
        List<Food> expected = new ArrayList<>();
        expected.add(new Fish(
                "fish",
                LocalDate.of(2022, 02, 10),
                LocalDate.of(2022, 02, 18),
                500,
                250
        ));
        assertThat(Shop.get(), is(expected));
    }

}