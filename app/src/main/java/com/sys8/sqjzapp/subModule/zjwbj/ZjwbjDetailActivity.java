package com.sys8.sqjzapp.subModule.zjwbj;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hjq.bar.TitleBar;
import com.kingja.supershapeview.view.SuperShapeTextView;
import com.sys8.sqjzapp.R;
import com.sys8.sqjzapp.adapters.TimeLineAdapter;
import com.sys8.sqjzapp.baseClass.BaseActivity;
import com.sys8.sqjzapp.module.TimelineItem;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.sys8.sqjzapp.baseClass.ActivityCollector.TitleCilckListener;
import static com.sys8.sqjzapp.subModule.zjwbj.BjjlListData.list_BjState;
import static com.sys8.sqjzapp.utils.DataUtils.getRevertTimeLineData;

public class ZjwbjDetailActivity extends BaseActivity {

    @BindView(R.id.tb_zjwbj_detail)
    TitleBar tbZjwbjDetail;
    @BindView(R.id.tv_zjwbj_detail_timeApply)
    TextView tvZjwbjDetailTimeApply;
    @BindView(R.id.tv_zjwbj_detail_timeStart)
    TextView tvZjwbjDetailTimeStart;
    @BindView(R.id.tv_zjwbj_detail_bjsm)
    SuperShapeTextView tvZjwbjDetailBjsm;
    @BindView(R.id.rv_zjwbj_detail_history)
    RecyclerView rvZjwbjDetailHistory;

    private TimeLineAdapter adapter;
    private List<TimelineItem> list ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zjwbj_detail);
        ButterKnife.bind(this);
        TitleCilckListener(tbZjwbjDetail, this);/*title按钮监听*/
        bindData();
        initAdapter();
    }

    private void bindData() {
        Intent intent = getIntent();
        String timeApply = intent.getStringExtra("timeApply");
        String timeStart = intent.getStringExtra("timeStart");
        String bjsm = intent.getStringExtra("bjsm");

        for(BjState bjState: list_BjState){
            if(bjState.getTimeApply().equals(timeApply)){
                list = bjState.getBjjl();
                break;
            }
        }

        tvZjwbjDetailTimeApply.setText(timeApply);
        tvZjwbjDetailTimeStart.setText(timeStart);
        tvZjwbjDetailBjsm.setText(bjsm);
    }

    private void initAdapter(){
        rvZjwbjDetailHistory.setLayoutManager(new LinearLayoutManager(this));
        adapter = new TimeLineAdapter(this,getRevertTimeLineData(list));
        rvZjwbjDetailHistory.setAdapter(adapter);
    }
}
