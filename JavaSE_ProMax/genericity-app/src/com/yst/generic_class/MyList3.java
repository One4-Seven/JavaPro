package com.yst.generic_class;

public class MyList3 <E extends Animal>{
    public void put(E e) {
        System.out.println("限定了泛型的父类!");
    }
}
