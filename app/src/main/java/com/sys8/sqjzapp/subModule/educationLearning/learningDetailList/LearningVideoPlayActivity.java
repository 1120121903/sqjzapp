package com.sys8.sqjzapp.subModule.educationLearning.learningDetailList;

import android.Manifest;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

import com.barnettwong.dragfloatactionbuttonlibrary.view.DragFloatActionButton;
import com.hjq.bar.TitleBar;
import com.sys8.sqjzapp.R;
import com.sys8.sqjzapp.baseClass.ActivityCollector;
import com.sys8.sqjzapp.baseClass.BaseActivity;
import com.tbruyelle.rxpermissions2.RxPermissions;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LearningVideoPlayActivity extends BaseActivity {
    private static final String TAG = "LearningVideoPlayActivi";
    final RxPermissions rxPermissions = new RxPermissions(this);
    private int currentPosition;
    private MediaPlayer mediaPlayer;
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
        VideoView mediaPlayerSurfaceView =(VideoView)findViewById(R.id.educationlearning_media_player);
        String videoPath="http://192.168.0.168:8008/sqjz/app/education/getCourseDetail/06c0913a3c8733725de434b29716752c?token=5f09503f9acb7e8f5adc494b659f3df5";
        mediaPlayerSurfaceView.setVideoPath(videoPath);
        mediaPlayerSurfaceView.start();
        mediaPlayerSurfaceView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

            }
        });
        MediaController mediaController = new MediaController(this,false);
        mediaController.setEnabled(false);
        mediaPlayerSurfaceView.setMediaController(mediaController);

        //        SurfaceHolder holder =mediaPlayerSurfaceView.getHolder();
//        mediaPlayer =new MediaPlayer();
//        holder.addCallback(new SurfaceHolder.Callback() {
//            @Override
//            public void surfaceCreated(SurfaceHolder holder) {
//                System.out.println("surfaceCreated");
//                try {
//                    //https://sqjzvideo.oss-cn-beijing.aliyuncs.com/1.mp4
//                    //https://sqjzvideo.oss-cn-beijing.aliyuncs.com/sqjz.mp4
//                    //http://192.168.0.133:8000/sqjz/api/sqjzDataFile/download/0f985eb5667c7508bc516c8464d4d0ab?token=a376c2b91bc09dfe34c932f38e942193
//
//                    mediaPlayer.setDataSource("http://192.168.0.133:8000/sqjz/api/sqjzDataFile/download/0f985eb5667c7508bc516c8464d4d0ab?token=0baecc1f781cca481b4a44a5798cbc50");
//                    mediaPlayer.prepareAsync();
//                    mediaPlayer.setDisplay(holder);
//                    mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
//                        @Override
//                        public void onPrepared(MediaPlayer mp) {
//                            mediaPlayer.start();
//                        }
//                    });
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }

//            @Override
//            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
//
//            }
//
//            @Override
//            public void surfaceDestroyed(SurfaceHolder holder) {
//                if (mediaPlayer!=null&&mediaPlayer.isPlaying()){
//                    currentPosition=mediaPlayer.getCurrentPosition();
//                    mediaPlayer.stop();
//                }
//            }
//        });

       // mediaPlayer.setDataSource(this,"http://192.168.0.133:8000/sqjz/api/sqjzDataFile/download/0f985eb5667c7508bc516c8464d4d0ab?token=a376c2b91bc09dfe34c932f38e942193");
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
        //http://192.168.0.133:8000/sqjz/api/sqjzDataFile/download/0f985eb5667c7508bc516c8464d4d0ab?token=a376c2b91bc09dfe34c932f38e942193
     //   wvEducationlearningVideoPlayMainPage.loadUrl("http://192.168.0.133:8000/sqjz/api/sqjzDataFile/download/0f985eb5667c7508bc516c8464d4d0ab?token=a376c2b91bc09dfe34c932f38e942193");
//        wvEducationlearningVideoPlayMainPage.loadUrl("https://mip.findlaw.cn/video/11708.html");
        //wvEducationlearningVideoPlayMainPage.loadUrl("https://www.qingting.fm/channels/172736/programs/4998624");

    }


}
