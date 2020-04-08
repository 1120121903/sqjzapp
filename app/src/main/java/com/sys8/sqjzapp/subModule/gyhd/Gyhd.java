package com.sys8.sqjzapp.subModule.gyhd;

public class Gyhd {
    String title;
    String fbsj;//发布时间
    String kssj;//开始时间
    String hddd;//活动地点
    String bmrs;//报名人数
    String cotent;//其它内容
    String state;//申请状态

    public Gyhd(String title, String fbsj, String kssj, String hddd, String bmrs, String cotent, String state) {
        this.title = title;
        this.fbsj = fbsj;
        this.kssj = kssj;
        this.hddd = hddd;
        this.bmrs = bmrs;
        this.cotent = cotent;
        this.state = state;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFbsj() {
        return fbsj;
    }

    public void setFbsj(String fbsj) {
        this.fbsj = fbsj;
    }

    public String getKssj() {
        return kssj;
    }

    public void setKssj(String kssj) {
        this.kssj = kssj;
    }

    public String getHddd() {
        return hddd;
    }

    public void setHddd(String hddd) {
        this.hddd = hddd;
    }

    public String getBmrs() {
        return bmrs;
    }

    public void setBmrs(String bmrs) {
        this.bmrs = bmrs;
    }

    public String getCotent() {
        return cotent;
    }

    public void setCotent(String cotent) {
        this.cotent = cotent;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}


