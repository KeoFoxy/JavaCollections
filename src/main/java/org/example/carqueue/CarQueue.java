package org.example.carqueue;

import org.example.collection.CarCollection;
import org.example.entity.Car;

public interface CarQueue extends CarCollection {
    boolean add(Car car);
    Car peek();
    Car poll();
}
