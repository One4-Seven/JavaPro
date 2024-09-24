package com.yst.modifer_demo;

import com.yst.modifer.Modifer;

public class ModiferSon extends Modifer {
    public void text() {
        // 在任意包的子类中
        protectedMethod();
        publicMethod();
    }
}
