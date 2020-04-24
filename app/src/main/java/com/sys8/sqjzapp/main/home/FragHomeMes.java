package com.sys8.sqjzapp.main.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;

import com.sys8.sqjzapp.R;
import com.sys8.sqjzapp.adapters.ImageAdapter;
import com.sys8.sqjzapp.adapters.TopLineAdapter;
import com.sys8.sqjzapp.main.tztx.Tzxx;
import com.sys8.sqjzapp.main.tztx.TzxxDetailActivity;
import com.youth.banner.Banner;
import com.youth.banner.indicator.CircleIndicator;
import com.youth.banner.transformer.ZoomOutPageTransformer;
import com.youth.banner.util.BannerUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.sys8.sqjzapp.main.tztx.ListData.list_TZTX_WD;
import static com.sys8.sqjzapp.utils.DataUtils.getRevertTimeLineData;

public class FragHomeMes extends Fragment {

    @BindView(R.id.image_top)
    ImageView imageTop;
    @BindView(R.id.home_tztx)
    Banner homeTztx;
    @BindView(R.id.topLine)
    LinearLayout topLine;
    @BindView(R.id.image_right)
    ImageView imageRight;
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
            view = inflater.inflate(R.layout.home_message, container, false);
        }
        ButterKnife.bind(this, view);
        initMesBanner();//初始化banner和指示器
//        homeTztx.start();//开始轮播
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        //结束轮播
        homeTztx.stop();
    }

    private void initMesBanner() {
        //通知提醒滚动显示
        homeTztx.setAdapter(new TopLineAdapter(getRevertTimeLineData(list_TZTX_WD)))
                .setOrientation(Banner.VERTICAL)
                .setPageTransformer(new ZoomOutPageTransformer())
                .setOnBannerListener((data, position) -> {
                    //Snackbar.make(bannerHomeTop, ((Tzxx) data).getTitle(), Snackbar.LENGTH_SHORT).show();
                    Intent intent = new Intent(getActivity(), TzxxDetailActivity.class);
                    Bundle bundle = new Bundle();
                    Tzxx tzxx = (Tzxx) getRevertTimeLineData(list_TZTX_WD).get(position);
                    System.out.println("title:"+tzxx.getTitle());
                    bundle.putString("title",tzxx.getTitle() );
                    intent.putExtras(bundle);
                    getActivity().startActivity(intent);
                });
    }

}
