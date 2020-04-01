package com.sys8.sqjzapp.subModule.rcbg;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import com.sys8.sqjzapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.sys8.sqjzapp.subModule.rcbg.RcbgListData.list_RCBG;

public class FragRcbg_wdbg extends Fragment {

    private static FragRcbg_wdbg fragRcbgWdbgInstanse = null;
    @BindView(R.id.lv_rcbg)
    ListView lvRcbg;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_rcbg_wdbg, container, false);
        // Inflate the layout for this fragment
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        /* 刷新数据 */
        RcbgnListViewAdapter adapter = new RcbgnListViewAdapter(getView(),getContext(),list_RCBG,getActivity());
        lvRcbg.setAdapter(adapter);
    }

    private FragRcbg_wdbg() {
    }

    public static FragRcbg_wdbg getInstance() {
        if (fragRcbgWdbgInstanse == null) {
            fragRcbgWdbgInstanse = new FragRcbg_wdbg();
        }
        return fragRcbgWdbgInstanse;
    }

}
