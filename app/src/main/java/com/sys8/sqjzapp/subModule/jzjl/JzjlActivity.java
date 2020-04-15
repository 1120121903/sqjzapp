package com.sys8.sqjzapp.subModule.jzjl;

import android.os.Bundle;
import android.widget.ListView;

import com.hjq.bar.TitleBar;
import com.sys8.sqjzapp.R;
import com.sys8.sqjzapp.baseClass.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.sys8.sqjzapp.baseClass.ActivityCollector.TitleCilckListener;

public class JzjlActivity extends BaseActivity {

    @BindView(R.id.tb_jzjl)
    TitleBar tbJzjl;
    @BindView(R.id.lv_jzjl)
    ListView lvJzjl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jzjl);
        ButterKnife.bind(this);
        TitleCilckListener(tbJzjl, this);/*title按钮监听*/
    }
}
