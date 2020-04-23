package com.sys8.sqjzapp.subModule.tdqy;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.sys8.sqjzapp.R;

import java.util.List;

import static com.sys8.sqjzapp.utils.DataUtils.getRevertTimeLineData;


public class TdqyListViewAdapter extends BaseAdapter
{
    View view;
    private List<Tdqy> list;
    private LayoutInflater inflater;
    private Activity activity;

    public TdqyListViewAdapter(View view, Context context, List<Tdqy> list, Activity activity)
    {
        this.view = view;
        this.list = getRevertTimeLineData(list);
        this.activity = activity;
        inflater = LayoutInflater.from(context);
    }

    public TdqyListViewAdapter(Context context, List<Tdqy> list, Activity activity)
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
        Tdqy tdqy = (Tdqy) this.getItem(position);

        ViewHolder viewHolder;

        if(convertView == null){
            viewHolder = new ViewHolder();
            convertView = inflater.inflate(R.layout.tdqy_list_item, null);
            viewHolder.tdqy_title = convertView.findViewById(R.id.tv_tdqy_listItem_title);
            viewHolder.tdqy_timeApply = convertView.findViewById(R.id.tv_tdqy_listItem_timeApply);
            viewHolder.tdqy_timeStart =  convertView.findViewById(R.id.tv_tdqy_listItem_jrsj);
            viewHolder.tdqy_reason = convertView.findViewById(R.id.tv_tdqy_listItem_reason);
            viewHolder.tdqy_state = convertView.findViewById(R.id.tv_tdqy_listItem_state);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.tdqy_title.setText(tdqy.getTitle());
        viewHolder.tdqy_timeApply.setText(tdqy.getTimeApply());
        viewHolder.tdqy_timeStart.setText(tdqy.getTimeStart()+"至"+tdqy.getTimeEnd());
        viewHolder.tdqy_reason.setText(tdqy.getReason());
        viewHolder.tdqy_state.setText(tdqy.getState());

        return convertView;
    }



    public static class ViewHolder{
        public TextView tdqy_title;
        public TextView tdqy_timeApply;
        public TextView tdqy_timeStart;
        public TextView tdqy_timeEnd;
        public TextView tdqy_reason;
        public TextView tdqy_state;
    }
}
