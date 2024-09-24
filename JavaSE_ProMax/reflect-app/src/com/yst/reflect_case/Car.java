package com.yst.reflect_case;

public class Car {
    private String name;
    private String mode;

    public Car() {
    }

    public Car(String name, String mode) {
        this.name = name;
        this.mode = mode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", mode='" + mode + '\'' +
                '}';
    }
}
