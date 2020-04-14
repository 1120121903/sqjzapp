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
            add(new Shbz("贫困户春节慰问品申领","每月家庭收入不高于1000元","2020年1月20日","2020-01-10",
                    "为帮助贫困户生活，海淀区学院路司法所将对生活困难的矫正对象发放春节慰问品，请符合条件的社区矫正对象7个工作日内到所在司法所领取","1"));

            add(new Shbz("落实社会保险","每月家庭收入不高于1000元","2020年3月2日","2020-03-30",
                    "人社部门要落实社会保险政策，已参加企业职工基本养老保险并实现再就业或已参加城乡居民基本养老保险的，按规定继续参保缴纳，" +
                            "达到法定退休年龄或养老保险待遇领取年龄的，可按规定领取相应基本养老金，但服刑期间不参与基本养老金调整。" +
                            "社区矫正对象可按规定执行基本医疗保险等有关医疗保障政策，享受相应待遇。符合申领失业保险金条件的社区矫正对象，可按规定享受失业保险待遇。" +
                            "申请截止时间为2020年3月30日。","2"));

            add(new Shbz("贫困户低保补助","每月家庭收入不高于1000元","2020年4月20日","2020-04-10",
                    "为进一步落实开展帮学、帮教、帮困“三帮”活动，海淀区学院路司法所将对生活困难的矫正对象一次性发放补助金2千元，请符合条件的社区矫正对象准备证明材料并及时报名！\n"
                    +"\n需要提交材料如下：\n"  +
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
