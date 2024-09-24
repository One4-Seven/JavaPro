package com.yst.generic_method;

public class Car {
    public String name;

    public Car() {
    }

    public Car(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                '}';
    }
}
