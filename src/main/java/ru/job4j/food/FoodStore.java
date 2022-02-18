package ru.job4j.food;

import java.time.LocalDate;
import java.util.List;

public interface FoodStore {

     boolean add(Food product);

     boolean accept(Food food);

     List<Food> get();

     void clear();


     default double defineRestOfTheFreshness(Food food) {
          LocalDate now = LocalDate.now();
          LocalDate created = food.getCreateDate();
          LocalDate expired = food.getExpiryDate();
          return ((double) (now.getDayOfYear() - created.getDayOfYear())
                  / (double) (expired.getDayOfYear() - created.getDayOfYear()));

     }


}
