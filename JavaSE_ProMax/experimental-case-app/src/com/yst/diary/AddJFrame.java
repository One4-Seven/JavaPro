package com.yst.diary;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

public class AddJFrame extends JFrame implements ActionListener {
    // 定义标题输入框
    JTextField titleText  = new JTextField();

    // 定义内容的输入区域
    JTextArea contentText = new JTextArea();

    // 定义保存按钮
    JButton save = new JButton("保存");

    // 定义取消按钮
    JButton cancel = new JButton("取消");

    public AddJFrame(){
        // 初始化界面
        initFrame();
        // 初始化组件
        initView();
        // 让界面展示出来
        this.setVisible(true);
    }

    private void initView() {
        // 定义最上面的每日一记
        JLabel title = new JLabel("每日一记");
        title.setBounds(220, 20, 584, 50);
        title.setFont(new Font("宋体", Font.BOLD, 32));
        this.getContentPane().add(title);

        // 定义文字：标题
        JLabel subject = new JLabel("标题");
        subject.setBounds(70,90,100,30);
        subject.setFont(new Font("宋体",Font.PLAIN,16));
        this.getContentPane().add(subject);

        // 定义文字：内容
        JLabel content = new JLabel("内容");
        content.setBounds(70,140,100,30);
        content.setFont(new Font("宋体",Font.PLAIN,16));
        this.getContentPane().add(content);


        // 设置标题的输入框
        titleText.setBounds(120,90,426,30);
        titleText.setFont(new Font("宋体",Font.PLAIN,16));
        this.getContentPane().add(titleText);

        // 设置内容的输入框
        contentText.setBounds(120,140,426,300);
        contentText.setFont(new Font("宋体",Font.PLAIN,16));
        this.getContentPane().add(contentText);

        // 设置保存按钮
        save.setBounds(132,466,140,40);
        save.setFont(new Font("宋体",Font.PLAIN,24));
        save.addActionListener(this);
        this.getContentPane().add(save);

        // 设置取消按钮
        cancel.setBounds(312,466,140,40);
        cancel.setFont(new Font("宋体",Font.PLAIN,24));
        cancel.addActionListener(this);
        this.getContentPane().add(cancel);
    }

    private void initFrame() {
        // 设置界面的宽高
        this.setSize(600, 600);
        // 设置界面的标题
        this.setTitle("每日一记（添加日记）");
        // 设置界面置顶
        this.setAlwaysOnTop(true);
        // 设置界面居中
        this.setLocationRelativeTo(null);
        // 设置关闭模式
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // 取消默认的居中放置，只有取消了才会按照XY轴的形式添加组件
        this.setLayout(null);
        // 设置背景颜色
        this.getContentPane().setBackground(new Color(212,212,212));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if(obj == save){
            if (titleText.getText().isEmpty() || contentText.getText().isEmpty()) {
                showJDialog("请输入数据");
            } else {
                String a = titleText.getText();
                String b = titleText.getText();
                FileWriter fw;
                try {
                    fw = new FileWriter("experimental-case-app\\daily_date\\date.txt", true);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                try {
                    fw.write("\n");
                    fw.write(a + "&" + b);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                try {
                    fw.close();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                showJDialog("添加成功");
                this.setVisible(false);
                new NoteJFrame();
            }
        }else if(obj == cancel){
            this.setVisible(false);
            new NoteJFrame();
        }
    }

    public void showJDialog(String content) {
            // 创建一个弹框对象
            JDialog jDialog = new JDialog();
            // 给弹框设置大小
            jDialog.setSize(200, 150);
            // 让弹框置顶
            jDialog.setAlwaysOnTop(true);
            // 让弹框居中
            jDialog.setLocationRelativeTo(null);
            // 弹框不关闭永远无法操作下面的界面
            jDialog.setModal(true);
            // 创建 JLabel 对象管理文字并添加到弹框当中
            JLabel warning = new JLabel(content);
            warning.setBounds(0, 0, 200, 150);
            jDialog.getContentPane().add(warning);
            // 让弹框展示出来
            jDialog.setVisible(true);
    }
}
