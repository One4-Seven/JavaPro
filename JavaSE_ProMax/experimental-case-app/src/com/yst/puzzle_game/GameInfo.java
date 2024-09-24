package com.yst.puzzle_game;

import java.io.Serial;
import java.io.Serializable;

public class GameInfo implements Serializable {
    @Serial
    private static final long serialVersionUID = 1766797730979378674L;
    int[][] date = new int[4][4];
    int x, y;
    String path;
    int step = 0;

    public GameInfo(int[][] date, int x, int y, String path, int step) {
        this.date = date;
        this.x = x;
        this.y = y;
        this.path = path;
        this.step = step;
    }

    public int[][] getDate() {
        return date;
    }

    public void setDate(int[][] date) {
        this.date = date;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }
}
