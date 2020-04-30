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

import com.barnettwong.dragfloatactionbuttonlibrary.view.DragFloatActionButton;
import com.hjq.bar.TitleBar;
import com.sys8.sqjzapp.R;
import com.sys8.sqjzapp.baseClass.ActivityCollector;
import com.sys8.sqjzapp.baseClass.BaseActivity;
import com.tbruyelle.rxpermissions2.RxPermissions;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LearningVideoPlayActivity extends BaseActivity {
    final RxPermissions rxPermissions = new RxPermissions(this);
    @BindView(R.id.tb_educationlearning_video_play_titlebar)
    TitleBar tbEducationlearningVideoPlayTitlebar;
    String title;
    @BindView(R.id.wv_educationlearning_video_play_main_page)
    WebView wvEducationlearningVideoPlayMainPage;
    @BindView(R.id.bt_learning_education_video_exam)
    Button btLearningEducationVideoExam;
    @BindView(R.id.layout_educationlearning_video_play_main_page)
    RelativeLayout layoutEducationlearningVideoPlayMainPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learning_video_play);
        ButterKnife.bind(this);
        ActivityCollector.TitleCilckListener(tbEducationlearningVideoPlayTitlebar, this);
        bindData();
        requestPremission();
    }
    public void bindData() {
        Intent intent = getIntent();
        title = intent.getStringExtra("title");
        tbEducationlearningVideoPlayTitlebar.setTitle(title);
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

        wvEducationlearningVideoPlayMainPage.setHorizontalScrollBarEnabled(false);
        WebSettings settings = wvEducationlearningVideoPlayMainPage.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setDefaultTextEncodingName("UTF-8");
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        wvEducationlearningVideoPlayMainPage.setWebViewClient(new WebViewClient());
        wvEducationlearningVideoPlayMainPage.loadUrl("http://124.205.50.122:18888/");
//        wvEducationlearningVideoPlayMainPage.loadUrl("https://mip.findlaw.cn/video/11708.html");
        //wvEducationlearningVideoPlayMainPage.loadUrl("https://www.qingting.fm/channels/172736/programs/4998624");

    }


}
