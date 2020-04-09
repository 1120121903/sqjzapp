package com.sys8.sqjzapp.main.tztx;

public class Tzxx {
    String type;
    String time;
    String title;
    String content;
    String dep;//发送单位
    String state;//状态:1已读，0未读

    public Tzxx(String type,String  time,String title,String content,String dep,String state){
        this.time = time;
        this.type = type;
        this.title = title;
        this.content = content;
        this.dep = dep;
        this.state = state;
    }

    public Tzxx(){}

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getDep() {
        return dep;
    }

    public void setDep(String dep) {
        this.dep = dep;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

