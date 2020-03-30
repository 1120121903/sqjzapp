package com.sys8.sqjzapp.main.tztx;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.hjq.bar.OnTitleBarListener;
import com.hjq.bar.TitleBar;
import com.sys8.sqjzapp.R;
import com.sys8.sqjzapp.baseClass.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TzxxDetailActivity extends BaseActivity {

    @BindView(R.id.tb_main_title)
    TitleBar tbMainTitle;
    @BindView(R.id.tv_tzxx_detail_title)
    TextView tvTzxxDetailTitle;
    @BindView(R.id.tv_tzxx_detail_content)
    TextView tvTzxxDetailContent;
    @BindView(R.id.tv_tzxx_detail_time)
    TextView tvTzxxDetailTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tzxx_detail);
        ButterKnife.bind(this);
        TitleCilckListenerTzxx(tbMainTitle);
        bindData();

    }

    /**
     *description:解析获取的参数
    */
    private void bindData(){
        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        String content = intent.getStringExtra("content");
        String time = intent.getStringExtra("time");
        tvTzxxDetailTitle.setText(title);
        tvTzxxDetailContent.setText(content);
        tvTzxxDetailTime.setText(time);
    }

    /**
     *description:Title返回按钮监听函数
     */
    private  void TitleCilckListenerTzxx(TitleBar titleBar){
        titleBar.setOnTitleBarListener(new OnTitleBarListener() {
            @Override
            public void onLeftClick(View v) {
                finish();
            }
            @Override
            public void onTitleClick(View v) { }
            @Override
            public void onRightClick(View v) { }});
    }
}
