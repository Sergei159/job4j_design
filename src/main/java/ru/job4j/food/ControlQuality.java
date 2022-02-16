package ru.job4j.food;

import java.util.ArrayList;
import java.util.List;

/**
 * Метод сортирует продукты по разным хранилищам. Для этого нужно создать
 * лист с продуктами и лист с хранилищами.
 * Из листа с продуктами метод будет пытаться добавить каждый продукт в каждое
 * хранилище из списка хранилищ.
 */
public class ControlQuality {
    /**
     * Лист с хранилищами
     */
    private  List<FoodStore> foodStoreList = new ArrayList<>();

    public ControlQuality(List<FoodStore> foodStoreList) {
        this.foodStoreList = foodStoreList;
    }

    /**
     * метод будет пытаться добавить food в каждый из возможных вариантов
     * из foodStoreList. Если метод add интерфейса FoodStore вернул true, прекращаем
     * цикл, так как один продукт не может находиться в разных хранилищах
     */
    public  void sort(Food food) {
        for (FoodStore store : foodStoreList) {
            store.add(food);
        }
    }

}

