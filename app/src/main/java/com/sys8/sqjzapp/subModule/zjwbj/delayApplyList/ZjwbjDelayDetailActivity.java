package com.sys8.sqjzapp.subModule.zjwbj.delayApplyList;

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
import static com.sys8.sqjzapp.subModule.zjwbj.delayApplyList.DelayApplyListData.list_DelayApplyState;
import static com.sys8.sqjzapp.utils.DataUtils.getRevertTimeLineData;

public class ZjwbjDelayDetailActivity extends BaseActivity {

    @BindView(R.id.tb_zjwbj_delay_detail)
    TitleBar tbZjwbjDelayDetail;
    @BindView(R.id.tv_zjwbj_delay_detail_timeApply)
    TextView tvZjwbjDelayDetailTimeApply;
    @BindView(R.id.tv_zjwbj_delay_detail_time)
    TextView tvZjwbjDelayDetailTime;
    @BindView(R.id.tv_zjwbj_delay_detail_reason)
    SuperShapeTextView tvZjwbjDelayDetailReason;
    @BindView(R.id.rv_zjwbj_delay_detail_history)
    RecyclerView rvZjwbjDelayDetailHistory;

    private TimeLineAdapter adapter;
    private List<TimelineItem> list ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zjwbj_delay_detail);
        ButterKnife.bind(this);
        TitleCilckListener(tbZjwbjDelayDetail, this);/*title按钮监听*/
        bindData();
        initAdapter();
    }

    private void bindData() {
        Intent intent = getIntent();
        String timeApply = intent.getStringExtra("timeApply");
        String time = intent.getStringExtra("timeDelay");
        String reason = intent.getStringExtra("reasonDelay");
        for(DelayApplyState delayApplyState: list_DelayApplyState){
            if(delayApplyState.getTimeApply().equals(timeApply)){
                list = delayApplyState.getDelayApply();
                break;
            }
        }
        tvZjwbjDelayDetailTimeApply.setText(timeApply);
        tvZjwbjDelayDetailTime.setText(time);
        tvZjwbjDelayDetailReason.setText(reason);
    }

    private void initAdapter(){
        rvZjwbjDelayDetailHistory.setLayoutManager(new LinearLayoutManager(this));
        adapter = new TimeLineAdapter(this,getRevertTimeLineData(list));
        rvZjwbjDelayDetailHistory.setAdapter(adapter);
    }
}
