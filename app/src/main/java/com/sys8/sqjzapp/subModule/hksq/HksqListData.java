package com.sys8.sqjzapp.subModule.hksq;

import java.util.ArrayList;
import java.util.List;

public class HksqListData {

    /**
     *会客申请数据列表
     */
    public static final List<Hksq> list_Hksq=new ArrayList<Hksq>(){
        {
            add(new Hksq("张海洋提交的会客申请","2020-02-04","2020-03-04","张三",
                    "辽宁省沈阳市和平区新和大街526号","工作需要","已提交"));
            add(new Hksq("张海洋提交的会客申请","2020-03-04","2020-04-04","李四",
                    "辽宁省沈阳市和平区新和大街526号", "工作需要","审批中"));
        }
    };

}
