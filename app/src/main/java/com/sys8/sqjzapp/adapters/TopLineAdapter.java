package com.sys8.sqjzapp.adapters;


import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sys8.sqjzapp.R;
import com.sys8.sqjzapp.main.tztx.Tzxx;
import com.youth.banner.adapter.BannerAdapter;
import com.youth.banner.util.BannerUtils;

import java.util.List;

/**
 * 自定义布局，实现类似1号店、淘宝头条的滚动效果
 */
public class TopLineAdapter extends BannerAdapter<Tzxx, TopLineAdapter.TopLineHolder> {

    public TopLineAdapter(List<Tzxx> mDatas) {
        super(mDatas);
    }

    @Override
    public TopLineHolder onCreateHolder(ViewGroup parent, int viewType) {
        return new TopLineHolder(BannerUtils.getView(parent, R.layout.top_line_item));
    }

    @Override
    public void onBindView(TopLineHolder holder, Tzxx data, int position, int size) {
        holder.message.setText(data.getTitle());
        holder.time.setText(data.getTime());
        holder.content.setText(data.getContent());
    }

    class TopLineHolder extends RecyclerView.ViewHolder {
        public TextView message;
        public TextView time;
        public TextView content;

        public TopLineHolder(@NonNull View view) {
            super(view);
            message=view.findViewById(R.id.home_tztx_message);
            time=view.findViewById(R.id.home_tztx_time);
            content = view.findViewById(R.id.home_tztx_content);
        }
    }
}

