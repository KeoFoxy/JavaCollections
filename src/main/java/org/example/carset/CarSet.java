package org.example.carset;

import org.example.entity.Car;

public interface CarSet {
    boolean add(Car car);
    boolean remove(Car car);
    int size();
    void clear();
}
