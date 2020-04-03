package com.sys8.sqjzapp.subModule.zjwbj;

import com.sys8.sqjzapp.module.TimelineItem;

import java.util.List;

public class BjState {
    String  timeApply;
    List<TimelineItem> bjjl;

    public BjState(String timeApply, List<TimelineItem> bjjl ) {
        this.timeApply = timeApply;
        this.bjjl = bjjl;
    }

    public String getTimeApply() {
        return timeApply;
    }

    public void setTimeApply(String timeApply) {
        this.timeApply = timeApply;
    }

    public List<TimelineItem> getBjjl() {
        return bjjl;
    }

    public void setBjjl(List<TimelineItem> bjjl) {
        this.bjjl = bjjl;
    }
}


