package com.yst.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyUtils {
    // 创建动态代理
    public static Star createProxy(BigStar bigStar) {
        Star proxy = (Star) Proxy.newProxyInstance(
                ProxyUtils.class.getClassLoader(),
                new Class[]{Star.class},
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        if ("sing".equals(method.getName())) {
                            System.out.println("每人￥250");
                        } else if ("dance".equals(method.getName())) {
                            System.out.println("每人￥300");
                        }
                        return method.invoke(bigStar, args);
                    }
                }
        );
        return proxy;
    }
}
