package com.sys8.sqjzapp.subModule.educationLearning;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.hjq.bar.TitleBar;
import com.sys8.sqjzapp.R;
import com.sys8.sqjzapp.baseClass.ActivityCollector;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EducationLearningActivity extends AppCompatActivity {

    @BindView(R.id.tb_educationlearning_titlebar)
    TitleBar tbEducationlearningTitlebar;
    @BindView(R.id.bt_educationlearning_video_tab)
    Button btEducationlearningVideoTab;
    @BindView(R.id.bt_educationlearning_audio_tab)
    Button btEducationlearningAudioTab;
    @BindView(R.id.bt_educationlearning_picture_tab)
    Button btEducationlearningPictureTab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_education_learning);
        ButterKnife.bind(this);
        ActivityCollector.TitleCilckListener(tbEducationlearningTitlebar, this);
    }
}
