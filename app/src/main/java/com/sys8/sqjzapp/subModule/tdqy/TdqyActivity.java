package com.sys8.sqjzapp.subModule.tdqy;

import android.os.Bundle;

import com.hjq.bar.TitleBar;
import com.sys8.sqjzapp.R;
import com.sys8.sqjzapp.baseClass.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.sys8.sqjzapp.baseClass.ActivityCollector.TitleCilckListener;

public class TdqyActivity extends BaseActivity {

    @BindView(R.id.tb_tdqy_titlebar)
    TitleBar tbTdqyTitlebar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tdqy);
        ButterKnife.bind(this);
        TitleCilckListener(tbTdqyTitlebar, this);
    }
}
