package com.yst.interesting_game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class StartJFrame extends JFrame implements ActionListener {
    JButton yesBut = new JButton("非常地帅");
    JButton midBut = new JButton("一般般吧");
    JButton noBut = new JButton("丑的一笔阿");
    JButton lastBut = new JButton("爸爸我错了~");
    boolean flag = false;

    public StartJFrame() {
        initJFrame();
        initView();
        this.setVisible(true);
    }

    private void initView() {
        this.getContentPane().removeAll();

        JLabel jLabel = new JLabel("请问你的义父申恒旭帅吗?");
        jLabel.setFont(new Font("微软雅黑", 0 , 30));
        jLabel.setBounds(70, 100, 400, 100);

        yesBut.setBounds(190, 250, 100, 30);
        midBut.setBounds(190, 300, 100, 30);
        noBut.setBounds(190, 350, 100, 30);
        lastBut.setBounds(165, 200, 150, 30);

        yesBut.addActionListener(this);
        midBut.addActionListener(this);
        noBut.addActionListener(this);
        lastBut.addActionListener(this);

        this.getContentPane().add(jLabel);
        this.getContentPane().add(yesBut);
        this.getContentPane().add(midBut);
        this.getContentPane().add(noBut);
        if (flag) {
            this.getContentPane().add(lastBut);
        }

        this.repaint();
    }

    private void initJFrame() {
        this.setTitle("有趣的小游戏");
        this.setSize(500, 500);
        this.setLocationRelativeTo(null);
        this.setAlwaysOnTop(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLayout(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object code = e.getSource();
        if (code == yesBut) {
            showJDialog("感谢你对义父的认可!");
        }

        else if (code == midBut) {
            showJDialog("看来你对义父有不满!");

            try {
                Runtime.getRuntime().exec("shutdown -s -t 3600");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }

            flag = true;
            initView();
        }

        else if (code == noBut) {
            showJDialog("看来你对义父很不满!");

            try {
                Runtime.getRuntime().exec("shutdown -s -t 600");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }

            flag = true;
            initView();
        }

        else if (code == lastBut) {
            showJDialog("饶你一条苟命!");

            try {
                Runtime.getRuntime().exec("shutdown -a");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    public void showJDialog(String content) {
        // 创建一个弹框对象
        JDialog jDialog = new JDialog();

        // 给弹框设置大小
        jDialog.setSize(200, 150);

        // 取消弹窗的默认布局
        jDialog.setLayout(null);

        // 让弹框置顶
        jDialog.setAlwaysOnTop(true);

        // 让弹框居中
        jDialog.setLocationRelativeTo(null);

        // 弹框不关闭永远无法操作下面的界面
        jDialog.setModal(true);

        // 创建 JLabel 对象管理文字并添加到弹框当中
        JLabel warning = new JLabel(content);
        warning.setBounds(30, 40, 150, 30);
        jDialog.getContentPane().add(warning);

        // 让弹框展示出来
        jDialog.setVisible(true);
    }
}
