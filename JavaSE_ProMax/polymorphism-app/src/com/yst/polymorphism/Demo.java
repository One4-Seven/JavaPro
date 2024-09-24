package com.yst.polymorphism;

public class Demo {
    public static void main(String[] args) {
        // 认识和理解多态 对象多态 行为多态
        // 识别技巧: 编译看左边 运行看右边 (变量: 编译看左边 运行看左边)
        // 多态的好处: 解耦性 拓展性强
        // 多态的弊端: 无法调用子类中的独有功能
        People p1 = new Student();
        p1.run();
        System.out.println(p1.name);
        System.out.println(p1.LIVE_PLACE);

        People p2 = new Teacher();
        p2.run();
        System.out.println(p2.name);
        System.out.println(p2.LIVE_PLACE);

        // 进行强制类型转换 来调用子类的独有方法
        System.out.println("--------------------");
        go(p1);
        go(p2);
    }
    public static void go(People p) {
        p.run();
        // instanceof 关键字判断具体类型 放置强制类型转换出错
        if (p instanceof Student s) {
            s.speak();
        } else if (p instanceof Teacher t) {
            t.speak();
        }
    }
}
