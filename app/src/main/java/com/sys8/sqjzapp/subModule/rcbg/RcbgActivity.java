package com.sys8.sqjzapp.subModule.rcbg;

import android.os.Bundle;
import android.widget.Button;

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

public class RcbgActivity extends BaseActivity {

    @BindView(R.id.tb_rcbg)
    TitleBar tbRcbg;
    @BindView(R.id.bt_rcbg_txbg)
    Button btRcbgTxbg;
    @BindView(R.id.bt_rcbg_wdbg)
    Button btRcbgWdbg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rcbg);
        ButterKnife.bind(this);
        TitleCilckListener(tbRcbg, this);/*title按钮监听*/
        addFragment(FragRcbg_txbg.getInstance());
    }

    @OnClick(R.id.bt_rcbg_txbg)
    public void rcbgTxbgFragment(){
        btRcbgTxbg.setBackground(getDrawable(R.color.blue));
        btRcbgWdbg.setBackground(getDrawable(R.color.blue1));
        replaceFragment(FragRcbg_txbg.getInstance());
    }
    @OnClick(R.id.bt_rcbg_wdbg)
    public void rcbgWdbgFragment(){
        btRcbgTxbg.setBackground(getDrawable(R.color.blue1));
        btRcbgWdbg.setBackground(getDrawable(R.color.blue));
        replaceFragment(FragRcbg_wdbg.getInstance());
    }

    /**
     * description:替换Fragment
     */
    public void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fl_rcbg, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
    public void addFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fl_rcbg, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

}
