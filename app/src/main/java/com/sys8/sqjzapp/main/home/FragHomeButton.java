package com.sys8.sqjzapp.main.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.sys8.sqjzapp.R;
import com.sys8.sqjzapp.common.FaceVerifyActivity;
import com.sys8.sqjzapp.subModule.gyhd.GyhdActivity;
import com.sys8.sqjzapp.subModule.hksq.HksqActivity;
import com.sys8.sqjzapp.subModule.jstx.JstxActivity;
import com.sys8.sqjzapp.subModule.jzdbg.JzdbgActivity;
import com.sys8.sqjzapp.subModule.jzjl.JzjlActivity;
import com.sys8.sqjzapp.subModule.tdqy.TdqyActivity;
import com.sys8.sqjzapp.subModule.wcqj.WcqjActivity;
import com.sys8.sqjzapp.subModule.xlzx.XlzxActivity;
import com.sys8.sqjzapp.subModule.ycbf.YcbfActivity;
import com.sys8.sqjzapp.subModule.zjwbj.ZjwbjActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FragHomeButton extends Fragment {

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
            view = inflater.inflate(R.layout.home_button, container, false);
        }
        ButterKnife.bind(this, view);
        return view;
    }

    /*网上签到*/
    @OnClick(R.id.bt_home_onlinesignin)
    public void toSubModuleOnlineSignIn(View view) {
        Intent intent = new Intent(this.getActivity(), FaceVerifyActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("SubModuleName", "wsqd"); //网上签到
        intent.putExtras(bundle);
        this.startActivity(intent);
    }

    /* 日常报告 */
    @OnClick(R.id.bt_home_rcbg)
    public void toSubModuleRcbg(View view) {
        Intent intent = new Intent(this.getActivity(), FaceVerifyActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("SubModuleName", "rcbg"); //日常报告
        intent.putExtras(bundle);
        this.startActivity(intent);
    }

    /*教育学习*/
    @OnClick(R.id.bt_home_jyxx)
    public void toSubModuleJyxx(View view) {
        Intent intent = new Intent(this.getActivity(), FaceVerifyActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("SubModuleName", "jyxx"); //教育学习
        intent.putExtras(bundle);
        this.startActivity(intent);
    }

    /* 外出请假 */
    @OnClick(R.id.bt_home_wcqj)
    public void toSubModuleWcqj(View view) {
        Intent intent = new Intent(this.getActivity(), WcqjActivity.class);
//        Bundle bundle = new Bundle();
//        bundle.putString("SubModuleName", "wcqj"); //外出请假
//        intent.putExtras(bundle);
        this.startActivity(intent);
    }

    /* 暂监外病检 */
    @OnClick(R.id.bt_home_zjwbj)
    public void toSubModuleZjwbj(View view) {
        Intent intent = new Intent(this.getActivity(), ZjwbjActivity.class);
//        Bundle bundle = new Bundle();
//        bundle.putString("SubModuleName", "zjwbj"); //暂监外病检
//        intent.putExtras(bundle);
        this.startActivity(intent);
    }

    /* 居住地变更 */
    @OnClick(R.id.bt_home_jzdbg)
    public void toSubModuleJzdbg(View view) {
        Intent intent = new Intent(this.getActivity(), JzdbgActivity.class);
//        Bundle bundle = new Bundle();
//        bundle.putString("SubModuleName", "jzdbg"); //居住地变更
//        intent.putExtras(bundle);
        this.startActivity(intent);
    }

    /* 远程帮扶 */
    @OnClick(R.id.bt_home_ycbf)
    public void toSubModuleYcbf(View view) {
        Intent intent = new Intent(this.getActivity(), YcbfActivity.class);
        this.startActivity(intent);
    }

    /* 公益活动 */
    @OnClick(R.id.bt_home_gyhd)
    public void toSubModuleGyhd(View view) {
        Intent intent = new Intent(this.getActivity(), GyhdActivity.class);
        this.startActivity(intent);
    }

    /* 即时通信 */
    @OnClick(R.id.bt_home_jstx)
    public void toSubModuleJstx(View view) {
        Intent intent = new Intent(this.getActivity(), JstxActivity.class);
        this.startActivity(intent);
    }

    /* 心理咨询 */
    @OnClick(R.id.bt_home_xlzx)
    public void toSubModuleXlzx(View view) {
        Intent intent = new Intent(this.getActivity(), XlzxActivity.class);
        this.startActivity(intent);
    }

    /* 特定区域 */
    @OnClick(R.id.bt_home_tdqy)
    public void toSubModuleTdqy(View view) {
        Intent intent = new Intent(this.getActivity(), TdqyActivity.class);
        this.startActivity(intent);
    }

    /* 会客申请 */
    @OnClick(R.id.bt_home_hksq)
    public void toSubModuleHksp(View view) {
        Intent intent = new Intent(this.getActivity(), HksqActivity.class);
        this.startActivity(intent);
    }
}
