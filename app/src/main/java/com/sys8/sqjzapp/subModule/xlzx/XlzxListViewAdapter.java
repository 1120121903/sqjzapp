package com.sys8.sqjzapp.subModule.xlzx;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.sys8.sqjzapp.R;
import com.sys8.sqjzapp.subModule.jzdbg.Jzdbg;

import java.util.List;

import static com.sys8.sqjzapp.utils.DataUtils.getRevertTimeLineData;


public class XlzxListViewAdapter extends BaseAdapter
{
    View view;
    private List<Xlzx> list;
    private LayoutInflater inflater;
    private Activity activity;

    public XlzxListViewAdapter(View view, Context context, List<Xlzx> list, Activity activity)
    {
        this.view = view;
        this.list = getRevertTimeLineData(list);
        this.activity = activity;
        inflater = LayoutInflater.from(context);
    }

    public XlzxListViewAdapter(Context context, List<Xlzx> list, Activity activity)
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
        Xlzx xlzx = (Xlzx) this.getItem(position);

        ViewHolder viewHolder;

        if(convertView == null){
            viewHolder = new ViewHolder();
            convertView = inflater.inflate(R.layout.xlzx_list_item, null);
            viewHolder.xlzx_head = convertView.findViewById(R.id.iv_xlzx_head);
            viewHolder.xlzx_name =  convertView.findViewById(R.id.tv_xlzx_name);
            viewHolder.xlzx_zc = convertView.findViewById(R.id.tv_xlzx_zc);
            viewHolder.xlzx_des = convertView.findViewById(R.id.tv_xlzx_des);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.xlzx_head.setImageDrawable(activity.getDrawable(xlzx.getHead()));
        viewHolder.xlzx_name.setText(xlzx.getName());
        viewHolder.xlzx_zc.setText(xlzx.getZc());
        viewHolder.xlzx_des.setText(xlzx.getDes());

        return convertView;
    }

    public static class ViewHolder{
        public ImageView xlzx_head;
        public TextView xlzx_name;
        public TextView xlzx_zc;
        public TextView xlzx_des;
    }
}
