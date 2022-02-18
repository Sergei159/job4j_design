package ru.job4j.parking;

public class GeneralCar implements Transport {
   public static final int SIZE = 1;


   @Override
   public int getSize() {
      return SIZE;
   }
}
