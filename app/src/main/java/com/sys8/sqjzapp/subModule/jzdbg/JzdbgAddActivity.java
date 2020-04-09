package com.sys8.sqjzapp.subModule.jzdbg;

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
import static com.sys8.sqjzapp.subModule.jzdbg.JzdbgListData.list_Jzdbg;
import static com.sys8.sqjzapp.subModule.jzdbg.JzdbgListData.list_JzdbgState;
import static com.sys8.sqjzapp.subModule.jzdbg.JzdbgListData.list_JzdbgState2;
import static com.sys8.sqjzapp.utils.DataUtils.getDate;
import static com.sys8.sqjzapp.utils.DataUtils.getRevertTimeLineData;

public class JzdbgAddActivity extends BaseActivity {

    @BindView(R.id.tb_jzdbg_add)
    TitleBar tbJzdbgAdd;
    @BindView(R.id.et_jzdbg_sqbg_szdq)
    EditText etJzdbgSqbgSzdq;
    @BindView(R.id.et_jzdbg_sqbg_xxdz)
    EditText etJzdbgSqbgXxdz;
    @BindView(R.id.et_jzdbg_sqbg_bgyy)
    SuperShapeEditText etJzdbgSqbgBgyy;
    @BindView(R.id.bt_jzdbg_sqbg_save)
    Button btJzdbgSqbgSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jzdbg_add);
        ButterKnife.bind(this);
        TitleCilckListener(tbJzdbgAdd, this);/*title按钮监听*/
    }

    @OnClick(R.id.bt_jzdbg_sqbg_save)
    public void saveData() {
        list_Jzdbg.add(new Jzdbg(
                getDate("yyyy-MM-dd"),
                "xxx司法局",
                etJzdbgSqbgSzdq .getText().toString()+etJzdbgSqbgXxdz.getText().toString(),
                etJzdbgSqbgBgyy.getText().toString(),
                "审批中"
        ));
        list_JzdbgState2.add(new TimelineItem(new LocationItem("张海洋提交居住地变更申请" + "\n" + getDate("yyyy-MM-dd"), R.drawable.ic_homt_jzdbg)));
        list_JzdbgState.add(new JzdbgState(getDate("yyyy-MM-dd"), list_JzdbgState2));

        Intent intent = new Intent(JzdbgAddActivity.this, JzdbgDetailActivity.class); //参数1:Fragment所依存的Activity,参数2：要跳转的Activity
        Bundle bundle = new Bundle();
        bundle.putString("timeApply", getDate("yyyy-MM-dd"));
        bundle.putString("jsdw", "xxx司法局");
        bundle.putString("xjzd",etJzdbgSqbgSzdq .getText().toString()+etJzdbgSqbgXxdz.getText().toString());
        bundle.putString("bgyy",  etJzdbgSqbgBgyy.getText().toString());
        intent.putExtras(bundle);
        startActivity(intent);
        finish();
    }
}
