package com.sys8.sqjzapp.module;

import com.sys8.sqjzapp.utils.Constant;

public class TimelineItem {
    private LocationItem locationItem;
    private LearningVideoItem learningVideoItem;
    private int viewType;

    public TimelineItem(LocationItem locationItem) {
        this.locationItem = locationItem;
        viewType = Constant.ITEM_LOCATION_VIEWTYPE;
    }

    public TimelineItem(LearningVideoItem learningVideoItem) {
        this.learningVideoItem = learningVideoItem;
        viewType = Constant.ITEM_EDUCATION_LEARNING_VIDEO;
    }

    public LocationItem getLocationItem() {
        return locationItem;
    }

    public void setLocationItem(LocationItem locationItem) {
        this.locationItem = locationItem;
    }

    public LearningVideoItem getLearningVideoItem() {
        return learningVideoItem;
    }

    public void setLearningVideoItem(LearningVideoItem learningVideoItem) {
        this.learningVideoItem = learningVideoItem;
    }

    public int getViewType() {
        return viewType;
    }

    public void setViewType(int viewType) {
        this.viewType = viewType;
    }
}
