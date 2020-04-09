package com.sys8.sqjzapp.subModule.wcqj;

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
import static com.sys8.sqjzapp.subModule.wcqj.QjjlListData.list_Qjjl;
import static com.sys8.sqjzapp.utils.DataUtils.getRevertTimeLineData;

public class WcqjActivity extends BaseActivity {

    @BindView(R.id.tb_wcqj)
    TitleBar tbWcqj;
    @BindView(R.id.bt_wcqj_wyqj)
    DragFloatActionButton btWcqjWyqj;
    @BindView(R.id.lv_wcqj)
    ListView lvWcqj;
    private QjjlListViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wcqj);
        ButterKnife.bind(this);
        TitleCilckListener(tbWcqj, this);/*title按钮监听*/
        bindData();
    }

    private void bindData(){
        adapter = new QjjlListViewAdapter(this,list_Qjjl,this);
        lvWcqj.setAdapter(adapter);
        //设置列表监听事件
        lvWcqj.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(WcqjActivity.this,WcqjDetailActivity.class); //参数1:Fragment所依存的Activity,参数2：要跳转的Activity
                Bundle bundle = new Bundle();
                Qjjl qjjl = (Qjjl) getRevertTimeLineData(list_Qjjl).get(position);
                bundle.putString("title",qjjl.getTitle() ); //放入所需要传递的值
                bundle.putString("timeApply", qjjl.getTimeApply());
                bundle.putString("timeStart", qjjl.getTimeStart());
                bundle.putString("timeEnd", qjjl.getTimeEnd());
                bundle.putString("days", qjjl.getDays());
                bundle.putString("place", qjjl.getPlace());
                bundle.putString("reason", qjjl.getReason());
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        /* 刷新数据 */
        adapter = new QjjlListViewAdapter(this,list_Qjjl,this);
        lvWcqj.setAdapter(adapter);
    }

    @OnClick(R.id.bt_wcqj_wyqj)
    public void wcqjWyqjFragment() {
        Intent intent = new Intent(WcqjActivity.this,WcqjAddActivity.class);
        startActivity(intent);
    }

}
