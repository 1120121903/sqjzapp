package com.sys8.sqjzapp.subModule.educationLearning;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import butterknife.ButterKnife;

/**
 * 教育学习分类的抽象类baseFragment：所有教育学习分类页面都要继承自这个Fragment
 */
public abstract class LearningClassificationBaseFragment extends Fragment {
    private View mContentView;
    private Context mContext;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        mContentView = inflater.inflate(setLayoutResourceID(), container, false);
        ButterKnife.bind(this, mContentView);
        mContext = getContext();
        return mContentView;
    }


    /**
     * 此方法用于返回Fragment设置ContentView的布局文件资源ID * * @return 布局文件资源ID
     */
    public abstract int setLayoutResourceID();

    /**
     * 用于过滤教育学习列表的媒体类型
     */
    public abstract void FilterMediaType(int MediaType);
}
