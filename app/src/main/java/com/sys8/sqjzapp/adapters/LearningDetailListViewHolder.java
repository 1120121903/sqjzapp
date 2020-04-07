package com.sys8.sqjzapp.adapters;

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
    private ImageView imageNumber;//学习图标
    private TextView tvNumber;//学习人数
    private ImageView imageCollectStatus;//图标-收藏状态
    private TextView tvCollectStatus;//收藏状态
    private ImageView imagePass;//通过图标

    public LearningDetailListViewHolder(@NonNull View itemView) {
        super(itemView);
        imageVideoThumbnail= itemView.findViewById(R.id.iv_learning_education_video_thumbnail);
        tvTitle = itemView.findViewById(R.id.item_learning__education_video_title);
        tvContent = itemView.findViewById(R.id.tv_item_learning_education_video_content);
        tvNumber = itemView.findViewById(R.id.tv_item_learning_video_number);
        imageCollectStatus = itemView.findViewById(R.id.ibt_item_learning_video_collect_statu);
        tvCollectStatus = itemView.findViewById(R.id.tv_learning_education_video_collect_statu);
        imagePass = itemView.findViewById(R.id.item_learning_education_video_pass);
        imageNumber=itemView.findViewById(R.id.iv_item_learning_video_number);
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
        //学习人数
        Glide.with(itemView.getContext()).load(R.drawable.ic_learning_education_number).into(imageNumber);
        tvNumber.setText(learningDetailListItem.getLearningNumber()+"人已学习");
        //收藏状态
        if(learningDetailListItem.isCollect()){
            Glide.with(itemView.getContext()).load(R.drawable.ic_learning_education_collect).into(imageCollectStatus);
            tvCollectStatus.setText("已收藏");
        }else{
            Glide.with(itemView.getContext()).load(R.drawable.ic_learning_education_not_collect).into(imageCollectStatus);
            tvCollectStatus.setText("收藏");
        }
        //通过状态
        if(learningDetailListItem.isPass()){
            imagePass.setVisibility(View.VISIBLE);
        }else{
            imagePass.setVisibility(View.GONE);
        }

    }
}
