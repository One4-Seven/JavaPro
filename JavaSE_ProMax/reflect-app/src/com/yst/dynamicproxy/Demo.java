package com.yst.dynamicproxy;

public class Demo {
    public static void main(String[] args) {
        // 创建使用动态代理
        BigStar bigStar = new BigStar("基哥");
        Star proxy = ProxyUtils.createProxy(bigStar);
        proxy.dance();
        System.out.println(proxy.sing("只因你太美"));
    }
}
