package com.sys8.sqjzapp.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.fragment.app.Fragment;

import com.sys8.sqjzapp.R;
import com.sys8.sqjzapp.adapters.ImageAdapter;
import com.sys8.sqjzapp.common.FaceVerifyActivity;
import com.sys8.sqjzapp.subModule.onlineSignIn.OnlineSignInActivity;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FragHome extends Fragment {
    @BindView(R.id.banner_home_top)
    Banner bannerHomeTop;
    @BindView(R.id.iv_home_message)
    ImageView ivHomeMessage;
    @BindView(R.id.bt_home_message_detail)
    Button btHomeMessageDetail;
    @BindView(R.id.bt_home_onlinesignin)
    Button btHomeOnlinesignin;
    @BindView(R.id.bt_home_rcbg)
    Button btHomeRcbg;
    @BindView(R.id.bt_home_jyxx)
    Button btHomeJyxx;
    @BindView(R.id.bt_home_ycbf)
    Button btHomeYcbf;
    @BindView(R.id.bt_home_wcqj)
    Button btHomeWcqj;
    @BindView(R.id.bt_home_zjwbj)
    Button btHomeZjwbj;
    @BindView(R.id.bt_home_jzdbg)
    Button btHomeJzdbg;
    @BindView(R.id.bt_home_gyhd)
    Button btHomeGyhd;
    @BindView(R.id.bt_home_jstx)
    Button btHomeJstx;
    @BindView(R.id.bt_home_xlzx)
    Button btHomeXlzx;
    @BindView(R.id.bt_home_jyxx_next)
    Button btHomeJyxxNext;
    @BindView(R.id.vv_home_jyxx1)
    VideoView vvHomeJyxx1;
    @BindView(R.id.tv_home_jyxx1_cotent)
    TextView tvHomeJyxx1Cotent;
    @BindView(R.id.tv_home_jyxx1_time)
    TextView tvHomeJyxx1Time;
    @BindView(R.id.vv_home_jyxx2)
    VideoView vvHomeJyxx2;
    @BindView(R.id.tv_home_jyxx2_cotent)
    TextView tvHomeJyxx2Cotent;
    @BindView(R.id.tv_home_jyxx2_time)
    TextView tvHomeJyxx2Time;
    private View view;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.frag_home, container, false);
        ButterKnife.bind(this, view);
        List<Integer> list = new ArrayList<>();
        list.add(R.drawable.img1);
        list.add(R.drawable.img2);
        list.add(R.drawable.img3);
        bannerHomeTop.setAdapter(new ImageAdapter(list));
        return view;
    }
    @OnClick(R.id.bt_home_onlinesignin)
    public void toSubModuleOnlineSignIn(View view){
        Intent intent = new Intent(this.getActivity(), OnlineSignInActivity.class);
        this.startActivity(intent);
    }
    /* 日常报告 */
    @OnClick(R.id.bt_home_rcbg)
    public void toSubModuleRcbg(View view){
        Intent intent = new Intent(this.getActivity(), FaceVerifyActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("SubModuleName", "rcbg"); //放入所需要传递的值
        intent.putExtras(bundle);
        this.startActivity(intent);
    }


}
