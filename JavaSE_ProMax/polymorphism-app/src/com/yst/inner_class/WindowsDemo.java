package com.yst.inner_class;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WindowsDemo {
    public static void main(String[] args) {
        // GUI 编程
        // 创建窗口
        JFrame win = new JFrame("登录界面");
        JPanel panel = new JPanel();
        win.add(panel);

        JButton btn = new JButton("点我哥们!");
        panel.add(btn);

        // 给按钮绑定单击事件监听器 需要使用到匿名类
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(win, "傻逼!");
            }
        });

        // lambda 表达式优化代码
        btn.addActionListener(e -> JOptionPane.showMessageDialog(win, "大傻逼!"));

        // 设置窗口属性
        win.setSize(400, 400);
        win.setLocationRelativeTo(null);
        win.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        win.setVisible(true);
    }
}
