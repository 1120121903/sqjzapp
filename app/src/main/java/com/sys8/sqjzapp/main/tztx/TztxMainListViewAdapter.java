package com.sys8.sqjzapp.main.tztx;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.sys8.sqjzapp.R;
import java.util.List;

public class TztxMainListViewAdapter extends BaseAdapter
{
    View view;
    private List<Tzxx> list;
    private LayoutInflater inflater;
    private String listType;
    private Activity activity;

    public TztxMainListViewAdapter(View view, Context context, List<Tzxx> list, String listType, Activity activity)
    {
        this.view = view;
        this.list = list;
        this.listType = listType;
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
        Tzxx tzxx = (Tzxx) this.getItem(position);

        ViewHolder viewHolder;

        if(convertView == null){
            viewHolder = new ViewHolder();
            convertView = inflater.inflate(R.layout.tzxx_list_item, null);
            viewHolder.tztx_type = convertView.findViewById(R.id.tv_tztx_type);
            viewHolder.tztx_time = convertView.findViewById(R.id.tv_tztx_time);
            viewHolder.tztx_cotent =  convertView.findViewById(R.id.tv_tztx_cotent);
            viewHolder.tzxx_detail = convertView.findViewById(R.id.bt_tzxx_detail);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.tztx_type.setText(tzxx.getType());
        viewHolder.tztx_time.setText(tzxx.getTime());
        if(tzxx.getType().substring(0,2).equals("通知")){
            viewHolder.tztx_cotent.setText(tzxx.getContent());
            viewHolder.tzxx_detail.setVisibility(View.VISIBLE);
            viewHolder.tzxx_detail.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(activity,TzxxDetailActivity.class); //参数1:Fragment所依存的Activity,参数2：要跳转的Activity
                    Bundle bundle = new Bundle();
                    bundle.putString("title", tzxx.getTitle()); //放入所需要传递的值
                    bundle.putString("content", tzxx.getContent());
                    bundle.putString("time", tzxx.getTime());
                    bundle.putString("dep", tzxx.getDep());
                    intent.putExtras(bundle);
                    activity.startActivity(intent); //这里一定要获取到所在Activity再startActivity()；
                }
            });
        }else {
            viewHolder.tztx_cotent.setText(tzxx.getContent());
            viewHolder.tzxx_detail.setVisibility(View.GONE);
        }
//        viewHolder.tztx_cotent.setTextSize(18);
        return convertView;
    }
    public static class ViewHolder{
        public TextView tztx_type;
        public TextView tztx_time;
        public TextView tztx_cotent;
        public Button tzxx_detail;
    }
}
