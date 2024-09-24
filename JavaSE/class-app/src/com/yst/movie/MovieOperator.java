package com.yst.movie;

public class MovieOperator {
    private Movie[] movies;

    public MovieOperator(Movie[] movies) {
        this.movies = movies;
    }

    public void showAllInfo() {
        for (int i = 0; i < movies.length; i++) {
            printInfo(movies[i]);
            System.out.println("---------------------------------");
        }
    }

    public void searchInfo(int id) {
        for (int i = 0; i < movies.length; i++) {
            if (movies[i].getId() == id) {
                printInfo(movies[i]);
                System.out.println("---------------------------------");
                return;
            }
        }
        System.out.println("未查询到此编号电影!");
        System.out.println("---------------------------------");
    }

    public void hotMoive() {
        for (int i = 0; i < movies.length; i++) {
            System.out.println("Id: " + movies[i].getId() + "\tName: 《" + movies[i].getName() + "》");
        }
    }

    public void printInfo(Movie movie) {
        System.out.println("电影编号: " + movie.getId());
        System.out.println("电影名称: 《" + movie.getName() + "》");
        System.out.println("导演: " + movie.getDirector());
        System.out.println("票价: " + movie.getPrice());
        System.out.println("豆瓣评分: " + movie.getScore());
    }

}
