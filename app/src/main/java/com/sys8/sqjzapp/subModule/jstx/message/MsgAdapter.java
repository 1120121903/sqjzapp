package com.sys8.sqjzapp.subModule.jstx.message;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import com.sys8.sqjzapp.R;

import java.util.List;

public class MsgAdapter extends RecyclerView.Adapter<MsgAdapter.ViewHolder> {

    private List<Msg> mMsglist;
    private Activity activity;

    static class ViewHolder extends RecyclerView.ViewHolder{
        LinearLayout leftLayout;
        LinearLayout rightLayout;
        TextView leftMsg;
        TextView rightMsg;
        ImageView leftHead;
        ImageView rightHead;
        public ViewHolder(View view){
            super(view);
            leftLayout = (LinearLayout)view.findViewById(R.id.line_jstx_detail_item_left);
            rightLayout = (LinearLayout)view.findViewById(R.id.line_jstx_detail_item_right);
            leftMsg = (TextView) view.findViewById(R.id.tv_jstx_detail_item_left_msg);
            rightMsg = (TextView) view.findViewById(R.id.tv_jstx_detail_item_right_msg);
            leftHead = (ImageView) view.findViewById(R.id.iv_jstx_detail_item_left_head);
            rightHead = (ImageView) view.findViewById(R.id.iv_jstx_detail_item_right_head);
        }
    }

    public MsgAdapter(List<Msg> msgList, Activity activity) {
        this.mMsglist = msgList;
        this.activity = activity;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.msg_item,parent,false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Msg msg = mMsglist.get(position);
        if(msg.getType() == Msg.TYPE_RECEIVE){
            //收到的消息
            holder.leftLayout.setVisibility(View.VISIBLE);
            holder.leftHead.setVisibility(View.VISIBLE);
            holder.rightLayout.setVisibility(View.GONE);
            holder.rightHead.setVisibility(View.GONE);
            holder.leftMsg.setText(msg.getContent());
            holder.leftHead.setBackground(activity.getDrawable(msg.getFromHead()));
        }else if(msg.getType() == Msg.TYPE_SENT){
            //发送的消息
            holder.leftLayout.setVisibility(View.GONE);
            holder.leftHead.setVisibility(View.GONE);
            holder.rightLayout.setVisibility(View.VISIBLE);
            holder.rightHead.setVisibility(View.VISIBLE);
            holder.rightMsg.setText(msg.getContent());
            holder.rightHead.setBackground(activity.getDrawable(msg.getFromHead()));
        }
    }

    @Override
    public int getItemCount() {
        return mMsglist.size();
    }
}
