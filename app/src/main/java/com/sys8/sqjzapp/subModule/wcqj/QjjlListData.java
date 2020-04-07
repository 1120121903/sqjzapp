package com.sys8.sqjzapp.subModule.wcqj;

import com.sys8.sqjzapp.R;
import com.sys8.sqjzapp.module.LocationItem;
import com.sys8.sqjzapp.module.TimelineItem;

import java.util.ArrayList;
import java.util.List;

public class QjjlListData {

    /**
     *请假记录数据列表
     */
    public static final List<Qjjl> list_Qjjl=new ArrayList<Qjjl>(){
        {
            add(new Qjjl("张海洋提交的请假","2020-02-04","2020-03-04","2020-03-06",
                    "2天","辽宁省沈阳市和平区新和大街526号","回户籍地办理房屋过户手续","已销假"));
            add(new Qjjl("张海洋提交的请假","2020-03-04","2020-04-04","2020-04-07",
                    "3天","北京市华北计算技术研究所","面试","审批中"));
        }
    };


    public static final List<TimelineItem> list_QjState1=new ArrayList<TimelineItem>(){
        {
            add(new TimelineItem(new LocationItem("张海洋提交请假申请"+"\n2020-02-04", R.drawable.ic_home_wcqj)));
            add(new TimelineItem(new LocationItem("海淀区司法局审批通过"+"\n2020-02-05", R.drawable.ic_home_wcqj)));
            add(new TimelineItem(new LocationItem("海淀区学院路司法所审批通过"+"\n2020-02-05", R.drawable.ic_home_wcqj)));
            add(new TimelineItem(new LocationItem("张海洋已销假"+"\n2020-02-10", R.drawable.ic_home_wcqj)));
        }
    };
    public static final List<TimelineItem> list_QjState2=new ArrayList<TimelineItem>(){
        {
            add(new TimelineItem(new LocationItem("张海洋提交请假申请"+"\n2020-03-04", R.drawable.ic_home_wcqj)));
            add(new TimelineItem(new LocationItem("海淀区司法局审批通过"+"\n2020-03-05", R.drawable.ic_home_wcqj)));
            add(new TimelineItem(new LocationItem("海淀区学院路司法所审批通过"+"\n2020-03-05", R.drawable.ic_home_wcqj)));
            add(new TimelineItem(new LocationItem("张海洋请假中"+"\n2020-03-09", R.drawable.ic_home_wcqj)));
        }
    };
    public static final List<TimelineItem> list_QjState3=new ArrayList<TimelineItem>(){
        {
        }
    };
    /**
     *请假状态变化
     */
    public static final List<QjState> list_QjState = new ArrayList<QjState>(){
        {
            add(new QjState("2020-02-04",list_QjState1));
            add(new QjState("2020-03-04",list_QjState2));
        }
    };

}
