package org.example.carset;

import org.example.carhashset.CarHashSet;
import org.example.entity.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarSetTest {

    private CarSet carSet;


    @BeforeEach
    public void setUp() throws Exception {
        carSet = new CarHashSet();
        for (int i = 0; i < 100; i++) {
            carSet.add(new Car(i, "Brand " + i));
        }
    }

    @Test
    public void whenAdd3SimilarObjectsThenSizeIncreaseBy1() {
        assertEquals(100, carSet.size());
        assertTrue(carSet.add(new Car(10,"BMW")));
        assertFalse(carSet.add(new Car(10,"BMW")));
        assertFalse(carSet.add(new Car(10,"BMW")));
        assertEquals(101, carSet.size());
    }

    @Test
    public void whenSetClearedThenSize0() {
        carSet.clear();
        assertEquals(0, carSet.size());
    }

    @Test
    public void whenElementRemovedThenSizeDecreased() {
        assertTrue(carSet.remove(new Car(30,"Brand 30")));
        assertEquals(99, carSet.size());
        assertFalse(carSet.remove(new Car(30,"Brand 30")));
        assertEquals(99, carSet.size());
    }


    @Test
    void clear() {
    }
}