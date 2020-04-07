package com.sys8.sqjzapp.module;

public class LearningListItem {
    private int MediaType;//多媒体类型
    private String title;//标题
    private int courseNumber;//课程集数
    private int courseDuration;//课程时间
    private int learningPeopleNumber;//学习人数
    private boolean isCollect;//收藏状态 true-已收藏   false-为收藏
    private boolean isPass;//通过状态  true-已通过  false-未通过
    private int ImageThumbnail;//视频或者图片缩略图

    /**
     * 视频
     * @param mediaType
     * @param title
     * @param courseNumber
     * @param courseDuration
     * @param learningPeopleNumber
     * @param isCollect
     * @param isPass
     * @param imageThumbnail
     */
    public LearningListItem(int mediaType, String title, int courseNumber, int courseDuration, int learningPeopleNumber, boolean isCollect, boolean isPass, int imageThumbnail) {
        this.MediaType = mediaType;
        this.title = title;
        this.courseNumber = courseNumber;
        this.courseDuration = courseDuration;
        this.learningPeopleNumber = learningPeopleNumber;
        this.isCollect = isCollect;
        this.isPass = isPass;
        this.ImageThumbnail = imageThumbnail;
    }

    /**
     * 音频
     * @param mediaType
     * @param title
     * @param courseNumber
     * @param courseDuration
     * @param learningPeopleNumber
     * @param isCollect
     * @param isPass
     */
    public LearningListItem(int mediaType, String title, int courseNumber, int courseDuration, int learningPeopleNumber, boolean isCollect, boolean isPass) {
        this.MediaType = mediaType;
        this.title = title;
        this.courseNumber = courseNumber;
        this.courseDuration = courseDuration;
        this.learningPeopleNumber = learningPeopleNumber;
        this.isCollect = isCollect;
        this.isPass = isPass;
    }

    /**
     * 图文
     * @param mediaType
     * @param title
     * @param learningPeopleNumber
     * @param isCollect
     * @param isPass
     * @param imageThumbnail
     */
    public LearningListItem(int mediaType, String title, int learningPeopleNumber, boolean isCollect, boolean isPass, int imageThumbnail) {
        MediaType = mediaType;
        this.title = title;
        this.learningPeopleNumber = learningPeopleNumber;
        this.isCollect = isCollect;
        this.isPass = isPass;
        ImageThumbnail = imageThumbnail;
    }

    public int getMediaType() {
        return MediaType;
    }

    public void setMediaType(int mediaType) {
        MediaType = mediaType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCourseNumber() {
        return courseNumber;
    }

    public void setCourseNumber(int courseNumber) {
        this.courseNumber = courseNumber;
    }

    public int getCourseDuration() {
        return courseDuration;
    }

    public void setCourseDuration(int courseDuration) {
        this.courseDuration = courseDuration;
    }

    public int getLearningPeopleNumber() {
        return learningPeopleNumber;
    }

    public void setLearningPeopleNumber(int learningPeopleNumber) {
        this.learningPeopleNumber = learningPeopleNumber;
    }

    public boolean isCollect() {
        return isCollect;
    }

    public void setCollect(boolean collect) {
        isCollect = collect;
    }

    public boolean isPass() {
        return isPass;
    }

    public void setPass(boolean pass) {
        isPass = pass;
    }

    public int getImageThumbnail() {
        return ImageThumbnail;
    }

    public void setImageThumbnail(int imageThumbnail) {
        ImageThumbnail = imageThumbnail;
    }
}
