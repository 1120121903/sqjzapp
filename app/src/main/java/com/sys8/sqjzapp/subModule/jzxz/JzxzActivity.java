package com.sys8.sqjzapp.subModule.jzxz;

import android.os.Bundle;

import com.hjq.bar.TitleBar;
import com.sys8.sqjzapp.R;
import com.sys8.sqjzapp.baseClass.ActivityCollector;
import com.sys8.sqjzapp.baseClass.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class JzxzActivity extends BaseActivity {

    @BindView(R.id.tb_jzxz_titlebar)
    TitleBar tbJzxzTitlebar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jzxz);
        ButterKnife.bind(this);
        ActivityCollector.TitleCilckListener(tbJzxzTitlebar, this);

    }
}
