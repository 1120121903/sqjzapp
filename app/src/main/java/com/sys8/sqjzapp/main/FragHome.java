package com.sys8.sqjzapp.main;

import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.sys8.sqjzapp.R;
import com.sys8.sqjzapp.adapters.ImageAdapter;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FragHome extends Fragment {
    @BindView(R.id.banner_home_top)
    Banner bannerHomeTop;
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

}
