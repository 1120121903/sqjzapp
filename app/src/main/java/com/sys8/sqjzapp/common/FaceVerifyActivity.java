package com.sys8.sqjzapp.common;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ImageFormat;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CaptureRequest;
import android.media.Image;
import android.media.ImageReader;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.SparseIntArray;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.app.ActivityCompat;

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
import com.sys8.sqjzapp.utils.ImageRotateUtils;
import com.tbruyelle.rxpermissions2.RxPermissions;

import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.sys8.sqjzapp.baseClass.ActivityCollector.TitleCilckListener;
import static com.sys8.sqjzapp.utils.ImageRotateUtils.getCircularBitmap;
import static com.sys8.sqjzapp.utils.ImageRotateUtils.readPictureDegree;
import static com.sys8.sqjzapp.utils.ImageRotateUtils.rotateBitmap;

public class FaceVerifyActivity extends BaseActivity {

    @BindView(R.id.tb_rlsb)
    TitleBar tbRlsb;
    @BindView(R.id.fsc_faceVerify_preview)
    FocusSurfaceView previewSv;
    @BindView(R.id.bt_faceVerify)
    Button btFaceVerify;
    @BindView(R.id.iv_faceVerify_preview)
    ImageView ivFaceVerifyPreview;
    @BindView(R.id.tv_faceverity_wait)
    TextView tvFaceverityWait;
    @BindView(R.id.ly_faceverify_pass)
    LinearLayout lyFaceverifyPass;
    @BindView(R.id.bt_takePhoto)
    ImageButton btTakePhoto;

    private static final int REQUEST_CAMERA_CODE = 100;
    private static final SparseIntArray ORIENTATIONS = new SparseIntArray();
    private String subMoudleName;

    ///为了使照片竖直显示,前置摄像头
    static {
        ORIENTATIONS.append(Surface.ROTATION_0, 270);
        ORIENTATIONS.append(Surface.ROTATION_90, 0);
        ORIENTATIONS.append(Surface.ROTATION_180, 90);
        ORIENTATIONS.append(Surface.ROTATION_270, 180);
    }

