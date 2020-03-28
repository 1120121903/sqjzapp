package com.sys8.sqjzapp.baseClass;

import android.app.Activity;
import android.view.View;

import com.hjq.bar.OnTitleBarListener;
import com.hjq.bar.TitleBar;

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

    public static void finishAll(){
        for(Activity activity: activities){
            activity.finish();
        }
    }

    /**
     *description:Title返回按钮监听函数
    */
    public static void TitleCilckListener(TitleBar titleBar,Activity activity){
        titleBar.setOnTitleBarListener(new OnTitleBarListener() {
            @Override
            public void onLeftClick(View v) {
                activity.finish();
            }
            @Override
            public void onTitleClick(View v) { }
            @Override
            public void onRightClick(View v) { }});
    }

}
