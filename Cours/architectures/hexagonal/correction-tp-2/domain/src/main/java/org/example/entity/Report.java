package org.example.entity;

import java.time.LocalDateTime;

public class Report {
    private int id;
    private double latitude;
    private double longitude;
    private LocalDateTime date;
    private int level;
    private String comment;

    public Report(int id, double latitude, double longitude, LocalDateTime date, int level, String comment) {
        this(latitude, longitude, date, level, comment);
        this.id = id;
    }

    public Report(double latitude, double longitude, LocalDateTime date, int level, String comment) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.date = date;
        this.level = level;
        this.comment = comment;
    }

    public Report() {

    }

    public int getId() {
        return id;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public int getLevel() {
        return level;
    }

    public String getComment() {
        return comment;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }


    public void setLevel(int level) {
        this.level = level;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
