package org.example.carlinkedlist;

import org.example.carlist.CarList;
import org.example.carqueue.CarQueue;
import org.example.entity.Car;
import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

public class CarLinkedList implements CarList, CarQueue {

    private Node first;
    private Node last;
    private int size = 0;

    @Override
    public Car get(int index) {
        return getNode(index).value;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        first = null;
        last = null;
        size = 0;
    }

    @Override
    public boolean add(Car car) {
        if(size == 0) {
            Node node = new Node(null, car, null);
            first = node;
            last = node;
        } else {
            Node secondLast = last;
            last = new Node(secondLast, car, null);
            secondLast.next = last;
        }
        size++;
        return true;
    }

    @Override
    public Car peek() {
        return (size > 0) ? get(0) : null;
    }

    @Override
    public Car poll() {
        Car car = get(0);
        removeAt(0);
        return car;
    }

    @Override
    public boolean add(Car car, int index) {
        if(index < 0 || index > size)
            throw new IndexOutOfBoundsException();
        if(index == size) {
            return add(car);
        }
        Node nodeNext = getNode(index);
        Node nodePrevious = nodeNext.previous;
        Node newNode = new Node(nodePrevious, car, nodeNext);
        nodeNext.previous = newNode;
        if(nodePrevious != null)
            nodePrevious.next = newNode;
        else
            first = newNode;
        size++;
        return true;
    }

    @Override
    public boolean removeAt(int index) {
        Node node = getNode(index);
        Node nodeNext = node.next;
        Node nodePrev = node.previous;

        if(nodeNext != null)
            nodeNext.previous = nodePrev;
        else
            last = nodePrev;

        if(nodePrev != null)
            nodePrev.next = nodeNext;
        else
            first = nodeNext;
        size--;
        return true;
    }

    @Override
    public boolean remove(Car car) {
        Node node = first;
        for(int i = 0; i < size; i++) {
            if(node.value.equals(car)) {
                return removeAt(i);
            }
            node = node.next;
        }
        return false;
    }

    @Override
    public boolean contains(Car car) {
        Node node = first;
        for(int i = 0; i < size; i++) {
            if(node.value.equals(car)) {
                return true;
            }
            node = node.next;
        }
        return false;
    }

    private Node getNode(int index) {
        if(index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
        Node node = first;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    @NotNull
    @Override
    public Iterator<Car> iterator() {
        return new Iterator<Car>() {

            private Node node = first;

            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public Car next() {
                Car car = node.value;
                node = node.next;
                return car;
            }
        };
    }

    private static class Node {
        private Node previous;
        private Car value;
        private Node next;

        Node(Node previous, Car value, Node next) {
            this.previous = previous;
            this.value = value;
            this.next = next;
        }
    }
}
