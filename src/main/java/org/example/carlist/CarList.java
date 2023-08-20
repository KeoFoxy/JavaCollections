package org.example.carlist;

import org.example.collection.CarCollection;
import org.example.entity.Car;

public interface CarList extends CarCollection {
    Car get(int index);

    int size();

    void clear();
    boolean add(Car car);
    boolean add(Car car, int index);

    boolean removeAt(int index);
    boolean remove(Car car);
}
