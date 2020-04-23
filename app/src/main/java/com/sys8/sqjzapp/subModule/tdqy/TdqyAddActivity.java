package com.sys8.sqjzapp.subModule.tdqy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

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
import static com.sys8.sqjzapp.subModule.tdqy.TdqyListData.list_Tdqy;
import static com.sys8.sqjzapp.subModule.tdqy.TdqyListData.list_TdqyApply_State;
import static com.sys8.sqjzapp.subModule.tdqy.TdqyListData.list_TdqySq_State3;
import static com.sys8.sqjzapp.utils.DataUtils.dateToString;
import static com.sys8.sqjzapp.utils.DataUtils.getDate;

public class TdqyAddActivity extends BaseActivity {

    @BindView(R.id.tb_tdqy_add)
    TitleBar tbTdqyAdd;
    @BindView(R.id.et_tdqy_time_start)
    EditText etTdqyTimeStart;
    @BindView(R.id.et_tdqy_time_end)
    EditText etTdqyTimeEnd;
    @BindView(R.id.et_tdqy_place)
    EditText etTdqyPlace;
    @BindView(R.id.et_tdqy_reason)
    SuperShapeEditText etTdqyReason;
    @BindView(R.id.bt_tdqy_add_save)
    Button btTdqyAddSave;
    @BindView(R.id.line_tdqy)
    LinearLayout lineTdqy;

    private Calendar kssjCalendarStart;
    private Calendar kssjCalendarEnd;
    private Calendar jssjCalendarStart;
    private Calendar jssjCalendarEnd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tdqy_add);
        ButterKnife.bind(this);
        TitleCilckListener(tbTdqyAdd, this);/*title按钮监听*/
    }

    @OnClick(R.id.bt_tdqy_add_save)
    public void saveData() {
        list_Tdqy.add(new Tdqy(
                "进入特定区域申请",
                getDate("yyyy-MM-dd"),
                etTdqyTimeStart.getText().toString(),
                etTdqyTimeEnd.getText().toString(),
                etTdqyPlace.getText().toString(),
                etTdqyReason.getText().toString(),
                "审批中"
        ));
        list_TdqySq_State3.add(new TimelineItem(new LocationItem("张海洋提交进入特定区域申请" + "\n" + getDate("yyyy-MM-dd"), R.drawable.ic_home_tdqy)));
        list_TdqyApply_State.add(new TdqyApplyState(getDate("yyyy-MM-dd"), list_TdqySq_State3));

        Intent intent = new Intent(TdqyAddActivity.this, TdqyDetailActivity.class); //参数1:Fragment所依存的Activity,参数2：要跳转的Activity
        Bundle bundle = new Bundle();
        bundle.putString("title", "进入特定区域申请"); //放入所需要传递的值
        bundle.putString("timeApply", getDate("yyyy-MM-dd"));
        bundle.putString("timeStart", etTdqyTimeStart.getText().toString());
        bundle.putString("timeEnd", etTdqyTimeEnd.getText().toString());
        bundle.putString("place", etTdqyPlace.getText().toString());
        bundle.putString("reason", etTdqyReason.getText().toString());
        intent.putExtras(bundle);
        startActivity(intent);
        finish();
    }

    @OnClick(R.id.et_tdqy_time_start)
    public void getKssj() {
        lineTdqy.clearFocus();
        HideKeyboard(lineTdqy);
        kssjCalendarStart = Calendar.getInstance();
        kssjCalendarEnd = Calendar.getInstance();
        kssjCalendarEnd.add(kssjCalendarStart.YEAR, +1); //年份加1
        TimePickerView pvTime = new TimePickerBuilder(this, new OnTimeSelectListener() {
            @Override
            public void onTimeSelect(Date date, View v) {
                etTdqyTimeStart.setText(dateToString(date, "yyyy-MM-dd"));
                jssjCalendarStart = Calendar.getInstance();
                jssjCalendarStart.setTime(date);
                etTdqyTimeEnd.setText("");
            }
        })
                .setRangDate(kssjCalendarStart, kssjCalendarEnd)//设置起始时间和结束时间
                .build();
        pvTime.show();
    }

    @OnClick(R.id.et_tdqy_time_end)
    public void getJssj() {
        lineTdqy.clearFocus();
        HideKeyboard(lineTdqy);
        if (etTdqyTimeStart.getText().toString().equals("")) {
            Toast.makeText(this, "请选择开始时间", Toast.LENGTH_SHORT).show();
            return;
        }
        jssjCalendarEnd = Calendar.getInstance();
        jssjCalendarEnd.add(jssjCalendarStart.YEAR, +1); //年份加1
        TimePickerView pvTime = new TimePickerBuilder(this, new OnTimeSelectListener() {
            @Override
            public void onTimeSelect(Date date, View v) {
                etTdqyTimeEnd.setText(dateToString(date, "yyyy-MM-dd"));
            }
        })
                .setRangDate(jssjCalendarStart, jssjCalendarEnd)//设置起始时间和结束时间
                .build();
        pvTime.show();
    }

}
