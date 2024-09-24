package com.yst.static_demo;

// 单例类 只存在一个实例
// 饿汉式单例 获取类的实例时 实例已经创建好了
public class HungrySingle {
    // 定义类变量 加载类时执行一次 自动生成一个 Single 实例
    private static HungrySingle hs = new HungrySingle();

    // 私有化构造方法
    private HungrySingle() {

    }

    // 定义类方法 返回 Single 实例
    public static HungrySingle getHungrySingle() {
        return hs;
    }
}
