package com.sys8.sqjzapp.subModule.gyhd;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.hjq.bar.TitleBar;
import com.sys8.sqjzapp.R;
import com.sys8.sqjzapp.baseClass.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.sys8.sqjzapp.baseClass.ActivityCollector.TitleCilckListener;

public class GyhdActivity extends BaseActivity {

    @BindView(R.id.tb_gyhd)
    TitleBar tbGyhd;
    @BindView(R.id.tab_gyhd)
    TabLayout tabGyhd;
    @BindView(R.id.vp_gyhd)
    ViewPager vpGyhd;
    private List<Fragment> fragmentList=new ArrayList<Fragment>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gyhd);
        ButterKnife.bind(this);
        TitleCilckListener(tbGyhd, this);/*title按钮监听*/

    }
}
