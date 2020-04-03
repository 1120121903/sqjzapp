package com.sys8.sqjzapp.subModule.educationLearning;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.sys8.sqjzapp.R;
import com.sys8.sqjzapp.subModule.educationLearning.video.AllVideoFragment;
import com.sys8.sqjzapp.subModule.educationLearning.video.PublicMoralsVideoFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class VideoEducationFragment extends Fragment {


    @BindView(R.id.education_view_page)
    ViewPager educationViewPage;
    @BindView(R.id.education_top_tab_layout)
    TabLayout educationTopTabLayout;
    static final int NUM_ITEMS = 4;
    private List<Fragment> fragmentList=new ArrayList<Fragment>();
    private String[] topTabs = new String[]{"全部","公共道德","法律常识","时事政治"};
    private Unbinder unbinder;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view  =inflater.inflate(R.layout.fragment_video_education, container, false);
        unbinder = ButterKnife.bind(this, view);
            fragmentList.add(new AllVideoFragment());
            fragmentList.add(new PublicMoralsVideoFragment());
            fragmentList.add(new AllVideoFragment());
            fragmentList.add(new AllVideoFragment());
        initView();
        return view;
    }
    public void initView(){

        MyAdapter adapter = new MyAdapter(getActivity().getSupportFragmentManager());
        educationViewPage.setAdapter(adapter);
        educationTopTabLayout.setupWithViewPager(educationViewPage);
    }

    public class MyAdapter extends FragmentPagerAdapter {
        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return NUM_ITEMS;
        }

        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return topTabs[position];
        }
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
