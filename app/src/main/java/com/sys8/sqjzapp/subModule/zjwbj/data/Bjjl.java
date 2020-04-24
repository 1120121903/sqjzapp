package com.sys8.sqjzapp.subModule.zjwbj.data;

public class Bjjl {
    String timeApply;
    String timeStart;
    String bjsm;
    String state;

    public Bjjl(String timeApply, String timeStart,String bjsm, String state) {
        this.timeApply = timeApply;
        this.timeStart = timeStart;
        this.bjsm = bjsm;
        this.state = state;
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

    public String getBjsm() {
        return bjsm;
    }

    public void setBjsm(String bjsm) {
        this.bjsm = bjsm;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}


