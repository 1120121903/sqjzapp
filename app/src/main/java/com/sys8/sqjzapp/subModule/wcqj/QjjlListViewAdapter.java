package com.sys8.sqjzapp.subModule.wcqj;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.sys8.sqjzapp.R;

import java.util.List;

import static com.sys8.sqjzapp.utils.DataUtils.getRevertTimeLineData;


public class QjjlListViewAdapter extends BaseAdapter
{
    View view;
    private List<Qjjl> list;
    private LayoutInflater inflater;
    private Activity activity;

    public QjjlListViewAdapter(View view, Context context, List<Qjjl> list, Activity activity)
    {
        this.view = view;
        this.list = getRevertTimeLineData(list);
        this.activity = activity;
        inflater = LayoutInflater.from(context);
    }

    public QjjlListViewAdapter(Context context, List<Qjjl> list, Activity activity)
    {
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
        Qjjl qjjl = (Qjjl) this.getItem(position);

        ViewHolder viewHolder;

        if(convertView == null){
            viewHolder = new ViewHolder();
            convertView = inflater.inflate(R.layout.qjjl_list_item, null);
            viewHolder.qjjl_title = convertView.findViewById(R.id.tv_qjjl_listItem_title);
            viewHolder.qjjl_timeApply = convertView.findViewById(R.id.tv_qjjl_listItem_timeApply);
            viewHolder.qjjl_timeStart =  convertView.findViewById(R.id.tv_qjjl_listItem_time_start);
            viewHolder.qjjl_timeEnd = convertView.findViewById(R.id.tv_qjjl_listItem_time_end);
            viewHolder.qjjl_place = convertView.findViewById(R.id.tv_qjjl_listItem_place);
            viewHolder.qjjl_state = convertView.findViewById(R.id.tv_qjjl_listItem_state);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.qjjl_title.setText(qjjl.getTitle());
        viewHolder.qjjl_timeApply.setText(qjjl.getTimeApply());
        viewHolder.qjjl_timeStart.setText(qjjl.getTimeStart());
        viewHolder.qjjl_timeEnd.setText(qjjl.getTimeEnd());
        viewHolder.qjjl_place.setText(qjjl.getPlace());
        viewHolder.qjjl_state.setText(qjjl.getState());

        return convertView;
    }



    public static class ViewHolder{
        public TextView qjjl_title;
        public TextView qjjl_timeApply;
        public TextView qjjl_timeStart;
        public TextView qjjl_timeEnd;
        public TextView qjjl_place;
        public TextView qjjl_state;
    }
}
