package com.yst.interface_demo;

public class Student extends People implements Driver, Singer {

    public Student() {
    }

    public Student(String name) {
        super(name);
    }

    @Override
    public void driver() {
        System.out.println("我" + getName() + "有驾驶证");
    }

    @Override
    public void sing() {
        System.out.println("我" + getName() + "会唱歌");
    }
}
