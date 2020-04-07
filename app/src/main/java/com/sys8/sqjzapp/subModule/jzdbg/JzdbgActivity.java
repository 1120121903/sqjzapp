package com.sys8.sqjzapp.subModule.jzdbg;

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

public class JzdbgActivity extends BaseActivity {

    @BindView(R.id.tb_jzdbg)
    TitleBar tbJzdbg;
    @BindView(R.id.fl_jzdbg)
    FrameLayout flJzdbg;
    @BindView(R.id.bt_jzdbg_sqbj)
    Button btJzdbgSqbj;
    @BindView(R.id.bt_jzdbg_lsbj)
    Button btJzdbgLsbj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jzdbg);
        ButterKnife.bind(this);
        TitleCilckListener(tbJzdbg, this);/*title按钮监听*/
        addFragment(FragJzdbg_bgsq.getInstance());
    }

    @OnClick(R.id.bt_jzdbg_sqbj)
    public void  jzdbgTbbjFragment(){
        btJzdbgSqbj.setBackground(getDrawable(R.color.blue));
        btJzdbgLsbj.setBackground(getDrawable(R.color.blue1));
        replaceFragment(FragJzdbg_bgsq.getInstance());
    }

    @OnClick(R.id.bt_jzdbg_lsbj)
    public void  jzdbgBgjlFragment(){
        btJzdbgSqbj.setBackground(getDrawable(R.color.blue1));
        btJzdbgLsbj.setBackground(getDrawable(R.color.blue));
        replaceFragment(FragJzdbg_bgjl.getInstance());
    }

    /**
     * description:替换Fragment
     */
    public void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fl_jzdbg, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    public void addFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fl_jzdbg, fragment);
        transaction.commit();
    }

}
