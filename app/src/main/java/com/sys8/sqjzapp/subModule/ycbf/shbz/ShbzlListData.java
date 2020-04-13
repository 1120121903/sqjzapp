package com.sys8.sqjzapp.subModule.ycbf.shbz;

import com.sys8.sqjzapp.R;
import com.sys8.sqjzapp.module.LocationItem;
import com.sys8.sqjzapp.module.TimelineItem;
import com.sys8.sqjzapp.subModule.wcqj.QjState;
import com.sys8.sqjzapp.subModule.wcqj.Qjjl;

import java.util.ArrayList;
import java.util.List;

public class ShbzlListData {

    /**
     *社会保障数据列表
     */
    public static final List<Shbz> list_Shbz=new ArrayList<Shbz>(){
        {
            add(new Shbz("贫困低保补助1","每月家庭收入不高于1000元","2020年2月20日","2020-02-10",
                    "为进一步落实开展帮学、帮教、帮困“三帮”活动，海淀区学院路司法所将对生活困难的矫正对象一次性发放补助金2千元，请符合条件的社区矫正对象准备证明材料并及时报名！","1"));

            add(new Shbz("贫困低保补助2","每月家庭收入不高于1000元","2020年4月20日","2020-03-10",
                    "为进一步落实开展帮学、帮教、帮困“三帮”活动，海淀区学院路司法所将对生活困难的矫正对象一次性发放补助金2千元，请符合条件的社区矫正对象准备证明材料并及时报名！","0"));

            add(new Shbz("贫困户低保补助","每月家庭收入不高于1000元","2020年4月20日","2020-04-10",
                    "为进一步落实开展帮学、帮教、帮困“三帮”活动，海淀区学院路司法所将对生活困难的矫正对象一次性发放补助金2千元，请符合条件的社区矫正对象准备证明材料并及时报名！\n"
                    +"需要提交材料如下：\n" + "\n" +
                            "1、矫正对象及家属收入证明；\n" +
                            "2、矫正对象及家属身份证复印件；\n" +
                            "3、社区矫正对象户口本复印件。\n","0"));
        }
    };

    /**
     *已申请社会保障
     */
    public static final List<Shbz> list_ShbzYsq=new ArrayList<Shbz>(){
        {
            add(list_Shbz.get(0));
        }
    };

}
