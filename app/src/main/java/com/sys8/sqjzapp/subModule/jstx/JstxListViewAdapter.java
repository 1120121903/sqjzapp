package com.sys8.sqjzapp.subModule.jstx;

import android.app.Activity;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.sys8.sqjzapp.R;

import java.util.List;

public class JstxListViewAdapter extends BaseAdapter
{
    View view;
    private List<Jstx> list;
    private LayoutInflater inflater;
    private Activity activity;

    public JstxListViewAdapter(View view, Context context, List<Jstx> list, Activity activity)
    {
        this.view = view;
        this.list = list;
        this.activity = activity;
        inflater = LayoutInflater.from(context);
    }

    public JstxListViewAdapter(Context context, List<Jstx> list, Activity activity)
    {
        this.list = list;
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
        Jstx jstx = (Jstx) this.getItem(position);

        ViewHolder viewHolder;

        if(convertView == null){
            viewHolder = new ViewHolder();
            convertView = inflater.inflate(R.layout.jstx_list_item, null);
            viewHolder.jstx_head = convertView.findViewById(R.id.iv_jstx_list_item_head);
            viewHolder.jstx_name = convertView.findViewById(R.id.iv_jstx_list_item_name);
            viewHolder.jstx_dep =  convertView.findViewById(R.id.iv_jstx_list_item_dep);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.jstx_head.setBackground(activity.getDrawable(jstx.getHead()));
        viewHolder.jstx_name.setText(jstx.getName());
        viewHolder.jstx_dep.setText(jstx.getDep());
        return convertView;
    }

    public static class ViewHolder{
        public ImageView jstx_head;
        public TextView jstx_name;
        public TextView jstx_dep;
    }
}
