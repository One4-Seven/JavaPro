package com.yst.static_demo;

// 单例类 只存在一个实例
// 懒汉式单例 获取类的实例时才开始创建实例
public class LazySingle {
    // 定义类变量 加载类时执行一次 生成一个空实例
    private static LazySingle ls;

    // 私有化构造方法
    private LazySingle() {

    }

    // 定义类方法 如果实例为空则创建新实例 否则返回现有的实例
    public static LazySingle getLazySingle() {
        if (ls == null) {
            ls = new LazySingle();
        }
        return ls;
    }
}
