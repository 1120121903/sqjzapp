package com.sys8.sqjzapp.subModule.zjwbj.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.sys8.sqjzapp.R;
import com.sys8.sqjzapp.subModule.zjwbj.data.Bjjl;
import com.sys8.sqjzapp.subModule.zjwbj.delayApplyList.DelayApply;

import java.util.List;

import static com.sys8.sqjzapp.utils.DataUtils.getRevertTimeLineData;


public class DelayApplyListViewAdapter extends BaseAdapter
{
    View view;
    private List<Bjjl> list;
    private LayoutInflater inflater;
    private Activity activity;

    public DelayApplyListViewAdapter(View view, Context context, List<Bjjl> list, Activity activity)
    {
        this.view = view;
        this.list = getRevertTimeLineData(list);
        this.activity = activity;
        inflater = LayoutInflater.from(context);
    }

    public DelayApplyListViewAdapter(Context context, List<DelayApply> list, Activity activity)
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
        DelayApply delayApply = (DelayApply) this.getItem(position);

        ViewHolder viewHolder;

        if(convertView == null){
            viewHolder = new ViewHolder();
            convertView = inflater.inflate(R.layout.zjwbj_delay_list_item, null);
            viewHolder.delayApply_timeApply = convertView.findViewById(R.id.tv_zjwbj_delay_listItem_timeApply);
            viewHolder.delayApply_timeDelay =  convertView.findViewById(R.id.tv_zjwbj_delay_listItem_timeDelay);
            viewHolder.delayApply_reasonDelay = convertView.findViewById(R.id.tv_zjwbj_delay_listItem_reasonDelay);
            viewHolder.delayApply_state = convertView.findViewById(R.id.tv_zjwbj_delay_listItem_stateDelay);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.delayApply_timeApply.setText(delayApply.getTimeApply());
        viewHolder.delayApply_timeDelay.setText(delayApply.getTimeDelay());
        viewHolder.delayApply_reasonDelay.setText(delayApply.getReasonDelay());
        viewHolder.delayApply_state.setText(delayApply.getState());

        return convertView;
    }



    public static class ViewHolder{
        public TextView delayApply_timeApply;
        public TextView delayApply_timeDelay;
        public TextView delayApply_reasonDelay;
        public TextView delayApply_state;
    }
}
