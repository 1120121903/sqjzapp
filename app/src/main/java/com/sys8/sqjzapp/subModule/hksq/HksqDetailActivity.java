package com.sys8.sqjzapp.subModule.hksq;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.hjq.bar.TitleBar;
import com.kingja.supershapeview.view.SuperShapeTextView;
import com.sys8.sqjzapp.R;
import com.sys8.sqjzapp.baseClass.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.sys8.sqjzapp.baseClass.ActivityCollector.TitleCilckListener;

public class HksqDetailActivity extends BaseActivity {

    @BindView(R.id.tb_hksq_detail)
    TitleBar tbHksqDetail;
    @BindView(R.id.tv_hksq_detail_title)
    TextView tvHksqDetailTitle;
    @BindView(R.id.tv_hksq_detail_timeApply)
    TextView tvHksqDetailTimeApply;
    @BindView(R.id.tv_hksq_detail_time)
    TextView tvHksqDetailTime;
    @BindView(R.id.tv_hksq_detail_place)
    TextView tvHksqDetailPlace;
    @BindView(R.id.tv_hksq_detail_name)
    TextView tvHksqDetailName;
    @BindView(R.id.tv_hksq_detail_reason)
    SuperShapeTextView tvHksqDetailReason;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hksq_detail);
        ButterKnife.bind(this);
        TitleCilckListener(tbHksqDetail, this);/*title按钮监听*/
        bindData();
    }

    private void bindData() {
        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        String timeApply = intent.getStringExtra("timeApply");
        String time = intent.getStringExtra("time");
        String name = intent.getStringExtra("name");
        String place = intent.getStringExtra("place");
        String reason = intent.getStringExtra("reason");

        tvHksqDetailTitle.setText(title);
        tvHksqDetailTimeApply.setText(timeApply);
        tvHksqDetailTime.setText(time);
        tvHksqDetailName.setText(name);
        tvHksqDetailPlace.setText(place);
        tvHksqDetailReason.setText(reason);
    }
}
