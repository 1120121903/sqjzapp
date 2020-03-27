package com.sys8.sqjzapp.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.List;

/**
 *date:2020/3/27
 *author:wy
 *description:碎片替换适配器
*/
public class MainFragmentAdapter extends FragmentStatePagerAdapter {

    private List<Fragment> mFragmentList;

    public MainFragmentAdapter(@NonNull FragmentManager fm, List<Fragment> fragments) {
        super(fm);
        this.mFragmentList = fragments;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }
}
