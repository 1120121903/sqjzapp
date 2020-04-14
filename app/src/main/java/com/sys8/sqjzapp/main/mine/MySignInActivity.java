package com.sys8.sqjzapp.main.mine;

import android.os.Build;
import android.os.Bundle;
import android.widget.DatePicker;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hjq.bar.TitleBar;
import com.sys8.sqjzapp.R;
import com.sys8.sqjzapp.adapters.TimeLineAdapter;
import com.sys8.sqjzapp.baseClass.ActivityCollector;
import com.sys8.sqjzapp.baseClass.BaseActivity;
import com.sys8.sqjzapp.module.LocationItem;
import com.sys8.sqjzapp.module.TimelineItem;
import com.sys8.sqjzapp.utils.DataSource;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.sys8.sqjzapp.utils.DataSource.myTodaySignInHistory;
import static com.sys8.sqjzapp.utils.DataUtils.getDate;
import static com.sys8.sqjzapp.utils.DataUtils.getRevertTimeLineData;

public class MySignInActivity extends BaseActivity {

    @BindView(R.id.recycler_mysignin_location_history)
    RecyclerView recyclerMysigninLocationHistory;
    @BindView(R.id.tb_mine_signin_titlebar)
    TitleBar tbMineSigninTitlebar;
    @BindView(R.id.date_mine_signin)
    DatePicker dateMineSignin;

    private TimeLineAdapter adapter;
    private List<TimelineItem> mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_sign_in);
        ButterKnife.bind(this);
        ActivityCollector.TitleCilckListener(tbMineSigninTitlebar, this);
        intRv();
        getListData();
        setupAdapter();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            dateMineSignin.setOnDateChangedListener(new DatePicker.OnDateChangedListener() {
                @Override
                public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                   System.out.println("year"+year);
                    System.out.println("monthOfYear"+monthOfYear);
                    System.out.println("dayOfMonth"+dayOfMonth);
                    String datestring = ""+year+"-0"+(monthOfYear+1)+"-"+dayOfMonth;
                    System.out.println("datestring"+datestring);
                    if (datestring.equals(getDate("YYYY-MM-dd"))){
                        mData = myTodaySignInHistory;
                    }else{
                        mData = DataSource.getTimelineData();
                        List<TimelineItem> newData = new ArrayList<>();
                        for (int i =0;i<mData.size();i++){
                            TimelineItem item = mData.get(i);
                            LocationItem locationItem =item.getLocationItem();
                            String location = locationItem.getTimeLineText().split("\n")[1];
                            locationItem.setTimeLineText(datestring+"  12:0"+i+"\n"+location);
                            item.setLocationItem(locationItem);
                            newData.add(item);
                        }
                        mData=newData;
                    }
                    setupAdapter();
                }
            });
        }
    }

    private void intRv() {
        recyclerMysigninLocationHistory.setLayoutManager(new LinearLayoutManager(this));
    }


    private void getListData() {

        mData =myTodaySignInHistory;

    }

    private void setupAdapter() {
        adapter = new TimeLineAdapter(this, getRevertTimeLineData(mData));
        recyclerMysigninLocationHistory.setAdapter(adapter);
    }
}
