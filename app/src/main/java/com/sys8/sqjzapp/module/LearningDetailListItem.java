package com.sys8.sqjzapp.module;

public class LearningDetailListItem {
    private int ImageThumbnail;//视频缩略图
    private String title;//标题
    private String content;//内容
    private boolean isStuded;//学习状态 true-已学习   false-未学习
    private boolean isPass;//考试状态  true-已通过  false-未通过
    private String updateTime;//更新时间

    public LearningDetailListItem(int imageThumbnail, String title, String content, String updateTime, boolean isStuded, boolean isPass) {
        this.ImageThumbnail = imageThumbnail;
        this.title = title;
        this.content = content;
        this.isStuded = isStuded;
        this.isPass = isPass;
        this.updateTime = updateTime;
    }

    public int getImageThumbnail() {
        return ImageThumbnail;
    }

    public void setImageThumbnail(int imageThumbnail) {
        ImageThumbnail = imageThumbnail;
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

    public boolean isStuded() {
        return isStuded;
    }

    public void setStuded(boolean studed) {
        isStuded = studed;
    }

    public boolean isPass() {
        return isPass;
    }

    public void setPass(boolean pass) {
        isPass = pass;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }
}
