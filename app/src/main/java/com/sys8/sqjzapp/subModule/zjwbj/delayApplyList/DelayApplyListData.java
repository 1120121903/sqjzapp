package com.sys8.sqjzapp.subModule.zjwbj.delayApplyList;

import com.sys8.sqjzapp.R;
import com.sys8.sqjzapp.module.LocationItem;
import com.sys8.sqjzapp.module.TimelineItem;
import com.sys8.sqjzapp.subModule.zjwbj.data.BjState;
import com.sys8.sqjzapp.subModule.zjwbj.data.Bjjl;

import java.util.ArrayList;
import java.util.List;

public class DelayApplyListData {

    /**
     *延期记录数据列表
     */
    public static final List<DelayApply> list_DelayApply=new ArrayList<DelayApply>(){
        {
            add(new DelayApply("2020-02-04","一个月", "出差","已通过"));
        }
    };


    public static final List<TimelineItem> list_DelayApplyState1=new ArrayList<TimelineItem>(){
        {
            add(new TimelineItem(new LocationItem("张海洋提交延期申请"+"\n2020-02-04", R.drawable.ic_homt_zjwbj)));
            add(new TimelineItem(new LocationItem("海淀区司法局审批通过"+"\n2020-02-05", R.drawable.ic_homt_zjwbj)));
            add(new TimelineItem(new LocationItem("海淀区学院路司法所审批通过"+"\n2020-02-05", R.drawable.ic_homt_zjwbj)));
        }
    };
    public static final List<TimelineItem> list_DelayApplyState2=new ArrayList<TimelineItem>(){
        {
        }
    };
    /**
     *暂监外病检记录状态变化
     */
    public static final List<DelayApplyState> list_DelayApplyState = new ArrayList<DelayApplyState>(){
        {
            add(new DelayApplyState("2020-02-04",list_DelayApplyState1));
            add(new DelayApplyState("2020-03-04",list_DelayApplyState2));
        }
    };

}
