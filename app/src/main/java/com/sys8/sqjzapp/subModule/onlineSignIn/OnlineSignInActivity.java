package com.sys8.sqjzapp.subModule.onlineSignIn;

import android.Manifest;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.maps2d.AMap;
import com.amap.api.maps2d.CameraUpdate;
import com.amap.api.maps2d.CameraUpdateFactory;
import com.amap.api.maps2d.LocationSource;
import com.amap.api.maps2d.MapView;
import com.amap.api.maps2d.UiSettings;
import com.amap.api.maps2d.model.BitmapDescriptorFactory;
import com.amap.api.maps2d.model.MyLocationStyle;
import com.hjq.bar.TitleBar;
import com.sys8.sqjzapp.R;
import com.sys8.sqjzapp.baseClass.ActivityCollector;
import com.sys8.sqjzapp.baseClass.BaseActivity;
import com.sys8.sqjzapp.common.design.CommonShapeButton;
import com.tbruyelle.rxpermissions2.RxPermissions;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class OnlineSignInActivity extends BaseActivity implements AMapLocationListener,
        LocationSource {

    private static final int WRITE_COARSE_LOCATION_REQUEST_CODE = 1;
    final RxPermissions rxPermissions = new RxPermissions(this);
    @BindView(R.id.tb_onlinesignin_titlebar)
    TitleBar tbOnlinesigninTitlebar;
    @BindView(R.id.map)
    MapView mapView;
    @BindView(R.id.tv_onlinesignin_currentlocation)
    TextView tvOnlinesigninCurrentlocation;
    @BindView(R.id.bt_onlinesignin_signin)
    CommonShapeButton btOnlinesigninSignin;

    //地图
    private AMap aMap;
    //
    //定位
    private AMapLocationClient mLocationClient = null;//定位发起端
    private AMapLocationClientOption mLocationOption = null;//定位参数
    private OnLocationChangedListener mListener = null;//定位监听器
    //标识，用于判断是否只显示一次定位信息和用户重新定位
    private boolean isFirstLoc = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onlinesignin);
        ButterKnife.bind(this);
        ActivityCollector.TitleCilckListener(tbOnlinesigninTitlebar, this);
        //获取地图控件引用
        mapView.onCreate(savedInstanceState);
        //初始化地图控制器
        initMap();
        //获取定位权限
        requestLocPremission();
    }

    /**
     * 初始化地图
     */
    private void initMap() {
        if (aMap == null) {
            aMap = mapView.getMap();
        }
        //设置地图类型为普通地图
        aMap.setMapType(AMap.MAP_TYPE_NORMAL);
        // 创建一个设置放大级别的CameraUpdate
        CameraUpdate cu = CameraUpdateFactory.zoomTo(18);
        // 设置地图的默认放大级别
        aMap.moveCamera(cu);
    }

    /**
     * 初始化定位
     */
    private void initLoc() {
        //设置显示定位按钮 并且可以点击
        UiSettings settings = aMap.getUiSettings();
        //设置定位监听
        aMap.setLocationSource(this);
        // 是否显示定位按钮
        settings.setMyLocationButtonEnabled(true);
        // 是否可触发定位并显示定位层
        aMap.setMyLocationEnabled(true);
        //定位的小图标
        MyLocationStyle myLocationStyle = new MyLocationStyle();
        myLocationStyle.myLocationIcon(BitmapDescriptorFactory.fromResource(R.drawable.onlinesignin_location));
        myLocationStyle.radiusFillColor(android.R.color.transparent);
        myLocationStyle.strokeColor(android.R.color.transparent);
        aMap.setMyLocationStyle(myLocationStyle);
    }

    /**
     * 权限检测-动态申请权限
     */
    private void requestLocPremission() {
        /**          SDK在Android 6.0以上的版本需要进行运行检测的动态权限如下：
         /*                Manifest.permission.ACCESS_COARSE_LOCATION,   粗略定位
         /*               Manifest.permission.ACCESS_FINE_LOCATION,     精细定位
         */
        rxPermissions.request(Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.ACCESS_FINE_LOCATION)
                .subscribe(granted -> {
                    if (granted) {
                        Log.i("permissions", Manifest.permission.ACCESS_COARSE_LOCATION + "：" + "获取成功");
                        Log.i("permissions", Manifest.permission.ACCESS_FINE_LOCATION + "：" + "获取成功");
                        initLoc();
                    } else {
                        Log.i("permissions", Manifest.permission.ACCESS_COARSE_LOCATION + "：" + "获取失败");
                        Log.i("permissions", Manifest.permission.ACCESS_FINE_LOCATION + "：" + "获取失败");
                    }
                });
    }

    //定位回调i函数
    @Override
    public void onLocationChanged(AMapLocation amapLocation) {
        if (mListener != null && amapLocation != null) {
            if (amapLocation != null
                    && amapLocation.getErrorCode() == 0) {
                mListener.onLocationChanged(amapLocation);// 显示系统小蓝点
                String address = "";
                address += amapLocation.getCity();//市
                address += amapLocation.getDistrict();//区域
                address += amapLocation.getAoiName();
                Log.e("OnlineSignInActivity", "address:" + address);
                tvOnlinesigninCurrentlocation.setText(address);
            } else {
                String errText = "定位失败," + amapLocation.getErrorCode() + ": " + amapLocation.getErrorInfo();
                Log.e("AmapErr", errText);
            }
        }
    }


    //激活定位
    @Override
    public void activate(OnLocationChangedListener onLocationChangedListener) {
        mListener = onLocationChangedListener;
        if (mLocationClient == null) {
            //初始化定位
            mLocationClient = new AMapLocationClient(this);
            //初始化定位参数
            mLocationOption = new AMapLocationClientOption();
            //设置定位回调监听
            mLocationClient.setLocationListener(this);
            //设置为高精度定位模式
            mLocationOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
            // 此方法为每隔固定时间会发起一次定位请求，为了减少电量消耗或网络流量消耗，
            mLocationOption.setInterval(10000);
            //设置定位参数
            mLocationClient.setLocationOption(mLocationOption);

            // 注意设置合适的定位时间的间隔（最小间隔支持为2000ms），并且在合适时间调用stopLocation()方法来取消定位请求
            // 在定位结束后，在合适的生命周期调用onDestroy()方法
            // 在单次定位情况下，定位无论成功与否，都无需调用stopLocation()方法移除请求，定位sdk内部会移除
            mLocationClient.startLocation();//启动定位
        }
    }

    //停止定位setMyLocationEnabled
    @Override
    public void deactivate() {
        mListener = null;
        if (mLocationClient != null) {
            mLocationClient.stopLocation();
            mLocationClient.onDestroy();
        }
        mLocationClient = null;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //在activity执行onDestroy时执行mapView.onDestroy()，销毁地图
        mapView.onDestroy();
        if (null != mLocationClient) {
            mLocationClient.onDestroy();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        //在activity执行onResume时执行mapView.onResume ()，重新绘制加载地图
        mapView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        //在activity执行onPause时执行mapView.onPause ()，暂停地图的绘制
        mapView.onPause();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        //在activity执行onSaveInstanceState时执行mMapView.onSaveInstanceState (outState)，保存地图当前的状态
        mapView.onSaveInstanceState(outState);
    }
    @OnClick(R.id.bt_onlinesignin_signin)
    public void login(View v) {

        finish();
    }
}