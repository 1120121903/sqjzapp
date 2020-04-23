package com.sys8.sqjzapp.main.mine;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.lixiaohui8636.widget.ClauseView;
import com.sys8.sqjzapp.R;
import com.sys8.sqjzapp.subModule.jzxz.JzxzActivity;
import com.sys8.sqjzapp.subModule.wcqj.WcqjActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FragMine extends Fragment {

    @BindView(R.id.cv_mine_wdsc)
    ClauseView cvMineWdsc;
    @BindView(R.id.cv_mine_wdqd)
    ClauseView cvMineWdqd;
    @BindView(R.id.cv_mine_wdqj)
    ClauseView cvMineWdqj;
    @BindView(R.id.cv_mine_bbgx)
    ClauseView cvMineBbgx;
    @BindView(R.id.cv_mine_jzxz)
    ClauseView cvMineJzxz;
    private View view;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        if (view == null) {
            view = inflater.inflate(R.layout.frag_mine, container, false);
        }
        ButterKnife.bind(this, view);
        return view;
    }

    //我的收藏
    @OnClick(R.id.cv_mine_wdsc)
    public void goWdsc() {
        Intent intent = new Intent(this.getActivity(), MyCollectActivity.class);
        this.startActivity(intent);
    }

    //我的签到
    @OnClick(R.id.cv_mine_wdqd)
    public void goWdqd() {
        Intent intent = new Intent(this.getActivity(), MySignInActivity.class);
        this.startActivity(intent);
    }

    //我的请假
    @OnClick(R.id.cv_mine_wdqj)
    public void goWdqj() {
        Intent intent = new Intent(this.getActivity(), WcqjActivity.class);
        this.startActivity(intent);
    }

    //矫正小组
    @OnClick(R.id.cv_mine_jzxz)
    public void goJzxz() {
        Intent intent = new Intent(this.getActivity(), JzxzActivity.class);
        this.startActivity(intent);
    }

    //版本更新
    @OnClick(R.id.cv_mine_bbgx)
    public void goBbgx() {

    }
}
