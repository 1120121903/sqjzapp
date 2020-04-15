package com.sys8.sqjzapp.subModule.jzjl;

public class Jzjl {
    private String date;
    private String act;

    public Jzjl(String date, String act){
        this.act = act;
        this.date  = date;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAct() {
        return act;
    }

    public void setAct(String act) {
        this.act = act;
    }
}
