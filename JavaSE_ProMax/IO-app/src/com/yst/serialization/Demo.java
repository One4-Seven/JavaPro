package com.yst.serialization;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Demo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // 简单认识和使用序列化流
        // 可以把已定义的类写入文件中且保持不可读的状态
        // 由于读取的方便性 统一将所有对象封装进集合再存储
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("IO-app\\text\\user.txt"));
        User user1 = new User("申恒旭", "334");
        User user2 = new User("杨思婷", "147");
        User user3 = new User("刘佳文", "675");
        User user4 = new User("彭佳怡", "771");
        ArrayList<User> users = new ArrayList<>();
        Collections.addAll(users, user1, user2, user3,user4);

        oos.writeObject(users);

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("IO-app\\text\\user.txt"));

        ArrayList<User> newusers = (ArrayList<User>) ois.readObject();

        for (User newuser : newusers) {
            System.out.println(newuser);
        }

        ois.close();
        oos.close();
    }
}
