package com.sys8.sqjzapp.subModule.educationLearning.learningDetailList;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.barnettwong.dragfloatactionbuttonlibrary.view.DragFloatActionButton;
import com.hjq.bar.TitleBar;
import com.sys8.sqjzapp.R;
import com.sys8.sqjzapp.baseClass.ActivityCollector;
import com.sys8.sqjzapp.baseClass.BaseActivity;
import com.sys8.sqjzapp.subModule.educationLearning.learningExam.ExaminationActivity;
import com.tbruyelle.rxpermissions2.RxPermissions;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LearningPictureDetailListActivity extends BaseActivity {
    final RxPermissions rxPermissions = new RxPermissions(this);
    @BindView(R.id.tb_educationlearning_picture_detail_list_titlebar)
    TitleBar tbEducationlearningPictureDetailListTitlebar;
    String title;
    @BindView(R.id.wv_educationlearning_picture_detail_list_main_page)
    WebView wvEducationlearningPictureDetailListMainPage;
    @BindView(R.id.layout_educationlearning_picture_detail_list_main_page)
    RelativeLayout layoutEducationlearningPictureDetailListMainPage;
    @BindView(R.id.bt_learning_education_exam)
    DragFloatActionButton btLearningEducationExam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learning_picture_detail_list);
        ButterKnife.bind(this);
        ActivityCollector.TitleCilckListener(tbEducationlearningPictureDetailListTitlebar, this);
        bindData();
        requestPremission();

    }

    public void requestPremission() {
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

    public void initWebView() {


        wvEducationlearningPictureDetailListMainPage.setHorizontalScrollBarEnabled(false);
        WebSettings settings = wvEducationlearningPictureDetailListMainPage.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setDefaultTextEncodingName("UTF-8");
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        wvEducationlearningPictureDetailListMainPage.setWebViewClient(new WebViewClient());
        //wvEducationlearningPictureDetailListMainPage.loadUrl("https://mip.findlaw.cn/video/11708.html");

        wvEducationlearningPictureDetailListMainPage.loadUrl("file:///android_asset/learning_education_picture_detail_display.html");
    }


    public void bindData() {
        Intent intent = getIntent();
        title = intent.getStringExtra("title");
        tbEducationlearningPictureDetailListTitlebar.setTitle(title);
    }


    /**
     * 跳转到考试页面
     */
    public void toExamPage(){
        Intent intent_exam=new Intent(this, ExaminationActivity.class); //参数1:Fragment所依存的Activity,参数2：要跳转的Activity
        this.startActivity(intent_exam); //这里一定要获取到所在Activity再startActivity()；
    }



    /**
     * 考试提醒
     */
    @OnClick(R.id.bt_learning_education_exam)
    public void showExamHintDialog(){
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setMessage("确定开始考试吗？")
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        toExamPage();
                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
        dialog.show();
    }
}
