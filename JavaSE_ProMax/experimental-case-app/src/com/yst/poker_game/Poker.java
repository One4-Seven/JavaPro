package com.yst.poker_game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Poker extends JLabel implements MouseListener {
    // 扑克
    private String name;

    // 表示正反
    private boolean up;

    // 是否已点击
    private boolean clicked = false;

    // 能否点击
    private boolean canClick = false;

    public Poker(String name, boolean up) {
        this.name = name;
        this.up = up;

        if (this.up) {
            showFront();
        } else {
            showRear();
        }


        this.setSize(71,96);
        this.setVisible(true);
        this.addMouseListener(this);
    }

    public void showFront() {
        this.setIcon(new ImageIcon("experimental-case-app\\image\\poker\\" + this.getName() + ".png"));
        this.up = true;
        this.canClick = true;
    }

    public void showRear() {
        this.setIcon(new ImageIcon("experimental-case-app\\image\\poker\\rear.png"));
        this.up = false;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public boolean isUp() {
        return up;
    }

    public void setUp(boolean up) {
        this.up = up;
    }

    public boolean isClicked() {
        return clicked;
    }

    public void setClicked(boolean clicked) {
        this.clicked = clicked;
    }

    public boolean isCanClick() {
        return canClick;
    }

    public void setCanClick(boolean canClick) {
        this.canClick = canClick;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (canClick) {
            int step;
            if (clicked) {
                step = 20;
            } else {
                step = -20;
            }

            // 把是否点击取反
            clicked = !clicked;

            Point from = this.getLocation();
            Point newFrom = new Point(from.x, from.y + step);
            this.setLocation(newFrom);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
