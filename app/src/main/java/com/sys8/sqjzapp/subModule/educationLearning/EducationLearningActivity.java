package com.sys8.sqjzapp.subModule.educationLearning;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.hjq.bar.TitleBar;
import com.sys8.sqjzapp.R;
import com.sys8.sqjzapp.baseClass.ActivityCollector;
import com.sys8.sqjzapp.baseClass.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EducationLearningActivity extends BaseActivity {

    @BindView(R.id.tb_educationlearning_titlebar)
    TitleBar tbEducationlearningTitlebar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_education_learning);
        ButterKnife.bind(this);
        ActivityCollector.TitleCilckListener(tbEducationlearningTitlebar, this);
        addFragment(new LearningListPageFragment());
    }

    /**
     * description:替换Fragment
     */
    public void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = this.getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.frag_educationlearning_main_page, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
    /**
     * description:替换Fragment
     */
    public void addFragment(Fragment fragment) {
        FragmentManager fragmentManager = this.getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.frag_educationlearning_main_page, fragment);
        transaction.commit();
    }

}
