package com.yst.generic_interface;

import java.util.ArrayList;

public class B extends Father implements Date<B> {

    @Override
    public void add(B b) {
        System.out.println("增加了一个B对象");
    }

    @Override
    public ArrayList<B> getFromName(String name) {
        return null;
    }
}
