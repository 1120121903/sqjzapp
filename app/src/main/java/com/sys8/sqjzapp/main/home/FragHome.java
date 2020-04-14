package com.sys8.sqjzapp.main.home;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ScrollView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.snackbar.Snackbar;
import com.sys8.sqjzapp.R;
import com.sys8.sqjzapp.adapters.ImageAdapter;
import com.sys8.sqjzapp.adapters.TopLineAdapter;
import com.sys8.sqjzapp.common.FaceVerifyActivity;
import com.sys8.sqjzapp.main.tztx.Tzxx;
import com.sys8.sqjzapp.main.tztx.TzxxDetailActivity;
import com.sys8.sqjzapp.subModule.gyhd.GyhdActivity;
import com.sys8.sqjzapp.subModule.jstx.JstxActivity;
import com.sys8.sqjzapp.subModule.jzdbg.JzdbgActivity;
import com.sys8.sqjzapp.subModule.wcqj.WcqjActivity;
import com.sys8.sqjzapp.subModule.ycbf.YcbfActivity;
import com.sys8.sqjzapp.subModule.zjwbj.ZjwbjActivity;
import com.youth.banner.Banner;
import com.youth.banner.indicator.CircleIndicator;
import com.youth.banner.indicator.RoundLinesIndicator;
import com.youth.banner.transformer.ZoomOutPageTransformer;
import com.youth.banner.util.BannerUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.sys8.sqjzapp.main.tztx.ListData.list_TZTX;
import static com.sys8.sqjzapp.utils.Constant.userBitMap;
import static com.sys8.sqjzapp.utils.Constant.userCircleBitmap;
import static com.sys8.sqjzapp.utils.DataUtils.getRevertTimeLineData;

public class FragHome extends Fragment {
    @BindView(R.id.banner_home_top)
    Banner bannerHomeTop;
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
    @BindView(R.id.indicator_home_top)
    RoundLinesIndicator indicatorHomeTop;
    @BindView(R.id.sl_home)
    ScrollView slHome;
    @BindView(R.id.bt_home_jzxz)
    Button btHomeJzxz;
    @BindView(R.id.bt_home_jzjl)
    Button btHomeJzjl;
    @BindView(R.id.fl_home_zxkc)
    FrameLayout flHomeZxkc;
    @BindView(R.id.fl_home_zxbf)
    FrameLayout flHomeZxbf;
    @BindView(R.id.fl_home_zxgy)
    FrameLayout flHomeZxgy;
    @BindView(R.id.home_tztx)
    Banner homeTztx;
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
            view = inflater.inflate(R.layout.frag_home, container, false);
        }
        ButterKnife.bind(this, view);
        userBitMap = BitmapFactory.decodeResource(getResources(), R.drawable.location_timeline_imguser);
        userCircleBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.location_timeline_imguser);
        initBannerAndIndicator();//初始化banner和指示器
        bannerHomeTop.start();//开始轮播
        homeTztx.start();//开始轮播
        slHome.scrollTo(0, 0);//.fullScroll(ScrollView.FOCUS_UP);
        replaceFragment();
        return view;
    }

    /**
     * description:替换碎片
     */
    private void replaceFragment() {
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fl_home_zxkc, new FragHomeJyxx());
        transaction.replace(R.id.fl_home_zxbf, new FragHomeYcbf());
        transaction.replace(R.id.fl_home_zxgy, new FragHomeGyhd());
        transaction.commit();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        //结束轮播
        bannerHomeTop.stop();
        homeTztx.stop();
    }

    private void initBannerAndIndicator() {
        List<Integer> list = new ArrayList<>();
        list.add(R.drawable.img2);
        list.add(R.drawable.img1);
        list.add(R.drawable.img3);

        bannerHomeTop.setAdapter(new ImageAdapter(list));
        bannerHomeTop.setIndicator(new CircleIndicator(getContext()));
        //在布局文件中使用指示器，这样更灵活
        bannerHomeTop.setIndicator(indicatorHomeTop, false);
        bannerHomeTop.setIndicatorSelectedWidth((int) BannerUtils.dp2px(15));//指示器的圆角
        bannerHomeTop.setIndicatorNormalColor(getResources().getColor(R.color.white));//指示器的选中颜色
        bannerHomeTop.setIndicatorSelectedColor(getResources().getColor(R.color.red));//指示器的选中颜色
        bannerHomeTop.setBannerRound(BannerUtils.dp2px(20));//banner的圆角

        //通知提醒滚动显示
        homeTztx.setAdapter(new TopLineAdapter(getRevertTimeLineData(list_TZTX)))
                .setOrientation(Banner.VERTICAL)
                .setPageTransformer(new ZoomOutPageTransformer())
                .setOnBannerListener((data, position) -> {
//                    Snackbar.make(bannerHomeTop, ((Tzxx) data).getTitle(), Snackbar.LENGTH_SHORT).show();
                    Intent intent = new Intent(getActivity(), TzxxDetailActivity.class);
                    Bundle bundle = new Bundle();
                    Tzxx tzxx = (Tzxx) getRevertTimeLineData(list_TZTX).get(position);
                    System.out.println("title:"+tzxx.getTitle());
                    bundle.putString("title",tzxx.getTitle() );
                    intent.putExtras(bundle);
                    getActivity().startActivity(intent);
                });
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

    /* 矫正小组 */
    @OnClick(R.id.bt_home_jstx)
    public void toSubModuleJzxz(View view) {

    }

    /* 矫正记录 */
    @OnClick(R.id.bt_home_jstx)
    public void toSubModuleJzjl(View view) {

    }

}
