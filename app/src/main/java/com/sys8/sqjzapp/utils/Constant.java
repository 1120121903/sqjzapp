package com.sys8.sqjzapp.utils;

import android.graphics.Bitmap;

import com.sys8.sqjzapp.R;

public class Constant {
    //RecyclerView-ViewType
    public static final int ITEM_LOCATION_VIEWTYPE=0;
    public static final int ITEM_EDUCATION_LEARNING_VIDEO_DETAIL_LIST =1;
    public static final int ITEM_EDUCATION_LEARNING_LIST=2;
    public static final int ITEM_EDUCATION_LEARNING_AUDIO_DETAIL_LIST =3;


    public static String USER_NAME = "张海洋";

    public static String CURRENT_LOCATION = "北京市海淀区华北所科技大厦";

    //教育学习，多媒体类型
    public static final int MEDIA_TYPE_ALLMEDIA=0;//全部
    public static final int MEDIA_TYPE_VIDEO=1;//视频
    public static final int MEDIA_TYPE_AUDIO=2;//音频
    public static final int MEDIA_TYPE_PICTURE=3;//图文

    //远程帮扶
    public static String[] topTabs_ycbf = new String[]{"社会保障","便民服务","生活服务","就业服务"};
    public static String STATE_YCBF_SHBZ_YBM = "1";

    //公益活动
    public static String[] topTabs_gyhd = new String[]{"活动列表","已参加"};
    public static String STATE_GYHD = "我要报名";

    //暂监外病检
    public static String[] topTabs_zjwbj = new String[]{"每月健康上报","季度病检上报","上报申请"};

    //通知提醒
    public static String STATE_TZTX_YD = "1";//已读

    //头像
    public static Bitmap userBitMap = null;
    public static Bitmap userCircleBitmap = null;

}
