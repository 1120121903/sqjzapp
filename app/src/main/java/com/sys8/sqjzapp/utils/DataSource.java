package com.sys8.sqjzapp.utils;

import com.sys8.sqjzapp.R;
import com.sys8.sqjzapp.module.LocationItem;
import com.sys8.sqjzapp.module.TimelineItem;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class DataSource {
    public static List<TimelineItem> getTimelineData(){
        List<TimelineItem> mdata = new ArrayList<>();
        //locationItem1
        LocationItem itemLocation = new LocationItem("2020-01-01 12:00:01"+"\n北京市海淀区太极机械所","", R.drawable.location_timeline_imguser);
        TimelineItem locationTimelintItem = new TimelineItem(itemLocation);
        mdata.add(locationTimelintItem);

        //locationItem2
        itemLocation = new LocationItem("2020-02-02 12:00:01"+"\n北京市海淀区十五所社区","", R.drawable.location_timeline_imguser);
        locationTimelintItem = new TimelineItem(itemLocation);
        mdata.add(locationTimelintItem);

        return mdata;
    }
    public static List<TimelineItem> getRevertTimeLineData(List<TimelineItem> mdata){
        List<TimelineItem> mRevertData = new ArrayList<>();
        for(int i=mdata.size()-1;i>=0;i--){
            mRevertData.add(mdata.get(i));
        }
        return mRevertData;
    }
}
