package com.yst.object;

import java.util.Arrays;

public class Scores implements Cloneable{
    private int[] scores;

    public Scores() {
    }

    public int[] getScores() {
        return scores;
    }

    public void setScores(int[] scores) {
        this.scores = scores;
    }

    public Scores(int[] scores) {
        this.scores = scores;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "Scores{" +
                "scores=" + Arrays.toString(scores) +
                '}';
    }
}
