package com.sys8.sqjzapp.adapters;

import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.sys8.sqjzapp.R;
import com.sys8.sqjzapp.module.LearningDetailListItem;
import com.sys8.sqjzapp.module.TimelineItem;

public class LearningDetailListViewHolder extends BaseViewHolder  {

    private ImageView imageVideoThumbnail;//缩略图
    private TextView tvTitle;//标题
    private TextView tvContent;//内容
    private TextView tvStudyStatus;//学习状态
    private TextView tvExamStatus;//考试状态
    private TextView tvUpdateTime;//更细时间

    public LearningDetailListViewHolder(@NonNull View itemView) {
        super(itemView);
        imageVideoThumbnail= itemView.findViewById(R.id.iv_learning_education_video_thumbnail);
        tvTitle = itemView.findViewById(R.id.item_learning__education_video_title);
        tvContent = itemView.findViewById(R.id.tv_item_learning_education_video_content);
        tvStudyStatus = itemView.findViewById(R.id.tv_item_learning_video_detail_study_status);
        tvExamStatus = itemView.findViewById(R.id.tv_learning_education_video_exam_status);
        tvUpdateTime = itemView.findViewById(R.id.tv_item_learning_video_detail_update_time);
    }

    @Override
    void setData(TimelineItem item) {
        LearningDetailListItem learningDetailListItem = item.getLearningDetailListItem();
        //标题
        tvTitle.setText(learningDetailListItem.getTitle());
        //内容
        tvContent.setText(learningDetailListItem.getContent());
        //缩略图
        Glide.with(itemView.getContext()).load(learningDetailListItem.getImageThumbnail()).into(imageVideoThumbnail);
        //更新时间
        tvUpdateTime.setText("更新时间："+learningDetailListItem.getUpdateTime());
        if (learningDetailListItem.isPass()){
            tvExamStatus.setText("考试合格");
            tvExamStatus.setTextColor(Color.parseColor("#388E3C"));
        }else{
            tvExamStatus.setText("未考试");
        }
        if (learningDetailListItem.isStuded()){
            tvStudyStatus.setText("已学习");
        }else{
            tvStudyStatus.setText("未学习");
        }
    }
}
