package com.sys8.sqjzapp.utils;

import com.sys8.sqjzapp.R;
import com.sys8.sqjzapp.module.LearningDetailListItem;
import com.sys8.sqjzapp.module.LearningListItem;
import com.sys8.sqjzapp.module.LocationItem;
import com.sys8.sqjzapp.module.TimelineItem;

import java.util.ArrayList;
import java.util.List;

public class DataSource {
    public static List<TimelineItem> getTimelineData(){
        List<TimelineItem> mdata = new ArrayList<>();
        //locationItem1
        LocationItem itemLocation = new LocationItem("2020-01-01 12:00:01"+"\n北京市海淀区太极机械所", R.drawable.location_timeline_imguser);
        TimelineItem locationTimelintItem = new TimelineItem(itemLocation);
        mdata.add(locationTimelintItem);

        //locationItem2
        itemLocation = new LocationItem("2020-02-02 12:00:01"+"\n北京市海淀区十五所社区", R.drawable.location_timeline_imguser);
        locationTimelintItem = new TimelineItem(itemLocation);
        mdata.add(locationTimelintItem);

        //矫正记录1
        itemLocation = new LocationItem("2018年05月25日"+"\n第8次日常报告", R.drawable.ic_chat_gray_24dp);
        locationTimelintItem = new TimelineItem(itemLocation);
        mdata.add(locationTimelintItem);


        //矫正记录2
        itemLocation = new LocationItem("2018年07月26日"+"\n第一次外出请假到辽宁沈阳", R.drawable.ic_local_airport_black_24dp);
        locationTimelintItem = new TimelineItem(itemLocation);
        mdata.add(locationTimelintItem);

        return mdata;
    }

    public static String CurrentLocation = "";

    public static List<TimelineItem> getLearningEducationDetailRvData(){
        List<TimelineItem> mdata = new ArrayList<>();
        //video1
        LearningDetailListItem learningDetailListItem = new LearningDetailListItem(
                R.drawable.legal_test_image_2,
                "教你学习交通法",
                "为进一步落实开展帮学、帮教、帮困“三帮”活动。为进一步落实开展帮学、帮教、帮困“三帮”活动。为进一步落实开展帮学、帮教、帮困“三帮”活动。",
                "2020-01-01",
                true,
                false
                );
        TimelineItem timelineItem = new TimelineItem(learningDetailListItem);
        mdata.add(timelineItem);
        //video2
        learningDetailListItem = new LearningDetailListItem(
                R.drawable.legal_test_image_2,
                "教你学习交通法",
                "为进一步落实开展帮学、帮教、帮困“三帮”活动。为进一步落实开展帮学、帮教、帮困“三帮”活动。为进一步落实开展帮学、帮教、帮困“三帮”活动。",
                "2020-01-03",
                false,
                true
        );
        timelineItem = new TimelineItem(learningDetailListItem);
        mdata.add(timelineItem);
        //video3
        learningDetailListItem = new LearningDetailListItem(
                R.drawable.legal_test_image_2,
                "教你学习交通法",
                "为进一步落实开展帮学、帮教、帮困“三帮”活动。为进一步落实开展帮学、帮教、帮困“三帮”活动。为进一步落实开展帮学、帮教、帮困“三帮”活动。",
                "2020-01-05",
                true,
                false
        );
        timelineItem = new TimelineItem(learningDetailListItem);
        mdata.add(timelineItem);
        //video4
        mdata.add(timelineItem);
        //video5
        learningDetailListItem = new LearningDetailListItem(
                R.drawable.legal_test_image_2,
                "教你学习交通法",
                "为进一步落实开展帮学、帮教、帮困“三帮”活动。为进一步落实开展帮学、帮教、帮困“三帮”活动。为进一步落实开展帮学、帮教、帮困“三帮”活动。",
                "2020-02-01",
                false,
                false
        );
        timelineItem = new TimelineItem(learningDetailListItem);
        mdata.add(timelineItem);
        return mdata;
    }


