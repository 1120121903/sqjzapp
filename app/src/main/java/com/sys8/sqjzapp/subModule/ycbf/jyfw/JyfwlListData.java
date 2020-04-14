package com.sys8.sqjzapp.subModule.ycbf.jyfw;

import java.util.ArrayList;
import java.util.List;

public class JyfwlListData {

    /**
     *社会保障数据列表
     */
    public static final List<Jyfw> list_Jyfw=new ArrayList<Jyfw>(){
        {
            add(new Jyfw(
                    "幸福小区招聘门卫",
                    "2020-2-20",
                    "2020年3月20日",
                    "2000-4000元",
                    "2人",
                    "北京海淀",
                    "门卫\n",
                    "1.30-40岁，男性\n" +"\n"+
                            "2.认真负责\n" +"\n"+
                            "3.身体素质高\n"));
            add(new Jyfw(
                    "我爱我家招聘门店经理",
                    "2020-3-20",
                    "2020年4月20日",
                    "6000-12000元",
                    "1人",
                    "北京海淀",
                    "房屋销售\n",
                    "1.全日制本科及以上学历，23-30岁，性别不限\n" +"\n"+
                            "2.为人善良，诚实，工作认真有良好的团队协调能力\n"));
            add(new Jyfw(
                    "链家招聘销售精英",
                    "2020-4-3",
                    "2020年5月20日",
                    "5000-10000元",
                    "5人",
                    "北京海淀",
                    "房屋销售\n",
                    "1.全日制本科及以上学历，23-30岁，性别不限\n" +"\n"+
                            "2.为人善良，诚实，工作认真\n" +"\n"+
                            "3.抗压能力强\n"));

        }
    };

}
