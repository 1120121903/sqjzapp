package com.sys8.sqjzapp.subModule.rcbg;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextClock;
import android.widget.TextView;

import com.hjq.bar.TitleBar;
import com.kingja.supershapeview.view.SuperShapeEditText;
import com.sys8.sqjzapp.R;
import com.sys8.sqjzapp.baseClass.BaseActivity;
import com.sys8.sqjzapp.utils.Constant;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import static com.sys8.sqjzapp.baseClass.ActivityCollector.TitleCilckListener;
import static com.sys8.sqjzapp.subModule.rcbg.RcbgListData.list_RCBG;

public class RcbgAddActivity extends BaseActivity {

    @BindView(R.id.tb_rcbg_add)
    TitleBar tbRcbgAdd;
    @BindView(R.id.et_rcbg_txbg_content)
    SuperShapeEditText etRcbgTxbgContent;
    @BindView(R.id.bt_rcbg_txbg_save)
    Button btRcbgTxbgSave;
    @BindView(R.id.tc_rcbg_txbg_time)
    TextClock tcRcbgTxbgTime;
    @BindView(R.id.tv_rcbg_txbg_place)
    TextView tvRcbgTxbgPlace;
    @BindView(R.id.tv_rcbg_txbg_title)
    EditText tvRcbgTxbgTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rcbg_add);
        ButterKnife.bind(this);
        TitleCilckListener(tbRcbgAdd, this);/*title按钮监听*/
        tvRcbgTxbgPlace.setText(Constant.CURRENT_LOCATION);
    }

    @OnClick(R.id.bt_rcbg_txbg_save)
    public void saveRcbgData() {
        list_RCBG.add(new Rcbg(
                tcRcbgTxbgTime.getText().toString(),
                tvRcbgTxbgTitle.getText().toString(),
                etRcbgTxbgContent.getText().toString(),
                tvRcbgTxbgPlace.getText().toString()));
                btRcbgTxbgSave.setText("已提交");
//        Intent intent  = new Intent(RcbgAddActivity.this,RcbgDetailActivity.class);Bundle bundle = new Bundle();
//        bundle.putString("title",   tvRcbgTxbgTitle.getText().toString()); //放入所需要传递的值
//        bundle.putString("content", etRcbgTxbgContent.getText().toString());
//        bundle.putString("time",tcRcbgTxbgTime.getText().toString());
//        bundle.putString("place", tvRcbgTxbgPlace.getText().toString());
//        intent.putExtras(bundle);
//        startActivity(intent); //这里一定要获取到所在Activity再startActivity()；
        finish();
    }
}