    public static List<TimelineItem> getLearningEducationListData(){
        List<TimelineItem> mdata = new ArrayList<>();
        //视频
        LearningListItem learningListItem = new LearningListItem(
                Constant.MEDIA_TYPE_VIDEO,
                "一起学宪法",
                12,
                180,
                23,
                true,true,R.drawable.legal_test_image);
        TimelineItem timelineItem = new TimelineItem(learningListItem);
        mdata.add(timelineItem);

        //音频1
        learningListItem = new LearningListItem(
                Constant.MEDIA_TYPE_AUDIO,
                "法律大讲堂第一期",
                15,
                200,
                101,
                true,false);
        timelineItem = new TimelineItem(learningListItem);
        mdata.add(timelineItem);


        //视频2
        learningListItem = new LearningListItem(
                Constant.MEDIA_TYPE_VIDEO,
                "教你交通法",
                15,
                200,
                11,
                true,false,R.drawable.legal_test_image_2);
        timelineItem = new TimelineItem(learningListItem);
        mdata.add(timelineItem);

        //图文
        learningListItem = new LearningListItem(
                Constant.MEDIA_TYPE_PICTURE,
                "酒家醉驾法律常识",
                51,
                false,false,R.drawable.legal_test_image_3);
        timelineItem = new TimelineItem(learningListItem);
        mdata.add(timelineItem);
        //音频2
        learningListItem = new LearningListItem(
                Constant.MEDIA_TYPE_AUDIO,
                "法律大讲堂第二期",
                15,
                200,
                37,
                false,true);
        timelineItem = new TimelineItem(learningListItem);
        mdata.add(timelineItem);
        //音频3
        learningListItem = new LearningListItem(
                Constant.MEDIA_TYPE_AUDIO,
                "法律大讲堂第三期",
                15,
                200,
                32,
                false,false);
        timelineItem = new TimelineItem(learningListItem);
        mdata.add(timelineItem);
        //音频4
        learningListItem = new LearningListItem(
                Constant.MEDIA_TYPE_AUDIO,
                "法律大讲堂第四期",
                15,
                200,
                22,
                false,false);
        timelineItem = new TimelineItem(learningListItem);
        mdata.add(timelineItem);
        //音频5
        learningListItem = new LearningListItem(
                Constant.MEDIA_TYPE_AUDIO,
                "法律大讲堂第五期",
                15,
                180,
                82,
                false,false);
        timelineItem = new TimelineItem(learningListItem);
        mdata.add(timelineItem);

        return mdata;
    }

    public static List<TimelineItem> getLearningEducationListAudioData(){
        List<TimelineItem> mdata = new ArrayList<>();


        //音频1
        LearningListItem learningListItem = new LearningListItem(
                Constant.MEDIA_TYPE_AUDIO,
                "法律大讲堂第一期",
                15,
                200,
                101,
                true,false);
        TimelineItem timelineItem = new TimelineItem(learningListItem);
        mdata.add(timelineItem);

        //音频2
        learningListItem = new LearningListItem(
                Constant.MEDIA_TYPE_AUDIO,
                "法律大讲堂第二期",
                15,
                200,
                37,
                false,true);
        timelineItem = new TimelineItem(learningListItem);
        mdata.add(timelineItem);
        //音频3
        learningListItem = new LearningListItem(
                Constant.MEDIA_TYPE_AUDIO,
                "法律大讲堂第三期",
                15,
                200,
                32,
                false,false);
        timelineItem = new TimelineItem(learningListItem);
        mdata.add(timelineItem);
        //音频4
        learningListItem = new LearningListItem(
                Constant.MEDIA_TYPE_AUDIO,
                "法律大讲堂第四期",
                15,
                200,
                22,
                false,false);
        timelineItem = new TimelineItem(learningListItem);
        mdata.add(timelineItem);
        //音频5
        learningListItem = new LearningListItem(
                Constant.MEDIA_TYPE_AUDIO,
                "法律大讲堂第五期",
                15,
                180,
                82,
                false,false);
        timelineItem = new TimelineItem(learningListItem);
        mdata.add(timelineItem);

        return mdata;
    }

    public static List<TimelineItem> getLearningEducationListVideoData(){
        List<TimelineItem> mdata = new ArrayList<>();
        //视频
        LearningListItem learningListItem = new LearningListItem(
                Constant.MEDIA_TYPE_VIDEO,
                "一起学宪法",
                12,
                180,
                23,
                true,true,R.drawable.legal_test_image);
        TimelineItem timelineItem = new TimelineItem(learningListItem);
        mdata.add(timelineItem);



        //视频2
        learningListItem = new LearningListItem(
                Constant.MEDIA_TYPE_VIDEO,
                "教你交通法",
                15,
                200,
                11,
                true,false,R.drawable.legal_test_image_2);
        timelineItem = new TimelineItem(learningListItem);
        mdata.add(timelineItem);



        return mdata;
    }

    public static List<TimelineItem> getLearningEducationListPictureData(){
        List<TimelineItem> mdata = new ArrayList<>();

        //图文
        LearningListItem learningListItem = new LearningListItem(
                Constant.MEDIA_TYPE_PICTURE,
                "酒家醉驾法律常识",
                51,
                false,false,R.drawable.legal_test_image_3);
        TimelineItem timelineItem = new TimelineItem(learningListItem);
        mdata.add(timelineItem);


        return mdata;
    }
}
