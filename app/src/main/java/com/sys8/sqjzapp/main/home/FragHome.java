package com.sys8.sqjzapp.main.home;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.sys8.sqjzapp.R;
import com.sys8.sqjzapp.adapters.ImageAdapter;
import com.youth.banner.Banner;
import com.youth.banner.indicator.CircleIndicator;
import com.youth.banner.indicator.RoundLinesIndicator;
import com.youth.banner.util.BannerUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import static com.sys8.sqjzapp.utils.Constant.userBitMap;
import static com.sys8.sqjzapp.utils.Constant.userCircleBitmap;

public class FragHome extends Fragment {
    @BindView(R.id.banner_home_top)
    Banner bannerHomeTop;
    @BindView(R.id.indicator_home_top)
    RoundLinesIndicator indicatorHomeTop;
    @BindView(R.id.sl_home)
    ScrollView slHome;
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
        slHome.scrollTo(0, 0);//.fullScroll(ScrollView.FOCUS_UP);
        replaceFragment();
        initTopBanner();
        userBitMap = BitmapFactory.decodeResource(getResources(), R.drawable.location_timeline_imguser);
        userCircleBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.location_timeline_imguser);
        return view;
    }

    /**
     * description:替换碎片
     */
    private void replaceFragment() {
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fl_home_button, new FragHomeButton());
        transaction.replace(R.id.fl_home_message, new FragHomeMes());
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
    }

    private void initTopBanner() {
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

         bannerHomeTop.start();//开始轮播
    }

}
