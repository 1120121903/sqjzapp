package com.sys8.sqjzapp.module;

import com.sys8.sqjzapp.utils.Constant;

public class TimelineItem {
    private LocationItem locationItem;
    private LearningVideoDetailListItem learningVideoDetailListItem;
    private LearningListItem learningListItem;
    private LearningAudioDetailListItem learningAudioDetailListItem;
    private int viewType;

    public TimelineItem(LocationItem locationItem) {
        this.locationItem = locationItem;
        viewType = Constant.ITEM_LOCATION_VIEWTYPE;
    }

    public TimelineItem(LearningVideoDetailListItem learningVideoDetailListItem) {
        this.learningVideoDetailListItem = learningVideoDetailListItem;
        viewType = Constant.ITEM_EDUCATION_LEARNING_VIDEO_DETAIL_LIST;
    }

    public TimelineItem(LearningListItem learningListItem) {
        this.learningListItem = learningListItem;
        viewType = Constant.ITEM_EDUCATION_LEARNING_LIST;
    }

    public TimelineItem(LearningAudioDetailListItem learningAudioDetailListItem){
        this.learningAudioDetailListItem = learningAudioDetailListItem;
        viewType = Constant.ITEM_EDUCATION_LEARNING_AUDIO_DETAIL_LIST;
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

    public LearningVideoDetailListItem getLearningVideoDetailListItem() {
        return learningVideoDetailListItem;
    }

    public void setLearningVideoDetailListItem(LearningVideoDetailListItem learningVideoDetailListItem) {
        this.learningVideoDetailListItem = learningVideoDetailListItem;
    }

    public LearningAudioDetailListItem getLearningAudioDetailListItem() {
        return learningAudioDetailListItem;
    }

    public void setLearningAudioDetailListItem(LearningAudioDetailListItem learningAudioDetailListItem) {
        this.learningAudioDetailListItem = learningAudioDetailListItem;
    }

    public int getViewType() {
        return viewType;
    }

    public void setViewType(int viewType) {
        this.viewType = viewType;
    }
}
