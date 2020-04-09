package com.sys8.sqjzapp.subModule.educationLearning.learningDetailList;

import android.content.Intent;
import android.os.Bundle;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.hjq.bar.TitleBar;
import com.sys8.sqjzapp.R;
import com.sys8.sqjzapp.baseClass.ActivityCollector;
import com.tbruyelle.rxpermissions2.RxPermissions;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LearningPictureDetailListActivity extends AppCompatActivity {
    @BindView(R.id.tb_educationlearning_picture_detail_list_titlebar)
    TitleBar tbEducationlearningPictureDetailListTitlebar;
    String title;
    @BindView(R.id.frag_educationlearning_picture_detail_list_main_page)
    FrameLayout fragEducationlearningPictureDetailListMainPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learning_picture_detail_list);
        ButterKnife.bind(this);
        ActivityCollector.TitleCilckListener(tbEducationlearningPictureDetailListTitlebar, this);
        bindData();

    }


    public void bindData() {
        Intent intent = getIntent();
        title = intent.getStringExtra("title");
        tbEducationlearningPictureDetailListTitlebar.setTitle(title);
    }
}
