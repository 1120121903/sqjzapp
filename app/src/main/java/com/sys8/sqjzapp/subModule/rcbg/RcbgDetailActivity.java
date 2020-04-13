package com.sys8.sqjzapp.subModule.rcbg;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.hjq.bar.TitleBar;
import com.kingja.supershapeview.view.SuperShapeTextView;
import com.sys8.sqjzapp.R;
import com.sys8.sqjzapp.baseClass.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.sys8.sqjzapp.baseClass.ActivityCollector.TitleCilckListener;
import static com.sys8.sqjzapp.utils.Constant.userBitMap;

public class RcbgDetailActivity extends BaseActivity {

    @BindView(R.id.tb_rcbg_detail)
    TitleBar tbRcbgTitle;
    @BindView(R.id.tv_rcbg_detail_title)
    TextView tvRcbgDetailTitle;
    @BindView(R.id.et_rcbg_detail_content)
    SuperShapeTextView etRcbgDetailContent;
    @BindView(R.id.tv_rcbg_detail_time)
    TextView tvRcbgDetailTime;
    @BindView(R.id.tv_rcbg_detail_place)
    TextView tvRcbgDetailPlace;
    @BindView(R.id.iv_rcbg_face)
    ImageView ivRcbgFace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rcbg_detail);
        ButterKnife.bind(this);
        TitleCilckListener(tbRcbgTitle, this);/*title按钮监听*/
        bindData();//获取参数数据
    }

    private void bindData() {
        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        String content = intent.getStringExtra("content");
        String time = intent.getStringExtra("time");
        String place = intent.getStringExtra("place");
        tvRcbgDetailTitle.setText(title);
        etRcbgDetailContent.setText(content);
        tvRcbgDetailTime.setText(time);
        tvRcbgDetailPlace.setText(place);
        ivRcbgFace.setImageBitmap(userBitMap);
    }
}
