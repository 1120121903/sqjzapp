package com.sys8.sqjzapp.subModule.wcqj;

import android.os.Bundle;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.bigkoo.pickerview.builder.TimePickerBuilder;
import com.bigkoo.pickerview.listener.OnTimeSelectListener;
import com.bigkoo.pickerview.view.TimePickerView;
import com.kingja.supershapeview.view.SuperShapeEditText;
import com.sys8.sqjzapp.R;
import com.sys8.sqjzapp.module.LocationItem;
import com.sys8.sqjzapp.module.TimelineItem;

import java.util.Calendar;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.sys8.sqjzapp.subModule.wcqj.QjjlListData.list_QjState;
import static com.sys8.sqjzapp.subModule.wcqj.QjjlListData.list_QjState3;
import static com.sys8.sqjzapp.subModule.wcqj.QjjlListData.list_Qjjl;
import static com.sys8.sqjzapp.utils.DataUtils.calculateDaysFromTwoDateString;
import static com.sys8.sqjzapp.utils.DataUtils.dateToString;
import static com.sys8.sqjzapp.utils.DataUtils.getDate;
import static com.sys8.sqjzapp.utils.DataUtils.getUserName;

public class FragWcqj_wyqj extends Fragment {

    private static FragWcqj_wyqj fragInstanse = null;
    private static boolean SAVE_CLICK_UNABLE;//保存按钮的状态
    @BindView(R.id.et_wcqj_wyqj_kssj)
    EditText etWcqjWyqjKssj;
    @BindView(R.id.et_wcqj_wyqj_jssj)
    EditText etWcqjWyqjJssj;
    @BindView(R.id.et_wcqj_wyqj_wcsc)
    EditText etWcqjWyqjWcsc;
    @BindView(R.id.et_wcqj_wyqj_wcdd)
    EditText etWcqjWyqjWcdd;
    @BindView(R.id.et_wcqj_wyqj_wcly)
    SuperShapeEditText etWcqjWyqjWcly;
    @BindView(R.id.bt_wcqj_wyqj_save)
    Button btWcqjWyqjSaveAble;
    private WcqjActivity parentActivity = null;
    private Calendar kssjCalendarStart;
    private Calendar kssjCalendarEnd;
    private Calendar jssjCalendarStart;
    private Calendar jssjCalendarEnd;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SAVE_CLICK_UNABLE = false;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_wcqj_wyqj, container, false);
        // Inflate the layout for this fragment
        ButterKnife.bind(this, view);
        parentActivity = (WcqjActivity) getActivity();
        etWcqjWyqjKssj.setInputType(InputType.TYPE_NULL);
        etWcqjWyqjJssj.setInputType(InputType.TYPE_NULL);
        if(SAVE_CLICK_UNABLE){
            btWcqjWyqjSaveAble.setText("已保存");
            btWcqjWyqjSaveAble.setClickable(false);
        }
        return view;
    }

    @OnClick(R.id.et_wcqj_wyqj_kssj)
    public void getKssj() {
        kssjCalendarStart = Calendar.getInstance();
        kssjCalendarEnd = Calendar.getInstance();
        kssjCalendarEnd.add(kssjCalendarStart.YEAR, +1); //年份加1
        TimePickerView pvTime = new TimePickerBuilder(getContext(), new OnTimeSelectListener() {
            @Override
            public void onTimeSelect(Date date, View v) {
                etWcqjWyqjKssj.setText(dateToString(date, "yyyy-MM-dd"));
                jssjCalendarStart = Calendar.getInstance();
                jssjCalendarStart.setTime(date);
                etWcqjWyqjJssj.setText("");
            }
        })
                .setRangDate(kssjCalendarStart, kssjCalendarEnd)//设置起始时间和结束时间
                .build();
        pvTime.show();
    }

    @OnClick(R.id.et_wcqj_wyqj_jssj)
    public void getJssj() {
        if (etWcqjWyqjKssj.getText().toString().equals("")) {
            Toast.makeText(getActivity(), "请选择开始时间", Toast.LENGTH_SHORT).show();
            return;
        }
        jssjCalendarEnd = Calendar.getInstance();
        jssjCalendarEnd.add(jssjCalendarStart.YEAR, +1); //年份加1
        TimePickerView pvTime = new TimePickerBuilder(getContext(), new OnTimeSelectListener() {
            @Override
            public void onTimeSelect(Date date, View v) {
                etWcqjWyqjJssj.setText(dateToString(date, "yyyy-MM-dd"));
                etWcqjWyqjWcsc.setText(calculateDaysFromTwoDateString(etWcqjWyqjKssj.getText().toString(), etWcqjWyqjJssj.getText().toString(), "yyyy-MM-dd"));
            }
        })
                .setRangDate(jssjCalendarStart, jssjCalendarEnd)//设置起始时间和结束时间
                .build();
        pvTime.show();
    }

    @OnClick(R.id.bt_wcqj_wyqj_save)
    public void saveData() {
        list_Qjjl.add(new Qjjl(
                getUserName() + "提交的请假",
                getDate("yyyy-MM-dd"),
                etWcqjWyqjKssj.getText().toString(),
                etWcqjWyqjJssj.getText().toString(),
                etWcqjWyqjWcsc.getText().toString(),
                etWcqjWyqjWcdd.getText().toString(),
                etWcqjWyqjWcly.getText().toString(),
                "审批中"
        ));
        list_QjState3.add(new TimelineItem(new LocationItem("张海洋提交请假申请"+"\n"+getDate("yyyy-MM-dd"), R.drawable.ic_home_wcqj)));
        list_QjState.add(new QjState(getDate("yyyy-MM-dd"),list_QjState3));
        SAVE_CLICK_UNABLE = true;//保存按钮不可点击
        parentActivity.wcqjQjjlFragment();
    }

    private FragWcqj_wyqj() {
    }

    public static FragWcqj_wyqj getInstance() {
        if (fragInstanse == null) {
            fragInstanse = new FragWcqj_wyqj();
        }
        return fragInstanse;
    }

}
