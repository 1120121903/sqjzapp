package com.sys8.sqjzapp.main.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.sys8.sqjzapp.R;
import com.sys8.sqjzapp.subModule.gyhd.GyhdActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.sys8.sqjzapp.subModule.gyhd.GyhdListData.list_Gyhd;

public class FragHomeGyhd extends Fragment {
    @BindView(R.id.bt_home_gyhd_next)
    Button btHomeGyhdNext;
    @BindView(R.id.tv_zxgy_listItem_title1)
    TextView tvZxgyListItemTitle1;
    @BindView(R.id.tv_zxgy_listItem_time_fbsj1)
    TextView tvZxgyListItemTimeFbsj1;
    @BindView(R.id.tv_zxgy_listItem_title2)
    TextView tvZxgyListItemTitle2;
    @BindView(R.id.tv_zxgy_listItem_time_fbsj2)
    TextView tvZxgyListItemTimeFbsj2;
    private View view;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        if (view == null) {
            view = inflater.inflate(R.layout.home_gyhd, container, false);
        }
        ButterKnife.bind(this, view);
        bindData();
        return view;
    }

    private void bindData(){
        if(list_Gyhd.size()>2){
            tvZxgyListItemTitle1.setText(list_Gyhd.get(list_Gyhd.size()-1).getTitle());
            tvZxgyListItemTimeFbsj1.setText(list_Gyhd.get(list_Gyhd.size()-1).getFbsj());
            tvZxgyListItemTitle2.setText(list_Gyhd.get(list_Gyhd.size()-2).getTitle());
            tvZxgyListItemTimeFbsj2.setText(list_Gyhd.get(list_Gyhd.size()-2).getFbsj());
        }
    }

    @OnClick(R.id.bt_home_gyhd_next)
    public void toGyhdActivity(){
        Intent intent = new Intent(this.getActivity(), GyhdActivity.class);
        this.startActivity(intent);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

}
