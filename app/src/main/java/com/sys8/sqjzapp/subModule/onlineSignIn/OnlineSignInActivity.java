package com.sys8.sqjzapp.subModule.onlineSignIn;

import android.Manifest;
import android.os.Bundle;
import android.util.Log;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.hjq.bar.TitleBar;
import com.sys8.sqjzapp.R;
import com.sys8.sqjzapp.baseClass.ActivityCollector;
import com.sys8.sqjzapp.baseClass.BaseActivity;
import com.tbruyelle.rxpermissions2.RxPermissions;

import butterknife.BindView;
import butterknife.ButterKnife;

public class OnlineSignInActivity extends BaseActivity {
    @BindView(R.id.tb_onlinesignin_titlebar)
    TitleBar tbOnlinesigninTitlebar;

    final RxPermissions rxPermissions = new RxPermissions(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onlinesignin);
        ButterKnife.bind(this);
        ActivityCollector.TitleCilckListener(tbOnlinesigninTitlebar, this);
        //获取定位权限
        requestLocPremission();
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
                        replaceFragment(new LocationFragment());
                    } else {
                        Log.i("permissions", Manifest.permission.ACCESS_COARSE_LOCATION + "：" + "获取失败");
                        Log.i("permissions", Manifest.permission.ACCESS_FINE_LOCATION + "：" + "获取失败");
                        finish();
                    }
                });
    }

    /**
     * description:替换Fragment
     */
    public void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = this.getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.frag_onlinesignin_main_page, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

}
