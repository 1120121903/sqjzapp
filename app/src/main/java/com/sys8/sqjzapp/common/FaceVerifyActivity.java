package com.sys8.sqjzapp.common;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.cymaybe.foucsurfaceview.FocusSurfaceView;
import com.hjq.bar.TitleBar;
import com.sys8.sqjzapp.R;
import com.sys8.sqjzapp.baseClass.BaseActivity;
import com.sys8.sqjzapp.subModule.educationLearning.EducationLearningActivity;
import com.sys8.sqjzapp.subModule.onlineSignIn.OnlineSignInActivity;
import com.sys8.sqjzapp.subModule.rcbg.RcbgActivity;
import com.sys8.sqjzapp.subModule.wcqj.WcqjActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.sys8.sqjzapp.baseClass.ActivityCollector.TitleCilckListener;

public class FaceVerifyActivity extends BaseActivity {

    @BindView(R.id.tb_rlsb)
    TitleBar tbRlsb;
    @BindView(R.id.preview_sv)
    FocusSurfaceView previewSv;
    @BindView(R.id.bt_faceVerify)
    Button btFaceVerify;
    String subMoudleName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_face_verify);
        ButterKnife.bind(this);
        TitleCilckListener(tbRlsb, this);/*title按钮监听*/
        subMoudleName = getSubModuleName();
    }

    @OnClick(R.id.bt_faceVerify)
    public void gotoSubModuleName(){
        Intent intent = null;
        finish();
        switch (subMoudleName){
            case "wsqd"://网上签到
                intent = new Intent(this, OnlineSignInActivity.class);
                break;
            case "rcbg"://日常报告
                intent = new Intent(this, RcbgActivity.class);
                break;
            case "jyxx"://教育学习
                intent = new Intent(this, EducationLearningActivity.class);
                break;
            case "wcqj"://外出请假
                intent = new Intent(this, WcqjActivity.class);
                break;
            case "zjwbj"://暂监外病检
                intent = new Intent(this, WcqjActivity.class);
                break;
            default:
                break;
        }
        this.startActivity(intent);
    }

    /**
     * description:获取跳转的子模块名称
     */
    private String getSubModuleName() {
        Intent intent = getIntent();
        String text = intent.getStringExtra("SubModuleName");
        System.out.println("SubModuleNamet" + text);
        switch (text){
            case "wsqd":
                btFaceVerify.setText("进入网上签到");
                break;
            case "rcbg":
                btFaceVerify.setText("进入日常报告");
                break;
            case "jyxx":
                btFaceVerify.setText("进入教育学习");
                break;
            case "wcqj":
                btFaceVerify.setText("进入外出请假");
                break;
            default:
                break;
        }
        return text;
    }

}
