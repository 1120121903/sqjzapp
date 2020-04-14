package com.sys8.sqjzapp.subModule.jstx;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.sys8.sqjzapp.R;

import java.util.ArrayList;
import java.util.List;

public class JstxListData {
    public static final List<Jstx> list_Jstx=new ArrayList<Jstx>(){
        {
            add(new Jstx(
                    "矫正小组",
                    R.drawable.ic_jstx_head0,
                    "学院路司法所"));
            add(new Jstx(
                    "张黎明警官",
                    R.drawable.ic_jstx_head2,
                    "学院路司法所"));
            add(new Jstx(
                    "孙晓丽警官",
                    R.drawable.ic_jstx_head1,
                    "学院路司法所"));
            add(new Jstx(
                    "葛建设警官",
                    R.drawable.ic_jstx_head2,
                    "学院路司法所"));
        }
    };
}
