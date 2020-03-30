package com.sys8.sqjzapp.main.tztx;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import com.sys8.sqjzapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.sys8.sqjzapp.main.tztx.ListData.list_TZ;

public class FragTztx_Tz extends Fragment {


    @BindView(R.id.lv_tztx_tz)
    ListView lvTztxTz;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_tztx_tz, container, false);
        // Inflate the layout for this fragment
        ButterKnife.bind(this, view);
        TztxMainListViewAdapter adapter = new TztxMainListViewAdapter(getView(),getContext(),list_TZ,"TZ",getActivity());
        lvTztxTz.setAdapter(adapter);
        return view;
    }
}
