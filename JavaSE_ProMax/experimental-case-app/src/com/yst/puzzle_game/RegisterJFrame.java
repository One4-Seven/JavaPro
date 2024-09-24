package com.yst.puzzle_game;

import cn.hutool.core.io.FileUtil;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class RegisterJFrame extends JFrame implements MouseListener {
    ArrayList<User> allUsers;
    JTextField username = new JTextField();
    JTextField password = new JTextField();
    JTextField rePassword = new JTextField();
    JButton submit = new JButton();
    JButton reset = new JButton();

    public RegisterJFrame(ArrayList<User> allUsers) {
        this.allUsers = allUsers;
        initJFrame();
        initView();
        this.setVisible(true);
    }

    private void initView() {
        // 添加注册用户名的文本
        JLabel usernameText = new JLabel(new ImageIcon("experimental-case-app\\image\\register\\注册用户名.png"));
        usernameText.setBounds(85, 135, 80, 20);

        // 添加注册用户名的输入框
        username.setBounds(195, 134, 200, 30);

        // 添加注册密码的文本
        JLabel passwordText = new JLabel(new ImageIcon("experimental-case-app\\image\\register\\注册密码.png"));
        passwordText.setBounds(97, 193, 70, 20);

        // 添加密码输入框
        password.setBounds(195, 195, 200, 30);

        // 添加再次输入密码的文本
        JLabel rePasswordText = new JLabel(new ImageIcon("experimental-case-app\\image\\register\\再次输入密码.png"));
        rePasswordText.setBounds(64, 255, 95, 20);

        // 添加再次输入密码的输入框
        rePassword.setBounds(195, 255, 200, 30);

        // 注册的按钮
        submit.setIcon(new ImageIcon("experimental-case-app\\image\\register\\注册按钮.png"));
        submit.setBounds(123, 310, 128, 47);
        submit.setBorderPainted(false);
        submit.setContentAreaFilled(false);
        submit.addMouseListener(this);

        // 重置的按钮
        reset.setIcon(new ImageIcon("experimental-case-app\\image\\register\\重置按钮.png"));
        reset.setBounds(256, 310, 128, 47);
        reset.setBorderPainted(false);
        reset.setContentAreaFilled(false);
        reset.addMouseListener(this);

        // 背景图片
        JLabel background = new JLabel(new ImageIcon("experimental-case-app\\image\\register\\background.png"));
        background.setBounds(0, 0, 470, 390);

        this.getContentPane().add(usernameText);
        this.getContentPane().add(passwordText);
        this.getContentPane().add(rePasswordText);
        this.getContentPane().add(username);
        this.getContentPane().add(password);
        this.getContentPane().add(rePassword);
        this.getContentPane().add(submit);
        this.getContentPane().add(reset);
        this.getContentPane().add(background);
    }

    private void initJFrame() {
        this.setSize(488, 430);
        this.setTitle("注册账号");
        this.setLocationRelativeTo(null);
        this.setAlwaysOnTop(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        Object code = e.getSource();
        if (code == submit) {
            if (username.getText().isEmpty() || password.getText().isEmpty() || rePassword.getText().isEmpty()) {
                showJDialog("用户名或密码不能为空!");
                return;
            }

            String newusername = username.getText();

            for (User user : allUsers) {
                if (newusername.equals(user.getUsername())) {
                    showJDialog("用户名重复!");
                    return;
                }
            }

            String key = password.getText();
            String rekey = rePassword.getText();
            if (!key.equals(rekey)) {
                showJDialog("两次输入的密码不相同!");
                return;
            }

            // allUsers.add(new User(newusername, key));
            // FileUtil.writeUtf8Lines(allUsers, "E:\\Java\\JavaSE_ProMax\\experimental-case-app\\loading\\userinfo.txt");

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
                throw new RuntimeException(ex);
            }
            Connection connection;
            try {
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/puzzle_game", "root", "12345");
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            System.out.println("连接成功");
            Statement statement;
            try {
                statement = connection.createStatement();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            String sql = "insert into puzzle_game.users(username, password) values (?,?)";
            PreparedStatement preparedStatement;
            try {
                preparedStatement = connection.prepareStatement(sql);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            try {
                preparedStatement.setString(1,newusername);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            try {
                preparedStatement.setString(2, key);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            try {
                preparedStatement.executeUpdate();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            try {
                preparedStatement.close();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            try {
                statement.close();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            try {
                connection.close();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }

            showJDialog("注册成功!");
            this.setVisible(false);
            try {
                new LoginJFrame();
            } catch (IOException | SQLException | ClassNotFoundException ex) {
                throw new RuntimeException(ex);
            }

        } else if (code == reset) {
            username.setText("");
            password.setText("");
            rePassword.setText("");
        }

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getSource() == submit) {
            submit.setIcon(new ImageIcon("experimental-case-app\\image\\register\\注册按下.png"));
        } else if (e.getSource() == reset) {
            reset.setIcon(new ImageIcon("experimental-case-app\\image\\register\\重置按下.png"));
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (e.getSource() == submit) {
            submit.setIcon(new ImageIcon("experimental-case-app\\image\\register\\注册按钮.png"));
        } else if (e.getSource() == reset) {
            reset.setIcon(new ImageIcon("experimental-case-app\\image\\register\\重置按钮.png"));
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

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

        jDialog.setLayout(null);

        // 创建 JLabel 对象管理文字并添加到弹框当中
        JLabel warning = new JLabel(content);
        warning.setBounds(45, 20, 200, 75);
        jDialog.getContentPane().add(warning);

        // 让弹框展示出来
        jDialog.setVisible(true);
    }
}
