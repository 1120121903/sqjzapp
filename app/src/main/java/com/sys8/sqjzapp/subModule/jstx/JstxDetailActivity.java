package com.sys8.sqjzapp.subModule.jstx;

import android.content.Intent;
import android.os.Bundle;

import com.hjq.bar.TitleBar;
import com.sys8.sqjzapp.R;
import com.sys8.sqjzapp.baseClass.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.sys8.sqjzapp.baseClass.ActivityCollector.TitleCilckListener;

public class JstxDetailActivity extends BaseActivity {

    @BindView(R.id.tb_jstx_detail)
    TitleBar tbJstxDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jstx_detail);
        ButterKnife.bind(this);
        TitleCilckListener(tbJstxDetail, this);/*title按钮监听*/
        bindData();
    }

    private void bindData(){
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String dep = intent.getStringExtra("dep");
//        tbJstxDetail.setTitle(name+"("+dep+")");
        tbJstxDetail.setTitle(name);
    }
}
