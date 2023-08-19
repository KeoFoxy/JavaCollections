package org.example.entity;

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
}
