package org.example.carlist;

import org.example.entity.Car;

public interface CarList {
    Car get(int index);

    int size();

    void clear();
    void add(Car car);
    void add(Car car, int index);

    boolean removeAt(int index);
    boolean remove(Car car);
}
