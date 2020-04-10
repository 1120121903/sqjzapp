package com.sys8.sqjzapp.main.tztx;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.sys8.sqjzapp.R;
import java.util.List;

import static com.sys8.sqjzapp.utils.Constant.STATE_TZTX_YD;
import static com.sys8.sqjzapp.utils.DataUtils.getRevertTimeLineData;

public class TztxListViewAdapter extends BaseAdapter
{
    View view;
    private List<Tzxx> list;
    private LayoutInflater inflater;
    private Activity activity;

    public TztxListViewAdapter(View view, Context context, List<Tzxx> list, Activity activity)
    {
        this.view = view;
        this.list = getRevertTimeLineData(list);
        this.activity = activity;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount()
    {
        int ret = 0;
        if(list!=null){
            ret = list.size();
        }
        return ret;
    }

    @Override
    public Object getItem(int position)
    {
        return list.get(position);
    }

    @Override
    public long getItemId(int position)
    {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        Tzxx tzxx = (Tzxx) this.getItem(position);

        ViewHolder viewHolder;

        if(convertView == null){
            viewHolder = new ViewHolder();
            convertView = inflater.inflate(R.layout.tzxx_list_item, null);
            viewHolder.tztx_title = convertView.findViewById(R.id.iv_tztx_title);
            viewHolder.tztx_type = convertView.findViewById(R.id.tv_tztx_type);
            viewHolder.tztx_time = convertView.findViewById(R.id.tv_tztx_time);
            viewHolder.tztx_cotent =  convertView.findViewById(R.id.tv_tztx_cotent);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.tztx_type.setText(tzxx.getType());
        viewHolder.tztx_time.setText(tzxx.getTime());
        viewHolder.tztx_cotent.setText(tzxx.getContent());
        if(tzxx.getType().substring(0,2).equals("通知")){
            if(tzxx.getState().equals(STATE_TZTX_YD)){
                viewHolder.tztx_title.setBackground(activity.getDrawable(R.drawable.ic_tztx_tz_yd));
                viewHolder.tztx_type.setTextColor(activity.getColor(R.color.colorFontGray));
            }else{
                viewHolder.tztx_title.setBackground(activity.getDrawable(R.drawable.ic_tztx_tz));
            }
        }else {
            if(tzxx.getState().equals(STATE_TZTX_YD)){
                viewHolder.tztx_type.setTextColor(activity.getColor(R.color.colorFontGray));
                viewHolder.tztx_title.setBackground(activity.getDrawable(R.drawable.ic_tztx_tx_yd));
            }else{
                viewHolder.tztx_title.setBackground(activity.getDrawable(R.drawable.ic_tztx_tx));
            }
        }
        return convertView;
    }
    public static class ViewHolder{
        public ImageView tztx_title;
        public TextView tztx_type;
        public TextView tztx_time;
        public TextView tztx_cotent;
    }
}
