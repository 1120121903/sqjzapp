package com.sys8.sqjzapp.subModule.rcbg;

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

import com.sys8.sqjzapp.R;
import com.sys8.sqjzapp.main.tztx.Tzxx;
import com.sys8.sqjzapp.main.tztx.TzxxDetailActivity;

import java.util.List;

import static com.sys8.sqjzapp.utils.DataSource.getRevertTimeLineData;

public class RcbgnListViewAdapter extends BaseAdapter
{
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
            viewHolder.rcbg_detail = convertView.findViewById(R.id.bt_rcbg_listItem_detail);
            viewHolder.rcbg_detail.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(activity,RcbgDetailActivity.class); //参数1:Fragment所依存的Activity,参数2：要跳转的Activity
                    Bundle bundle = new Bundle();
                    bundle.putString("title", rcbg.getTitle()); //放入所需要传递的值
                    bundle.putString("content", rcbg.getContent());
                    bundle.putString("time", rcbg.getTime());
                    bundle.putString("place", rcbg.getPlace());
                    intent.putExtras(bundle);
                    activity.startActivity(intent); //这里一定要获取到所在Activity再startActivity()；
                }
            });
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.rcbg_title.setText(rcbg.getTitle());
        viewHolder.rcbg_time.setText(rcbg.getTime());
        viewHolder.rcbg_place.setText(rcbg.getPlace());
//        viewHolder.tztx_cotent.setTextSize(18);

        return convertView;
    }
    public static class ViewHolder{
        public TextView rcbg_title;
        public TextView rcbg_time;
        public TextView rcbg_place;
        public Button rcbg_detail;
    }
}
