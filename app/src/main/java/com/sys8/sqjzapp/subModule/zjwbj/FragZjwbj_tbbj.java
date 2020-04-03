package com.sys8.sqjzapp.subModule.zjwbj;

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
import com.kingja.supershapeview.view.SuperShapeEditText;
import com.sys8.sqjzapp.R;
import com.sys8.sqjzapp.module.LocationItem;
import com.sys8.sqjzapp.module.TimelineItem;

import java.util.Calendar;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.sys8.sqjzapp.subModule.zjwbj.BjjlListData.list_BjState;
import static com.sys8.sqjzapp.subModule.zjwbj.BjjlListData.list_BjState2;
import static com.sys8.sqjzapp.subModule.zjwbj.BjjlListData.list_Bjjl;
import static com.sys8.sqjzapp.utils.DataUtils.dateToString;
import static com.sys8.sqjzapp.utils.DataUtils.getDate;
import static com.sys8.sqjzapp.utils.DataUtils.getUserName;

public class FragZjwbj_tbbj extends Fragment {

    private static FragZjwbj_tbbj fragInstanse = null;
    private static boolean SAVE_CLICK_UNABLE;//保存按钮的状态
    private ZjwbjActivity parentActivity = null;
    private Calendar bjsjCalendar;
    @BindView(R.id.et_zjwbj_tbbj_bjsj)
    EditText etZjwbjTbbjBjsj;
    @BindView(R.id.bt_zjwbj_tbbj_save)
    Button btZjwbjTbbjSave;
    @BindView(R.id.et_zjwbj_tbbj_bjsm)
    SuperShapeEditText etZjwbjTbbjBjsm;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SAVE_CLICK_UNABLE = false;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_zjwbj_tbbj, container, false);
        // Inflate the layout for this fragment
        ButterKnife.bind(this, view);
        parentActivity = (ZjwbjActivity) getActivity();
        etZjwbjTbbjBjsj.setInputType(InputType.TYPE_NULL);
        if (SAVE_CLICK_UNABLE) {
            btZjwbjTbbjSave.setText("已保存");
            btZjwbjTbbjSave.setClickable(false);
        }
        return view;
    }

    @OnClick(R.id.et_zjwbj_tbbj_bjsj)
    public void getBjsj() {
        bjsjCalendar = Calendar.getInstance();
        bjsjCalendar.add(bjsjCalendar.YEAR, +1); //年份加1
        TimePickerView pvTime = new TimePickerBuilder(getContext(), new OnTimeSelectListener() {
            @Override
            public void onTimeSelect(Date date, View v) {
                etZjwbjTbbjBjsj.setText(dateToString(date, "yyyy-MM-dd"));
            }
        })
                .setRangDate(Calendar.getInstance(), bjsjCalendar)//设置起始时间和结束时间
                .build();
        pvTime.show();
    }

    @OnClick(R.id.bt_zjwbj_tbbj_save)
    public void saveData() {
        list_Bjjl.add(new Bjjl(
                 getDate("yyyy-MM-dd"),
                 etZjwbjTbbjBjsj .getText().toString(),
                 etZjwbjTbbjBjsm.getText().toString(),
                "审批中"
        ));
        list_BjState2.add(new TimelineItem(new LocationItem("张海洋提交暂监外病检申请" + "\n" + getDate("yyyy-MM-dd"), R.drawable.zjwbj)));
        list_BjState.add(new BjState(getDate("yyyy-MM-dd"), list_BjState2));
        SAVE_CLICK_UNABLE = true;//保存按钮不可点击
        parentActivity.zjwbjBjjlFragment();
    }

    private FragZjwbj_tbbj() {
    }

    public static FragZjwbj_tbbj getInstance() {
        if (fragInstanse == null) {
            fragInstanse = new FragZjwbj_tbbj();
        }
        return fragInstanse;
    }

}
