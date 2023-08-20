package org.example.carset;

import org.example.collection.CarCollection;
import org.example.entity.Car;

public interface CarSet extends CarCollection {
    boolean add(Car car);
    boolean remove(Car car);
    int size();
    void clear();
}
