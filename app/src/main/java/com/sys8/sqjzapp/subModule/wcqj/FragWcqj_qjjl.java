package com.sys8.sqjzapp.subModule.wcqj;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.sys8.sqjzapp.R;

import butterknife.ButterKnife;

public class FragWcqj_qjjl extends Fragment {

    private static FragWcqj_qjjl fragInstanse = null;
    private WcqjActivity parentActivity = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_wcqj_qjjl, container, false);
        // Inflate the layout for this fragment
        parentActivity = (WcqjActivity) getActivity();
        ButterKnife.bind(this, view);
        return view;
    }

    private FragWcqj_qjjl() {
    }

    public static FragWcqj_qjjl getInstance() {
        if (fragInstanse == null) {
            fragInstanse = new FragWcqj_qjjl();
        }
        return fragInstanse;
    }

}
