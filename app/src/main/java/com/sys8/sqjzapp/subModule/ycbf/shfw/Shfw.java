package com.sys8.sqjzapp.subModule.ycbf.shfw;

public class Shfw {
    String title;
    String fbsj;//发布时间
    String content;//内容

    public Shfw(String title, String fbsj, String content) {
        this.title = title;
        this.fbsj = fbsj;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFbsj() {
        return fbsj;
    }

    public void setFbsj(String fbsj) {
        this.fbsj = fbsj;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}


