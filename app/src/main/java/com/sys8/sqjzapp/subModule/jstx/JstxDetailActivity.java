package com.sys8.sqjzapp.subModule.jstx;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hjq.bar.TitleBar;
import com.sys8.sqjzapp.R;
import com.sys8.sqjzapp.baseClass.BaseActivity;
import com.sys8.sqjzapp.subModule.jstx.message.Msg;
import com.sys8.sqjzapp.subModule.jstx.message.MsgAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.sys8.sqjzapp.baseClass.ActivityCollector.TitleCilckListener;
import static com.sys8.sqjzapp.subModule.jstx.JstxListData.JSTX_JG1;
import static com.sys8.sqjzapp.subModule.jstx.JstxListData.JSTX_JG2;
import static com.sys8.sqjzapp.subModule.jstx.JstxListData.JSTX_JG3;
import static com.sys8.sqjzapp.subModule.jstx.JstxListData.JSTX_JZXZ;
import static com.sys8.sqjzapp.subModule.jstx.message.MsgListData.list_Msg_0;
import static com.sys8.sqjzapp.subModule.jstx.message.MsgListData.list_Msg_1;
import static com.sys8.sqjzapp.subModule.jstx.message.MsgListData.list_Msg_2;
import static com.sys8.sqjzapp.subModule.jstx.message.MsgListData.list_Msg_3;

public class JstxDetailActivity extends BaseActivity {

    @BindView(R.id.tb_jstx_detail)
    TitleBar tbJstxDetail;
    @BindView(R.id.rv_jstx_detail_history)
    RecyclerView rvJstxDetailHistory;
    @BindView(R.id.et_jstx_detail_text)
    EditText etJstxDetailText;
    @BindView(R.id.bt_jstx_detail_send)
    Button btJstxDetailSend;
    private MsgAdapter adapter;
    private  String name;
    private  List<Msg> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jstx_detail);
        ButterKnife.bind(this);
        TitleCilckListener(tbJstxDetail, this);/*title按钮监听*/
        bindData();
    }

    private void bindData() {
        Intent intent = getIntent();
        name = intent.getStringExtra("name");
        tbJstxDetail.setTitle(name);
        //RecycleView初始化
        LinearLayoutManager layoutManager = new LinearLayoutManager((this));
        rvJstxDetailHistory.setLayoutManager(layoutManager);
        list = new ArrayList<>();
        switch (name){
            case JSTX_JZXZ:
                list = list_Msg_0;
                break;
            case JSTX_JG1:
                list = list_Msg_1;
                break;
            case JSTX_JG2:
                list = list_Msg_2;
                break;
            case JSTX_JG3:
                list = list_Msg_3;
                break;
        }
        adapter = new MsgAdapter(list,this);
        rvJstxDetailHistory.setAdapter(adapter);
    }

    @OnClick(R.id.bt_jstx_detail_send)
    public void senMsg(){
        String content = etJstxDetailText.getText().toString();
        if(!"".equals(content)){
            Msg msg = new Msg(content,R.drawable.ic_jstx_msg_myhead,Msg.TYPE_SENT);
            switch (name){
                case JSTX_JZXZ:
                    list_Msg_0.add(msg);
                    list = list_Msg_0;
                    break;
                case JSTX_JG1:
                    list_Msg_1.add(msg);
                    list = list_Msg_1;
                    break;
                case JSTX_JG2:
                    list_Msg_2.add(msg);
                    list = list_Msg_2;
                    break;
                case JSTX_JG3:
                    list_Msg_3.add(msg);
                    list = list_Msg_3;
                    break;
            }
            adapter.notifyItemInserted(list.size()-1);//当有新消息时，刷新ListView中的显示
            rvJstxDetailHistory.scrollToPosition(list.size()-1);//将ListView定位到最后一行
            etJstxDetailText.setText("");//清空输入框
        }
    }
}
