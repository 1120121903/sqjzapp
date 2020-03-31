package com.sys8.sqjzapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sys8.sqjzapp.R;
import com.sys8.sqjzapp.module.TimelineItem;
import com.sys8.sqjzapp.utils.Constant;

import java.util.List;

public class TimeLineAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    private Context mContext;
    private List<TimelineItem> mdata;

    public TimeLineAdapter(Context mContext, List<TimelineItem> mdata) {
        this.mContext = mContext;
        this.mdata = mdata;
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        switch (viewType){
            case(Constant.ITEM_LOCATION_VIEWTYPE):
                view = LayoutInflater.from(mContext).inflate(R.layout.item_location,parent,false);
                return new LocationViewHolder(view);
            default:throw new IllegalArgumentException();
        }
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
        holder.setData(mdata.get(position));
    }

    @Override
    public int getItemViewType(int position) {
        return mdata.get(position).getViewType();
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
