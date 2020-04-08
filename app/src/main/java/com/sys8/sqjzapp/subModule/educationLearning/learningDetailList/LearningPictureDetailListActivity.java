package com.sys8.sqjzapp.subModule.educationLearning.learningDetailList;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.hjq.bar.TitleBar;
import com.sys8.sqjzapp.R;
import com.sys8.sqjzapp.baseClass.ActivityCollector;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LearningPictureDetailListActivity extends AppCompatActivity {

    @BindView(R.id.tb_educationlearning_picture_detail_list_titlebar)
    TitleBar tbEducationlearningPictureDetailListTitlebar;
    String title;
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
        title= intent.getStringExtra("title");
        tbEducationlearningPictureDetailListTitlebar.setTitle(title);
    }
}
