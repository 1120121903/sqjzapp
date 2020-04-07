package com.sys8.sqjzapp.utils;

import com.sys8.sqjzapp.R;
import com.sys8.sqjzapp.module.LearningVideoItem;
import com.sys8.sqjzapp.module.LocationItem;
import com.sys8.sqjzapp.module.TimelineItem;

import java.sql.Time;
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

    public static List<TimelineItem> getLearningEducationRvData(){
        List<TimelineItem> mdata = new ArrayList<>();
        //video1
        LearningVideoItem learningVideoItem = new LearningVideoItem(
                R.drawable.legal_test_image,
                "教你学习交通法",
                "为进一步落实开展帮学、帮教、帮困“三帮”活动。为进一步落实开展帮学、帮教、帮困“三帮”活动。为进一步落实开展帮学、帮教、帮困“三帮”活动。",
                23,
                true,
                false
                );
        TimelineItem timelineItem = new TimelineItem(learningVideoItem);
        mdata.add(timelineItem);
        //video2
        learningVideoItem = new LearningVideoItem(
                R.drawable.legal_test_image,
                "教你学习交通法",
                "为进一步落实开展帮学、帮教、帮困“三帮”活动。为进一步落实开展帮学、帮教、帮困“三帮”活动。为进一步落实开展帮学、帮教、帮困“三帮”活动。",
                112,
                false,
                true
        );
        timelineItem = new TimelineItem(learningVideoItem);
        mdata.add(timelineItem);
        //video3
        learningVideoItem = new LearningVideoItem(
                R.drawable.legal_test_image,
                "教你学习交通法",
                "为进一步落实开展帮学、帮教、帮困“三帮”活动。为进一步落实开展帮学、帮教、帮困“三帮”活动。为进一步落实开展帮学、帮教、帮困“三帮”活动。",
                21,
                true,
                false
        );
        timelineItem = new TimelineItem(learningVideoItem);
        mdata.add(timelineItem);
        //video4
        mdata.add(timelineItem);
        //video5
        learningVideoItem = new LearningVideoItem(
                R.drawable.legal_test_image,
                "教你学习交通法",
                "为进一步落实开展帮学、帮教、帮困“三帮”活动。为进一步落实开展帮学、帮教、帮困“三帮”活动。为进一步落实开展帮学、帮教、帮困“三帮”活动。",
                12,
                false,
                false
        );
        timelineItem = new TimelineItem(learningVideoItem);
        mdata.add(timelineItem);
        return mdata;
    }
}
