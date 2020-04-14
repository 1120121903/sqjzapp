package com.sys8.sqjzapp.adapters;

import android.graphics.Color;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.sys8.sqjzapp.R;
import com.sys8.sqjzapp.module.LearningAudioDetailListItem;
import com.sys8.sqjzapp.module.LearningVideoDetailListItem;
import com.sys8.sqjzapp.module.TimelineItem;

public class LearningAudioDetailListViewHolder extends BaseViewHolder {
    private TextView tvTitle;//标题
    private TextView tvContent;//内容
    private TextView tvStudyStatus;//学习状态
    private TextView tvExamStatus;//考试状态
    private TextView tvUpdateTime;//更细时间

    public LearningAudioDetailListViewHolder(@NonNull View itemView) {
        super(itemView);
        tvTitle = itemView.findViewById(R.id.item_learning__education_audio_title);
        tvContent = itemView.findViewById(R.id.tv_item_learning_education_audio_content);
        tvStudyStatus = itemView.findViewById(R.id.tv_item_learning_audio_detail_study_status);
        tvExamStatus = itemView.findViewById(R.id.tv_learning_education_audio_exam_status);
        tvUpdateTime = itemView.findViewById(R.id.tv_item_learning_audio_detail_update_time);
    }


    @Override
    void setData(TimelineItem item) {
        LearningAudioDetailListItem learningAudioDetailListItem = item.getLearningAudioDetailListItem();
        //标题
        tvTitle.setText(learningAudioDetailListItem.getTitle());
        //内容
        tvContent.setText(learningAudioDetailListItem.getContent());
           //更新时间
        tvUpdateTime.setText("更新时间："+ learningAudioDetailListItem.getUpdateTime());
        if (learningAudioDetailListItem.isPass()){
            tvExamStatus.setText("考试合格");
            tvExamStatus.setTextColor(Color.parseColor("#388E3C"));
        }else{
            tvExamStatus.setText("未考试");
        }
        if (learningAudioDetailListItem.isStuded()){
            tvStudyStatus.setText("已学习");
        }else{
            tvStudyStatus.setText("未学习");
        }
    }
}
