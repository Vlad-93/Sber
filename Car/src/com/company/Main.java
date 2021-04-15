package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        List<Car> list = new LinkedList<>();

        list.add(new Car("Лада", "седан"));
        list.add(new Car("Лада", "хэтчбек"));
        list.add(new Car("Мерседес", "седан"));
        list.add(new Car("Бмв", "кроссовер"));
        list.add(new Car("Форд", "хэтчбек"));
        list.add(new Car("Пежо", "кроссовер"));
        list.add(new Car("Тойота", "седан"));

        HashMap<String, List<Car>> map = new HashMap<>();

        for (Car car : list) {
            String type = car.getType();

            if (map.containsKey(type)) {
                List<Car> cars =  map.get(type);
                cars.add(car);
            } else {
                List<Car> cars = new ArrayList<>();
                cars.add(car);

                map.put(type, cars);
            }
        }

        System.out.println(map);
    }
}
