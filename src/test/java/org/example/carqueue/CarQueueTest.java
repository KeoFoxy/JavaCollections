package org.example.carqueue;

import org.example.carlinkedlist.CarLinkedList;
import org.example.entity.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CarQueueTest {

    private CarQueue queue;

    @BeforeEach
    public void setUp() throws Exception {
        queue = new CarLinkedList();
        for (int i = 0; i < 10; i++) {
            queue.add(new Car(i,"Brand " + i));
        }
    }

    @Test
    public void add() {
        assertEquals(10, queue.size());
    }

    @Test
    public void peek() {
        Car car = queue.peek();
        assertEquals("Brand 0", car.getBrand());
        assertEquals(10, queue.size());
    }

    @Test
    public void poll() {
        Car car = queue.poll();
        assertEquals("Brand 0", car.getBrand());
        assertEquals(9, queue.size());
    }
}