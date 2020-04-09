package com.sys8.sqjzapp.subModule.zjwbj;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.sys8.sqjzapp.R;
import com.sys8.sqjzapp.subModule.wcqj.Qjjl;

import java.util.List;

import static com.sys8.sqjzapp.utils.DataUtils.getRevertTimeLineData;


public class BjjlListViewAdapter extends BaseAdapter
{
    View view;
    private List<Bjjl> list;
    private LayoutInflater inflater;
    private Activity activity;

    public BjjlListViewAdapter(View view, Context context, List<Bjjl> list, Activity activity)
    {
        this.view = view;
        this.list = getRevertTimeLineData(list);
        this.activity = activity;
        inflater = LayoutInflater.from(context);
    }

    public BjjlListViewAdapter(Context context, List<Bjjl> list, Activity activity)
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
        Bjjl bjjl = (Bjjl) this.getItem(position);

        ViewHolder viewHolder;

        if(convertView == null){
            viewHolder = new ViewHolder();
            convertView = inflater.inflate(R.layout.zjwbj_list_item, null);
            viewHolder.bjjl_timeApply = convertView.findViewById(R.id.tv_zjwbj_listItem_timeApply);
            viewHolder.bjjl_timeStart =  convertView.findViewById(R.id.tv_zjwbj_listItem_time);
            viewHolder.bjjl_state = convertView.findViewById(R.id.tv_zjwbj_listItem_state);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.bjjl_timeApply.setText(bjjl.getTimeApply());
        viewHolder.bjjl_timeStart.setText(bjjl.getTimeStart());
        viewHolder.bjjl_state.setText(bjjl.getState());

        return convertView;
    }



    public static class ViewHolder{
        public TextView bjjl_timeApply;
        public TextView bjjl_timeStart;
        public TextView bjjl_state;
    }
}
