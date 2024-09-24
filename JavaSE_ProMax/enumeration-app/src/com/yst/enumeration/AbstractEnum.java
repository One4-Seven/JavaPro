package com.yst.enumeration;

// 抽象枚举
public enum AbstractEnum {
    X("申恒旭") {
        @Override
        public void speak() {
            System.out.println("我叫: " + super.getName());
            System.out.println("我是第一个实例对象");
        }
    }, Y("张升源") {
        @Override
        public void speak() {
            System.out.println("我叫: " + super.getName());
            System.out.println("我是第二个实例对象");
        }
    };

    private String name;

    AbstractEnum(String name) {
        this.name = name;
    }

    AbstractEnum() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract void speak();
}


