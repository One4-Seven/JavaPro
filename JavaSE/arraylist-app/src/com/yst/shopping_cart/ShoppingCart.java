package com.yst.shopping_cart;

import java.util.ArrayList;
import java.util.Scanner;

public class ShoppingCart {
    public static void main(String[] args) {
        // 模拟购物车的添加和删除物品
        Scanner sc = new Scanner(System.in);
        ArrayList<String> shoppingcart = new ArrayList<>();
        shoppingcart.add("黑枸杞");
        shoppingcart.add("优质枸杞");
        shoppingcart.add("澳洲鲍鱼");
        shoppingcart.add("澳洲生蚝");
        shoppingcart.add("海胆");
        shoppingcart.add("大马哈鱼");
        shoppingcart.add("保健品");
        shoppingcart.add("栏精灵");

        System.out.println("输入[1]增加物品");
        System.out.println("输入[2]删除物品");
        System.out.println("输入[3]退出系统");

        while (true) {
            showShopCart(shoppingcart);
            System.out.print("请给出你的操作: ");
            int flag = sc.nextInt();
            // 增加物品
            if (flag == 1) {
                System.out.print("请输入你要增加的物品: ");
                String good = sc.next();
                install(shoppingcart, good);
            }
            // 删除物品
            else if (flag == 2) {
                System.out.print("请输入你删除物品的关键词: ");
                String good = sc.next();
                delete(shoppingcart, good);
            }
            // 退出系统
            else if (flag == 3) {
                break;
            }
            // 用户输入错误
            else {
                System.out.println("哥们,上面的提示看不懂?");
            }
        }


    }

    public static void showShopCart(ArrayList<String> shopcart) {
        System.out.println("----------购 物 车----------");
        for (int i = 0; i < shopcart.size(); i++) {
            System.out.println( (i + 1) + ": " + shopcart.get(i));
        }
        System.out.println("---------------------------");
    }

    public static void install(ArrayList<String> shopcart, String goods) {
        shopcart.add(goods);
    }

    public static void delete(ArrayList<String> shopcart, String goods) {
        for (int i = shopcart.size() - 1; i >= 0; i--) {
            if (shopcart.get(i).contains(goods)) {
                shopcart.remove(i);
            }
        }
    }
}
