package com.yst.abstract_demo;

public class Dog extends Animal{

    public Dog() {
    }

    public Dog(String name) {
        super(name);
    }

    @Override
    public void cry() {
        System.out.println("我是小狗" + getName());
    }
}
