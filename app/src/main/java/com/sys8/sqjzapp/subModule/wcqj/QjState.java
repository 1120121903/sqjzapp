package com.sys8.sqjzapp.subModule.wcqj;

import com.sys8.sqjzapp.module.TimelineItem;

import java.util.List;

public class QjState {
    String  timeApply;
    List<TimelineItem> qjjl;

    public QjState(String timeApply,List<TimelineItem> qjjl ) {
        this.timeApply = timeApply;
        this.qjjl = qjjl;
    }

    public String getTimeApply() {
        return timeApply;
    }

    public void setTimeApply(String timeApply) {
        this.timeApply = timeApply;
    }

    public List<TimelineItem> getQjjl() {
        return qjjl;
    }

    public void setQjjl(List<TimelineItem> qjjl) {
        this.qjjl = qjjl;
    }
}


