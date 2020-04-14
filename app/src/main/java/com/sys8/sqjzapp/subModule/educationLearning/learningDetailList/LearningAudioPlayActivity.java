package com.sys8.sqjzapp.subModule.educationLearning.learningDetailList;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.hjq.bar.TitleBar;
import com.sys8.sqjzapp.R;
import com.sys8.sqjzapp.baseClass.ActivityCollector;
import com.sys8.sqjzapp.baseClass.BaseActivity;
import com.tbruyelle.rxpermissions2.RxPermissions;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LearningAudioPlayActivity extends BaseActivity {
    final RxPermissions rxPermissions = new RxPermissions(this);

    @BindView(R.id.tb_educationlearning_audio_play_titlebar)
    TitleBar tbEducationlearningAudioPlayTitlebar;
    @BindView(R.id.wv_educationlearning_audio_play_main_page)
    WebView wvEducationlearningAudioPlayMainPage;
    @BindView(R.id.bt_learning_education_audio_exam)
    Button btLearningEducationAudioExam;
    @BindView(R.id.layout_educationlearning_audio_play_main_page)
    RelativeLayout layoutEducationlearningAudioPlayMainPage;
    String title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learning_audio_play);
        ButterKnife.bind(this);
        ActivityCollector.TitleCilckListener(tbEducationlearningAudioPlayTitlebar, this);
        bindData();
        requestPremission();
    }

    public void bindData() {
        Intent intent = getIntent();
        title = intent.getStringExtra("title");
        tbEducationlearningAudioPlayTitlebar.setTitle(title);
    }
    public void requestPremission() {
        rxPermissions.request(Manifest.permission.INTERNET)
                .subscribe(granted -> {
                    if (granted) {
                        initWebView();
                    } else {
                        Log.d("permissions", Manifest.permission.INTERNET + "：" + "获取失败");
                        finish();
                    }
                });
    }
    public void initWebView() {

        wvEducationlearningAudioPlayMainPage.setHorizontalScrollBarEnabled(false);
        WebSettings settings = wvEducationlearningAudioPlayMainPage.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setDefaultTextEncodingName("UTF-8");
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        wvEducationlearningAudioPlayMainPage.setWebViewClient(new WebViewClient());
        //wvEducationlearningAudioPlayMainPage.loadUrl("https://mip.findlaw.cn/video/11708.html");
        wvEducationlearningAudioPlayMainPage.loadUrl("https://www.qingting.fm/channels/172736/programs/4998624");

    }

}
