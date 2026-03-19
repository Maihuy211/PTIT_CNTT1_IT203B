package ra.entity;

import java.util.Scanner;

public class Moive {
    private String movieId;
    private String movieName;
    private int duration;
    private int views;

    public Moive() {
    }
    public Moive(String movieId, String movieName, int duration, int views) {
        this.movieId = movieId;
        this.movieName = movieName;
        this.duration = duration;
        this.views = views;
    }
    public String getMovieId() {
        return movieId;
    }
    public String getMovieName() {
        return movieName;
    }
    public int getDuration() {
        return duration;
    }
    public int getViews() {
        return views;
    }
    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }
    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }
    public void setDuration(int duration) {
        this.duration = duration;
    }
    public void setViews(int views) {
        this.views = views;
    }
    public void inputData(Scanner sc){
        do {
            System.out.print("Nhập ID: ");
            movieId = sc.nextLine();
        } while (movieId.isEmpty());

        do {
            System.out.print("Nhập tên phim: ");
            movieName = sc.nextLine();
        } while (movieName.isEmpty());

        do {
            System.out.print("Nhập duration: ");
            duration = sc.nextInt();
        } while (duration <= 0);

        do {
            System.out.print("Nhập views: ");
            views = sc.nextInt();
        } while (views < 0);
        sc.nextLine();
    }
    public void displayData(){
        System.out.printf("%-10s %-20s %-10d %-10d\n", movieId, movieName, duration, views);
    }
}