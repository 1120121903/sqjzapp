package com.sys8.sqjzapp.subModule.hksq;

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
import butterknife.OnClick;

import static com.sys8.sqjzapp.baseClass.ActivityCollector.TitleCilckListener;
import static com.sys8.sqjzapp.subModule.hksq.HksqListData.list_Hksq;
import static com.sys8.sqjzapp.utils.DataUtils.getDate;
import static com.sys8.sqjzapp.utils.DataUtils.getRevertTimeLineData;
import static com.sys8.sqjzapp.utils.DataUtils.getUserName;

/**
 * date:2020/6/2
 * author:wy
 * description:会客申请
 */
public class HksqActivity extends BaseActivity {

    @BindView(R.id.tb_hksp)
    TitleBar tbHksp;
    @BindView(R.id.lv_hksq)
    ListView lvHksq;
    private HksqListViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hksq);
        ButterKnife.bind(this);
        TitleCilckListener(tbHksp, this);/*title按钮监听*/
        bindData();
    }

    private void bindData(){
        adapter = new HksqListViewAdapter(this,list_Hksq,this);
        lvHksq.setAdapter(adapter);
        //设置列表监听事件
        lvHksq.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(HksqActivity.this, HksqDetailActivity.class); //参数1:Fragment所依存的Activity,参数2：要跳转的Activity
                Bundle bundle = new Bundle();
                Hksq hksq = (Hksq) getRevertTimeLineData(list_Hksq).get(position);
                bundle.putString("title",hksq.getTitle()); //放入所需要传递的值
                bundle.putString("timeApply",hksq.getTimeApply());
                bundle.putString("time",hksq.getTime());
                bundle.putString("name",hksq.getName());
                bundle.putString("place", hksq.getPlace());
                bundle.putString("reason", hksq.getReason());
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        /* 刷新数据 */
        adapter = new HksqListViewAdapter(this,list_Hksq,this);
        lvHksq.setAdapter(adapter);
    }

    @OnClick(R.id.bt_hksq_wysq)
    public void hksqWysqFragment() {
        Intent intent = new Intent(HksqActivity.this,HksqAddActivity.class);
        startActivity(intent);
    }

}
