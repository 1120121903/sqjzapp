package com.sys8.sqjzapp.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.sys8.sqjzapp.R;
import com.sys8.sqjzapp.adapters.ManyPictureAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FragHome extends Fragment {
    @BindView(R.id.vp_home_top)
    ViewPager vpHomeTop;
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
        viewPager();
        return view;
    }

    /**
     * description:顶部ViewPager滑动显示图片,暂不能循环播放
     */
    private void viewPager() {
        //设置ViewPager中两页之间的距离
        vpHomeTop.setPageMargin(30);
        // 设置预加载的页数，我们知道默认情况下这个参数为1，也就是左右各预加载一页，但是我们这里要让左右各预加载两页
        vpHomeTop.setOffscreenPageLimit(3);
        List<Integer> list = new ArrayList<>();
        list.add(R.drawable.img1);
        list.add(R.drawable.img2);
        list.add(R.drawable.img3);
        ManyPictureAdapter adater = new ManyPictureAdapter(view.getContext(), list);
        vpHomeTop.setAdapter(adater);
//        vpMainTop.setPageTransformer(false, new ScaleTransformer());
    }

}
