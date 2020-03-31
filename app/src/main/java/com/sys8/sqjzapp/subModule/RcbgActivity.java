package com.sys8.sqjzapp.subModule;

import android.os.Bundle;

import com.hjq.bar.TitleBar;
import com.sys8.sqjzapp.R;
import com.sys8.sqjzapp.baseClass.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.sys8.sqjzapp.baseClass.ActivityCollector.TitleCilckListener;

public class RcbgActivity extends BaseActivity {

    @BindView(R.id.tb_rcbg)
    TitleBar tbRcbg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rcbg);
        ButterKnife.bind(this);
        TitleCilckListener(tbRcbg, this);/*title按钮监听*/
    }
}
