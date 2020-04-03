package com.sys8.sqjzapp.subModule.jzdbg;

import com.sys8.sqjzapp.R;
import com.sys8.sqjzapp.module.LocationItem;
import com.sys8.sqjzapp.module.TimelineItem;
import com.sys8.sqjzapp.subModule.zjwbj.BjState;
import com.sys8.sqjzapp.subModule.zjwbj.Bjjl;

import java.util.ArrayList;
import java.util.List;

public class JzdbgListData {

    /**
     *居住地变更记录数据列表
     */
    public static final List<Jzdbg> list_Jzdbg=new ArrayList<Jzdbg>(){
        {
            add(new Jzdbg("2020-03-04","辽宁省沈阳市和平区司法局", "辽宁省沈阳市和平区新河大街526号",
                    "父母年岁过高，需要人照顾，下月回家照顾老人","已通过"));
        }
    };


    public static final List<TimelineItem> list_JzdbgState1=new ArrayList<TimelineItem>(){
        {
            add(new TimelineItem(new LocationItem("张海洋提交居住地变更申请"+"\n2020-03-04", R.drawable.ic_homt_jzdbg)));
            add(new TimelineItem(new LocationItem("海淀区司法局审批通过"+"\n2020-03-05", R.drawable.ic_homt_jzdbg)));
            add(new TimelineItem(new LocationItem("海淀区学院路司法所审批通过"+"\n2020-03-05", R.drawable.ic_homt_jzdbg)));
        }
    };
    public static final List<TimelineItem> list_JzdbgState2=new ArrayList<TimelineItem>(){
        {
        }
    };
    /**
     *暂监外病检记录状态变化
     */
    public static final List<JzdbgState> list_JzdbgState = new ArrayList<JzdbgState>(){
        {
            add(new JzdbgState("2020-03-04",list_JzdbgState1));
        }
    };

}
