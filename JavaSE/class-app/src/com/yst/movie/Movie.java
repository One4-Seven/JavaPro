package com.yst.movie;

public class Movie {
    private int id;
    private String name;
    private double price;
    private double score;
    private String director;

    public Movie() {
    }

    public Movie(int id, String name, double price, double score, String director) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.score = score;
        this.director = director;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

}
