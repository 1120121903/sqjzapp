package com.sys8.sqjzapp.subModule.ycbf.jyfw;

public class Jyfw {
    String title;
    String fbsj;//发布时间
    String jzsj;//截止时间
    String xzfw;//薪资范围
    String zprs;//招聘人数
    String gzdd;//工作地点
    String gwms;//岗位描述
    String gwyq;//岗位要求

    public Jyfw(String title, String fbsj, String jzsj,String xzfw,String zprs,String gzdd,String gwms,String gwyq) {
        this.title = title;
        this.fbsj = fbsj;
        this.jzsj = jzsj;
        this.xzfw = xzfw;
        this.zprs = zprs;
        this.gzdd = gzdd;
        this.gwms = gwms;
        this.gwyq = gwyq;
    }

    public Jyfw(){}

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

    public String getJzsj() {
        return jzsj;
    }

    public void setJzsj(String jzsj) {
        this.jzsj = jzsj;
    }

    public String getXzfw() {
        return xzfw;
    }

    public void setXzfw(String xzfw) {
        this.xzfw = xzfw;
    }

    public String getZprs() {
        return zprs;
    }

    public void setZprs(String zprs) {
        this.zprs = zprs;
    }

    public String getGzdd() {
        return gzdd;
    }

    public void setGzdd(String gzdd) {
        this.gzdd = gzdd;
    }

    public String getGwms() {
        return gwms;
    }

    public void setGwms(String gwms) {
        this.gwms = gwms;
    }

    public String getGwyq() {
        return gwyq;
    }

    public void setGwyq(String gwyq) {
        this.gwyq = gwyq;
    }
}


