package com.sys8.sqjzapp.subModule.ycbf.jyfw;

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


public class JyfwListViewAdapter extends BaseAdapter
{
    View view;
    private List<Jyfw> list;
    private LayoutInflater inflater;
    private Activity activity;

    public JyfwListViewAdapter(View view, Context context, List<Jyfw> list, Activity activity)
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
        Jyfw jyfw = (Jyfw) this.getItem(position);

        ViewHolder viewHolder;

        if(convertView == null){
            viewHolder = new ViewHolder();
            convertView = inflater.inflate(R.layout.frag_ycbf_jyfw_list_item, null);
            viewHolder.jyfw_title = convertView.findViewById(R.id.tv_jyfw_listItem_title);
            viewHolder.jyfw_fbsj = convertView.findViewById(R.id.tv_jyfw_listItem_fbsj);
            viewHolder.jyfw_xzfw =  convertView.findViewById(R.id.tv_jyfw_listItem_xzfw);
            viewHolder.jyfw_zprs =  convertView.findViewById(R.id.tv_jyfw_listItem_zprs);
            viewHolder.jyfw_gzdd =  convertView.findViewById(R.id.tv_jyfw_listItem_gzdd);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.jyfw_title.setText(jyfw.getTitle());
        viewHolder.jyfw_fbsj.setText(jyfw.getFbsj());
        viewHolder.jyfw_xzfw.setText(jyfw.getXzfw());
        viewHolder.jyfw_zprs.setText(jyfw.getZprs());
        viewHolder.jyfw_gzdd.setText(jyfw.getGzdd());

        return convertView;
    }

    public static class ViewHolder{
        public TextView jyfw_title;
        public TextView jyfw_fbsj;
        public TextView jyfw_xzfw;
        public TextView jyfw_zprs;
        public TextView jyfw_gzdd;
    }
}
