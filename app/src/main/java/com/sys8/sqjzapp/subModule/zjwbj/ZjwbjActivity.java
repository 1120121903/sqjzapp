package com.sys8.sqjzapp.subModule.zjwbj;

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

public class ZjwbjActivity extends BaseActivity {

    @BindView(R.id.tb_zjwbj)
    TitleBar tbZjwbj;
    @BindView(R.id.fl_zjwbj)
    FrameLayout flZjwbj;
    @BindView(R.id.bt_zjwbj_tbbj)
    Button btZjwbjTbbj;
    @BindView(R.id.bt_zjwbj_bjjl)
    Button btZjwbjBjjl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zjwbj);
        ButterKnife.bind(this);
        TitleCilckListener(tbZjwbj, this);/*title按钮监听*/
        replaceFragment(FragZjwbj_tbbj.getInstance());
    }

    @OnClick(R.id.bt_zjwbj_tbbj)
    public void  zjwbjTbbjFragment(){
        btZjwbjTbbj.setBackground(getDrawable(R.color.green_select));
        btZjwbjBjjl.setBackground(getDrawable(R.color.green));
        replaceFragment(FragZjwbj_tbbj.getInstance());
    }

    @OnClick(R.id.bt_zjwbj_bjjl)
    public void  zjwbjBjjlFragment(){
        btZjwbjTbbj.setBackground(getDrawable(R.color.green_select));
        btZjwbjBjjl.setBackground(getDrawable(R.color.green));
        replaceFragment(FragZjwbj_bjjl.getInstance());
    }

    /**
     * description:替换Fragment
     */
    public void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fl_zjwbj, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
