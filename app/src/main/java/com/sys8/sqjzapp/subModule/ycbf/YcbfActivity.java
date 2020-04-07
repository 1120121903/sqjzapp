package com.sys8.sqjzapp.subModule.ycbf;

import android.os.Bundle;

import com.hjq.bar.TitleBar;
import com.sys8.sqjzapp.R;
import com.sys8.sqjzapp.baseClass.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.sys8.sqjzapp.baseClass.ActivityCollector.TitleCilckListener;

public class YcbfActivity extends BaseActivity {

    @BindView(R.id.tb_ycbf)
    TitleBar tbYcbf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ycbf);
        ButterKnife.bind(this);
        TitleCilckListener(tbYcbf, this);/*title按钮监听*/
    }
}
