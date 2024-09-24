package com.yst.abstract_demo;

public class Cat extends Animal {

    public Cat() {
    }

    public Cat(String name) {
        super(name);
    }

    @Override
    public void cry() {
        System.out.println("我是小猫" + getName());
    }
}
