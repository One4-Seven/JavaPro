package com.yst.food;

import java.util.ArrayList;
import java.util.Scanner;

public class FoodOperator {
    private ArrayList<Food> Foods = new ArrayList<>();

    public void addFood() {
        Food food = new Food();
        Scanner sc = new Scanner(System.in);
        System.out.println("----------------------------------");

        System.out.print("请给出新菜品的名字: ");
        String name = sc.next();
        food.setName(name);

        System.out.print("请给出新菜品的价格: ");
        double price = sc.nextDouble();
        food.setPrice(price);

        System.out.print("请给出新菜品的评分: ");
        double score = sc.nextDouble();
        food.setScore(score);
        Foods.add(food);

        System.out.println("------------菜品添加成功------------");
    }

    public void showFoods() {
        if (Foods.size() == 0) {
            System.out.println("---------菜谱为空,请添加菜品---------");
            return;
        }

        System.out.println("-------------南审大食堂-------------");
        for (int i = 0;i < Foods.size(); i++) {
            System.out.println("Name: " + Foods.get(i).getName());
            System.out.println("Price: " + Foods.get(i).getPrice());
            System.out.println("Score: " + Foods.get(i).getScore());
            System.out.println("----------------------------------");
        }
    }

    public void Start() {
        System.out.println("----------欢迎光临南审大食堂----------");
        System.out.println("输入[1]添加菜品");
        System.out.println("输入[2]查看菜品");
        System.out.println("输入[3]退出系统");
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.print("请给出你的操作: ");
            int flag = sc.nextInt();
            switch (flag) {
                case 1:
                    addFood();
                    break;
                case 2:
                    showFoods();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("哥们,上面的提示看不懂?");
            }
        }
    }
}
