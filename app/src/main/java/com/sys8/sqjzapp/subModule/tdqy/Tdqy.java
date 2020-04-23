package com.sys8.sqjzapp.subModule.tdqy;

//特定区域
public class Tdqy {
    String title;
    String timeApply;
    String timeStart;
    String timeEnd;
    String place;
    String reason;
    String state;

    public Tdqy(String title, String timeApply, String timeStart, String timeEnd,String place, String reason, String state) {
        this.title = title;
        this.timeApply = timeApply;
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
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

    public String getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(String timeStart) {
        this.timeStart = timeStart;
    }

    public String getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(String timeEnd) {
        this.timeEnd = timeEnd;
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


