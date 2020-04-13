package com.sys8.sqjzapp.module;

import android.graphics.Bitmap;

public class LocationItem {

    private String timeLineText;//时间线右边的文字
    private int imgUser;//时间线上的图片
    private Bitmap imgUserBitMap;//图片

    public String getTimeLineText() {
        return timeLineText;
    }

    public void setTimeLineTex(String text) {
        this.timeLineText = text;
    }


    public int getImgUser() {
        return imgUser;
    }

    public void setImgUser(int imgUser) {
        this.imgUser = imgUser;
    }

    public LocationItem(String text,int imgUser) {
        this.timeLineText = text;
        this.imgUser = imgUser;
    }

    public LocationItem(String text,Bitmap imgUserBitMap){
        this.timeLineText = text;
        this.imgUserBitMap = imgUserBitMap;
    }

    public void setTimeLineText(String timeLineText) {
        this.timeLineText = timeLineText;
    }

    public Bitmap getImgUserBitMap() {
        return imgUserBitMap;
    }

    public void setImgUserBitMap(Bitmap imgUserBitMap) {
        this.imgUserBitMap = imgUserBitMap;
    }
}
