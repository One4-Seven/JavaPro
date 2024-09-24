package com.yst.interface_demo;

public interface Driver {
    void driver();

    // 默认方法 需要创建实例访问 由于接口无法创建实例
    // 默认方法在实现它的实现类中可以访问 一般访问格式: 实现类实例名.默认方法
    default void dspeak() {
        System.out.println("我是一个司机,啦啦啦~");
        speaks();
    }

    private void speaks() {
        System.out.println("我是接口内部的私有方法,可以供接口中的其他方法使用哦!");
    }

    // 接口内部静态方法 一般访问格式: 接口名.方法名
    static void profession() {
        System.out.println("我的职业: 司机");
    }
}
