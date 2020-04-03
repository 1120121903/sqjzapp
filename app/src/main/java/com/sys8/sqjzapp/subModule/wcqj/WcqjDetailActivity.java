package com.sys8.sqjzapp.subModule.wcqj;

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
import static com.sys8.sqjzapp.subModule.wcqj.QjjlListData.list_QjState;
import static com.sys8.sqjzapp.utils.DataUtils.getRevertTimeLineData;

public class WcqjDetailActivity extends BaseActivity {

    @BindView(R.id.tb_wcqj_detail)
    TitleBar tbWcqjDetail;
    @BindView(R.id.tv_wcqj_detail_title)
    TextView tvWcqjDetailTitle;
    @BindView(R.id.tv_wcqj_detail_timeApply)
    TextView tvWcqjDetailTimeApply;
    @BindView(R.id.tv_wcqj_detail_timeStart)
    TextView tvWcqjDetailTimeStart;
    @BindView(R.id.tv_wcqj_detail_timeEnd)
    TextView tvWcqjDetailTimeEnd;
    @BindView(R.id.tv_wcqj_detail_days)
    TextView tvWcqjDetailDays;
    @BindView(R.id.tv_wcqj_detail_place)
    TextView tvWcqjDetailPlace;
    @BindView(R.id.tv_wcqj_detail_reason)
    SuperShapeTextView tvWcqjDetailReason;
    @BindView(R.id.rv_wcqj_detail_history)
    RecyclerView rvWcqjDetailHistory;
    private TimeLineAdapter adapter;
    private List<TimelineItem> list ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wcqj_detail);
        ButterKnife.bind(this);
        TitleCilckListener(tbWcqjDetail, this);/*title按钮监听*/
        bindData();
        initAdapter();
    }

    private void bindData() {
        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        String timeApply = intent.getStringExtra("timeApply");
        String timeStart = intent.getStringExtra("timeStart");
        String timeEnd = intent.getStringExtra("timeEnd");
        String days = intent.getStringExtra("days");
        String place = intent.getStringExtra("place");
        String reason = intent.getStringExtra("reason");

        for(QjState qjState: list_QjState){
            if(qjState.getTimeApply().equals(timeApply)){
                list = qjState.getQjjl();
                break;
            }
        }

        tvWcqjDetailTitle.setText(title);
        tvWcqjDetailTimeApply.setText(timeApply);
        tvWcqjDetailTimeStart.setText(timeStart);
        tvWcqjDetailTimeEnd.setText(timeEnd);
        tvWcqjDetailDays.setText(days);
        tvWcqjDetailPlace.setText(place);
        tvWcqjDetailReason.setText(reason);
    }

    private void initAdapter(){
        rvWcqjDetailHistory.setLayoutManager(new LinearLayoutManager(this));
        adapter = new TimeLineAdapter(this,getRevertTimeLineData(list));
        rvWcqjDetailHistory.setAdapter(adapter);
    }
}
