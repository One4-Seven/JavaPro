package com.yst.enumeration;

public class Demo {
    public static void main(String[] args) {
        // 认识枚举类 在第一行定义的均为常量 每个存放一个枚举类的实例
        // 枚举类的构造器私有 外部无法访问
        Enumeration e1 = Enumeration.X;
        Enumeration e2 = Enumeration.valueOf("Y");
        Enumeration e3 = Enumeration.Z;

        // 把所有枚举类的实例放在一个数组中返回
        Enumeration[] enumerations = Enumeration.values();

        // 调用枚举类中的成员方法
        System.out.println(e1.getName());
        System.out.println(e3.getName());

        // 返回实例在数组中的索引
        System.out.println(e2.ordinal());

        // 打印指定索引位置的枚举实例对象
        System.out.println(enumerations[2]);

        // 抽象枚举实例
        AbstractEnum ae1 = AbstractEnum.X;
        AbstractEnum ae2 = AbstractEnum.valueOf("Y");

        ae1.speak();
        ae2.speak();

        // 利用枚举类来做信息标志进行参数传递
        checkSex(SingleEnum.BOY);
        checkSex(SingleEnum.GIRL);
    }

    public static void checkSex(SingleEnum se) {
        switch (se) {
            case BOY -> System.out.println("喜欢打游戏!");
            case GIRL -> System.out.println("瞎混看帅哥!");
        }
    }
}
