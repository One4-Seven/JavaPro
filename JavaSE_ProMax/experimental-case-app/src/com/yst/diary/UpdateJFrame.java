package com.yst.diary;

import cn.hutool.core.io.FileUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class UpdateJFrame extends JFrame implements ActionListener {
    // 定义标题输入框
    JTextField titleText  = new JTextField();

    // 定义内容的输入区域
    JTextArea contentText = new JTextArea();

    // 定义修改按钮
    JButton update = new JButton("修改");

    // 定义取消按钮
    JButton cancel = new JButton("取消");

    // 存放所有信息
    List<String> Date;

    int row;

    public UpdateJFrame(List<String> Dates, int row){
        // 获取要操作的数据
        Date = Dates;
        this.row = row;
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

        String[] split = Date.get(row).split("&");

        // 设置标题的输入框
        titleText.setBounds(120,90,426,30);
        titleText.setFont(new Font("宋体",Font.PLAIN,16));
        titleText.setText(split[0]);
        this.getContentPane().add(titleText);

        // 设置内容的输入框
        contentText.setBounds(120,140,426,300);
        contentText.setFont(new Font("宋体",Font.PLAIN,16));
        contentText.setText(split[1]);
        this.getContentPane().add(contentText);

        // 设置保存按钮
        update.setBounds(132,466,140,40);
        update.setFont(new Font("宋体",Font.PLAIN,24));
        update.addActionListener(this);
        this.getContentPane().add(update);

        // 设置取消按钮
        cancel.setBounds(312,466,140,40);
        cancel.setFont(new Font("宋体",Font.PLAIN,24));
        cancel.addActionListener(this);
        this.getContentPane().add(cancel);

    }

    // 对添加界面的一些设置
    private void initFrame() {
        // 设置界面的宽高
        this.setSize(600, 600);
        // 设置界面的标题
        this.setTitle("每日一记（添加日记）");
        // 设置界面置顶
        this.setAlwaysOnTop(true);
        // 置界面居中
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
        if(obj == update){
            String a = titleText.getText();
            String b = contentText.getText();
            String s = a + "&" + b;
            // 删除并修改数组
            Date.remove(row);
            Date.add(row, s);
            // 写入新的数据
            FileUtil.writeUtf8Lines(Date, "E:\\Java\\JavaSE_ProMax\\experimental-case-app\\daily_date\\date.txt");
            // 提示用户
            showJDialog("修改成功");
            this.setVisible(false);
            new NoteJFrame();
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
