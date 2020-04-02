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

import java.util.Calendar;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.sys8.sqjzapp.utils.DateUtils.calculateDaysFromTwoDateString;
import static com.sys8.sqjzapp.utils.DateUtils.dateToString;

public class FragWcqj_wyqj extends Fragment {

    private static FragWcqj_wyqj fragInstanse = null;
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
    Button btWcqjWyqjSave;
    private WcqjActivity parentActivity = null;
    private Calendar kssjCalendarStart;
    private Calendar kssjCalendarEnd;
    private Calendar jssjCalendarStart;
    private Calendar jssjCalendarEnd;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
                etWcqjWyqjKssj.setText(dateToString(date, "yyyy年MM月dd日"));
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
                etWcqjWyqjJssj.setText(dateToString(date, "yyyy年MM月dd日"));
                etWcqjWyqjWcsc.setText(calculateDaysFromTwoDateString(etWcqjWyqjKssj.getText().toString(),etWcqjWyqjJssj.getText().toString()));
            }
        })
                .setRangDate(jssjCalendarStart, jssjCalendarEnd)//设置起始时间和结束时间
                .build();
        pvTime.show();
    }

    @OnClick(R.id.bt_wcqj_wyqj_save)
    public void saveData(){
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
