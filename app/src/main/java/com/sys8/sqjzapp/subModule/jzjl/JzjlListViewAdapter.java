package com.sys8.sqjzapp.subModule.jzjl;

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


public class JzjlListViewAdapter extends BaseAdapter
{
    View view;
    private List<Jzjl> list;
    private LayoutInflater inflater;
    private Activity activity;

    public JzjlListViewAdapter(View view, Context context, List<Jzjl> list, Activity activity)
    {
        this.view = view;
        this.list = getRevertTimeLineData(list);
        this.activity = activity;
        inflater = LayoutInflater.from(context);
    }

    public JzjlListViewAdapter(Context context, List<Jzjl> list, Activity activity)
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
        Jzjl jzjl = (Jzjl) this.getItem(position);

        ViewHolder viewHolder;

        if(convertView == null){
            viewHolder = new ViewHolder();
            convertView = inflater.inflate(R.layout.jzjl_item, null);
            viewHolder.jzjl_date = convertView.findViewById(R.id.tv_jzjl_date);
            viewHolder.jzjl_act =  convertView.findViewById(R.id.tv_jzjl_act);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.jzjl_date.setText(jzjl.getDate());
        viewHolder.jzjl_act.setText(jzjl.getAct());

        return convertView;
    }

    public static class ViewHolder{
        public TextView jzjl_date;
        public TextView jzjl_act;
    }
}
