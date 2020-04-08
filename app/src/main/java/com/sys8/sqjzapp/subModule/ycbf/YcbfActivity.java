package com.sys8.sqjzapp.subModule.ycbf;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.hjq.bar.TitleBar;
import com.sys8.sqjzapp.R;
import com.sys8.sqjzapp.baseClass.BaseActivity;
import com.sys8.sqjzapp.subModule.ycbf.bmfw.FragYcbfBmfw;
import com.sys8.sqjzapp.subModule.ycbf.jyfw.FragYcbfJyfw;
import com.sys8.sqjzapp.subModule.ycbf.shbz.FragYcbfShbz;
import com.sys8.sqjzapp.subModule.ycbf.shfw.FragYcbfShfw;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.sys8.sqjzapp.baseClass.ActivityCollector.TitleCilckListener;

public class YcbfActivity extends BaseActivity implements ViewPager.OnPageChangeListener {

    @BindView(R.id.tb_ycbf)
    TitleBar tbYcbf;
    @BindView(R.id.tab_ycbf)
    TabLayout tabYcbf;
    @BindView(R.id.vp_ycbf)
    ViewPager vpYcbf;
    private List<Fragment> fragmentList=new ArrayList<Fragment>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ycbf);
        ButterKnife.bind(this);
        TitleCilckListener(tbYcbf, this);/*title按钮监听*/
        fragmentList.add(FragYcbfShbz.getInstance());
        fragmentList.add(FragYcbfBmfw.getInstance());
        fragmentList.add(FragYcbfShfw.getInstance());
        fragmentList.add(FragYcbfJyfw.getInstance());
        initView();
    }

    private void initView(){
        vpYcbf.addOnPageChangeListener(this);//设置页面切换时的监听器(可选，用了之后要重写它的回调方法处理页面切换时候的事务)
        vpYcbf.setAdapter(new YcbfViewPagerAdapter(getSupportFragmentManager(), fragmentList));
        tabYcbf.setupWithViewPager(vpYcbf);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) { }

    @Override
    public void onPageSelected(int position) { }

    @Override
    public void onPageScrollStateChanged(int state) { }

}
