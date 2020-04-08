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

public class GyhdActivity extends BaseActivity implements ViewPager.OnPageChangeListener {

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
        fragmentList.add(FragGyhdList.getInstance());
        fragmentList.add(FragGyhdWdList.getInstance());
        initView();
    }

    private void initView(){
        vpGyhd.addOnPageChangeListener(this);//设置页面切换时的监听器(可选，用了之后要重写它的回调方法处理页面切换时候的事务)
        vpGyhd.setAdapter(new GyhdViewPagerAdapter(getSupportFragmentManager(), fragmentList));
        tabGyhd.setupWithViewPager(vpGyhd);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) { }

    @Override
    public void onPageSelected(int position) { }

    @Override
    public void onPageScrollStateChanged(int state) { }
}
