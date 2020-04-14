package com.sys8.sqjzapp.subModule.jstx.message;

import com.sys8.sqjzapp.R;
import com.sys8.sqjzapp.subModule.jstx.Jstx;

import java.util.ArrayList;
import java.util.List;

public class MsgListData {
    //警官3
    public static final List<Msg> list_Msg_3=new ArrayList<Msg>(){
        {
            add(new Msg("你好，请发给我本次思想汇报", R.drawable.ic_jstx_head1,Msg.TYPE_RECEIVE));
            add(new Msg("好的", R.drawable.ic_jstx_msg_myhead, Msg.TYPE_SENT));
            add(new Msg("缓刑期间，本人思过悔过，充分认识到所犯罪行的严重性，因自身的法制观念、组织纪律观念淡薄，" +
                    "这件事，已对造成了社会不好的影响、对自己的家庭带来沉重压力和精神负担。现在，我从思想上进行了" +
                    "深刻的反思，认识到了我的法制观念、组织纪律性确实很淡薄，从而导致自己犯了罪。我要在思想上继续" +
                    "深刻的反思，再次加强我的法制观念及组织纪律性，坚决杜绝此类事件的发生",  R.drawable.ic_jstx_msg_myhead,Msg.TYPE_SENT));
            add(new Msg("收到",  R.drawable.ic_jstx_head1,Msg.TYPE_RECEIVE));
        }
    };
    //警官2
    public static final List<Msg> list_Msg_2=new ArrayList<Msg>(){
        {
            add(new Msg("你好，汇报现在的位置", R.drawable.ic_jstx_head2,Msg.TYPE_RECEIVE));
            add(new Msg("我现在在北京市海淀区华北计算技术研究所",  R.drawable.ic_jstx_msg_myhead,Msg.TYPE_SENT));
            add(new Msg("收到",  R.drawable.ic_jstx_head2,Msg.TYPE_RECEIVE));
        }
    };
    //警官1
    public static final List<Msg> list_Msg_1=new ArrayList<Msg>(){
        {
            add(new Msg("你好，汇报现在的位置", R.drawable.ic_jstx_head1,Msg.TYPE_RECEIVE));
            add(new Msg("我现在在北京市人民医院",  R.drawable.ic_jstx_msg_myhead,Msg.TYPE_SENT));
            add(new Msg("好的",  R.drawable.ic_jstx_head1,Msg.TYPE_RECEIVE));
        }
    };
    //矫正小组
    public static final List<Msg> list_Msg_0=new ArrayList<Msg>(){
        {
            add(new Msg("请大家汇报现在的位置", R.drawable.ic_jstx_head1,Msg.TYPE_RECEIVE));
            add(new Msg("我现在在北京市海淀区司法所",  R.drawable.ic_jstx_msg_myhead,Msg.TYPE_RECEIVE));
            add(new Msg("我现在在北京市海淀区幸福小区",  R.drawable.ic_jstx_msg_myhead,Msg.TYPE_RECEIVE));
            add(new Msg("我现在在北京市人民医院",  R.drawable.ic_jstx_msg_myhead,Msg.TYPE_SENT));
            add(new Msg("好的",  R.drawable.ic_jstx_head1,Msg.TYPE_RECEIVE));
            add(new Msg("收到",  R.drawable.ic_jstx_head2,Msg.TYPE_RECEIVE));
        }
    };

}
