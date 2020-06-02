package com.sys8.sqjzapp.subModule.hksq;

public class Hksq {
    String title;
    String timeApply;
    String time;
    String name;
    String place;
    String reason;
    String state;

    public Hksq(String title, String timeApply, String time, String name, String place, String reason,String state) {
        this.title = title;
        this.timeApply = timeApply;
        this.time = time;
        this.name = name;
        this.place = place;
        this.reason = reason;
        this.state = state;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTimeApply() {
        return timeApply;
    }

    public void setTimeApply(String timeApply) {
        this.timeApply = timeApply;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}


