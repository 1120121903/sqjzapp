package com.sys8.sqjzapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sys8.sqjzapp.R;
import com.sys8.sqjzapp.module.LearningListItem;
import com.sys8.sqjzapp.module.TimelineItem;
import com.sys8.sqjzapp.utils.Constant;

import java.util.List;

import static com.sys8.sqjzapp.utils.Constant.ITEM_EDUCATION_LEARNING_AUDIO_DETAIL_LIST;
import static com.sys8.sqjzapp.utils.Constant.ITEM_EDUCATION_LEARNING_LIST;
import static com.sys8.sqjzapp.utils.Constant.ITEM_EDUCATION_LEARNING_VIDEO_DETAIL_LIST;
import static com.sys8.sqjzapp.utils.Constant.ITEM_LOCATION_VIEWTYPE;
import static com.sys8.sqjzapp.utils.DataSource.mCollectData;

public class TimeLineAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    private Context mContext;
    private List<TimelineItem> mdata;
    private OnItemClickListener mOnItemClickListener;
    public TimeLineAdapter(Context mContext, List<TimelineItem> mdata) {
        this.mContext = mContext;
        this.mdata = mdata;
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        switch (viewType){
            case(ITEM_LOCATION_VIEWTYPE):
                view = LayoutInflater.from(mContext).inflate(R.layout.item_location,parent,false);
                return new LocationViewHolder(view);
            case(ITEM_EDUCATION_LEARNING_VIDEO_DETAIL_LIST):
                view = LayoutInflater.from(mContext).inflate(R.layout.item_learning_list_detail_video,parent,false);
                return new LearningVideoDetailListViewHolder(view);
            case(ITEM_EDUCATION_LEARNING_LIST):
                view = LayoutInflater.from(mContext).inflate(R.layout.item_learning_list,parent,false);
                return new LearningListViewHolder(view);
            case(ITEM_EDUCATION_LEARNING_AUDIO_DETAIL_LIST):
                view = LayoutInflater.from(mContext).inflate(R.layout.item_learning_list_detail_audio,parent,false);
                return new LearningAudioDetailListViewHolder(view);
            default:throw new IllegalArgumentException();
        }

    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
        holder.setData(mdata.get(position));

        View itemView = holder.itemView;

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = holder.getLayoutPosition();
                    if(mOnItemClickListener!=null) {
                        mOnItemClickListener.onItemClick(holder.itemView, position);
                    }
                }
            });


        //教育学习-主列表
        if(getItemViewType(position)==ITEM_EDUCATION_LEARNING_LIST){
            LearningListItem learningListItem = getItem(position).getLearningListItem();
            ImageButton imageCollectStatus = holder.itemView.findViewById(R.id.imageBt_learning_list_collect_statu);
            TextView tvCollectStatu = holder.itemView.findViewById(R.id.tv_learning_list_collect_statu);
            //收藏按钮被点击
            imageCollectStatus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(learningListItem.isCollect()){
                        imageCollectStatus.setImageResource(R.drawable.ic_learning_education_not_collect);
                        tvCollectStatu.setText("收藏");
                        //我的收藏中去除此数据
                        mCollectData.removeIf(
                                item -> item.getLearningListItem().getTitle().equals(learningListItem.getTitle())
                        );
                    }else{
                        imageCollectStatus.setImageResource(R.drawable.ic_learning_education_collect);
                        tvCollectStatu.setText("已收藏");
                        //我的收藏中添加这条数据
                        mCollectData.add(getItem(position));
                    }
                    learningListItem.setCollect(!learningListItem.isCollect());
                }
            });
        }
    }

    @Override
    public int getItemViewType(int position) {
        return mdata.get(position).getViewType();
    }


    public TimelineItem getItem(int position){
        return mdata.get(position);
    }

    /**
     * 点击事件回调接口
     */
    public interface OnItemClickListener{
        void onItemClick(View view,int position);
    }


    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        mOnItemClickListener = onItemClickListener;
    }

    @Override
    public int getItemCount() {
        if(mdata != null){
            return mdata.size();
        }else{
            return 0;
        }
    }
}
