package com.sys8.sqjzapp.subModule.zjwbj;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.hjq.bar.TitleBar;
import com.sys8.sqjzapp.R;
import com.sys8.sqjzapp.baseClass.BaseActivity;
import com.sys8.sqjzapp.subModule.zjwbj.adapter.ZjwbjViewPagerAdapter;
import com.sys8.sqjzapp.subModule.zjwbj.bjbgList.FragBjbgList;
import com.sys8.sqjzapp.subModule.zjwbj.delayApplyList.FragDelayApplyList;
import com.sys8.sqjzapp.subModule.zjwbj.stjkList.FragStjkList;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.sys8.sqjzapp.baseClass.ActivityCollector.TitleCilckListener;

public class ZjwbjActivity extends BaseActivity  implements ViewPager.OnPageChangeListener {

    @BindView(R.id.tb_zjwbj)
    TitleBar tbZjwbj;
    @BindView(R.id.tab_zjwbj)
    TabLayout tabZjwbj;
    @BindView(R.id.vp_zjwbj)
    ViewPager vpZjwbj;
    private List<Fragment> fragmentList=new ArrayList<Fragment>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zjwbj);
        ButterKnife.bind(this);
        TitleCilckListener(tbZjwbj, this);/*title按钮监听*/
        fragmentList.add(FragStjkList.getInstance());
        fragmentList.add(FragBjbgList.getInstance());
        fragmentList.add(FragDelayApplyList.getInstance());
        initView();
    }

    private void initView(){
        vpZjwbj.addOnPageChangeListener(this);//设置页面切换时的监听器(可选，用了之后要重写它的回调方法处理页面切换时候的事务)
        vpZjwbj.setAdapter(new ZjwbjViewPagerAdapter(getSupportFragmentManager(), fragmentList));
        tabZjwbj.setupWithViewPager(vpZjwbj);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) { }

    @Override
    public void onPageSelected(int position) { }

    @Override
    public void onPageScrollStateChanged(int state) { }

}
