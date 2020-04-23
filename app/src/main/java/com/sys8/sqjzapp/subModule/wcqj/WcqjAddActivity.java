package com.sys8.sqjzapp.subModule.wcqj;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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
import static com.sys8.sqjzapp.subModule.wcqj.QjjlListData.list_QjState;
import static com.sys8.sqjzapp.subModule.wcqj.QjjlListData.list_QjState3;
import static com.sys8.sqjzapp.subModule.wcqj.QjjlListData.list_Qjjl;
import static com.sys8.sqjzapp.utils.DataUtils.calculateDaysFromTwoDateString;
import static com.sys8.sqjzapp.utils.DataUtils.dateToString;
import static com.sys8.sqjzapp.utils.DataUtils.getDate;
import static com.sys8.sqjzapp.utils.DataUtils.getUserName;

public class WcqjAddActivity extends BaseActivity {

    @BindView(R.id.tb_wcqj_add)
    TitleBar tbWcqjAdd;
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
    private Calendar kssjCalendarStart;
    private Calendar kssjCalendarEnd;
    private Calendar jssjCalendarStart;
    private Calendar jssjCalendarEnd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wcqj_add);
        ButterKnife.bind(this);
        TitleCilckListener(tbWcqjAdd, this);/*title按钮监听*/
        etWcqjWyqjKssj.setInputType(InputType.TYPE_NULL);
        etWcqjWyqjJssj.setInputType(InputType.TYPE_NULL);
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

        Intent intent=new Intent(WcqjAddActivity.this,WcqjDetailActivity.class); //参数1:Fragment所依存的Activity,参数2：要跳转的Activity
        Bundle bundle = new Bundle();
        bundle.putString("title",getUserName() + "提交的请假"); //放入所需要传递的值
        bundle.putString("timeApply",getDate("yyyy-MM-dd"));
        bundle.putString("timeStart",etWcqjWyqjKssj.getText().toString());
        bundle.putString("timeEnd", etWcqjWyqjJssj.getText().toString());
        bundle.putString("days",etWcqjWyqjWcsc.getText().toString());
        bundle.putString("place", etWcqjWyqjWcdd.getText().toString());
        bundle.putString("reason", etWcqjWyqjWcly.getText().toString());
        intent.putExtras(bundle);
        startActivity(intent);
        finish();
    }

    @OnClick(R.id.et_wcqj_wyqj_kssj)
    public void getKssj() {
        hideKeybord();
        kssjCalendarStart = Calendar.getInstance();
        kssjCalendarEnd = Calendar.getInstance();
        kssjCalendarEnd.add(kssjCalendarStart.YEAR, +1); //年份加1
        TimePickerView pvTime = new TimePickerBuilder(this, new OnTimeSelectListener() {
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
        hideKeybord();
        if (etWcqjWyqjKssj.getText().toString().equals("")) {
            Toast.makeText(this, "请选择开始时间", Toast.LENGTH_SHORT).show();
            return;
        }
        jssjCalendarEnd = Calendar.getInstance();
        jssjCalendarEnd.add(jssjCalendarStart.YEAR, +1); //年份加1
        TimePickerView pvTime = new TimePickerBuilder(this, new OnTimeSelectListener() {
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

    private void hideKeybord(){
        etWcqjWyqjWcdd.clearFocus();
        etWcqjWyqjWcly.clearFocus();
        HideKeyboard(etWcqjWyqjWcdd);
        HideKeyboard(etWcqjWyqjWcly);
    }
}
