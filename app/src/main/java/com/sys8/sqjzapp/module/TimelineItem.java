package com.sys8.sqjzapp.module;

import com.sys8.sqjzapp.utils.Constant;

public class TimelineItem {
    private LocationItem locationItem;
    private LearningDetailListItem learningDetailListItem;
    private LearningListItem learningListItem;
    private int viewType;

    public TimelineItem(LocationItem locationItem) {
        this.locationItem = locationItem;
        viewType = Constant.ITEM_LOCATION_VIEWTYPE;
    }

    public TimelineItem(LearningDetailListItem learningDetailListItem) {
        this.learningDetailListItem = learningDetailListItem;
        viewType = Constant.ITEM_EDUCATION_LEARNING_DETAIL_LIST;
    }

    public TimelineItem(LearningListItem learningListItem) {
        this.learningListItem = learningListItem;
        viewType = Constant.ITEM_EDUCATION_LEARNING_LIST;
    }

    public LearningListItem getLearningListItem() {
        return learningListItem;
    }

    public void setLearningListItem(LearningListItem learningListItem) {
        this.learningListItem = learningListItem;
    }

    public LocationItem getLocationItem() {
        return locationItem;
    }

    public void setLocationItem(LocationItem locationItem) {
        this.locationItem = locationItem;
    }

    public LearningDetailListItem getLearningDetailListItem() {
        return learningDetailListItem;
    }

    public void setLearningDetailListItem(LearningDetailListItem learningDetailListItem) {
        this.learningDetailListItem = learningDetailListItem;
    }

    public int getViewType() {
        return viewType;
    }

    public void setViewType(int viewType) {
        this.viewType = viewType;
    }
}