    private SurfaceHolder mSurfaceHolder;
    private CameraManager mCameraManager;//摄像头管理器
    private Handler childHandler, mainHandler;
    private String mCameraID;//摄像头Id 0 为后  1 为前
    private ImageReader mImageReader;
    private CameraCaptureSession mCameraCaptureSession;
    private CameraDevice mCameraDevice;
    private ByteBuffer buffer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_face_verify);
        ButterKnife.bind(this);
        TitleCilckListener(tbRlsb, this);/*title按钮监听*/
        subMoudleName = getSubModuleName();
        initView();
    }

    @OnClick(R.id.bt_takePhoto)
    public void takePhoto() {
        btTakePhoto.setVisibility(View.GONE);
        tvFaceverityWait.setVisibility(View.INVISIBLE);
        takePicture();
    }

    /**
     * 摄像头创建监听
     */
    private CameraDevice.StateCallback stateCallback = new CameraDevice.StateCallback() {
        @Override
        public void onOpened(CameraDevice camera) {//打开摄像头
            mCameraDevice = camera;
            //开启预览
            takePreview();
        }

        //关闭摄像头
        @Override
        public void onDisconnected(CameraDevice camera) {
            if (null != mCameraDevice) {
                mCameraDevice.close();
                mCameraDevice = null;
            }
        }

        //发生错误
        @Override
        public void onError(CameraDevice camera, int error) {
            Toast.makeText(FaceVerifyActivity.this, "摄像头开启失败", Toast.LENGTH_SHORT).show();
        }
    };

    /**
     * 初始化
     */
    private void initView() {
        mSurfaceHolder = previewSv.getHolder();
        mSurfaceHolder.setKeepScreenOn(true);
        // mSurfaceView添加回调
        mSurfaceHolder.addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder holder) { //SurfaceView创建
                // 初始化Camera
                initCamera2();
            }

            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
            }

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) { //SurfaceView销毁
                // 释放Camera资源
                if (null != mCameraDevice) {
                    mCameraDevice.close();
                    mCameraDevice = null;
                }
            }
        });
    }

    /**
     * 初始化Camera2
     */
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void initCamera2() {
        HandlerThread handlerThread = new HandlerThread("Camera2");
        handlerThread.start();
        childHandler = new Handler(handlerThread.getLooper());
        mainHandler = new Handler(getMainLooper());
        mCameraID = "" + CameraCharacteristics.LENS_FACING_BACK;//前摄像头
        mImageReader = ImageReader.newInstance(1080, 1920, ImageFormat.JPEG, 10);
        mImageReader.setOnImageAvailableListener(new ImageReader.OnImageAvailableListener() { //可以在这里处理拍照得到的临时照片 例如，写入本地
            @Override
            public void onImageAvailable(ImageReader reader) {
                //mCameraDevice.close();
                // 拿到拍照照片数据
                Image image = reader.acquireNextImage();
                buffer = image.getPlanes()[0].getBuffer();
                byte[] bytes = new byte[buffer.remaining()];
                buffer.get(bytes);//由缓冲区存入字节数组
                Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
                //角度旋转
                InputStream sbs = new ByteArrayInputStream(bytes);
                Bitmap bitmap1 = rotateBitmap(bitmap, readPictureDegree(sbs));
                //前置时左右翻转时处理
                Matrix m = new Matrix();
                m.postScale(-1, 1); // 镜像水平翻转
                bitmap1 = Bitmap.createBitmap(bitmap1, 0, 0, bitmap1.getWidth(), bitmap1.getHeight(), m, true);
                if (bitmap1 != null) {
                    ivFaceVerifyPreview.setImageBitmap(bitmap1);
                    previewSv.setVisibility(View.GONE);
                    ivFaceVerifyPreview.setVisibility(View.VISIBLE);
                    //一秒后显示通过人脸识别
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                Thread.sleep(1000);
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        btFaceVerify.setVisibility(View.VISIBLE);
                                        lyFaceverifyPass.setVisibility(View.VISIBLE);
                                        btFaceVerify.setVisibility(View.VISIBLE);
                                    }
                                });
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }).start();
                }
            }
        }, mainHandler);
        //获取摄像头管理
        mCameraManager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);
        try {
            if (ActivityCompat.checkSelfPermission(FaceVerifyActivity.this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                //申请WRITE_EXTERNAL_STORAGE权限
                requestPermissions(new String[]{Manifest.permission.CAMERA},
                        REQUEST_CAMERA_CODE);
                //return;
            } else {
                //打开摄像头
                mCameraManager.openCamera(mCameraID, stateCallback, mainHandler);
            }
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }
    }

    /**
     * 权限获取返回值
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_CAMERA_CODE) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permission Granted
                try {
                    mCameraManager.openCamera(mCameraID, stateCallback, mainHandler);
                } catch (CameraAccessException e) {
                    e.printStackTrace();
                } catch (SecurityException e) {
                    e.printStackTrace();
                }
            } else {
                // Permission Denied
            }
        }
    }

    /**
     * 开始预览
     */
    private void takePreview() {
        try {
            // 创建预览需要的CaptureRequest.Builder
            final CaptureRequest.Builder previewRequestBuilder = mCameraDevice.createCaptureRequest(CameraDevice.TEMPLATE_PREVIEW);
            // 将SurfaceView的surface作为CaptureRequest.Builder的目标
            previewRequestBuilder.addTarget(mSurfaceHolder.getSurface());
            // 创建CameraCaptureSession，该对象负责管理处理预览请求和拍照请求
            mCameraDevice.createCaptureSession(Arrays.asList(mSurfaceHolder.getSurface(), mImageReader.getSurface()), new CameraCaptureSession.StateCallback() // ③
            {
                @Override
                public void onConfigured(CameraCaptureSession cameraCaptureSession) {
                    if (null == mCameraDevice) return;
                    // 当摄像头已经准备好时，开始显示预览
                    mCameraCaptureSession = cameraCaptureSession;
                    try {
                        // 自动对焦
                        previewRequestBuilder.set(CaptureRequest.CONTROL_AF_MODE, CaptureRequest.CONTROL_AF_MODE_CONTINUOUS_PICTURE);
                        // 打开闪光灯
                        previewRequestBuilder.set(CaptureRequest.CONTROL_AE_MODE, CaptureRequest.CONTROL_AE_MODE_ON_AUTO_FLASH);
                        // 显示预览
                        CaptureRequest previewRequest = previewRequestBuilder.build();
                        mCameraCaptureSession.setRepeatingRequest(previewRequest, null, childHandler);
                    } catch (CameraAccessException e) {
                        e.printStackTrace();
                    }
                }

                @Override
                public void onConfigureFailed(CameraCaptureSession cameraCaptureSession) {
                    Toast.makeText(FaceVerifyActivity.this, "配置失败", Toast.LENGTH_SHORT).show();
                }
            }, childHandler);
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }
    }

    /**
     * 拍照
     */
    private void takePicture() {
        if (mCameraDevice == null) return;
        // 创建拍照需要的CaptureRequest.Builder
        final CaptureRequest.Builder captureRequestBuilder;
        try {
            captureRequestBuilder = mCameraDevice.createCaptureRequest(CameraDevice.TEMPLATE_STILL_CAPTURE);
            // 将imageReader的surface作为CaptureRequest.Builder的目标
            captureRequestBuilder.addTarget(mImageReader.getSurface());
            // 自动对焦
            captureRequestBuilder.set(CaptureRequest.CONTROL_AF_MODE, CaptureRequest.CONTROL_AF_MODE_CONTINUOUS_PICTURE);
            // 自动曝光
            captureRequestBuilder.set(CaptureRequest.CONTROL_AE_MODE, CaptureRequest.CONTROL_AE_MODE_ON_AUTO_FLASH);
            // 获取手机方向
            int rotation = this.getWindowManager().getDefaultDisplay().getRotation();
            System.out.println("rotation:" + rotation);
            System.out.println("ORIENTATIONS.get(rotation):" + ORIENTATIONS.get(rotation));
            // 根据设备方向计算设置照片的方向
            captureRequestBuilder.set(CaptureRequest.JPEG_ORIENTATION, ORIENTATIONS.get(rotation));
            //拍照
            CaptureRequest mCaptureRequest = captureRequestBuilder.build();
            mCameraCaptureSession.capture(mCaptureRequest, null, childHandler);
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }
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
        btFaceVerify.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG ); // 下划线
        switch (text) {
            case "wsqd":
                btFaceVerify.setText("网上签到");
                break;
            case "rcbg":
                btFaceVerify.setText("日常报告");
                break;
            case "jyxx":
                btFaceVerify.setText("教育学习");
                break;
            default:
                break;
        }
        return text;
    }

}
