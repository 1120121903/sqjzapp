package com.sys8.sqjzapp.main.tztx;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.sys8.sqjzapp.R;

import butterknife.BindView;
import butterknife.OnClick;

public class FragTztx extends Fragment {

    @BindView(R.id.bt_tztx_tz)
    Button btTztxTz;
    @BindView(R.id.bt_tztx_tx)
    Button btTztxTx;
    @BindView(R.id.fl_tztx)
    FrameLayout flTztx;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.frag_tztx_main, container, false);
    }

    @OnClick(R.id.bt_tztx_tz)
    public void tzFragment(){
        replaceFragment(new FragTztx_Tz());
    }

    @OnClick(R.id.bt_tztx_tx)
    public void txFragment(){
        replaceFragment(new FragTztx_Tx());
    }

    /**
     * description:替换Fragment
     */
    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fl_tztx, fragment);
        //当前事务入栈
        //transaction.addToBackStack(null);
        transaction.commit();
    }
}
