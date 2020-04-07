package com.sys8.sqjzapp.subModule.wcqj;

import android.os.Bundle;
import android.widget.Button;
import android.widget.FrameLayout;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.hjq.bar.TitleBar;
import com.sys8.sqjzapp.R;
import com.sys8.sqjzapp.baseClass.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.sys8.sqjzapp.baseClass.ActivityCollector.TitleCilckListener;

public class WcqjActivity extends BaseActivity {

    @BindView(R.id.tb_wcqj)
    TitleBar tbWcqj;
    @BindView(R.id.fl_wcqj)
    FrameLayout flWcqj;
    @BindView(R.id.bt_wcqj_wyqj)
    Button btWcqjWyqj;
    @BindView(R.id.bt_wcqj_qjjl)
    Button btWcqjQjjl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wcqj);
        ButterKnife.bind(this);
        TitleCilckListener(tbWcqj, this);/*title按钮监听*/
        addFragment(FragWcqj_wyqj.getInstance());
    }

    @OnClick(R.id.bt_wcqj_wyqj)
    public void wcqjWyqjFragment(){
        btWcqjWyqj.setBackground(getDrawable(R.color.blue));
        btWcqjQjjl.setBackground(getDrawable(R.color.blue1));
        replaceFragment(FragWcqj_wyqj.getInstance());
    }
    @OnClick(R.id.bt_wcqj_qjjl)
    public void wcqjQjjlFragment(){
        btWcqjQjjl.setBackground(getDrawable(R.color.blue));
        btWcqjWyqj.setBackground(getDrawable(R.color.blue1));
        replaceFragment(FragWcqj_qjjl.getInstance());
    }

    /**
     * description:替换Fragment
     */
    public void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fl_wcqj, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
    public void addFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fl_wcqj, fragment);
        transaction.commit();
    }
}
