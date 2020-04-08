package com.sys8.sqjzapp.subModule.ycbf.shbz;

public class ShbzSq {
    String title;
    String sqly;
    String state;
    Shbz shbz;

    public ShbzSq(String title,String sqly,String state,Shbz shbz) {
        this.title = title;
        this.sqly = sqly;
        this.state = state;
        this.shbz = shbz;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSqly() {
        return sqly;
    }

    public void setSqly(String sqly) {
        this.sqly = sqly;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Shbz getShbz() {
        return shbz;
    }

    public void setShbz(Shbz shbz) {
        this.shbz = shbz;
    }
}


