package com.sys8.sqjzapp.subModule.ycbf.bmfw;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.sys8.sqjzapp.R;

import butterknife.ButterKnife;

public class FragYcbf_bmfw extends Fragment {

    private static FragYcbf_bmfw fragInstanse = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_ycbf_bmfw, container, false);
        // Inflate the layout for this fragment
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onResume() { super.onResume(); }

    private FragYcbf_bmfw() { }

    public static FragYcbf_bmfw getInstance() {
        if (fragInstanse == null) {
            fragInstanse = new FragYcbf_bmfw();
        }
        return fragInstanse;
    }

}
