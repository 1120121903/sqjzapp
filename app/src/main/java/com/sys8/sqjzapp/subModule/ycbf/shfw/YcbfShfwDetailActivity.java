package com.sys8.sqjzapp.subModule.ycbf.shfw;

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

public class YcbfShfwDetailActivity extends BaseActivity {

    @BindView(R.id.tb_ycbf_shfw)
    TitleBar tbYcbfShfw;
    @BindView(R.id.tv_ycbf_shfw_title)
    TextView tvYcbfShfwTitle;
    @BindView(R.id.tv_ycbf_shfw_content)
    SuperShapeTextView tvYcbfShfwContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ycbf_shfw_detail);
        ButterKnife.bind(this);
        TitleCilckListener(tbYcbfShfw, this);/*title按钮监听*/
        bindData();
    }

    private void bindData(){
        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        String content = intent.getStringExtra("content");
        tvYcbfShfwTitle.setText(title);
        tvYcbfShfwContent.setText(content);
    }

}
