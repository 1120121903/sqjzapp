package com.sys8.sqjzapp.utils;

import com.sys8.sqjzapp.R;
import com.sys8.sqjzapp.module.LocationItem;
import com.sys8.sqjzapp.module.TimelineItem;

import java.util.ArrayList;
import java.util.List;

public class DataSource {
    public static List<TimelineItem> getTimelineData(){
        List<TimelineItem> mdata = new ArrayList<>();
        //locationItem
        LocationItem itemLocation = new LocationItem("beijing","11:11", R.drawable.home_jyxx);
        TimelineItem locationTimelintItem = new TimelineItem(itemLocation);
        mdata.add(locationTimelintItem);
        return mdata;
    }
}
