package com.sys8.sqjzapp.subModule.educationLearning;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.sys8.sqjzapp.R;
import com.sys8.sqjzapp.adapters.MainFragmentAdapter;
import com.sys8.sqjzapp.subModule.educationLearning.video.AllVideoFragment;
import com.sys8.sqjzapp.subModule.educationLearning.video.PublicMoralsVideoFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class VideoEducationFragment extends Fragment {


    @BindView(R.id.education_view_page)
    ViewPager educationViewPage;
    @BindView(R.id.education_top_tab_layout)
    TabLayout educationTopTabLayout;

    private List<Fragment> fragmentList=new ArrayList<Fragment>();
    private String[] topTabs = new String[]{"A","B","C","D"};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view  =inflater.inflate(R.layout.fragment_video_education, container, false);
            fragmentList.add(new AllVideoFragment());
            fragmentList.add(new PublicMoralsVideoFragment());
            //fragmentList.add(new FragmentC());
           // fragmentList.add(new FragmentD());
        // Inflate the layout for this fragment
        //initView();
        return view;
    }
    public void initView(){
        MainFragmentAdapter adapter = new MainFragmentAdapter(getActivity().getSupportFragmentManager(),fragmentList);
        educationViewPage.setAdapter(adapter);
        educationTopTabLayout.setupWithViewPager(educationViewPage);
    }

}
