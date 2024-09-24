package com.yst.abstract_demo;

public class Demo {
    public static void main(String[] args) {
        // 认识理解简单的抽象类
        // 抽象方法没有方法体 存在抽象方法必须在抽象类中
        // 抽象方法不能创建实例 但可以有构造器方法 供子类继承
        // 子类必须重写所有的抽象方法 否则子类要是抽象类
        Animal a1 = new Cat();
        a1.setName("TOM");

        Animal a2 = new Dog("PPP");

        a1.speak();
        a2.speak();
    }
}
