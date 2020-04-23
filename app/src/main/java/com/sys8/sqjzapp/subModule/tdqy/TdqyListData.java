package com.sys8.sqjzapp.subModule.tdqy;

import com.sys8.sqjzapp.R;
import com.sys8.sqjzapp.module.LocationItem;
import com.sys8.sqjzapp.module.TimelineItem;
import com.sys8.sqjzapp.subModule.wcqj.QjState;
import com.sys8.sqjzapp.subModule.wcqj.Qjjl;

import java.util.ArrayList;
import java.util.List;

public class TdqyListData {

    /**
     *特定区域申请列表
     */
    public static final List<Tdqy> list_Tdqy=new ArrayList<Tdqy>(){
        {
            add(new Tdqy("进入特定区域申请","2020-03-02","2020-03-04","2020-03-07",
                    "辽宁省沈阳市和平区新和大街526号",
                    "因出售户籍地房产，需前往吉林省公主岭市办理过户手续，望领导批准。",
                    "已通过"));
            add(new Tdqy("进入特定区域申请","2020-04-04","2020-04-10","2020-04-12",
                    "北京市朝阳区幸福小区",
                    "由于本人单位安排到朝阳区调查居民生活情况，需进入特定区域，望领导批准。",
                    "审批中"));
        }
    };


    public static final List<TimelineItem> list_TdqySq_State1=new ArrayList<TimelineItem>(){
        {
            add(new TimelineItem(new LocationItem("张海洋提交进入特定区域申请"+"\n2020-03-02", R.drawable.ic_home_tdqy)));
            add(new TimelineItem(new LocationItem("海淀区司法局审批通过"+"\n2020-03-04", R.drawable.ic_home_tdqy)));
            add(new TimelineItem(new LocationItem("海淀区学院路司法所审批通过"+"\n2020-03-07", R.drawable.ic_home_tdqy)));
        }
    };
    public static final List<TimelineItem> list_TdqySq_State2=new ArrayList<TimelineItem>(){
        {
            add(new TimelineItem(new LocationItem("张海洋提交进入特定区域申请"+"\n2020-04-04", R.drawable.ic_home_tdqy)));
            add(new TimelineItem(new LocationItem("海淀区司法局审批通过"+"\n2020-04-05", R.drawable.ic_home_tdqy)));
        }
    };
    public static final List<TimelineItem> list_TdqySq_State3=new ArrayList<TimelineItem>(){
        {
        }
    };

    public static final List<TdqyApplyState> list_TdqyApply_State = new ArrayList<TdqyApplyState>(){
        {
            add(new TdqyApplyState("2020-03-02",list_TdqySq_State1));
            add(new TdqyApplyState("2020-04-04",list_TdqySq_State2));
        }
    };

}
