package com.sys8.sqjzapp.subModule.rcbg;

public class Rcbg {
    String time;
    String title;
    String content;
    String place;

    public Rcbg(String time,String title, String content, String place){
        this.time = time;
        this.title = title;
        this.content = content;
        this.place = place;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }
}

