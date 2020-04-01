package com.sys8.sqjzapp.subModule.wcqj;

import android.os.Bundle;
import android.widget.Button;
import android.widget.FrameLayout;

import com.hjq.bar.TitleBar;
import com.sys8.sqjzapp.R;
import com.sys8.sqjzapp.baseClass.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.sys8.sqjzapp.baseClass.ActivityCollector.TitleCilckListener;

public class WcqjActivity extends BaseActivity {

    @BindView(R.id.tb_wcqj)
    TitleBar tbWcqj;
    @BindView(R.id.fl_wcqj)
    FrameLayout flWcqj;
    @BindView(R.id.bt_wcqj_wyqj)
    Button btWcqjWyqj;
    @BindView(R.id.bt_wcqj_qjjl)
    Button btWcqjQjjl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wcqj);
        ButterKnife.bind(this);
        TitleCilckListener(tbWcqj, this);/*title按钮监听*/
    }
}
