package com.yst.puzzle_game;

import cn.hutool.core.io.IoUtil;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.*;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Random;

public class GameJFrame extends JFrame implements KeyListener, ActionListener {
    // 存放图片位置信息
    int[][] Date = new int[4][4];

    // 存放最终结果的数组
    int[][] win = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 0}};

    // 记录空白图片的位置
    int x, y;

    // 记录文件路径
    String path = "experimental-case-app\\image\\girl\\girl7\\";

    // 记录玩家操作步数
    int step = 0;

    // 创建选项条目
    JMenuItem rePlayItem = new JMenuItem("重新开始");
    JMenuItem reLoginItem = new JMenuItem("切换账号");
    JMenuItem exitItem = new JMenuItem("退出游戏");
    JMenuItem supportItem = new JMenuItem("充值");
    JMenuItem girl = new JMenuItem("美女");
    JMenuItem animal = new JMenuItem("动物");
    JMenuItem sport = new JMenuItem("运动");
    JMenuItem saveItem0 = new JMenuItem("存档0(空)");
    JMenuItem saveItem1 = new JMenuItem("存档1(空)");
    JMenuItem saveItem2 = new JMenuItem("存档2(空)");
    JMenuItem saveItem3 = new JMenuItem("存档3(空)");
    JMenuItem saveItem4 = new JMenuItem("存档4(空)");
    JMenuItem loadItem0 = new JMenuItem("读档0(空)");
    JMenuItem loadItem1 = new JMenuItem("读档1(空)");
    JMenuItem loadItem2 = new JMenuItem("读档2(空)");
    JMenuItem loadItem3 = new JMenuItem("读档3(空)");
    JMenuItem loadItem4 = new JMenuItem("读档4(空)");
    JMenu saveJMenu = new JMenu("存档");
    JMenu loadJMenu = new JMenu("读档");


    public GameJFrame() throws IOException, ClassNotFoundException {
        // 创建整个游戏界面
        initJFrame();

        // 加载游戏界面菜单
        initJMenuBar();

        // 初始化打乱图片顺序的数据
        initDate();

        // 加载打乱后的图片
        initImage();

        // 设置界面可见
        this.setVisible(true);

        // 设置键盘监听器
        this.addKeyListener(this);
    }

    private void initDate() {
        Random r = new Random();
        int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        for (int i = 0; i < arr.length; i++) {
            int index = r.nextInt(arr.length);
            int temp = arr[i];
            arr[i] = arr[index];
            arr[index] = temp;
        }
        for (int i = 0; i < arr.length; i++) {
            // 获取空白图片位置
            if (arr[i] == 0) {
                x = i / 4;
                y = i % 4;
            }
            Date[i / 4][i % 4] = arr[i];
        }
    }

    private void initImage() {
        // 清空当前界面
        this.getContentPane().removeAll();

        // 判断是否胜利 加载胜利图片
        if (victory()) {
            JLabel jLabel = new JLabel(new ImageIcon("experimental-case-app\\image\\win.png"));
            jLabel.setBounds(203, 283, 197, 73);
            this.getContentPane().add(jLabel);
        }

        // 显示玩家步数
        JLabel stepCount = new JLabel("步数: " + step);
        stepCount.setBounds(50, 30, 100, 20);
        this.getContentPane().add(stepCount);

        // 通过循环嵌套加载所有图片
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                // 创建一个管理容器存放图片 同时创建一个 ImageIcon 存放图片信息
                JLabel jLabel = new JLabel(new ImageIcon(path + Date[i][j] + ".jpg"));
                // 初始化图片位置
                jLabel.setBounds(105 * j + 83, 105 * i + 134, 105, 105);
                // 设置控制容器边框
                jLabel.setBorder(new BevelBorder(BevelBorder.RAISED));
                // 把图片加载到默认的隐藏容器中
                this.getContentPane().add(jLabel);
            }
        }

        // 设置背景图片
        JLabel jLabel = new JLabel(new ImageIcon("experimental-case-app\\image\\background.png"));
        jLabel.setBounds(40, 40, 508, 560);
        this.getContentPane().add(jLabel);

        // 刷新界面
        this.getContentPane().repaint();
    }

    private void initJMenuBar() throws IOException, ClassNotFoundException {
        // 创建菜单对象
        JMenuBar jMenuBar = new JMenuBar();

        // 创建菜单选项 支持嵌套
        JMenu funtionJMenu = new JMenu("菜单");
        JMenu aboutJMenu = new JMenu("关于我们");
        JMenu changeImage = new JMenu("更换图片");

        // 给所有条目绑定事件监听器
        rePlayItem.addActionListener(this);
        reLoginItem.addActionListener(this);
        exitItem.addActionListener(this);
        supportItem.addActionListener(this);
        girl.addActionListener(this);
        sport.addActionListener(this);
        animal.addActionListener(this);
        saveItem0.addActionListener(this);
        saveItem1.addActionListener(this);
        saveItem2.addActionListener(this);
        saveItem3.addActionListener(this);
        saveItem4.addActionListener(this);
        loadItem0.addActionListener(this);
        loadItem1.addActionListener(this);
        loadItem2.addActionListener(this);
        loadItem3.addActionListener(this);
        loadItem4.addActionListener(this);

        // 选项的嵌套
        funtionJMenu.add(changeImage);

        // 把对应条目添加进指定选项中
        funtionJMenu.add(rePlayItem);
        funtionJMenu.add(reLoginItem);
        funtionJMenu.add(exitItem);
        aboutJMenu.add(supportItem);
        changeImage.add(girl);
        changeImage.add(sport);
        changeImage.add(animal);
        saveJMenu.add(saveItem0);
        saveJMenu.add(saveItem1);
        saveJMenu.add(saveItem2);
        saveJMenu.add(saveItem3);
        saveJMenu.add(saveItem4);
        loadJMenu.add(loadItem0);
        loadJMenu.add(loadItem1);
        loadJMenu.add(loadItem2);
        loadJMenu.add(loadItem3);
        loadJMenu.add(loadItem4);

        funtionJMenu.add(saveJMenu);
        funtionJMenu.add(loadJMenu);

        // 把对应选项添加到菜单中
        jMenuBar.add(funtionJMenu);
        jMenuBar.add(aboutJMenu);

        // 设置存档初始化值
        getGameInfo();

        // 设置此界面的菜单
        this.setJMenuBar(jMenuBar);
    }

    private void getGameInfo() throws IOException, ClassNotFoundException {
        File save = new File("experimental-case-app\\Save");
        int index;
        File[] files = save.listFiles();
        if (files == null) return;
        GameInfo gi;
        for (File file : files) {
            index = file.getName().charAt(4) - '0';
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("experimental-case-app\\Save\\save" + index + ".txt"));
            gi = (GameInfo) ois.readObject();
            ois.close();
            int infoStep = gi.getStep();
            saveJMenu.getItem(index).setText("存档" + index + "(" + infoStep + "步)");
            loadJMenu.getItem(index).setText("读档" + index + "(" + infoStep + "步)");
        }
    }

    private void initJFrame() {
        // 设置游戏界面的大框架
        this.setSize(610, 680);
        this.setTitle("拼图达人 v1.0");
        this.setLocationRelativeTo(null);
        this.setAlwaysOnTop(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // 取消界面的默认居中布局
        this.setLayout(null);
    }

    private boolean victory() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (Date[i][j] != win[i][j]) return false;
            }
        }
        return true;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        // 当你胜利后关闭键盘按下监听器
        if (victory()) {
            return;
        }

        int code = e.getKeyCode();
        // 查看答案的快捷键
        if (code == 65) {
            // 清空屏幕
            this.getContentPane().removeAll();

            // 显示答案图片
            JLabel all = new JLabel(new ImageIcon(path + "all.jpg"));
            all.setBounds(83, 134, 420, 420);
            this.getContentPane().add(all);

            // 显示玩家步数
            JLabel stepCount = new JLabel("步数: " + step);
            stepCount.setBounds(50, 30, 100, 20);
            this.getContentPane().add(stepCount);

            // 设置背景图片
            JLabel jLabel = new JLabel(new ImageIcon("E:\\Java\\JavaSE_ProMax\\experimental-case-app\\image\\background.png"));
            jLabel.setBounds(40, 40, 508, 560);
            this.getContentPane().add(jLabel);

            // 刷新界面
            this.getContentPane().repaint();
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        // 当你胜利后关闭键盘抬起监听器
        if (victory()) {
            return;
        }

        int code = e.getKeyCode();
        switch (code) {
            // 向左移动
            case 37:
                if (y == 3) return;
                Date[x][y] = Date[x][y + 1];
                Date[x][y + 1] = 0;
                y++;
                step++;
                initImage();
                break;

            // 向上移动
            case 38:
                if (x == 3) return;
                Date[x][y] = Date[x + 1][y];
                Date[x + 1][y] = 0;
                x++;
                step++;
                initImage();
                break;

            // 向右移动
            case 39:
                if (y == 0) return;
                Date[x][y] = Date[x][y - 1];
                Date[x][y - 1] = 0;
                y--;
                step++;
                initImage();
                break;

            // 向下移动
            case 40:
                if (x == 0) return;
                Date[x][y] = Date[x - 1][y];
                Date[x - 1][y] = 0;
                x--;
                step++;
                initImage();
                break;

            // 松开查看答案快捷键后刷新屏幕
            case 65:
                initImage();
                break;

            // 一键完成 松开老板键后直接加载答案
            case 87:
                Date = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 0}};
                x = 3;
                y = 3;
                initImage();
                break;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object object = e.getSource();
        // 重现开始游戏
        if (object == rePlayItem) {
            step = 0;
            initDate();
            initImage();
        }

        // 返回登录界面
        else if (object == reLoginItem) {
            this.setVisible(false);
            try {
                new LoginJFrame();
            } catch (IOException | SQLException | ClassNotFoundException ex) {
                throw new RuntimeException(ex);
            }
        }

        // 退出游戏
        else if (object == exitItem) {
            System.exit(0);
        }

        // 充值
        else if (object == supportItem) {
            // 创建一个弹窗 类似于一个小的 JFrame 对象
            JDialog jDialog = new JDialog();
            // 创建配置文件集合
            Properties prop = new Properties();
            FileInputStream fis;
            try {
                fis = new FileInputStream("experimental-case-app\\loading\\about.properties");
            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            }
            // 读取配置文件内容 返回一个 Map
            try {
                prop.load(fis);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            try {
                fis.close();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            // 获取配置文件路径
            String imagePath = (String) prop.get("account");
            JLabel jLabel = new JLabel(new ImageIcon(imagePath));
            jLabel.setBounds(0, 0, 360, 361);
            jDialog.getContentPane().add(jLabel);

            // 设置标题
            jDialog.setTitle("充值");
            // 设置弹窗大小
            jDialog.setSize(400, 400);
            // 设置居中显示
            jDialog.setLocationRelativeTo(null);
            // 设置显示图层
            jDialog.setAlwaysOnTop(true);
            // 设置存在时其他界面不可点击
            jDialog.setModal(true);
            // 设置弹窗可见
            jDialog.setVisible(true);

        }

        // 更换美女图片
        else if (object == girl) {
            Random r = new Random();
            int num = r.nextInt(13) + 1;
            path = "experimental-case-app\\image\\girl\\girl" + num + "\\";
            step = 0;
            initDate();
            initImage();
        }

        // 更换动物图片
        else if (object == animal) {
            Random r = new Random();
            int num = r.nextInt(8) + 1;
            path = "experimental-case-app\\image\\animal\\animal" + num + "\\";
            step = 0;
            initDate();
            initImage();
        }

        // 跟换运动图片
        else if (object == sport) {
            Random r = new Random();
            int num = r.nextInt(10) + 1;
            path = "experimental-case-app\\image\\sport\\sport" + num + "\\";
            step = 0;
            initDate();
            initImage();
        }

        // 存档
        else if (object == saveItem0 || object == saveItem1 || object == saveItem2 || object == saveItem3 || object == saveItem4) {
            JMenuItem item = (JMenuItem) object;
            int index = item.getText().charAt(2) - '0';
            ObjectOutputStream oos;
            try {
                oos = new ObjectOutputStream(new FileOutputStream("experimental-case-app\\Save\\save" + index + ".txt"));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            GameInfo gi = new GameInfo(Date, x, y, path, step);
            // 序列化存档
            IoUtil.writeObj(oos, true, gi);
            item.setText("存档" + index + "(" + step + "步)");
            loadJMenu.getItem(index).setText("读档" + index + "(" + step + "步)");
            showJDialog("存档成功");
        }

        // 读档
        else if (object == loadItem0 || object == loadItem1 || object == loadItem2 || object == loadItem3 || object == loadItem4) {
            JMenuItem item = (JMenuItem) object;
            int index = item.getText().charAt(2) - '0';
            ObjectInputStream ois;
            GameInfo gi;
            try {
                ois = new ObjectInputStream(new FileInputStream("experimental-case-app\\Save\\save" + index + ".txt"));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            try {
                gi = (GameInfo) ois.readObject();
            } catch (IOException | ClassNotFoundException ex) {
                throw new RuntimeException(ex);
            }
            try {
                ois.close();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            Date = gi.getDate();
            path = gi.getPath();
            x = gi.getX();
            y = gi.getY();
            step = gi.getStep();

            initImage();
            showJDialog("读档成功");
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
}
