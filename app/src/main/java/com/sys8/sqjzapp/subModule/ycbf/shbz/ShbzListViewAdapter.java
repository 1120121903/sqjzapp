package com.sys8.sqjzapp.subModule.ycbf.shbz;

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


public class ShbzListViewAdapter extends BaseAdapter
{
    View view;
    private List<Shbz> list;
    private LayoutInflater inflater;
    private Activity activity;

    public ShbzListViewAdapter(View view, Context context, List<Shbz> list, Activity activity)
    {
        this.view = view;
        this.list = getRevertTimeLineData(list);
        this.activity = activity;
        inflater = LayoutInflater.from(context);
    }

    public ShbzListViewAdapter(Context context, List<Shbz> list, Activity activity)
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
        Shbz shbz = (Shbz) this.getItem(position);

        ViewHolder viewHolder;

        if(convertView == null){
            viewHolder = new ViewHolder();
            convertView = inflater.inflate(R.layout.frag_ycbf_shbz_list_item, null);
            viewHolder.shbz_title = convertView.findViewById(R.id.tv_shbz_listItem_title);
            viewHolder.shbz_bmtj = convertView.findViewById(R.id.tv_shbz_listItem_time_bmtj);
            viewHolder.shbz_jzsj =  convertView.findViewById(R.id.tv_shbz_listItem_time_jzsj);
            viewHolder.shbz_fbsj = convertView.findViewById(R.id.tv_shbz_listItem_time_fbsj);
            viewHolder.shbz_state = convertView.findViewById(R.id.tv_shbz_listItem_time_state);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.shbz_title.setText(shbz.getTitle());
        viewHolder.shbz_bmtj.setText(shbz.getBmtj());
        viewHolder.shbz_jzsj.setText(shbz.getJzsj());
        viewHolder.shbz_fbsj.setText(shbz.getFbsj());
        if(shbz.getState().equals("1")){
            viewHolder.shbz_state.setText("已申请");
        }

        return convertView;
    }

    public static class ViewHolder{
        public TextView shbz_title;
        public TextView shbz_bmtj;
        public TextView shbz_jzsj;
        public TextView shbz_fbsj;
        public TextView shbz_state;
    }
}
