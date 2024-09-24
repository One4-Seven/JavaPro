package com.yst.poker_game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

public class GameJFrame extends JFrame implements ActionListener {
    // 产生一个通用 Panel 对象
    public static Container container = null;

    // 管理抢地主按钮
    JButton[] landLord = new JButton[2];

    // 管理出牌按钮
    JButton[] publishCard = new JButton[2];

    // 管理地主标志
    JLabel landOwner;

    // 每个人打出的牌方便管理
    ArrayList<ArrayList<Poker>> currentList = new ArrayList<>();

    // 每个人的手牌
    ArrayList<ArrayList<Poker>> playerList = new ArrayList<>();

    // 底牌
    ArrayList<Poker> lordList = new ArrayList<>();

    // 牌盒
    ArrayList<Poker> cardList = new ArrayList<>();

    // 计时器
    JTextField[] times = new JTextField[3];

    public GameJFrame() {
        // 设置 JFrame 的图标
        setIconImage(Toolkit.getDefaultToolkit().getImage("experimental-case-app\\image\\poker\\dizhu.png"));
        initJFrame();
        initView();
        this.setVisible(true);
        initCard();
        // 开始游戏
        initGame();
    }

    private void initCard() {
        // 创建牌盒
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= 13; j++) {
                if ((i == 5) && (j > 2)) {
                    break;
                } else {
                    Poker poker = new Poker(i + "-" + j, false);
                    poker.setLocation(350, 150);
                    cardList.add(poker);
                    container.add(poker);
                }
            }
        }

        // 洗牌
        Collections.shuffle(cardList);

        // 发牌
        ArrayList<Poker> player0 = new ArrayList<>();
        ArrayList<Poker> player1 = new ArrayList<>();
        ArrayList<Poker> player2 = new ArrayList<>();

        for (int i = 0; i < cardList.size(); i++) {
            Poker poker = cardList.get(i);

            // 添加底牌
            if (i <= 2) {
                lordList.add(poker);
                Common.move(poker, poker.getLocation(), new Point(310 + (75 * i), 10));
                continue;
            }

            // 添加手牌
            if (i % 3 == 0) {
                Common.move(poker, poker.getLocation(), new Point(50, 60 + i * 5));
                player0.add(poker);
            } else if (i % 3 == 1) {
                Common.move(poker, poker.getLocation(), new Point(150 + (7 * i), 450));
                player1.add(poker);
                poker.showFront();
            } else {
                Common.move(poker, poker.getLocation(), new Point(700, 60 + i * 5));
                player2.add(poker);
            }

            // 设置新牌在最上方显示
            container.setComponentZOrder(poker, 0);
        }

        playerList.add(player0);
        playerList.add(player1);
        playerList.add(player2);

        // 排序手牌
        for (int i = 0; i < 3; i++) {
            order(playerList.get(i));
            Common.rePosition(this, playerList.get(i), i);
        }
    }

    private void order(ArrayList<Poker> pokers) {
        pokers.sort((o1, o2) -> {
            int color1 = Integer.parseInt(o1.getName().substring(0, 1));
            int value1 = getValue(o1);

            int color2 = Integer.parseInt(o2.getName().substring(0, 1));
            int value2 = getValue(o2);

            int flag = value2 - value1;

            if (flag == 0) {
                return color2 - color1;
            } else {
                return flag;
            }
        });
    }

    private int getValue(Poker poker) {
        int color = Integer.parseInt(poker.getName().substring(0, 1));
        int value = Integer.parseInt(poker.getName().substring(2));

        if (color == 5) {
            return value + 100;
        }

        if (value == 1) {
            return value + 20;
        }

        if (value == 2) {
            return value + 30;
        }

        return value;
    }

    private void initGame() {
        // 创建三个集合用来装三个玩家准备要出的牌
        for (int i = 0; i < 3; i++) {
            ArrayList<Poker> list = new ArrayList<>();
            // 添加到大集合中方便管理
            currentList.add(list);
        }

        // 展示抢地主和不抢地主两个按钮
        landLord[0].setVisible(true);
        landLord[1].setVisible(true);

        // 展示自己前面的倒计时文本
        for (JTextField field : times) {
            field.setText("倒计时30秒");
            field.setVisible(true);
        }

    }

    private void initView() {
        JButton robBut = new JButton("抢地主");
        robBut.setBounds(320, 400, 75, 20);
        robBut.setVisible(false);
        robBut.addActionListener(this);
        landLord[0] = robBut;
        container.add(robBut);

        JButton noBut = new JButton("不  抢");
        noBut.setBounds(420, 400, 75, 20);
        noBut.setVisible(false);
        noBut.addActionListener(this);
        landLord[1] = noBut;
        container.add(noBut);

        JButton outCardBut = new JButton("出牌");
        outCardBut.setBounds(320, 400, 75, 20);
        outCardBut.setVisible(false);
        outCardBut.addActionListener(this);
        publishCard[0] = outCardBut;
        container.add(outCardBut);

        JButton noCardBut = new JButton("不出");
        noCardBut.setBounds(420, 400, 75, 20);
        noCardBut.setVisible(false);
        noCardBut.addActionListener(this);
        publishCard[1] = noCardBut;
        container.add(noCardBut);

        for (int i = 0; i < 3; i++) {
            times[i] = new JTextField("倒计时:");
            times[i].setEnabled(false);
            times[i].setVisible(false);
            container.add(times[i]);
        }

        times[0].setBounds(140, 230, 60, 20);
        times[1].setBounds(374, 360, 60, 20);
        times[2].setBounds(620, 230, 60, 20);

        landOwner = new JLabel(new ImageIcon("experimental-case-app\\image\\poker\\dizhu.png"));
        landOwner.setVisible(false);
        landOwner.setSize(40, 40);
        container.add(landOwner);
    }

    private void initJFrame() {
        this.setTitle("南审斗地主");
        this.setSize(830, 620);
        this.setAlwaysOnTop(true);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setBackground(Color.LIGHT_GRAY);
        container = this.getContentPane();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        Object code = e.getSource();
        if (code == landLord[0]) {
            for (Poker poker : lordList) {
                poker.showFront();
                playerList.get(1).add(poker);
            }

            landLord[0].setVisible(false);
            landLord[1].setVisible(false);

            publishCard[0].setVisible(true);
            publishCard[1].setVisible(true);

            order(playerList.get(1));
            Common.rePosition(this, playerList.get(1), 1);
        }
    }
}
