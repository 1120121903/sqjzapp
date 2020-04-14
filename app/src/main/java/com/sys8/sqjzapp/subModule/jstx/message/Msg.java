package com.sys8.sqjzapp.subModule.jstx.message;

public class Msg {
    public static final int TYPE_RECEIVE =0;
    public static final int TYPE_SENT =1;
    private String content;
    private int fromHead;
    private  int type;

    public Msg(String content,int fromHead,int type){
        this.content = content;
        this.fromHead = fromHead;
        this.type = type;
    }

    public int getFromHead() {
        return fromHead;
    }

    public void setFromHead(int fromHead) {
        this.fromHead = fromHead;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
