package com.sys8.sqjzapp.subModule.rcbg;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextClock;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.kingja.supershapeview.view.SuperShapeEditText;
import com.sys8.sqjzapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.sys8.sqjzapp.subModule.rcbg.RcbgListData.list_RCBG;

public class FragRcbg_txbg extends Fragment {

    private static FragRcbg_txbg fragRcbgTxbgInstanse = null;
    @BindView(R.id.bt_rcbg_txbg_save)
    Button btRcbgTxbgSave;
    @BindView(R.id.tv_rcbg_wdbg_title)
    EditText tvRcbgTitle;
    @BindView(R.id.et_rcbg_wdbg_content)
    SuperShapeEditText etRcbgContent;
    @BindView(R.id.tc_rcbg_wdbg_time)
    TextClock tcRcbgTime;
    @BindView(R.id.tv_rcbg_wdbg_place)
    TextView tvRcbgPlace;
    private RcbgActivity parentActivity = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_rcbg_txbg, container, false);
        // Inflate the layout for this fragment
        parentActivity = (RcbgActivity) getActivity();
        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick(R.id.bt_rcbg_txbg_save)
    public void saveRcbgData() {
        list_RCBG.add(new Rcbg(tcRcbgTime.getText().toString(),
                tvRcbgTitle.getText().toString(),
                etRcbgContent.getText().toString(),
                tvRcbgPlace.getText().toString()));
        parentActivity.rcbgWdbgFragment();
    }

    private FragRcbg_txbg() {
    }

    public static FragRcbg_txbg getInstance() {
        if (fragRcbgTxbgInstanse == null) {
            fragRcbgTxbgInstanse = new FragRcbg_txbg();
        }
        return fragRcbgTxbgInstanse;
    }

}
