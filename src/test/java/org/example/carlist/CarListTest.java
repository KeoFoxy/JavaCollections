package org.example.carlist;

import org.example.entity.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarListTest {

    private CarList carList;

    @BeforeEach
    public void setUp() throws Exception{
        //init
        for(int i = 0; i < 100; i++) {
            carList.add(new Car(i, "Brand " + i));
        }
    }

    @Test
    public void whenAdded100ElementsThenSizeMustBe100() {
        assertEquals(100, carList.size());
    }

    @Test
    public void whenElementRemovedByIndexThenSizeMustBeDecreased() {
        assertEquals(100, carList.size());
        assertTrue(carList.removeAt(5));
        assertEquals(99, carList.size());
    }

    @Test
    public void whenElementRemovedThenSizeMustBeDecreased() {
        Car car = new Car(18, "Porsche");
        carList.add(car);
        assertEquals(101, carList.size());
        assertTrue(carList.remove(car));
        assertEquals(100, carList.size());
    }

    @Test
    public void whenNonExistingElementRemovedThenReturnFalse() {
        Car car = new Car(18, "Porsche");
        assertFalse(carList.remove(car));
        assertEquals(100, carList.size());
    }

    @Test
    public void whenListCreatedThenSizeMustBeZero() {
        carList.clear();
        assertEquals(0, carList.size());
    }

    @Test
    public void whenIndexOutOfBoundsThenThrownException() {
        assertThrows(IndexOutOfBoundsException.class, () -> {
            carList.get(100);
        });
    }

    @Test
    public void methodGetReturnedRightValue() {
        Car car = carList.get(0);
        assertEquals("Brand 0", car.getBrand());
    }
}