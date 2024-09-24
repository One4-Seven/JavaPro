package com.yst.generic_method;

public class Toyota extends Car {
    public Toyota() {
    }

    public Toyota(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return "Toyota{" +
                "name='" + name + '\'' +
                '}';
    }
}
