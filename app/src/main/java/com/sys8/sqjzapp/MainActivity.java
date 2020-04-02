package com.sys8.sqjzapp;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.hjq.bar.TitleBar;
import com.sys8.sqjzapp.adapters.MainFragmentAdapter;
import com.sys8.sqjzapp.baseClass.BaseActivity;
import com.sys8.sqjzapp.main.home.FragHome;
import com.sys8.sqjzapp.main.mine.FragMine;
import com.sys8.sqjzapp.main.tztx.FragTztx;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * date:2020/3/27
 * author:wy
 * description:主页面，控制三个标签页的滑动切换
 */
public class MainActivity extends BaseActivity {

    @BindView(R.id.vp_main_pager)
    ViewPager vpMainPager;
    @BindView(R.id.tb_main_title)
    TitleBar tbMainTitle;
    private ArrayList<Fragment> mMainFragmentList;
    @BindView(R.id.bottom_nav_view)
    BottomNavigationView bnvMainBottom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
//        TitleCilckListener(tbMainTitle,this);/*title按钮监听*/
        initMainData(); /* 底部标签页绑定布局 */
    }

    /**
     * description:底部标签页绑定布局，实现滑动切换效果
     */
    private void initMainData() {
        mMainFragmentList = new ArrayList<>(3);
        mMainFragmentList.add(new FragHome());
        mMainFragmentList.add(new FragTztx());
        mMainFragmentList.add(new FragMine());

        //viewpager初始化
        MainFragmentAdapter mainFragmentAdapter = new MainFragmentAdapter(getSupportFragmentManager(), mMainFragmentList);
        vpMainPager.setAdapter(mainFragmentAdapter);

        //viewpager滑动点击等监听
        bnvMainBottom.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int menuId = item.getItemId();
                switch (menuId) {
                    case R.id.main_bottom_home:
                        vpMainPager.setCurrentItem(0);
                        break;
                    case R.id.main_bottom_message:
                        vpMainPager.setCurrentItem(1);
                        break;
                    case R.id.main_bottom_mine:
                        vpMainPager.setCurrentItem(2);
                        break;
                }
                return false;
            }
        });

        vpMainPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                //滑动到某页面让底部导航栏为选中状态
                bnvMainBottom.getMenu().getItem(position).setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}
