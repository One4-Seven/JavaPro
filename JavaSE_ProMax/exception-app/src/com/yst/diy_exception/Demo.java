package com.yst.diy_exception;

import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        // 简单认识和使用自定义异常类
        GirlFriend girlFriend = new GirlFriend();
        Scanner sc = new Scanner(System.in);


        while(true) {
            try {
                System.out.print("请给出你女朋友的姓名: ");
                String name = sc.nextLine();
                girlFriend.setName(name);

                System.out.print("请给出你女朋友的年龄: ");
                int age = Integer.parseInt(sc.nextLine());
                girlFriend.setAge(age);

                break;
            } catch (NumberFormatException e) {
                e.printStackTrace();
                System.out.println("叫你给年龄,你给我乱码?");
            } catch (NameFormatException e) {
                e.printStackTrace();
                System.out.println("名字太长了,外星人?");
            } catch (AgeRangeException e) {
                e.printStackTrace();
                System.out.println("兄弟,你是真的饿了!");
            }
        }

        System.out.println(girlFriend);
    }
}
