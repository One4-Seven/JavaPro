package com.yst.abstract_demo;

public abstract class Animal {
    private String name;

    // 模板方法设计模式 简化代码
    public final void speak() {
        System.out.println("我是一只可爱的小动物!");
        cry();
    }

    public abstract void cry();

    public Animal() {
    }

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
