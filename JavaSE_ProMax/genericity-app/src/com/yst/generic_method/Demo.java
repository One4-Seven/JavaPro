package com.yst.generic_method;

import java.util.ArrayList;

public class Demo {
    public static void main(String[] args) {
        // 认识泛型方法 通配符 ?
        // 泛型不允许使用基本数据类型 只能使用应用类型
        ArrayList<Car> cars = new ArrayList<>();
        cars.add(new BMW("宝马一号"));
        cars.add(new Toyota("丰田一号"));
        go(cars);
        System.out.println("----------");

        ArrayList<BMW> bmws = new ArrayList<>();
        bmws.add(new BMW("宝马二号"));
        bmws.add(new BMW("宝马三号"));
        go(bmws);
        System.out.println("----------");

        ArrayList<Toyota> toyotas = new ArrayList<>();
        toyotas.add(new Toyota("丰田二号"));
        toyotas.add(new Toyota("丰田三号"));
        go(toyotas);
        System.out.println("----------");

        ArrayList<Car> brokens = new ArrayList<>();
        brokens.add(new Car("张升源的兰博基尼"));
        brokens.add(new Car("黄海冰的法拉第"));
        broken(brokens);
    }

    // 泛型方法 使用用户给出的 E 类型代替方法中的所有 E
    public static <E> void go(ArrayList<E> arr) {
        System.out.println("参赛车辆: ");
        for (E e : arr) {
            System.out.println(e);
        }
    }

    // 在使用泛型时采用通配符(?) 来代表任意地引用类型
    public static void broken(ArrayList<? extends Car> arr) {
        System.out.println("报废车辆: ");
        for (Car car : arr) {
            System.out.println(car);
        }
    }
}
