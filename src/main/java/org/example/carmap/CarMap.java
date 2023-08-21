package org.example.carmap;

import org.example.entity.Car;
import org.example.entity.CarOwner;

import java.util.List;
import java.util.Set;

public interface CarMap {
    int size();
    void clear();
    List<Car> values();
    Set<CarOwner> keySet();
    Car get(CarOwner key);
    boolean remove(CarOwner key);
    void put(CarOwner key, Car value);
}
