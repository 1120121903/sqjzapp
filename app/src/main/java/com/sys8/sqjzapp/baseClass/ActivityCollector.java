package com.sys8.sqjzapp.baseClass;

import android.app.Activity;
import java.util.ArrayList;
import java.util.List;

/**
 *date:2019/11/28
 *author:wy
 *description:对所有活动进行管理
*/
public class ActivityCollector {

    public static List<Activity> activities = new ArrayList<>();

    public static void addActivity(Activity activity){
        activities.add(activity);
    }

    public  static void removeActivity(Activity activity){
        activities.remove(activity);
    }
}
