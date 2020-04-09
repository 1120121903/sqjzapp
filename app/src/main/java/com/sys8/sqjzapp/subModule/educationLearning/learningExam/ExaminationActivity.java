package com.sys8.sqjzapp.subModule.educationLearning.learningExam;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.hjq.bar.TitleBar;
import com.sys8.sqjzapp.R;
import com.sys8.sqjzapp.baseClass.ActivityCollector;
import com.sys8.sqjzapp.baseClass.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ExaminationActivity extends BaseActivity {

    @BindView(R.id.tb_educationlearning_exam_titlebar)
    TitleBar tbEducationlearningExamTitlebar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_examination);
        ButterKnife.bind(this);
        ActivityCollector.TitleCilckListener(tbEducationlearningExamTitlebar, this);
    }
}
