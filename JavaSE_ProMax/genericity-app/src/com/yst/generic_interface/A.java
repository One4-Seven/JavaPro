package com.yst.generic_interface;

import java.util.ArrayList;

// 泛型接口的实现类 不定义泛型 默认为 Object
public class A extends Father implements Date<A>{
    @Override
    public void add(A a) {
        System.out.println("增加了一个A对象");
    }

    @Override
    public ArrayList<A> getFromName(String name) {
        return null;
    }
}
