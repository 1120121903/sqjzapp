package com.sys8.sqjzapp.subModule.ycbf.shfw;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.sys8.sqjzapp.R;
import com.sys8.sqjzapp.subModule.ycbf.shbz.Shbz;

import java.util.List;

import static com.sys8.sqjzapp.utils.DataUtils.getRevertTimeLineData;


public class ShfwListViewAdapter extends BaseAdapter
{
    View view;
    private List<Shfw> list;
    private LayoutInflater inflater;
    private Activity activity;

    public ShfwListViewAdapter(View view, Context context, List<Shfw> list, Activity activity)
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
        Shfw shfw = (Shfw) this.getItem(position);

        ViewHolder viewHolder;

        if(convertView == null){
            viewHolder = new ViewHolder();
            convertView = inflater.inflate(R.layout.frag_ycbf_shfw_list_item, null);
            viewHolder.shfw_title = convertView.findViewById(R.id.tv_shfw_listItem_title);
            viewHolder.shfw_fbsj = convertView.findViewById(R.id.tv_shfw_listItem_fbsj);
            viewHolder.shfw_cotent =  convertView.findViewById(R.id.tv_shfw_listItem_content);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.shfw_title.setText(shfw.getTitle());
        viewHolder.shfw_fbsj.setText(shfw.getFbsj());
        viewHolder.shfw_cotent.setText(shfw.getContent());

        return convertView;
    }

    public static class ViewHolder{
        public TextView shfw_title;
        public TextView shfw_fbsj;
        public TextView shfw_cotent;
    }
}
