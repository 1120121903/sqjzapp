package com.sys8.sqjzapp.module;

import com.sys8.sqjzapp.utils.Constant;

public class TimelineItem {
    private LocationItem locationItem;
    private int viewType;

    public TimelineItem(LocationItem locationItem) {
        this.locationItem = locationItem;
        viewType = Constant.ITEM_LOCATION_VIEWTYPE;
    }

    public LocationItem getLocationItem() {
        return locationItem;
    }

    public void setLocationItem(LocationItem locationItem) {
        this.locationItem = locationItem;
    }

    public int getViewType() {
        return viewType;
    }

    public void setViewType(int viewType) {
        this.viewType = viewType;
    }
}
