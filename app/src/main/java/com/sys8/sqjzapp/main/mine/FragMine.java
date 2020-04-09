package com.sys8.sqjzapp.main.mine;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.sys8.sqjzapp.R;
import butterknife.ButterKnife;

public class FragMine extends Fragment {

    private View view;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        if(view == null){
            view = inflater.inflate(R.layout.frag_mine, container, false);
        }
        ButterKnife.bind(this, view);
        return view;
    }

//    @OnClick(R.id.miv_mine_wdsc)
//    public void goWdsc(){
//        System.out.println("111111111111111");
//    }
}
