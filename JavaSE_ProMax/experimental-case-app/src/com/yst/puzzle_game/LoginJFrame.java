package com.yst.puzzle_game;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class LoginJFrame extends JFrame implements MouseListener {
    // 存放用户信息
    static ArrayList<User> allUsers = new ArrayList<>();

    // 登录按钮
    JButton login = new JButton();

    // 注册按钮
    JButton register = new JButton();

    // 用户名输入框
    JTextField username = new JTextField();

    // 密码输入框
    JPasswordField password = new JPasswordField();

    // 验证码输入框
    JTextField code = new JTextField();

    // 正确的验证码
    JLabel rightCode = new JLabel();


    public LoginJFrame() throws IOException, SQLException, ClassNotFoundException {
        initUserInfo();
        initJFrame();
        initView();
        this.setVisible(true);
    }

    private void initUserInfo() throws ClassNotFoundException, SQLException {
        // 本地文档读取数据
//        List<String> strings = FileUtil.readUtf8Lines("E:\\Java\\JavaSE_ProMax\\experimental-case-app\\loading\\userinfo.txt");
//        for (String string : strings) {
//            String[] split = string.split("&");
//            String[] split1 = split[0].split("=");
//            String[] split2 = split[1].split("=");
//            String username = split1[1];
//            String password = split2[1];
//            allUsers.add(new User(username, password));
//        }
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/puzzle_game", "root", "12345");
        System.out.println("连接成功");
        Statement statement = connection.createStatement();
        String sql = "select * from users";
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            String username = resultSet.getString("username");
            String password = resultSet.getString("password");
            allUsers.add(new User(username, password));
        }
        resultSet.close();
        statement.close();
        connection.close();
    }

    public void initView() {
        // 添加用户名文字
        JLabel usernameText = new JLabel(new ImageIcon("experimental-case-app\\image\\login\\用户名.png"));
        usernameText.setBounds(116, 135, 47, 17);
        this.getContentPane().add(usernameText);

        // 添加用户名输入框
        username.setBounds(195, 134, 200, 30);
        this.getContentPane().add(username);

        // 添加密码文字
        JLabel passwordText = new JLabel(new ImageIcon("experimental-case-app\\image\\login\\密码.png"));
        passwordText.setBounds(130, 195, 32, 16);
        this.getContentPane().add(passwordText);

        // 密码输入框
        password.setBounds(195, 195, 200, 30);
        this.getContentPane().add(password);


        // 验证码提示
        JLabel codeText = new JLabel(new ImageIcon("experimental-case-app\\image\\login\\验证码.png"));
        codeText.setBounds(133, 256, 50, 30);
        this.getContentPane().add(codeText);

        // 验证码的输入框
        code.setBounds(195, 256, 100, 30);
        this.getContentPane().add(code);

        // 生成随机的验证码
        String codeStr = CodeUtil.getCode();

        // 显示随机验证码
        rightCode.setText(codeStr);

        // 绑定鼠标事件
        rightCode.addMouseListener(this);

        // 设置验证码位置和宽高
        rightCode.setBounds(300, 256, 50, 30);

        // 添加正确验证码到界面
        this.getContentPane().add(rightCode);

        // 添加登录按钮
        login.setBounds(123, 310, 128, 47);
        login.setIcon(new ImageIcon("experimental-case-app\\image\\login\\登录按钮.png"));

        // 去除按钮的边框
        login.setBorderPainted(false);

        // 去除按钮的背景
        login.setContentAreaFilled(false);

        // 给登录按钮绑定鼠标事件
        login.addMouseListener(this);

        // 添加登录按钮到界面
        this.getContentPane().add(login);

        // 添加注册按钮
        register.setBounds(256, 310, 128, 47);
        register.setIcon(new ImageIcon("experimental-case-app\\image\\login\\注册按钮.png"));

        // 去除按钮的边框
        register.setBorderPainted(false);

        // 去除按钮的背景
        register.setContentAreaFilled(false);

        // 给注册按钮绑定鼠标事件
        register.addMouseListener(this);

        // 添加注册按钮到界面
        this.getContentPane().add(register);


        // 添加背景图片
        JLabel background = new JLabel(new ImageIcon("experimental-case-app\\image\\login\\background.png"));
        background.setBounds(0, 0, 470, 390);
        this.getContentPane().add(background);

    }


    private void initJFrame() {
        this.setSize(488, 430);
        this.setTitle("登录账号");
        this.setLocationRelativeTo(null);
        this.setAlwaysOnTop(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // 取消内部默认布局
        this.setLayout(null);
    }


    // 点击
    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == login) {
            // 获取两个文本输入框中的内容
            String usernameInput = username.getText();
            String passwordInput = password.getText();

            // 获取用户输入的验证码
            String codeInput = code.getText();

            // 创建一个User对象
            User userInfo = new User(usernameInput, passwordInput);

            if (codeInput.isEmpty()) {
                // 提示用户输入验证码
                showJDialog("验证码不能为空");
            }

            // 校验用户名和密码是否为空
            else if (usernameInput.isEmpty() || passwordInput.isEmpty()) {
                // 调用 showJDialog 方法并展示弹框
                showJDialog("用户名或者密码为空");
            } else if (!codeInput.equalsIgnoreCase(rightCode.getText())) {
                showJDialog("验证码输入错误");
            }

            // 登录成功
            else if (contains(userInfo)) {
                showJDialog("登录成功");
                //关闭当前登录界面
                this.setVisible(false);
                //打开游戏的主界面
                try {
                    new GameJFrame();
                } catch (IOException | ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
            } else {
                showJDialog("用户名或密码错误");
            }
        } else if (e.getSource() == register) {
            this.setVisible(false);
            new RegisterJFrame(allUsers);
        } else if (e.getSource() == rightCode) {
            //获取一个新的验证码
            String code = CodeUtil.getCode();
            rightCode.setText(code);
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

        jDialog.setLayout(null);

        // 创建 JLabel 对象管理文字并添加到弹框当中
        JLabel warning = new JLabel(content);
        warning.setBounds(45, 20, 150, 75);
        jDialog.getContentPane().add(warning);

        // 让弹框展示出来
        jDialog.setVisible(true);
    }

    // 按下不松
    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getSource() == login) {
            login.setIcon(new ImageIcon("experimental-case-app\\image\\login\\登录按下.png"));
        } else if (e.getSource() == register) {
            register.setIcon(new ImageIcon("experimental-case-app\\image\\login\\注册按下.png"));
        }
    }


    // 松开按钮
    @Override
    public void mouseReleased(MouseEvent e) {
        if (e.getSource() == login) {
            login.setIcon(new ImageIcon("experimental-case-app\\image\\login\\登录按钮.png"));
        } else if (e.getSource() == register) {
            register.setIcon(new ImageIcon("experimental-case-app\\image\\login\\注册按钮.png"));
        }
    }

    // 鼠标划入
    @Override
    public void mouseEntered(MouseEvent e) {

    }

    // 鼠标划出
    @Override
    public void mouseExited(MouseEvent e) {

    }

    // 判断用户在集合中是否存在
    public boolean contains(User userInput) {
        for (User rightUser : allUsers) {
            if (userInput.getUsername().equals(rightUser.getUsername()) && userInput.getPassword().equals(rightUser.getPassword())) {
                return true;
            }
        }
        return false;
    }
}

