package com.yst.enumeration;

public enum Enumeration {
    X, Y, Z("大厦比");

    private String name;

    Enumeration(String name) {
        this.name = name;
    }

    Enumeration() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
