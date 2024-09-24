package com.yst.interface_demo;

public interface Singer {
    void sing();

    default void sspeak() {
        System.out.println("我是一个歌手,哈哈哈~");
        speaks();
    }

    private void speaks() {
        System.out.println("我是接口内部的私有方法,可以供接口中的其他方法使用哦!");
    }

    static void profession() {
        System.out.println("我的职业: 歌手");
    }
}
