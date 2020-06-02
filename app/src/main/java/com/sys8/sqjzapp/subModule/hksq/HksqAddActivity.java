package com.sys8.sqjzapp.subModule.hksq;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
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

import java.util.Calendar;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.sys8.sqjzapp.baseClass.ActivityCollector.TitleCilckListener;
import static com.sys8.sqjzapp.subModule.hksq.HksqListData.list_Hksq;
import static com.sys8.sqjzapp.utils.DataUtils.dateToString;
import static com.sys8.sqjzapp.utils.DataUtils.getDate;
import static com.sys8.sqjzapp.utils.DataUtils.getUserName;

public class HksqAddActivity extends BaseActivity {

    @BindView(R.id.tb_hksq_add)
    TitleBar tbHksqAdd;
    @BindView(R.id.et_hksq_wysq_time)
    EditText etHksqWysqTime;
    @BindView(R.id.et_hksq_wysq_place)
    EditText etHksqWysqPlace;
    @BindView(R.id.et_hksq_wysq_name)
    EditText etHksqWysqName;
    @BindView(R.id.et_hksq_wysq_reason)
    SuperShapeEditText etHksqWysqReason;
    @BindView(R.id.bt_hksq_wysq_save)
    Button btHksqWysqSave;
    private Calendar timeCalendarStart;
    private Calendar timeCalendarEnd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hksq_add);
        ButterKnife.bind(this);
        TitleCilckListener(tbHksqAdd, this);/*title按钮监听*/
        etHksqWysqTime.setInputType(InputType.TYPE_NULL);
    }

    @OnClick(R.id.bt_hksq_wysq_save)
    public void saveData() {
        list_Hksq.add(new Hksq(
                getUserName() + "提交的请假",
                getDate("yyyy-MM-dd"),
                etHksqWysqTime.getText().toString(),
                etHksqWysqName.getText().toString(),
                etHksqWysqPlace.getText().toString(),
                etHksqWysqReason.getText().toString(),
                "审批中"
        ));
        Intent intent=new Intent(HksqAddActivity.this, HksqDetailActivity.class); //参数1:Fragment所依存的Activity,参数2：要跳转的Activity
        Bundle bundle = new Bundle();
        bundle.putString("title",getUserName() + "提交的请假"); //放入所需要传递的值
        bundle.putString("timeApply",getDate("yyyy-MM-dd"));
        bundle.putString("time",etHksqWysqTime.getText().toString());
        bundle.putString("name",etHksqWysqName.getText().toString());
        bundle.putString("place", etHksqWysqPlace.getText().toString());
        bundle.putString("reason", etHksqWysqReason.getText().toString());
        intent.putExtras(bundle);
        startActivity(intent);
        finish();
    }

    @OnClick(R.id.et_hksq_wysq_time)
    public void getHksqAddTime() {
        hideKeybord();
        timeCalendarStart = Calendar.getInstance();
        timeCalendarEnd = Calendar.getInstance();
        timeCalendarEnd.add(timeCalendarStart.YEAR, +1); //年份加1
        TimePickerView pvTime = new TimePickerBuilder(this, new OnTimeSelectListener() {
            @Override
            public void onTimeSelect(Date date, View v) {
                etHksqWysqTime.setText(dateToString(date, "yyyy-MM-dd"));
                timeCalendarStart = Calendar.getInstance();
                timeCalendarStart.setTime(date);
                etHksqWysqTime.setText("");
            }
        })
                .setRangDate(timeCalendarStart, timeCalendarEnd)//设置起始时间和结束时间
                .build();
        pvTime.show();
    }


    private void hideKeybord(){
        etHksqWysqPlace.clearFocus();
        etHksqWysqName.clearFocus();
        etHksqWysqReason.clearFocus();
        HideKeyboard(etHksqWysqTime);
    }
}
