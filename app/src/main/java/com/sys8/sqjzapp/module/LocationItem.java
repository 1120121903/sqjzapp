package com.sys8.sqjzapp.module;

public class LocationItem {

    private String address;
    private String time;
    private int imgUser;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getImgUser() {
        return imgUser;
    }

    public void setImgUser(int imgUser) {
        this.imgUser = imgUser;
    }

    public LocationItem(String address, String time, int imgUser) {
        this.address = address;
        this.time = time;
        this.imgUser = imgUser;
    }
}
