package com.sys8.sqjzapp.subModule.ycbf;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.sys8.sqjzapp.R;

import butterknife.ButterKnife;

public class FragYcbf_jyfw extends Fragment {

    private static FragYcbf_jyfw fragInstanse = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_ycbf_jyfw, container, false);
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

    private FragYcbf_jyfw() { }

    public static FragYcbf_jyfw getInstance() {
        if (fragInstanse == null) {
            fragInstanse = new FragYcbf_jyfw();
        }
        return fragInstanse;
    }

}
