package com.sys8.sqjzapp.subModule.jzdbg;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import com.sys8.sqjzapp.R;
import butterknife.ButterKnife;

public class FragJzdbg_bgsq extends Fragment {

    private static FragJzdbg_bgsq fragInstanse = null;
    private static boolean SAVE_CLICK_UNABLE;//保存按钮的状态
    private JzdbgActivity parentActivity = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SAVE_CLICK_UNABLE = false;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_jzdbg_sqbg, container, false);
        // Inflate the layout for this fragment
        ButterKnife.bind(this, view);
        parentActivity = (JzdbgActivity) getActivity();
        return view;
    }

    private FragJzdbg_bgsq() {
    }

    public static FragJzdbg_bgsq getInstance() {
        if (fragInstanse == null) {
            fragInstanse = new FragJzdbg_bgsq();
        }
        return fragInstanse;
    }

}
