package com.sys8.sqjzapp.subModule.educationLearning.learningDetailList;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.hjq.bar.TitleBar;
import com.sys8.sqjzapp.R;
import com.sys8.sqjzapp.baseClass.ActivityCollector;
import com.sys8.sqjzapp.subModule.onlineSignIn.LocationFragment;
import com.tbruyelle.rxpermissions2.RxPermissions;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LearningPictureDetailListActivity extends AppCompatActivity {
    final RxPermissions rxPermissions = new RxPermissions(this);
    @BindView(R.id.tb_educationlearning_picture_detail_list_titlebar)
    TitleBar tbEducationlearningPictureDetailListTitlebar;
    String title;
    @BindView(R.id.wv_educationlearning_picture_detail_list_main_page)
    WebView wvEducationlearningPictureDetailListMainPage;
    @BindView(R.id.frag_educationlearning_picture_detail_list_main_page)
    FrameLayout fragEducationlearningPictureDetailListMainPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learning_picture_detail_list);
        ButterKnife.bind(this);
        ActivityCollector.TitleCilckListener(tbEducationlearningPictureDetailListTitlebar, this);
        bindData();
        requestPremission();

    }

    public void requestPremission(){
        rxPermissions.request(Manifest.permission.INTERNET)
            .subscribe(granted -> {
                if (granted) {
                    initWebView();
                    System.out.println("  initWebView();");
                } else {
                    Log.d("permissions", Manifest.permission.INTERNET + "：" + "获取失败");
                    finish();
                }
            });

    }
    public void initWebView(){

        wvEducationlearningPictureDetailListMainPage.loadUrl("https://www.baidu.com");
        wvEducationlearningPictureDetailListMainPage.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
    }

    public void bindData() {
        Intent intent = getIntent();
        title = intent.getStringExtra("title");
        tbEducationlearningPictureDetailListTitlebar.setTitle(title);
    }
}
