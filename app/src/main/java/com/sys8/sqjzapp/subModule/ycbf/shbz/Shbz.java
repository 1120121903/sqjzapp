package com.sys8.sqjzapp.subModule.ycbf.shbz;

public class Shbz {
    String title;
    String bmtj;//报名条件
    String jzsj;//截止时间
    String fbsj;//发布时间
    String content;//内容
    String state;//状态

    public Shbz(String title, String bmtj, String jzsj, String fbsj, String content,String state) {
        this.title = title;
        this.bmtj = bmtj;
        this.jzsj = jzsj;
        this.fbsj = fbsj;
        this.content = content;
        this.state = state;
    }

    public Shbz(){}

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBmtj() {
        return bmtj;
    }

    public void setBmtj(String bmtj) {
        this.bmtj = bmtj;
    }

    public String getJzsj() {
        return jzsj;
    }

    public void setJzsj(String jzsj) {
        this.jzsj = jzsj;
    }

    public String getFbsj() {
        return fbsj;
    }

    public void setFbsj(String fbsj) {
        this.fbsj = fbsj;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}


