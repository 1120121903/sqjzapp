package com.sys8.sqjzapp.subModule.jstx;

import android.graphics.Bitmap;

public class Jstx {
    String name;
    int head;
    String dep;

    public Jstx(String name,int head,String dep){
        this.head = head;
        this.name = name;
        this.dep = dep;
    }

    public int getHead() {
        return head;
    }

    public void setHead(int head) {
        this.head = head;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDep() {
        return dep;
    }

    public void setDep(String dep) {
        this.dep = dep;
    }
}
