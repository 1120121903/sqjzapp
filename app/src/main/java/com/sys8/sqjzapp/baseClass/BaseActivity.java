package com.sys8.sqjzapp.baseClass;

import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.sys8.sqjzapp.R;
import com.tbruyelle.rxpermissions2.RxPermissions;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

import static com.sys8.sqjzapp.utils.StatusBarUtils.setWindowStatusBarColor;

public class BaseActivity extends AppCompatActivity  {
    public final RxPermissions rxPermissions = new RxPermissions(this);
    //声明mlocationClient对象
    public AMapLocationClient mlocationClient;
    //声明mLocationOption对象
    public AMapLocationClientOption mLocationOption = null;



    /**
     *description:重写活动创建方法
     */
    @Override
    protected void onCreate(Bundle savedInstancestate){
        super.onCreate(savedInstancestate);
        /* 将当前正在创建的活动添加到活动管理器中 */
        ActivityCollector.addActivity(this);
        Log.d("BaseActivity",getClass().getSimpleName());
        setWindowStatusBarColor(this, R.color.blue1);


    }


    public  Observable<String> LocationObserver(){
        Observable<String> locationObservable = Observable.create(new ObservableOnSubscribe<String>() {

            @Override
            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
//                //设置定位模式为高精度模式，Battery_Saving为低功耗模式，Device_Sensors是仅设备模式
//                mLocationOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
//                //设置定位间隔,单位毫秒,默认为2000ms
//                mLocationOption.setInterval(2000);
//                //设置定位监听
//                mlocationClient.setLocationListener(new AMapLocationListener(){
//                    @Override
//                    public void onLocationChanged(AMapLocation aMapLocation) {
//                        String address = "";
//                        if (aMapLocation != null){
//                            if (aMapLocation.getErrorCode() == 0){//成功获取定位
//                                address += aMapLocation.getCity();//市
//                                address += aMapLocation.getDistrict();//区域
//                                address += aMapLocation.getAoiName();
//                            }
//                        }
//                       // emitter.onNext(address);
//                        mlocationClient.onDestroy();
//                        System.out.println(" 1111111");
//                    }
//                });
//                mlocationClient.startLocation();
                emitter.onNext("1111111");
            }


        });
        return locationObservable;


    }





    /**
     *description:重写活动销毁方法
     */
    @Override
    protected void onDestroy(){
        super.onDestroy();
        ActivityCollector.removeActivity(this);
    }
    /**
     *description:隐藏底部虚拟手势栏，设置为全屏
     */
//    protected void hideBottomUIMenu(){
//        if (Build.VERSION.SDK_INT > 11 && Build.VERSION.SDK_INT < 19) { // lower api
//            View v = this.getWindow().getDecorView();
//            v.setSystemUiVisibility(View.GONE);
//        } else if (Build.VERSION.SDK_INT >= 19) {
//            //for new api versions.
//            View decorView = getWindow().getDecorView();
//            int uiOptions = View.SYSTEM_UI_FLAG_LAYOUT_STABLE
//                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
//                    | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
//                    | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION // hide nav bar
//                    | View.SYSTEM_UI_FLAG_FULLSCREEN // hide status bar
//                    | View.SYSTEM_UI_FLAG_IMMERSIVE;
//            decorView.setSystemUiVisibility(uiOptions);
//            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
//        }
//    }




}
