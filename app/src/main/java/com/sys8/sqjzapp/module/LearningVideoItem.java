package com.sys8.sqjzapp.module;

public class LearningVideoItem {
    private int ImageVideoThumbnail;//视频缩略图
    private String title;//标题
    private String content;//内容
    private int learningNumber;//学习人数
    private boolean isCollect;//收藏状态 true-已收藏   false-为收藏
    private boolean isPass;//通过状态  true-已通过  false-未通过

    public LearningVideoItem(int imageVideoThumbnail, String title, String content,int learningNumber, boolean isCollect, boolean isPass) {
        ImageVideoThumbnail = imageVideoThumbnail;
        this.learningNumber = learningNumber;
        this.title = title;
        this.content = content;
        this.isCollect = isCollect;
        this.isPass = isPass;
    }

    public int getLearningNumber() {
        return learningNumber;
    }

    public void setLearningNumber(int learningNumber) {
        this.learningNumber = learningNumber;
    }

    public int getImageVideoThumbnail() {
        return ImageVideoThumbnail;
    }

    public void setImageVideoThumbnail(int imageVideoThumbnail) {
        ImageVideoThumbnail = imageVideoThumbnail;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        if(content.length()>41){
            content = content.substring(0,40)+"……";
        }
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
}
