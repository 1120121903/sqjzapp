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
            add(new Shfw("1上门免费为市民维修家电服务","2020-2-20日-",
                    "2020年4月30日，96345加盟商家志愿者蔡亚斌师傅，为万达二期的居民提供一对一服务，免费为其维修家电。\n" +"\n"+
                            "联系电话：010-58254154\n" +"\n"+
                            "联系人：张先生"));

            add(new Shfw("2上门免费为市民维修家电服务","2020-3-20",
                    "2020年4月30日，96345加盟商家志愿者蔡亚斌师傅，为万达二期的居民提供一对一服务，免费为其维修家电。\n" +"\n"+
                            "联系电话：010-58254154\n" +"\n"+
                            "联系人：张先生"));

            add(new Shfw("3上门免费为市民维修家电服务","2020-4-20",
                    "2020年4月30日，96345加盟商家志愿者蔡亚斌师傅，为万达二期的居民提供一对一服务，免费为其维修家电。\n" +"\n"+
                            "联系电话：010-58254154\n" +"\n"+
                            "联系人：张先生"));

        }
    };

}
