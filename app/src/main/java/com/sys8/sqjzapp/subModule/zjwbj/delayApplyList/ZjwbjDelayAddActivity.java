package com.sys8.sqjzapp.subModule.zjwbj.delayApplyList;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.hjq.bar.TitleBar;
import com.kingja.supershapeview.view.SuperShapeEditText;
import com.sys8.sqjzapp.R;
import com.sys8.sqjzapp.baseClass.BaseActivity;
import com.sys8.sqjzapp.module.LocationItem;
import com.sys8.sqjzapp.module.TimelineItem;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.sys8.sqjzapp.baseClass.ActivityCollector.TitleCilckListener;
import static com.sys8.sqjzapp.subModule.zjwbj.delayApplyList.DelayApplyListData.list_DelayApply;
import static com.sys8.sqjzapp.subModule.zjwbj.delayApplyList.DelayApplyListData.list_DelayApplyState;
import static com.sys8.sqjzapp.subModule.zjwbj.delayApplyList.DelayApplyListData.list_DelayApplyState2;
import static com.sys8.sqjzapp.utils.DataUtils.getDate;

public class ZjwbjDelayAddActivity extends BaseActivity {

    @BindView(R.id.tb_zjwbj_delay_add)
    TitleBar tbZjwbjDelayAdd;
    @BindView(R.id.et_zjwbj_delay_time)
    EditText etZjwbjDelayTime;
    @BindView(R.id.et_zjwbj_delay_reason)
    SuperShapeEditText etZjwbjDelayReason;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zjwbj_delay_add);
        ButterKnife.bind(this);
        TitleCilckListener(tbZjwbjDelayAdd, this);/*title按钮监听*/
    }

    @OnClick(R.id.bt_zjwbj_delay_save)
    public void saveData() {
        list_DelayApply.add(new DelayApply(
                getDate("yyyy-MM-dd"),
                etZjwbjDelayTime .getText().toString(),
                etZjwbjDelayReason.getText().toString(),
                "审批中"
        ));
        list_DelayApplyState2.add(new TimelineItem(new LocationItem("张海洋提交延期上报申请" + "\n" + getDate("yyyy-MM-dd"), R.drawable.ic_homt_zjwbj)));
        list_DelayApplyState.add(new DelayApplyState(getDate("yyyy-MM-dd"), list_DelayApplyState2));

        Intent intent = new Intent(getApplicationContext(), ZjwbjDelayDetailActivity.class); //参数1:Fragment所依存的Activity,参数2：要跳转的Activity
        Bundle bundle = new Bundle();
        bundle.putString("timeApply", getDate("yyyy-MM-dd"));
        bundle.putString("timeDelay", etZjwbjDelayTime .getText().toString());
        bundle.putString("reasonDelay", etZjwbjDelayReason.getText().toString());
        intent.putExtras(bundle);
        startActivity(intent);
        finish();
    }
}
