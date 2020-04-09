package com.sys8.sqjzapp.subModule.jzdbg;

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
import static com.sys8.sqjzapp.subModule.jzdbg.JzdbgListData.list_Jzdbg;
import static com.sys8.sqjzapp.utils.DataUtils.getRevertTimeLineData;

public class JzdbgActivity extends BaseActivity {

    @BindView(R.id.tb_jzdbg)
    TitleBar tbJzdbg;
    @BindView(R.id.bt_jzdbg_sqbj)
    DragFloatActionButton btJzdbgSqbj;
    @BindView(R.id.lv_bgjl)
    ListView lvBgjl;
    private JzdbgListViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jzdbg);
        ButterKnife.bind(this);
        TitleCilckListener(tbJzdbg, this);/*title按钮监听*/
        bindData();
    }

    private void bindData() {
        adapter = new JzdbgListViewAdapter(this, list_Jzdbg,this);
        lvBgjl.setAdapter(adapter);
        //设置列表监听事件
        lvBgjl.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(JzdbgActivity.this, JzdbgDetailActivity.class); //参数1:Fragment所依存的Activity,参数2：要跳转的Activity
                Bundle bundle = new Bundle();
                Jzdbg jzdbg = (Jzdbg) getRevertTimeLineData(list_Jzdbg).get(position);
                bundle.putString("timeApply", jzdbg.getTimeApply());
                bundle.putString("jsdw", jzdbg.getJsdw());
                bundle.putString("xjzd", jzdbg.getXjzd());
                bundle.putString("bgyy", jzdbg.getBgyy());
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        /* 刷新数据 */
        adapter = new JzdbgListViewAdapter(this, list_Jzdbg,this);
        lvBgjl.setAdapter(adapter);
    }

    @OnClick(R.id.bt_jzdbg_sqbj)
    public void jzdbgSqbj() {
        Intent intent = new Intent(JzdbgActivity.this,JzdbgAddActivity.class);
        startActivity(intent);
    }

}
