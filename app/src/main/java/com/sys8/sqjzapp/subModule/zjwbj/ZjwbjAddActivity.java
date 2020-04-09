package com.sys8.sqjzapp.subModule.zjwbj;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.bigkoo.pickerview.builder.TimePickerBuilder;
import com.bigkoo.pickerview.listener.OnTimeSelectListener;
import com.bigkoo.pickerview.view.TimePickerView;
import com.hjq.bar.TitleBar;
import com.kingja.supershapeview.view.SuperShapeEditText;
import com.sys8.sqjzapp.R;
import com.sys8.sqjzapp.baseClass.BaseActivity;
import com.sys8.sqjzapp.module.LocationItem;
import com.sys8.sqjzapp.module.TimelineItem;

import java.util.Calendar;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.sys8.sqjzapp.baseClass.ActivityCollector.TitleCilckListener;
import static com.sys8.sqjzapp.baseClass.ActivityCollector.finishAll;
import static com.sys8.sqjzapp.subModule.zjwbj.BjjlListData.list_BjState;
import static com.sys8.sqjzapp.subModule.zjwbj.BjjlListData.list_BjState2;
import static com.sys8.sqjzapp.subModule.zjwbj.BjjlListData.list_Bjjl;
import static com.sys8.sqjzapp.utils.DataUtils.dateToString;
import static com.sys8.sqjzapp.utils.DataUtils.getDate;
import static com.sys8.sqjzapp.utils.DataUtils.getRevertTimeLineData;

public class ZjwbjAddActivity extends BaseActivity {

    @BindView(R.id.tb_zjwbj_add)
    TitleBar tbZjwbjAdd;
    @BindView(R.id.et_zjwbj_tbbj_bjsj)
    EditText etZjwbjTbbjBjsj;
    @BindView(R.id.et_zjwbj_tbbj_bjsm)
    SuperShapeEditText etZjwbjTbbjBjsm;
    @BindView(R.id.bt_zjwbj_tbbj_save)
    Button btZjwbjTbbjSave;
    private Calendar bjsjCalendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zjwbj_add);
        ButterKnife.bind(this);
        TitleCilckListener(tbZjwbjAdd, this);/*title按钮监听*/
    }

    @OnClick(R.id.et_zjwbj_tbbj_bjsj)
    public void getBjsj() {
        bjsjCalendar = Calendar.getInstance();
        bjsjCalendar.add(bjsjCalendar.YEAR, +1); //年份加1
        TimePickerView pvTime = new TimePickerBuilder(this, new OnTimeSelectListener() {
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
        list_BjState2.add(new TimelineItem(new LocationItem("张海洋提交暂监外病检申请" + "\n" + getDate("yyyy-MM-dd"), R.drawable.ic_homt_zjwbj)));
        list_BjState.add(new BjState(getDate("yyyy-MM-dd"), list_BjState2));

        Intent intent = new Intent(ZjwbjAddActivity.this, ZjwbjDetailActivity.class); //参数1:Fragment所依存的Activity,参数2：要跳转的Activity
        Bundle bundle = new Bundle();
        bundle.putString("timeApply", getDate("yyyy-MM-dd"));
        bundle.putString("timeStart", etZjwbjTbbjBjsj .getText().toString());
        bundle.putString("bjsm", etZjwbjTbbjBjsm.getText().toString());
        intent.putExtras(bundle);
        startActivity(intent);
        finish();
    }
}
