package com.sys8.sqjzapp.subModule.wcqj;

import java.util.ArrayList;
import java.util.List;

public class QjjlListData {
    /**
     *日常报告数据列表
     */
    public static final List<Qjjl> list_Qjjl=new ArrayList<Qjjl>(){
        {
            add(new Qjjl("张海洋提交的请假","2020-02-04","2020-03-04","2020-03-06",
                    "2天","辽宁省沈阳市和平区新和大街526号","回户籍地办理房屋过户手续","已销假"));
            add(new Qjjl("张海洋提交的请假","2020-03-04","2020-04-04","2020-04-07",
                    "3天","北京市华北计算技术研究所","面试","审批中"));
        }
    };

}
