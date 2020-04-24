package com.sys8.sqjzapp.subModule.jzdbg;

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


public class JzdbgListViewAdapter extends BaseAdapter
{
    View view;
    private List<Jzdbg> list;
    private LayoutInflater inflater;
    private Activity activity;

    public JzdbgListViewAdapter(View view, Context context, List<Jzdbg> list, Activity activity)
    {
        this.view = view;
        this.list = getRevertTimeLineData(list);
        this.activity = activity;
        inflater = LayoutInflater.from(context);
    }

    public JzdbgListViewAdapter( Context context, List<Jzdbg> list, Activity activity)
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
        Jzdbg jzdbg = (Jzdbg) this.getItem(position);

        ViewHolder viewHolder;

        if(convertView == null){
            viewHolder = new ViewHolder();
            convertView = inflater.inflate(R.layout.jzdbg_list_item, null);
            viewHolder.jzdbg_timeApply = convertView.findViewById(R.id.tv_jzdbg_listItem_timeApply);
            viewHolder.jzdbg_jsdw =  convertView.findViewById(R.id.tv_jzdbg_listItem_jsdw);
            viewHolder.jzdbg_xjzd = convertView.findViewById(R.id.tv_jzdbg_listItem_xjzd);
            viewHolder.jzdbg_state = convertView.findViewById(R.id.tv_jzdbg_listItem_state);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.jzdbg_timeApply.setText(jzdbg.getTimeApply());
        viewHolder.jzdbg_jsdw.setText(jzdbg.getJsdw());
        viewHolder.jzdbg_xjzd.setText(jzdbg.getXjzd());
        viewHolder.jzdbg_state.setText(jzdbg.getState());

        return convertView;
    }

    public static class ViewHolder{
        public TextView jzdbg_timeApply;
        public TextView jzdbg_jsdw;
        public TextView jzdbg_xjzd;
        public TextView jzdbg_state;
    }
}
