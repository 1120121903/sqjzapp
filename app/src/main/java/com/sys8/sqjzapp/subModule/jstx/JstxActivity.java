package com.sys8.sqjzapp.subModule.jstx;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.hjq.bar.TitleBar;
import com.sys8.sqjzapp.R;
import com.sys8.sqjzapp.baseClass.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.sys8.sqjzapp.baseClass.ActivityCollector.TitleCilckListener;
import static com.sys8.sqjzapp.subModule.jstx.JstxListData.list_Jstx;

public class JstxActivity extends BaseActivity {

    @BindView(R.id.tb_jstx)
    TitleBar tbJstx;
    @BindView(R.id.lv_jstx_list)
    ListView lvJstxList;
    private JstxListViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jstx);
        ButterKnife.bind(this);
        TitleCilckListener(tbJstx, this);/*title按钮监听*/
        bindData();
    }

    private void bindData(){
        adapter = new JstxListViewAdapter(this,list_Jstx,this);
        lvJstxList.setAdapter(adapter);
        //设置列表监听事件
        lvJstxList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(JstxActivity.this, JstxDetailActivity.class); //参数1:Fragment所依存的Activity,参数2：要跳转的Activity
                Bundle bundle = new Bundle();
                Jstx jstx = list_Jstx.get(position);
                bundle.putString("name",jstx.getName());
                bundle.putString("dep",jstx.getDep());
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }

//
//    //警官3
//    @OnClick(R.id.line_jstx_jzxz)
//    public void toJg3Detail(){
//        Intent intent = new Intent(JstxActivity.this, JstxDetailActivity.class);
//        Bundle bundle = new Bundle();
//        bundle.putString("title", list_Jstx.get(3).getName()+list_Jstx.get(3).getMessage());
//        intent.putExtras(bundle);
//        this.startActivity(intent);
//    }
}
