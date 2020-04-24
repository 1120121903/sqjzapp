package com.sys8.sqjzapp.subModule.zjwbj.delayApplyList;

public class DelayApply {
    String timeApply;
    String timeDelay;
    String reasonDelay;
    String state;

    public DelayApply(String timeApply, String timeDelay, String reasonDelay, String state) {
        this.timeApply = timeApply;
        this.timeDelay = timeDelay;
        this.reasonDelay = reasonDelay;
        this.state = state;
    }

    public String getTimeApply() {
        return timeApply;
    }

    public void setTimeApply(String timeApply) {
        this.timeApply = timeApply;
    }

    public String getTimeDelay() {
        return timeDelay;
    }

    public void setTimeDelay(String timeDelay) {
        this.timeDelay = timeDelay;
    }

    public String getReasonDelay() {
        return reasonDelay;
    }

    public void setReasonDelay(String reasonDelay) {
        this.reasonDelay = reasonDelay;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}


