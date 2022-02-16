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
        Shop shop = new Shop();
        Warehouse warehouse = new Warehouse();
        Trash trash = new Trash();
        List<FoodStore> foodStoreList = List.of(shop, warehouse, trash);

        Food potato = new Vegetables(
                "potato",
                LocalDate.now().minusDays(5),
                LocalDate.now().plusDays(100),
                500,
                0
        );
        Food chicken = new Meat(
                "chicken",
                LocalDate.now().minusDays(1),
                LocalDate.now().plusDays(20),
                700,
                0
        );
        List<Food> foodList = List.of(potato, chicken);
        ControlQuality controlQuality = new ControlQuality(foodStoreList);
        foodList.forEach(controlQuality::sort);

        List<Food> expected = new ArrayList<>();
        expected.add(new Vegetables(
                "potato",
                LocalDate.now().minusDays(5),
                LocalDate.now().plusDays(100),
                500,
                0
        ));
        expected.add(new Meat(
                "chicken",
                LocalDate.now().minusDays(1),
                LocalDate.now().plusDays(20),
                700,
                0
        ));
        assertThat(Warehouse.get(), is(expected));
    }

    @Test
    public void whenIsInTrash() {
        Shop shop = new Shop();
        Warehouse warehouse = new Warehouse();
        Trash trash = new Trash();
        List<FoodStore> foodStoreList = List.of(shop, warehouse, trash);

        Food chicken = new Meat(
                "chicken",
                LocalDate.now().minusDays(15),
                LocalDate.now().minusDays(2),
                500,
                0
        );
        Food bacon = new Meat(
                "bacon",
                LocalDate.now().minusDays(10),
                LocalDate.now().minusDays(1),
                700,
                0
        );
        List<Food> foodList = List.of(chicken, bacon);
        ControlQuality controlQuality = new ControlQuality(foodStoreList);
        foodList.forEach(controlQuality::sort);

        List<Food> expected = new ArrayList<>();
        expected.add(new Meat(
                "chicken",
                LocalDate.now().minusDays(15),
                LocalDate.now().minusDays(2),
                500,
                0
        ));
        expected.add(new Meat(
                "bacon",
                LocalDate.now().minusDays(10),
                LocalDate.now().minusDays(1),
                700,
                0
        ));
        assertThat(Trash.get(), is(expected));
    }



    @Test
    public void whenIsInShopWithoutDiscount() {
        Shop shop = new Shop();
        Warehouse warehouse = new Warehouse();
        Trash trash = new Trash();
        List<FoodStore> foodStoreList = List.of(shop, warehouse, trash);

        Food bread = new Bakery(
                "bread",
                LocalDate.now().minusDays(5),
                LocalDate.now().plusDays(10),
                500,
                0
        );
        List<Food> foodList = List.of(bread);
        ControlQuality controlQuality = new ControlQuality(foodStoreList);
        foodList.forEach(controlQuality::sort);

        List<Food> expected = new ArrayList<>();
        expected.add(new Bakery(
                "bread",
                LocalDate.now().minusDays(5),
                LocalDate.now().plusDays(10),
                500,
                0
        ));
        assertThat(Shop.get(), is(expected));
    }

}