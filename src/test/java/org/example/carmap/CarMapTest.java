package org.example.carmap;

import org.example.carhashmap.CarHashMap;
import org.example.entity.Car;
import org.example.entity.CarOwner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CarMapTest {

    private CarMap carMap;

    @BeforeEach
    public void setUp() throws Exception {
        carMap = new CarHashMap();
    }


    @Test
    public void whenPut100ElementsThenSizeBecome100() {
        for(int i = 0; i < 100; i++) {
            CarOwner carOwner = new CarOwner(i , "Name " + i, "LastName " + i);
            Car car = new Car(i, "Porsche " + i);
            carMap.put(carOwner, car);
        }

        assertEquals(100, carMap.size());
    }

    @Test
    public void whenPut100ElementsWith10DifferentKeysThenSize10() {
        for (int i = 0; i < 100; i++) {
            int index = i % 10;
            CarOwner carOwner = new CarOwner(index, "Name" + index, "LastName" + index);
            Car car = new Car(index,"Brand " + index);
            carMap.put(carOwner, car);
        }
        assertEquals(10, carMap.size());
    }

    @Test
    public void removeReturnTrueOnlyOnce() {
        for (int i = 0; i < 10; i++) {
            CarOwner carOwner = new CarOwner(i, "Name" + i, "LastName" + i);
            Car car = new Car(i,"Brand" + i);
            carMap.put(carOwner, car);
        }
        assertEquals(10, carMap.size());

        CarOwner elementForDeleting = new CarOwner(5, "Name5", "LastName5");
        assertTrue(carMap.remove(elementForDeleting));
        assertEquals(9, carMap.size());
        assertFalse(carMap.remove(elementForDeleting));
    }

    @Test
    public void countOfKeysMustBeEqualsToCountOfValues() {
        for (int i = 0; i < 100; i++) {
            CarOwner carOwner = new CarOwner(i, "Name" + i, "LastName" + i);
            Car car = new Car(i,"Brand" + i);
            carMap.put(carOwner, car);
        }
        assertEquals(100, carMap.size());
        assertEquals(100, carMap.keySet().size());
        assertEquals(100, carMap.values().size());
    }

    @Test
    public void methodGetMustReturnRightValue() {
        for (int i = 0; i < 100; i++) {
            CarOwner carOwner = new CarOwner(i, "Name" + i, "LastName" + i);
            Car car = new Car(i,"Brand" + i);
            carMap.put(carOwner, car);
        }
        CarOwner key = new CarOwner(50, "Name50", "LastName50");
        Car value = carMap.get(key);
        String expectedCarBrand = "Brand50";
        assertEquals(expectedCarBrand, value.getBrand());
    }
}
