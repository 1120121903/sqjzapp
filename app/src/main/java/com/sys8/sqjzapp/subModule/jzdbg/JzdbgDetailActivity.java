package com.sys8.sqjzapp.subModule.jzdbg;

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
import static com.sys8.sqjzapp.subModule.jzdbg.JzdbgListData.list_JzdbgState;
import static com.sys8.sqjzapp.utils.DataUtils.getRevertTimeLineData;

public class JzdbgDetailActivity extends BaseActivity {

    @BindView(R.id.tb_jzdbg_detail)
    TitleBar tbJzdbgDetail;
    @BindView(R.id.tv_jzdbg_detail_timeApply)
    TextView tvJzdbgDetailTimeApply;
    @BindView(R.id.tv_jzdbg_detail_jsdw)
    TextView tvJzdbgDetailJsdw;
    @BindView(R.id.tv_jzdbg_detail_xjzd)
    TextView tvJzdbgDetailXjzd;
    @BindView(R.id.tv_jzdbg_detail_bgyy)
    SuperShapeTextView tvJzdbgDetailBgyy;
    @BindView(R.id.rv_jzdbg_detail_history)
    RecyclerView rvJzdbgDetailHistory;
    private TimeLineAdapter adapter;
    private List<TimelineItem> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jzdbg_detail);
        ButterKnife.bind(this);
        TitleCilckListener(tbJzdbgDetail, this);/*title按钮监听*/
        bindData();
        initAdapter();
    }

    private void bindData() {
        Intent intent = getIntent();
        String timeApply = intent.getStringExtra("timeApply");
        String jsdw = intent.getStringExtra("jsdw");
        String xjzd = intent.getStringExtra("xjzd");
        String bgyy = intent.getStringExtra("bgyy");

        for (JzdbgState jzdbgState : list_JzdbgState) {
            if (jzdbgState.getTimeApply().equals(timeApply)) {
                list = jzdbgState.getJzdbg();
                break; }
        }
        tvJzdbgDetailTimeApply.setText(timeApply);
        tvJzdbgDetailJsdw.setText(jsdw);
        tvJzdbgDetailXjzd.setText(xjzd);
        tvJzdbgDetailBgyy.setText(bgyy);
    }

    private void initAdapter() {
        rvJzdbgDetailHistory.setLayoutManager(new LinearLayoutManager(this));
        adapter = new TimeLineAdapter(this, getRevertTimeLineData(list));
        rvJzdbgDetailHistory.setAdapter(adapter);
    }
}
