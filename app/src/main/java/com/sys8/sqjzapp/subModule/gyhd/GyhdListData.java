package com.sys8.sqjzapp.subModule.gyhd;

import java.util.ArrayList;
import java.util.List;

public class GyhdListData {

    /**
     *公益活动数据列表
     */
    public static final List<Gyhd> list_Gyhd=new ArrayList<Gyhd>(){
        {
            add(new Gyhd(
                    "学院路清扫街道卫生1",
                    "2020-02-20",
                    "2020年2月25日 8:00",
                    "海淀区学院路居委会",
                    "报名5/5人（已满）",
                    "需自备扫帚、大号垃圾袋等清扫工具，准时到达活动地点，不要迟到！",
                    "已结束"));
            add(new Gyhd(
                    "学院路清扫街道卫生2",
                    "2020-03-20",
                    "2020年3月25日 12:00",
                    "海淀区学院路居委会",
                    "报名5/5人（已满）",
                    "需自备扫帚、大号垃圾袋等清扫工具，准时到达活动地点，不要迟到！",
                    "已结束"));
            add(new Gyhd(
                    "学院路清扫街道卫生3",
                    "2020-04-02",
                    "2020年4月15日 13:00",
                    "海淀区学院路居委会",
                    "报名2/5人（未满）",
                    "需自备扫帚、大号垃圾袋等清扫工具，准时到达活动地点，不要迟到！",
                    "我要报名"));
        }
    };

    /**
     *已报名公益活动数据列表
     */
    public static final List<Gyhd> list_GyhdYbm=new ArrayList<Gyhd>(){
        {
            add(new Gyhd(
                    "学院路清扫街道卫生2",
                    "2020-03-20",
                    "2020年3月25日 12:00",
                    "海淀区学院路居委会",
                    "报名5/5人（已满）",
                    "需自备扫帚、大号垃圾袋等清扫工具，准时到达活动地点，不要迟到！",
                    "已结束"));

        }
    };

}
