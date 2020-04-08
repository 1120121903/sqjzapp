package com.sys8.sqjzapp.subModule.gyhd;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.sys8.sqjzapp.R;

import java.util.List;

import static com.sys8.sqjzapp.utils.Constant.STATE_GYHD;
import static com.sys8.sqjzapp.utils.DataUtils.getRevertTimeLineData;


public class GyhdListViewAdapter extends BaseAdapter
{
    View view;
    private List<Gyhd> list;
    private LayoutInflater inflater;
    private Activity activity;

    public GyhdListViewAdapter(View view, Context context, List<Gyhd> list, Activity activity)
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
        Gyhd gyhd = (Gyhd) this.getItem(position);

        ViewHolder viewHolder;

        if(convertView == null){
            viewHolder = new ViewHolder();
            convertView = inflater.inflate(R.layout.frag_gyhd_list_item, null);
            viewHolder.gyhd_title = convertView.findViewById(R.id.tv_gyhd_listItem_title);
            viewHolder.gyhd_fbsj = convertView.findViewById(R.id.tv_gyhd_listItem_fbsj);
            viewHolder.gyhd_kssj =  convertView.findViewById(R.id.tv_gyhd_listItem_kssj);
            viewHolder.gyhd_hddd =  convertView.findViewById(R.id.tv_gyhd_listItem_hddd);
            viewHolder.gyhd_bmrs =  convertView.findViewById(R.id.tv_gyhd_listItem_bmrs);
            viewHolder.gyhd_state =  convertView.findViewById(R.id.tv_gyhd_listItem_state);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.gyhd_title.setText(gyhd.getTitle());
        viewHolder.gyhd_fbsj.setText(gyhd.getFbsj());
        viewHolder.gyhd_kssj.setText(gyhd.getKssj());
        viewHolder.gyhd_hddd.setText(gyhd.getHddd());
        viewHolder.gyhd_bmrs.setText(gyhd.getBmrs());
        viewHolder.gyhd_state.setText(gyhd.getState());
        if(gyhd.getState().equals(STATE_GYHD)){
            viewHolder.gyhd_state.setTextColor(activity.getResources().getColor(R.color.blue1));
        }else{
            viewHolder.gyhd_state.setTextColor(activity.getResources().getColor(R.color.black));
        }
        return convertView;
    }

    public static class ViewHolder{
        public TextView gyhd_title;
        public TextView gyhd_fbsj;
        public TextView gyhd_kssj;
        public TextView gyhd_hddd;
        public TextView gyhd_bmrs;
        public TextView gyhd_state;
    }
}
