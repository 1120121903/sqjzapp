package com.sys8.sqjzapp.subModule.gyhd;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.sys8.sqjzapp.R;

import butterknife.ButterKnife;

public class FragGyhdWdList extends Fragment {

    private static FragGyhdWdList fragInstanse = null;
    private GyhdViewPagerAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_gyhd_wdlist, container, false);
        // Inflate the layout for this fragment
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        /* 刷新数据 */
//        lvQjjl.setAdapter(adapter);
    }

    private FragGyhdWdList() {
    }

    public static FragGyhdWdList getInstance() {
        if (fragInstanse == null) {
            fragInstanse = new FragGyhdWdList();
        }
        return fragInstanse;
    }

}
