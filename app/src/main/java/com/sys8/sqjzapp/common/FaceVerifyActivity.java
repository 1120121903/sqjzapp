package com.sys8.sqjzapp.common;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.cymaybe.foucsurfaceview.FocusSurfaceView;
import com.hjq.bar.TitleBar;
import com.sys8.sqjzapp.R;
import com.sys8.sqjzapp.baseClass.BaseActivity;
import com.sys8.sqjzapp.subModule.RcbgActivity;

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
        switch (subMoudleName){
            case "rcbg":
                finish();
                Intent intent = new Intent(this, RcbgActivity.class);
                this.startActivity(intent);
                break;
            default:
                break;
        }
    }

    /**
     * description:获取跳转的子模块名称
     */
    private String getSubModuleName() {
        Intent intent = getIntent();
        String text = intent.getStringExtra("SubModuleName");
        System.out.println("SubModuleNamet" + text);
        switch (text){
            case "rcbg":
                btFaceVerify.setText("进入日常报告");
                break;
            default:
                break;
        }
        return text;
    }

}
