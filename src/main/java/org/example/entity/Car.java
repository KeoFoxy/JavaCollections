package org.example.entity;

import java.util.Objects;

public class Car {
    private int number;
    private String brand;

    public Car(int number, String brand) {
        this.number = number;
        this.brand = brand;
    }

    public int getNumber() {
        return number;
    }

    public String getBrand() {
        return brand;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return number == car.number && Objects.equals(brand, car.brand);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, brand);
    }
}
