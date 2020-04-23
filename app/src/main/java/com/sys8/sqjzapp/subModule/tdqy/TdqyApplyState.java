package com.sys8.sqjzapp.subModule.tdqy;

import com.sys8.sqjzapp.module.TimelineItem;

import java.util.List;

public class TdqyApplyState {
    String  timeApply;
    List<TimelineItem> tdqyApply;

    public TdqyApplyState(String timeApply, List<TimelineItem> tdqyApply ) {
        this.timeApply = timeApply;
        this.tdqyApply = tdqyApply;
    }

    public String getTimeApply() {
        return timeApply;
    }

    public void setTimeApply(String timeApply) {
        this.timeApply = timeApply;
    }

    public List<TimelineItem> getTdqyApply() {
        return tdqyApply;
    }

    public void setTdqyApply(List<TimelineItem> tdqyApply) {
        this.tdqyApply = tdqyApply;
    }
}


