package com.sys8.sqjzapp.subModule.hksq;

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


public class HksqListViewAdapter extends BaseAdapter
{
    View view;
    private List<Hksq> list;
    private LayoutInflater inflater;
    private Activity activity;

    public HksqListViewAdapter(View view, Context context, List<Hksq> list, Activity activity)
    {
        this.view = view;
        this.list = getRevertTimeLineData(list);
        this.activity = activity;
        inflater = LayoutInflater.from(context);
    }

    public HksqListViewAdapter(Context context, List<Hksq> list, Activity activity)
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
        Hksq hksq = (Hksq) this.getItem(position);

        ViewHolder viewHolder;

        if(convertView == null){
            viewHolder = new ViewHolder();
            convertView = inflater.inflate(R.layout.hksq_list_item, null);
            viewHolder.hksq_title = convertView.findViewById(R.id.tv_hksq_listItem_title);
            viewHolder.hksq_timeApply = convertView.findViewById(R.id.tv_hksq_listItem_timeApply);
            viewHolder.hksq_time =  convertView.findViewById(R.id.tv_hksq_listItem_time);
            viewHolder.hksq_name = convertView.findViewById(R.id.tv_hksq_listItem_name);
            viewHolder.hksq_place = convertView.findViewById(R.id.tv_hksq_listItem_place);
            viewHolder.hksq_state = convertView.findViewById(R.id.tv_hksq_listItem_state);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.hksq_title.setText(hksq.getTitle());
        viewHolder.hksq_timeApply.setText(hksq.getTimeApply());
        viewHolder.hksq_time.setText(hksq.getTime());
        viewHolder.hksq_name.setText(hksq.getName());
        viewHolder.hksq_place.setText(hksq.getPlace());
        viewHolder.hksq_state.setText(hksq.getState());

        return convertView;
    }



    public static class ViewHolder{
        public TextView hksq_title;
        public TextView hksq_timeApply;
        public TextView hksq_time;
        public TextView hksq_name;
        public TextView hksq_place;
        public TextView hksq_state;
    }
}
