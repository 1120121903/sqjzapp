package com.sys8.sqjzapp.subModule.jzdbg;

public class Jzdbg {
    String timeApply;
    String jsdw;//接收单位
    String xjzd;//新居住地
    String bgyy;//变更原因
    String state;//审批状态

    public Jzdbg(String timeApply, String jsdw, String xjzd, String bgyy,String state) {
        this.timeApply = timeApply;
        this.jsdw = jsdw;
        this.xjzd = xjzd;
        this.bgyy = bgyy;
        this.state = state;
    }

    public String getTimeApply() {
        return timeApply;
    }

    public void setTimeApply(String timeApply) {
        this.timeApply = timeApply;
    }

    public String getJsdw() {
        return jsdw;
    }

    public void setJsdw(String jsdw) {
        this.jsdw = jsdw;
    }

    public String getXjzd() {
        return xjzd;
    }

    public void setXjzd(String xjzd) {
        this.xjzd = xjzd;
    }

    public String getBgyy() {
        return bgyy;
    }

    public void setBgyy(String bgyy) {
        this.bgyy = bgyy;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}


