package com.sys8.sqjzapp.adapters;

import android.media.Image;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.sys8.sqjzapp.R;
import com.sys8.sqjzapp.module.LearningListItem;
import com.sys8.sqjzapp.module.TimelineItem;
import com.sys8.sqjzapp.utils.Constant;

public class LearningListViewHolder extends BaseViewHolder {

    private ImageView imageMediaType;//图标-列表多媒体类型
    private TextView tvTitle;//文字-标题
    private TextView tvCourseNumber;//文字-课程集数
    private TextView tvCourseDuration;//文字-课程时间
    private ImageView imagePeopleNumber;//图标-学习人数
    private TextView tvPeopleNumber;//文字-学习人数
    private ImageView imageCollectStatus;//图标-收藏状态
    private TextView tvCollectStatus;//文字-收藏状态
    private ImageView imageVideoThumbnail;//缩略图
    private ImageView imagePass;//图标-角标通过

    public LearningListViewHolder(@NonNull View itemView) {
        super(itemView);
        this.imageMediaType = itemView.findViewById(R.id.image_learning_list_medai_type);
        this.tvTitle = itemView.findViewById(R.id.tv_learning_list_title);
        this.tvCourseNumber = itemView.findViewById(R.id.tv_learning_list_course_number);
        this.tvCourseDuration = itemView.findViewById(R.id.tv_learning_list_course_duration);
        this.imagePeopleNumber = itemView.findViewById(R.id.image_learning_list_people_number);
        this.tvPeopleNumber = itemView.findViewById(R.id.tv_learning_list_people_number);
        this.imageCollectStatus = itemView.findViewById(R.id.imageBt_learning_list_collect_statu);
        this.tvCollectStatus = itemView.findViewById(R.id.tv_learning_list_collect_statu);
        this.imageVideoThumbnail = itemView.findViewById(R.id.image_learning_list_thumbnail);
        this.imagePass = itemView.findViewById(R.id.image_learning_list_pass);
    }

    @Override
    void setData(TimelineItem item) {
        LearningListItem learningListItem = item.getLearningListItem();

        switch(learningListItem.getMediaType()){
            case(Constant.MEDIA_TYPE_VIDEO):
                Glide.with(itemView.getContext()).load(R.drawable.ic_jyxx_video).into(imageMediaType);
                tvCourseNumber.setText("共"+learningListItem.getCourseNumber()+"个视频");
                tvCourseDuration.setText("共"+learningListItem.getCourseDuration()+"分钟");
                Glide.with(itemView.getContext()).load(learningListItem.getImageThumbnail()).into(imageVideoThumbnail);
                break;
            case(Constant.MEDIA_TYPE_AUDIO):
                Glide.with(itemView.getContext()).load(R.drawable.ic_jyxx_audio).into(imageMediaType);
                tvCourseNumber.setText("共"+learningListItem.getCourseNumber()+"个音频");
                tvCourseDuration.setText("共"+learningListItem.getCourseDuration()+"分钟");
                break;
            case (Constant.MEDIA_TYPE_PICTURE):
                Glide.with(itemView.getContext()).load(R.drawable.ic_jyxx_picture).into(imageMediaType);
                Glide.with(itemView.getContext()).load(learningListItem.getImageThumbnail()).into(imageVideoThumbnail);
                break;
        }
        tvTitle.setText(learningListItem.getTitle());
        tvPeopleNumber.setText(learningListItem.getLearningPeopleNumber()+"人已学习");

        if(learningListItem.isCollect()){
            Glide.with(itemView.getContext()).load(R.drawable.ic_learning_education_collect).into(imageCollectStatus);
            tvCollectStatus.setText("已收藏");
        }else{
            Glide.with(itemView.getContext()).load(R.drawable.ic_learning_education_not_collect).into(imageCollectStatus);
            tvCollectStatus.setText("收藏");
        }

        if(learningListItem.isPass()) {
            imagePass.setVisibility(View.VISIBLE);
        }else{
            imagePass.setVisibility(View.GONE);
        }
    }


}
