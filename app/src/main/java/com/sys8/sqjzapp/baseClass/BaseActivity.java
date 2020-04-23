package com.sys8.sqjzapp.baseClass;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

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

    /**
     *description:重写活动创建方法
     */
    @Override
    protected void onCreate(Bundle savedInstancestate) {
        super.onCreate(savedInstancestate);
        /* 将当前正在创建的活动添加到活动管理器中 */
        ActivityCollector.addActivity(this);
        Log.d("BaseActivity", getClass().getSimpleName());
        setWindowStatusBarColor(this, R.color.blue1);


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
     *
    */
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            View currentFocus = getCurrentFocus();
            if (IsShouldHideKeyboard(currentFocus, ev)) {
                HideKeyboard(currentFocus);
            }
        }
        return super.dispatchTouchEvent(ev);
    }

    private boolean IsShouldHideKeyboard(View view, MotionEvent event) {
        if ((view instanceof EditText)) {
            int[] coord = {0, 0};
            view.getLocationInWindow(coord);
            int left = coord[0], top = coord[1], right = left + view.getWidth(), bottom = top + view.getHeight();
            int evX = (int) event.getRawX(), evY = (int) event.getRawY();
            return !((left <= evX && evX <= right) && (top <= evY && evY <= bottom));
        }
        return false;
    }

    public void HideKeyboard(View v) {
        InputMethodManager manager = ((InputMethodManager) getApplicationContext().getSystemService(Context.INPUT_METHOD_SERVICE));

        if (manager != null)
            manager.hideSoftInputFromWindow(v.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        v.clearFocus();
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
