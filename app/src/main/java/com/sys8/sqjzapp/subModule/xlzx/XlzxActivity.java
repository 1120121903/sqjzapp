package com.sys8.sqjzapp.subModule.xlzx;

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
import static com.sys8.sqjzapp.subModule.xlzx.XlzxListData.list_Xlzx;
import static com.sys8.sqjzapp.utils.DataUtils.getRevertTimeLineData;

public class XlzxActivity extends BaseActivity {

    @BindView(R.id.tb_xlzx)
    TitleBar tbXlzx;
    @BindView(R.id.lv_xlzx)
    ListView lvXlzx;
    private XlzxListViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xlzx);
        ButterKnife.bind(this);
        TitleCilckListener(tbXlzx, this);
        bindData();
    }

    private void bindData(){
        adapter = new XlzxListViewAdapter(this, list_Xlzx,this);
        lvXlzx.setAdapter(adapter);
        //设置列表监听事件
        lvXlzx.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(XlzxActivity.this, XlzxDetailActivity.class); //参数1:Fragment所依存的Activity,参数2：要跳转的Activity
                Bundle bundle = new Bundle();
                Xlzx xlzx = list_Xlzx.get(position);
                bundle.putString("name", xlzx.getName());
                bundle.putString("zc", xlzx.getZc());
                bundle.putString("des", xlzx.getDes());
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
}
