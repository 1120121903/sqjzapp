package com.sys8.sqjzapp.main.tztx;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.sys8.sqjzapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import static com.sys8.sqjzapp.main.tztx.ListData.list_TZTX;

public class FragTztx extends Fragment {

    @BindView(R.id.bt_tztx_tz)
    Button btTztxTz;
    @BindView(R.id.bt_tztx_tx)
    Button btTztxTx;
    @BindView(R.id.fl_tztx)
    FrameLayout flTztx;
    @BindView(R.id.line_tztx_main_list)
    LinearLayout lineTztxMainList;
    @BindView(R.id.lv_tztx)
    ListView lvTztx;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.frag_tztx_main, container, false);
        ButterKnife.bind(this, view);
        bindListData();
        return view;
    }

    private void bindListData(){
        TztxMainListViewAdapter adapter = new TztxMainListViewAdapter(getView(),getContext(),list_TZTX,"TZTX",getActivity());
        lvTztx.setAdapter(adapter);
    }

    @OnClick(R.id.bt_tztx_tz)
    public void tzFragment() {
        btTztxTz.setTextSize(15);
        btTztxTx.setTextSize(13);
        lineTztxMainList.setVisibility(View.GONE);
        replaceFragment(new FragTztx_Tz());
    }

    @OnClick(R.id.bt_tztx_tx)
    public void txFragment() {
        btTztxTz.setTextSize(13);
        btTztxTx.setTextSize(15);
        lineTztxMainList.setVisibility(View.GONE);
        replaceFragment(new FragTztx_Tx());
    }

    /**
     * description:替换Fragment
     */
    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fl_tztx, fragment);
        transaction.commit();
    }

}
