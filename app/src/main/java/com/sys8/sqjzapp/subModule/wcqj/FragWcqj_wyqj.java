package com.sys8.sqjzapp.subModule.wcqj;

import android.os.Bundle;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

import com.bigkoo.pickerview.builder.TimePickerBuilder;
import com.bigkoo.pickerview.listener.OnTimeSelectListener;
import com.bigkoo.pickerview.view.TimePickerView;
import com.sys8.sqjzapp.R;

import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.sys8.sqjzapp.utils.DateUtils.dateToString;

public class FragWcqj_wyqj extends Fragment {

    private static FragWcqj_wyqj fragInstanse = null;
    @BindView(R.id.et_wcqj_wyqj_kssj)
    EditText etWcqjWyqjKssj;
    @BindView(R.id.et_wcqj_wyqj_jssj)
    EditText etWcqjWyqjJssj;
    private WcqjActivity parentActivity = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_wcqj_wyqj, container, false);
        // Inflate the layout for this fragment
        parentActivity = (WcqjActivity) getActivity();
        ButterKnife.bind(this, view);
        etWcqjWyqjKssj.setInputType(InputType.TYPE_NULL);
        etWcqjWyqjJssj.setInputType(InputType.TYPE_NULL);
        return view;
    }

    @OnClick(R.id.et_wcqj_wyqj_kssj)
    public void getKssj() {
        TimePickerView pvTime = new TimePickerBuilder(getContext(), new OnTimeSelectListener() {
            @Override
            public void onTimeSelect(Date date, View v) {
                etWcqjWyqjKssj.setText(dateToString(date, "yyyy年MM月dd日"));
            }
        }).build();
        pvTime.show();
    }

    @OnClick(R.id.et_wcqj_wyqj_jssj)
    public void getJssj() {
        TimePickerView pvTime = new TimePickerBuilder(getContext(), new OnTimeSelectListener() {
            @Override
            public void onTimeSelect(Date date, View v) {
                etWcqjWyqjJssj.setText(dateToString(date, "yyyy年MM月dd日"));
            }
        }).build();
        pvTime.show();
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
