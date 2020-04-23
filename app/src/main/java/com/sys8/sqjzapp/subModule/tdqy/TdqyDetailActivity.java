package com.sys8.sqjzapp.subModule.tdqy;

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
import static com.sys8.sqjzapp.subModule.tdqy.TdqyListData.list_TdqyApply_State;
import static com.sys8.sqjzapp.utils.DataUtils.getRevertTimeLineData;

public class TdqyDetailActivity extends BaseActivity {

    @BindView(R.id.tb_tdqy_detail_titlebar)
    TitleBar tbTdqyDetailTitlebar;
    @BindView(R.id.tv_tdqy_detail_title)
    TextView tvTdqyDetailTitle;
    @BindView(R.id.tv_teqy_detail_timeApply)
    TextView tvTeqyDetailTimeApply;
    @BindView(R.id.tv_tdqy_detail_timeStart)
    TextView tvTdqyDetailTimeStart;
    @BindView(R.id.tv_tdqy_detail_timeEnd)
    TextView tvTdqyDetailTimeEnd;
    @BindView(R.id.tv_tdqy_detail_place)
    TextView tvTdqyDetailPlace;
    @BindView(R.id.tv_teqy_detail_reason)
    SuperShapeTextView tvTeqyDetailReason;
    @BindView(R.id.rv_tdqy_detail_history)
    RecyclerView rvTdqyDetailHistory;
    private TimeLineAdapter adapter;
    private List<TimelineItem> list ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tdqy_detail);
        ButterKnife.bind(this);
        TitleCilckListener(tbTdqyDetailTitlebar, this);
        bindData();
        initAdapter();
    }

    private void bindData() {
        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        String timeApply = intent.getStringExtra("timeApply");
        String timeStart = intent.getStringExtra("timeStart");
        String timeEnd = intent.getStringExtra("timeEnd");
        String place = intent.getStringExtra("place");
        String reason = intent.getStringExtra("reason");

        for(TdqyApplyState tdqyApplyState: list_TdqyApply_State){
            if(tdqyApplyState.getTimeApply().equals(timeApply)){
                list = tdqyApplyState.getTdqyApply();
                break;
            }
        }

        tvTdqyDetailTitle.setText(title);
        tvTeqyDetailTimeApply.setText(timeApply);
        tvTdqyDetailTimeStart.setText(timeStart);
        tvTdqyDetailTimeEnd.setText(timeEnd);
        tvTdqyDetailPlace.setText(place);
        tvTeqyDetailReason.setText(reason);
    }

    private void initAdapter(){
        rvTdqyDetailHistory.setLayoutManager(new LinearLayoutManager(this));
        adapter = new TimeLineAdapter(this,getRevertTimeLineData(list));
        rvTdqyDetailHistory.setAdapter(adapter);
    }
}
