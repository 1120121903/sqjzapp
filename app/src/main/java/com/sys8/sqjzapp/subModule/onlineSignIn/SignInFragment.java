package com.sys8.sqjzapp.subModule.onlineSignIn;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sys8.sqjzapp.R;
import com.sys8.sqjzapp.adapters.TimeLineAdapter;
import com.sys8.sqjzapp.module.TimelineItem;
import com.sys8.sqjzapp.utils.Constant;

import java.util.List;

import javax.sql.DataSource;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class SignInFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_SignInTime = "2020-3-15 12:00";
    private static final String ARG_SignInAddress = "北京市海淀区华北所科技大厦";
    @BindView(R.id.tv_onlinesignin_signtime)
    TextView tvOnlinesigninSigntime;
    @BindView(R.id.tv_onlinesignin_signaddress)
    TextView tvOnlinesigninSignaddress;

    private String mSignInTime;
    private String mSignInAddress;
    View view;
    private Unbinder unbinder;


        private RecyclerView timelineRv;
        private TimeLineAdapter adapter;
        private List<TimelineItem> mData;
    public SignInFragment() {
        // Required empty public constructor
    }

    /**
     * @param signInTime    签到时间
     * @param SignInAddress 签到地点
     * @return A new instance of fragment SignInFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SignInFragment newInstance(String signInTime, String SignInAddress) {
        SignInFragment fragment = new SignInFragment();
        Bundle args = new Bundle();
        args.putString(ARG_SignInTime, signInTime);
        args.putString(ARG_SignInAddress, SignInAddress);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mSignInTime = getArguments().getString(ARG_SignInTime);
            mSignInAddress = getArguments().getString(ARG_SignInAddress);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_sign_in, container, false);
        unbinder = ButterKnife.bind(this, view);
        tvOnlinesigninSigntime.setText(mSignInTime);
        tvOnlinesigninSignaddress.setText(mSignInAddress);

        intRv();
        getListData();
        System.out.println("Get Data"+mData.size());
        setupAdapter();
        return view;
    }

    private void setupAdapter() {
        adapter = new TimeLineAdapter(view.getContext(),mData);
        timelineRv.setAdapter(adapter);
    }

    private void getListData(){
        mData = com.sys8.sqjzapp.utils.DataSource.getTimelineData();
    }
    private void intRv(){
        timelineRv = view.findViewById(R.id.recycler_onlinesignin_location_history);
        timelineRv.setLayoutManager(new LinearLayoutManager(view.getContext()));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
