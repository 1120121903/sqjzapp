package com.sys8.sqjzapp.subModule.zjwbj;

import com.sys8.sqjzapp.R;
import com.sys8.sqjzapp.module.LocationItem;
import com.sys8.sqjzapp.module.TimelineItem;
import com.sys8.sqjzapp.subModule.wcqj.QjState;
import com.sys8.sqjzapp.subModule.wcqj.Qjjl;

import java.util.ArrayList;
import java.util.List;

public class BjjlListData {

    /**
     *请假记录数据列表
     */
    public static final List<Bjjl> list_Bjjl=new ArrayList<Bjjl>(){
        {
            add(new Bjjl("2020-02-04","2020-03-04", "手术","已通过"));
        }
    };


    public static final List<TimelineItem> list_BjState1=new ArrayList<TimelineItem>(){
        {
            add(new TimelineItem(new LocationItem("张海洋提交暂监外病检说明"+"\n2020-02-04", R.drawable.zjwbj)));
            add(new TimelineItem(new LocationItem("海淀区司法局审批通过"+"\n2020-02-05", R.drawable.zjwbj)));
            add(new TimelineItem(new LocationItem("海淀区学院路司法所审批通过"+"\n2020-02-05", R.drawable.zjwbj)));
        }
    };
    public static final List<TimelineItem> list_BjState2=new ArrayList<TimelineItem>(){
        {
        }
    };
    /**
     *请假状态变化
     */
    public static final List<BjState> list_BjState = new ArrayList<BjState>(){
        {
            add(new BjState("2020-02-04",list_BjState1));
            add(new BjState("2020-03-04",list_BjState2));
        }
    };

}
