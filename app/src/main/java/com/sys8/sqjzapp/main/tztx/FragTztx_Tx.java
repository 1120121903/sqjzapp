package com.sys8.sqjzapp.main.tztx;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import com.sys8.sqjzapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.sys8.sqjzapp.main.tztx.ListData.list_TX;

public class FragTztx_Tx extends Fragment {

    private static FragTztx_Tx fragTztxInstanse = null;

    @BindView(R.id.lv_tztx_tx)
    ListView lvTztxTx;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_tztx_tx, container, false);
        // Inflate the layout for this fragment
        ButterKnife.bind(this, view);
        TztxMainListViewAdapter adapter = new TztxMainListViewAdapter(getView(), getContext(), list_TX, "TX", getActivity());
        lvTztxTx.setAdapter(adapter);
        return view;
    }

    private FragTztx_Tx() {
    }

    public static FragTztx_Tx getInstance() {
        if (fragTztxInstanse == null) {
            fragTztxInstanse = new FragTztx_Tx();
        }
        return fragTztxInstanse;
    }
}
