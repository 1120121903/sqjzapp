package com.sys8.sqjzapp.adapters;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sys8.sqjzapp.module.TimelineItem;

public abstract class BaseViewHolder extends RecyclerView.ViewHolder {

    abstract void setData(TimelineItem item);

    public BaseViewHolder(@NonNull View itemView) {
        super(itemView);
    }
}
