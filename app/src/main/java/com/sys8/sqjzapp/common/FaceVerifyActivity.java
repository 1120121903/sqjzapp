package com.sys8.sqjzapp.common;

import android.Manifest;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.content.FileProvider;
import com.cymaybe.foucsurfaceview.FocusSurfaceView;
import com.hjq.bar.TitleBar;
import com.sys8.sqjzapp.R;
import com.sys8.sqjzapp.baseClass.BaseActivity;
import com.sys8.sqjzapp.subModule.educationLearning.EducationLearningActivity;
import com.sys8.sqjzapp.subModule.jzdbg.JzdbgActivity;
import com.sys8.sqjzapp.subModule.onlineSignIn.OnlineSignInActivity;
import com.sys8.sqjzapp.subModule.rcbg.RcbgActivity;
import com.sys8.sqjzapp.subModule.wcqj.WcqjActivity;
import com.sys8.sqjzapp.subModule.zjwbj.ZjwbjActivity;
import com.sys8.sqjzapp.utils.Constant;
import com.tbruyelle.rxpermissions2.RxPermissions;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
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
    @BindView(R.id.iv_faceVerify_preview)
    ImageView ivFaceVerifyPreview;
    @BindView(R.id.tv_faceverity_wait)
    TextView tvFaceverityWait;
    @BindView(R.id.ly_faceverify_pass)
    LinearLayout lyFaceverifyPass;

    private Uri imageUri;
    final RxPermissions rxPermissions = new RxPermissions(this);
    public static final int TAKE_PHOTO = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_face_verify);
        ButterKnife.bind(this);
        TitleCilckListener(tbRlsb, this);/*title按钮监听*/
        rxPermissions.request(Manifest.permission.CAMERA)
                .subscribe(granted -> {
                    if (granted) {
                        takePicture();
                    } else {
                        System.out.println("camera no ");
                    }
                });
        subMoudleName = getSubModuleName();
    }

    private void takePicture() {
        File outputImage = new File(getExternalCacheDir(), "output_image.jpg");
        try {
            if (outputImage.exists()) {
                outputImage.delete();
            }
            outputImage.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        imageUri = FileProvider.getUriForFile(FaceVerifyActivity.this, "com.sys8.sqjzapp.fileprovider", outputImage);
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
        intent.putExtra("android.intent.extras.CAMERA_FACING", 3);
        startActivityForResult(intent, TAKE_PHOTO);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        switch (requestCode) {
            case TAKE_PHOTO:
                if (resultCode == RESULT_OK) {
                    try {
                        Bitmap bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(imageUri));
                        Bitmap bitmap2 = getCircularBitmap(bitmap);
                        ivFaceVerifyPreview.setImageBitmap(bitmap2);
                        Constant.userBitMap = bitmap;
                        Constant.userCircleBitmap = bitmap2;
                        ivFaceVerifyPreview.setVisibility(View.VISIBLE);
                        previewSv.setVisibility(View.GONE);
                        //一秒后显示通过人脸识别
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    Thread.sleep(1000);
                                    runOnUiThread(new Runnable() {
                                        @Override
                                        public void run() {
                                            tvFaceverityWait.setVisibility(View.INVISIBLE);
                                            lyFaceverifyPass.setVisibility(View.VISIBLE);
                                            btFaceVerify.setVisibility(View.VISIBLE);
                                        }
                                    });
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                        }).start();

                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }


                }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }




    /**
     * 获取圆形图片
     */
    public  Bitmap getCircularBitmap(Bitmap square) {
        if (square == null) return null;
        Bitmap output = Bitmap.createBitmap(square.getWidth(), square.getHeight(), Bitmap.Config.ARGB_8888);

        final Rect rect = new Rect(0, 0, square.getWidth(), square.getHeight());
        Canvas canvas = new Canvas(output);

        int halfWidth = square.getWidth() / 2;
        int halfHeight = square.getHeight() / 2;

        final Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setFilterBitmap(true);

        canvas.drawCircle(halfWidth, halfHeight, Math.min(halfWidth, halfHeight), paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(square, rect, rect, paint);
        return output;
    }


    @OnClick(R.id.bt_faceVerify)
    public void gotoSubModuleName() {
        Intent intent = null;
        finish();
        switch (subMoudleName) {
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
                intent = new Intent(this, ZjwbjActivity.class);
                break;
            case "jzdbg"://居住地变更
                intent = new Intent(this, JzdbgActivity.class);
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
        switch (text) {
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
            case "zjwbj":
                btFaceVerify.setText("进入暂监外病检");
                break;
            case "jzdbg":
                btFaceVerify.setText("进入居住地变更");
                break;
            default:
                break;
        }
        return text;
    }

}
