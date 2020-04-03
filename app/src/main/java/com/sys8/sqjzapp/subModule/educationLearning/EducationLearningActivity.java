package com.sys8.sqjzapp.subModule.educationLearning;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.hjq.bar.TitleBar;
import com.sys8.sqjzapp.R;
import com.sys8.sqjzapp.adapters.MainFragmentAdapter;
import com.sys8.sqjzapp.baseClass.ActivityCollector;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class EducationLearningActivity extends AppCompatActivity {

    @BindView(R.id.tb_educationlearning_titlebar)
    TitleBar tbEducationlearningTitlebar;
    @BindView(R.id.vp_educationlearning_pager)
    ViewPager vpEducationlearningPager;
    @BindView(R.id.ecuation_bottom_nav_view)
    BottomNavigationView ecuationBottomNavView;

    private List<Fragment> mPageFragmentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_education_learning);
        ButterKnife.bind(this);
        ActivityCollector.TitleCilckListener(tbEducationlearningTitlebar, this);
        initFragmentPageData(); /* 底部标签页绑定布局 */
    }

    /**
     * description:底部标签页绑定布局，实现滑动切换效果
     */
    public void initFragmentPageData() {
        mPageFragmentList = new ArrayList<Fragment>(3);
        mPageFragmentList.add(new VideoEducationFragment());
        mPageFragmentList.add(new AudioEducationFragment());
        mPageFragmentList.add(new PictureEducationFragment());
        //viewpager初始化
        MainFragmentAdapter mainFragmentAdapter = new MainFragmentAdapter(getSupportFragmentManager(), mPageFragmentList);
        vpEducationlearningPager.setAdapter(mainFragmentAdapter);

        //viewpager滑动点击等监听
        ecuationBottomNavView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int menuId = item.getItemId();
                switch (menuId) {
                    case R.id.bt_educationlearning_video_tab:
                        vpEducationlearningPager.setCurrentItem(0);
                        break;
                    case R.id.bt_educationlearning_audio_tab:
                        vpEducationlearningPager.setCurrentItem(1);
                        break;
                    case R.id.bt_educationlearning_picture_tab:
                        vpEducationlearningPager.setCurrentItem(2);
                        break;
                }
                return false;
            }
        });

        vpEducationlearningPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                ecuationBottomNavView.getMenu().getItem(position).setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }
}
