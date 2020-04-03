package com.sys8.sqjzapp.subModule.jzdbg;

import com.sys8.sqjzapp.module.TimelineItem;

import java.util.List;

public class JzdbgState {
    String  timeApply;
    List<TimelineItem> jzdbg;

    public JzdbgState(String timeApply, List<TimelineItem> jzdbg ) {
        this.timeApply = timeApply;
        this.jzdbg = jzdbg;
    }

    public String getTimeApply() {
        return timeApply;
    }

    public void setTimeApply(String timeApply) {
        this.timeApply = timeApply;
    }

    public List<TimelineItem> getJzdbg() {
        return jzdbg;
    }

    public void setJzdbg(List<TimelineItem> jzdbg) {
        this.jzdbg = jzdbg;
    }
}


