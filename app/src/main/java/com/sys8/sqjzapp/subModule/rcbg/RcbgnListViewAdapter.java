package com.sys8.sqjzapp.subModule.rcbg;

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


public class RcbgnListViewAdapter extends BaseAdapter {

    View view;
    private List<Rcbg> list;
    private LayoutInflater inflater;
    private Activity activity;

    public RcbgnListViewAdapter(View view, Context context, List<Rcbg> list, Activity activity)
    {
        this.view = view;
        this.list = getRevertTimeLineData(list);
        this.activity = activity;
        inflater = LayoutInflater.from(context);
    }

    public RcbgnListViewAdapter( Context context, List<Rcbg> list, Activity activity)
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
        Rcbg rcbg = (Rcbg) this.getItem(position);

        ViewHolder viewHolder;

        if(convertView == null){
            viewHolder = new ViewHolder();
            convertView = inflater.inflate(R.layout.rcbg_list_item, null);
            viewHolder.rcbg_title = convertView.findViewById(R.id.tv_rcbg_listItem_title);
            viewHolder.rcbg_time = convertView.findViewById(R.id.tv_rcbg_listItem_time);
            viewHolder.rcbg_place =  convertView.findViewById(R.id.tv_rcbg_listItem_place);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.rcbg_title.setText(rcbg.getTitle());
        viewHolder.rcbg_time.setText(rcbg.getTime());
        viewHolder.rcbg_place.setText(rcbg.getPlace());
        return convertView;
    }
    public static class ViewHolder{
        public TextView rcbg_title;
        public TextView rcbg_time;
        public TextView rcbg_place;
    }
}
