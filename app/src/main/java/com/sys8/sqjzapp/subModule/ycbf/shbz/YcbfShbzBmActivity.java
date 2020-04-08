package com.sys8.sqjzapp.subModule.ycbf.shbz;

import android.os.Bundle;
import android.widget.FrameLayout;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.hjq.bar.TitleBar;
import com.sys8.sqjzapp.R;
import com.sys8.sqjzapp.baseClass.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.sys8.sqjzapp.baseClass.ActivityCollector.TitleCilckListener;

public class YcbfShbzBmActivity extends BaseActivity {

    @BindView(R.id.tb_ycbf_shbz_bm)
    TitleBar tbYcbfShbzBm;
    @BindView(R.id.fl_ycbf_shbz)
    FrameLayout flYcbfShbz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ycbf_shbz_apply);
        ButterKnife.bind(this);
        TitleCilckListener(tbYcbfShbzBm, this);/*title按钮监听*/
        addFragment(FragYcbfShbzSqbm.getInstance());
    }

    /**
     * description:替换Fragment
     */
    public void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fl_ycbf_shbz, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
    public void addFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fl_ycbf_shbz, fragment);
        transaction.commit();
    }

}
