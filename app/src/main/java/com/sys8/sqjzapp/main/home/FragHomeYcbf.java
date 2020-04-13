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
import com.sys8.sqjzapp.subModule.ycbf.YcbfActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.sys8.sqjzapp.subModule.ycbf.shbz.ShbzlListData.list_Shbz;

public class FragHomeYcbf extends Fragment {
    @BindView(R.id.tv_zxbf_listItem_title1)
    TextView tvZxbfListItemTitle1;
    @BindView(R.id.tv_zxbf_listItem_time_fbsj1)
    TextView tvZxbfListItemTimeFbsj1;
    @BindView(R.id.tv_zxbf_listItem_title2)
    TextView tvZxbfListItemTitle2;
    @BindView(R.id.tv_zxbf_listItem_time_fbsj2)
    TextView tvZxbfListItemTimeFbsj2;
    @BindView(R.id.bt_home_ycbf_next)
    Button btHomeYcbfNext;
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
            view = inflater.inflate(R.layout.home_ycbf, container, false);
        }
        ButterKnife.bind(this, view);
        bindData();
        return view;
    }

    @OnClick(R.id.bt_home_ycbf_next)
    public void toYcbfActivity(){
        Intent intent = new Intent(this.getActivity(), YcbfActivity.class);
        this.startActivity(intent);
    }

    private void bindData() {
        if (list_Shbz.size() > 2) {
            tvZxbfListItemTitle1.setText(list_Shbz.get(list_Shbz.size() - 1).getTitle());
            tvZxbfListItemTimeFbsj1.setText(list_Shbz.get(list_Shbz.size() - 1).getFbsj());
            tvZxbfListItemTitle2.setText(list_Shbz.get(list_Shbz.size() - 2).getTitle());
            tvZxbfListItemTimeFbsj2.setText(list_Shbz.get(list_Shbz.size() - 2).getFbsj());
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

}
