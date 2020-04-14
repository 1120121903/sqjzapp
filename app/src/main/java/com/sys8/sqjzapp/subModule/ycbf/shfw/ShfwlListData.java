package com.sys8.sqjzapp.subModule.ycbf.shfw;

import com.sys8.sqjzapp.subModule.ycbf.shbz.Shbz;
import com.sys8.sqjzapp.subModule.ycbf.shbz.ShbzSq;

import java.util.ArrayList;
import java.util.List;

public class ShfwlListData {

    /**
     *社会保障数据列表
     */
    public static final List<Shfw> list_Shfw=new ArrayList<Shfw>(){
        {

            add(new Shfw("2019年第四季度上门免费为市民维修家电服务","2019-10-20",
                    "2019年10月30日，96345加盟商家志愿者蔡亚斌师傅，为万达二期的居民提供一对一服务，免费为其维修家电。\n" +"\n"+
                            "联系电话：010-58254154\n" +"\n"+
                            "联系人：张先生"));

            add(new Shfw("2020年第一季度上门免费为市民维修家电服务","2020-4-20",
                    "2020年5月12日，96345加盟商家志愿者蔡亚斌师傅，为海淀区志新路健翔园小区的居民提供一对一服务，免费为小区居民维修家电。有意者请联系张先生预约。\n" +"\n"+
                            "联系电话：010-58254154\n" +"\n"+
                            "联系人：张先生"));

        }
    };

}
