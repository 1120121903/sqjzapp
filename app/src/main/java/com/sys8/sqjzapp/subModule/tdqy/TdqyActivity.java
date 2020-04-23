package com.sys8.sqjzapp.subModule.tdqy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.barnettwong.dragfloatactionbuttonlibrary.view.DragFloatActionButton;
import com.hjq.bar.TitleBar;
import com.sys8.sqjzapp.R;
import com.sys8.sqjzapp.baseClass.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.sys8.sqjzapp.baseClass.ActivityCollector.TitleCilckListener;
import static com.sys8.sqjzapp.subModule.tdqy.TdqyListData.list_Tdqy;
import static com.sys8.sqjzapp.utils.DataUtils.getRevertTimeLineData;

public class TdqyActivity extends BaseActivity {

    @BindView(R.id.tb_tdqy_titlebar)
    TitleBar tbTdqyTitlebar;
    @BindView(R.id.lv_tdqy)
    ListView lvTdqy;
    @BindView(R.id.bt_tdqy_wysq)
    DragFloatActionButton btTdqyWysq;
    private TdqyListViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tdqy);
        ButterKnife.bind(this);
        TitleCilckListener(tbTdqyTitlebar, this);
        bindData();
    }

    private void bindData(){
        adapter = new TdqyListViewAdapter(this,list_Tdqy,this);
        lvTdqy.setAdapter(adapter);
        //设置列表监听事件
        lvTdqy.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(TdqyActivity.this,TdqyDetailActivity.class); //参数1:Fragment所依存的Activity,参数2：要跳转的Activity
                Bundle bundle = new Bundle();
                Tdqy tdqy = (Tdqy) getRevertTimeLineData(list_Tdqy).get(position);
                bundle.putString("title",tdqy.getTitle() ); //放入所需要传递的值
                bundle.putString("timeApply", tdqy.getTimeApply());
                bundle.putString("timeStart", tdqy.getTimeStart());
                bundle.putString("timeEnd", tdqy.getTimeEnd());
                bundle.putString("place", tdqy.getPlace());
                bundle.putString("reason", tdqy.getReason());
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        /* 刷新数据 */
        adapter = new TdqyListViewAdapter(this,list_Tdqy,this);
        lvTdqy.setAdapter(adapter);
    }

    @OnClick(R.id.bt_tdqy_wysq)
    public void tdqyAdd() {
        Intent intent = new Intent(TdqyActivity.this,TdqyAddActivity.class);
        startActivity(intent);
    }
}
