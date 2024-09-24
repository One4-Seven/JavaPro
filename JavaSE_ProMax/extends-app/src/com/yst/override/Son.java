package com.yst.override;

public class Son extends Father {
    // 使用 @Override 注解让重写的方法更加安全 增加可读性
    @Override
    public void speak() {
        System.out.println("我是儿子!");
    }

    @Override
    public String toString() {
        return "这是一个儿子类的实例!";
    }

    public void speaks() {
        speak();
        super.speak();
    }
}
