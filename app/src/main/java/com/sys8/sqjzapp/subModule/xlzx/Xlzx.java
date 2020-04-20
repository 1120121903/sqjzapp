package com.sys8.sqjzapp.subModule.xlzx;

public class Xlzx {
    int head ;//头像
    String name;//姓名
    String zc;//职称
    String des;//介绍

    public Xlzx(int head, String name, String zc, String des) {
        this.head = head;
        this.name = name;
        this.zc = zc;
        this.des = des;
    }

    public int getHead() {
        return head;
    }

    public void setHead(int head) {
        this.head = head;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getZc() {
        return zc;
    }

    public void setZc(String zc) {
        this.zc = zc;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }
}


