package org.example.collection;

import org.example.entity.Car;

public interface CarCollection {
    int size();
    void clear();
    boolean remove(Car car);
    boolean add(Car car);
    boolean contains(Car car);
}
