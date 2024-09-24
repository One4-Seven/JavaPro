package com.yst.inner_class;

public class Demo {
    public static void main(String[] args) {
        // 认识内部类的四种基本类型和使用注意事项
        // 创建内部类实例 一般格式: 内部类名 实例名 = new 外部类名. new 内部类名
        // 创建外部类实例
        Outer outer = new Outer();

        // 创建内部类实例
        // Outer.Inner inner = new Outer().new Inner();
        Outer.Inner inner = outer.new Inner();

        // 调用内部类方法
        inner.showName();

        // 创建静态内部类实例
        Outer.staticInner sinner = new Outer.staticInner();

        // 调用静态内部类方法
        sinner.showName();

        // 调用静态内部类的类方法
        Outer.staticInner.showId();

        // 匿名内部类
        // 本质是创建一个抽象类或接口的子类 并立刻创建一个实例对象
        People people = new People() {
            @Override
            public void speak() {
                System.out.println("我是人类");
            }
        };
        people.speak();
    }
}
