package com.sys8.sqjzapp.subModule.zjwbj.delayApplyList;

import com.sys8.sqjzapp.module.TimelineItem;

import java.util.List;

public class DelayApplyState {
    String  timeApply;
    List<TimelineItem> delayApply;

    public DelayApplyState(String timeApply, List<TimelineItem> delayApply ) {
        this.timeApply = timeApply;
        this.delayApply = delayApply;
    }

    public String getTimeApply() {
        return timeApply;
    }

    public void setTimeApply(String timeApply) {
        this.timeApply = timeApply;
    }

    public List<TimelineItem> getDelayApply() {
        return delayApply;
    }

    public void setDelayApply(List<TimelineItem> delayApply) {
        this.delayApply = delayApply;
    }
}


