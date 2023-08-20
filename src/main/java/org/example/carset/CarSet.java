package org.example.carset;

import org.example.collection.CarCollection;
import org.example.entity.Car;

public interface CarSet extends CarCollection {
    int size();
    void clear();
    boolean add(Car car);
    boolean remove(Car car);
//    boolean contains(Car car);
}
