package org.example.collection;

import org.example.carlinkedlist.CarLinkedList;

import org.example.entity.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class CarCollectionTest {

    private CarCollection carCollection;

    @BeforeEach
    public void setUp() throws Exception {
        carCollection = new CarLinkedList();
        for (int i = 0; i < 100; i++) {
            carCollection.add(new Car(i, "Brand " + i));
        }
    }

    @Test
    public void contains() {
        assertTrue(carCollection.contains(new Car(20,"Brand 20")));
        assertFalse(carCollection.contains(new Car(20,"Brand 200")));
    }
}
