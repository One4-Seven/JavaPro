package com.yst.generic_method;

public class BMW extends Car {
    public BMW() {
    }

    public BMW(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return "BMW{" +
                "name='" + name + '\'' +
                '}';
    }
}
