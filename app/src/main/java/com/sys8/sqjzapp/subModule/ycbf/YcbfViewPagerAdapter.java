package com.sys8.sqjzapp.subModule.ycbf;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.List;

import static com.sys8.sqjzapp.utils.Constant.topTabs_ycbf;

public class YcbfViewPagerAdapter extends FragmentPagerAdapter {

    List<Fragment> list;

    public YcbfViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public YcbfViewPagerAdapter(FragmentManager fm,List<Fragment> list) {
        super(fm);
        this.list=list;
    }//写构造方法，方便赋值调用
    @Override
    public Fragment getItem(int arg0) {
        return list.get(arg0);
    }//根据Item的位置返回对应位置的Fragment，绑定item和Fragment

    @Override
    public int getCount() {
        return list.size();
    }//设置Item的数量

    @Override
    public CharSequence getPageTitle(int position) {
        return topTabs_ycbf[position];
    }
}
