package com.sys8.sqjzapp.subModule.zjwbj;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.barnettwong.dragfloatactionbuttonlibrary.view.DragFloatActionButton;
import com.hjq.bar.TitleBar;
import com.sys8.sqjzapp.R;
import com.sys8.sqjzapp.baseClass.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.sys8.sqjzapp.baseClass.ActivityCollector.TitleCilckListener;
import static com.sys8.sqjzapp.subModule.zjwbj.BjjlListData.list_Bjjl;
import static com.sys8.sqjzapp.utils.DataUtils.getRevertTimeLineData;

public class ZjwbjActivity extends BaseActivity {

    @BindView(R.id.tb_zjwbj)
    TitleBar tbZjwbj;
    @BindView(R.id.bt_zjwbj_tbbj)
    DragFloatActionButton btZjwbjTbbj;
    @BindView(R.id.lv_bjjl)
    ListView lvBjjl;
    private BjjlListViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zjwbj);
        ButterKnife.bind(this);
        TitleCilckListener(tbZjwbj, this);/*title按钮监听*/
        bindData();
    }

    private void bindData() {
        adapter = new BjjlListViewAdapter(this, list_Bjjl, this);
        lvBjjl.setAdapter(adapter);
        //设置列表监听事件
        lvBjjl.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ZjwbjActivity.this, ZjwbjDetailActivity.class); //参数1:Fragment所依存的Activity,参数2：要跳转的Activity
                Bundle bundle = new Bundle();
                Bjjl bjjl = (Bjjl) getRevertTimeLineData(list_Bjjl).get(position);
                bundle.putString("timeApply", bjjl.getTimeApply());
                bundle.putString("timeStart", bjjl.getTimeStart());
                bundle.putString("bjsm", bjjl.getBjsm());
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        /* 刷新数据 */
        adapter = new BjjlListViewAdapter(this, list_Bjjl, this);
        lvBjjl.setAdapter(adapter);
    }

    @OnClick(R.id.bt_zjwbj_tbbj)
    public void zjwbjBjjl() {
        Intent intent = new Intent(ZjwbjActivity.this,ZjwbjAddActivity.class);
        startActivity(intent);
    }

}
