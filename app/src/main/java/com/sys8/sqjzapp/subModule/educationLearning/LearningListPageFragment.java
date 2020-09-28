package com.sys8.sqjzapp.subModule.educationLearning;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.PopupWindow;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import com.sys8.sqjzapp.R;
import com.sys8.sqjzapp.subModule.educationLearning.learningClassification.AllFragment;
import com.sys8.sqjzapp.subModule.educationLearning.learningClassification.CurrentPolicyFragment;
import com.sys8.sqjzapp.subModule.educationLearning.learningClassification.LegalKnowledgeFragment;
import com.sys8.sqjzapp.subModule.educationLearning.learningClassification.PublicMoralsFragment;
import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import static com.sys8.sqjzapp.utils.Constant.MEDIA_TYPE_ALLMEDIA;
import static com.sys8.sqjzapp.utils.Constant.MEDIA_TYPE_AUDIO;
import static com.sys8.sqjzapp.utils.Constant.MEDIA_TYPE_PICTURE;
import static com.sys8.sqjzapp.utils.Constant.MEDIA_TYPE_VIDEO;

public class LearningListPageFragment extends Fragment{


    @BindView(R.id.education_view_page)
    ViewPager educationViewPage;
    @BindView(R.id.education_top_tab_layout)
    TabLayout educationTopTabLayout;
    @BindView(R.id.education_media_type_select)
    ImageButton educationMediaTypeSelect;

    private PopupWindow pop;
    MyAdapter adapter;

    static final int NUM_ITEMS = 4;
    private List<LearningClassificationBaseFragment> fragmentList=new ArrayList<LearningClassificationBaseFragment>();;
    private String[] topTabs = new String[]{"全部","公共道德","法律常识","时事政治"};
    private Unbinder unbinder;
    private View view;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view  =inflater.inflate(R.layout.fragment_learning_list_page, container, false);
        unbinder = ButterKnife.bind(this, view);
            fragmentList.add(new AllFragment());
            fragmentList.add(new PublicMoralsFragment());
            fragmentList.add(new LegalKnowledgeFragment());
            fragmentList.add(new CurrentPolicyFragment());
        initView();
        return view;
    }
    public void initView(){
        System.out.println("LearningListPageFragment initView");

        //FragmentManager fragmentManager = this.getChildFragmentManager();//getActivity().getSupportFragmentManager();//
        adapter = new MyAdapter(getActivity().getSupportFragmentManager());
        educationViewPage.setAdapter(adapter);
        educationTopTabLayout.setupWithViewPager(educationViewPage);
    }

    @Override
    public void onResume() {
        super.onResume();
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
        public LearningClassificationBaseFragment getItem(int position) {
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

    @OnClick(R.id.education_media_type_select)
    public void showMediaTypeSelectPopWindow(){
        //弹出框初始化
        initPopWindow();
        //弹出框位置设定 ：相对educationMediaTypeSelect按钮，垂直下移6dp
        pop.showAsDropDown(educationMediaTypeSelect,0,6);
    }

    /**
     * 弹出框：教育学习内容分类选择（视频、音频、图文）
     */
    public void initPopWindow(){
        View contentView = View.inflate(getActivity(), R.layout.ppw_learning_media_type_select, null);
        pop = new PopupWindow(contentView,
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT, true);
        //在此pop的区域 外点击关闭此窗口
        pop.setOutsideTouchable(true);

        //布局内的按钮-视频、音频、图文
        Button bt_all = (Button)contentView.findViewById(R.id.bt_educationlearning_ppw_all);
        Button bt_video = (Button)contentView.findViewById(R.id.bt_educationlearning_ppw_video);
        Button bt_audio = (Button)contentView.findViewById(R.id.bt_educationlearning_ppw_audio);
        Button bt_picture = (Button)contentView.findViewById(R.id.bt_educationlearning_ppw_picture);
        bt_all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapter.getItem(educationViewPage.getCurrentItem()).FilterMediaType(MEDIA_TYPE_ALLMEDIA);
                pop.dismiss();
            }
        });
        bt_video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter.getItem(educationViewPage.getCurrentItem()).FilterMediaType(MEDIA_TYPE_VIDEO);
                pop.dismiss();
            }
        });
        bt_audio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter.getItem(educationViewPage.getCurrentItem()).FilterMediaType(MEDIA_TYPE_AUDIO);
                pop.dismiss();
            }
        });
        bt_picture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter.getItem(educationViewPage.getCurrentItem()).FilterMediaType(MEDIA_TYPE_PICTURE);
                pop.dismiss();
            }
        });
    }


}
