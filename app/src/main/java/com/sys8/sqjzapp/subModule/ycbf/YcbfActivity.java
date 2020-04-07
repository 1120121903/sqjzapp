package com.sys8.sqjzapp.subModule.ycbf;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.hjq.bar.TitleBar;
import com.sys8.sqjzapp.R;
import com.sys8.sqjzapp.baseClass.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

import static com.sys8.sqjzapp.baseClass.ActivityCollector.TitleCilckListener;

public class YcbfActivity extends BaseActivity implements ViewPager.OnPageChangeListener {

    @BindView(R.id.tb_ycbf)
    TitleBar tbYcbf;
    @BindView(R.id.tab_ycbf)
    TabLayout tabYcbf;
    @BindView(R.id.vp_ycbf)
    ViewPager vpYcbf;
    static final int NUM_ITEMS = 4;
    private List<Fragment> fragmentList=new ArrayList<Fragment>();
    private String[] topTabs = new String[]{"社会保障","便民服务","生活服务","就业服务"};
    private YcbfViewPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ycbf);
        ButterKnife.bind(this);
        TitleCilckListener(tbYcbf, this);/*title按钮监听*/
        fragmentList.add(new FragYcbf_shbz());
        fragmentList.add(new FragYcbf_bmfw());
        fragmentList.add(new FragYcbf_shfw());
        fragmentList.add(new FragYcbf_jyfw());
        initView();
    }

    private void initView(){
        vpYcbf.addOnPageChangeListener(this);//设置页面切换时的监听器(可选，用了之后要重写它的回调方法处理页面切换时候的事务)
        vpYcbf.setAdapter(new YcbfViewPagerAdapter(getSupportFragmentManager(), fragmentList));
        tabYcbf.setupWithViewPager(vpYcbf);
    }


    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

}
