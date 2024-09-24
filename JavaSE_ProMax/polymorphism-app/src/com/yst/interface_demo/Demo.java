package com.yst.interface_demo;

public class Demo {
    public static void main(String[] args) {
        // 简单认识接口 可以实现多继承 增加代码可读性 复用性
        // 多继承指一个接口可以继承多个其它接口来增加代码可读性 简化代码
        // 接口实现的注意事项
        // 1. 一个接口继承多个接口时 如果继承的接口中存在同名且返回值不同的方法 不支持多继承
        // 2. 一个类实现多个接口时 如果继承的接口中存在同名且返回值不同的方法 不支持多实现
        // 3. 一个类既继承了父类又实现了接口 如果父类中的方法和接口中的默认方法存在同名同返回值 子类优先调用父类的方法
        // 4. 一个类实现多个接口时 如果接口中存在同名同返回值的方法 此类需要重写此方法 否则不支持多实现
        // 符合多态化性质 (编译看左边 运行看右边)
        // 认识接口在 JDK 新版本中的使用规则
        Student s1 = new Student("申恒旭");
        s1.driver();
        s1.sing();
        System.out.println("--------------------");

        Driver d1 =  new Student("张升源");
        Driver.profession();
        d1.driver();
        d1.dspeak();
        System.out.println("--------------------");

        Singer n1 = new Student("黄海冰");
        Singer.profession();
        n1.sing();
        n1.sspeak();
    }
}
