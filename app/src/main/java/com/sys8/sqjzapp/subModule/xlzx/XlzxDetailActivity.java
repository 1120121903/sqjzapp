package com.sys8.sqjzapp.subModule.xlzx;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.hjq.bar.TitleBar;
import com.sys8.sqjzapp.R;
import com.sys8.sqjzapp.baseClass.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.sys8.sqjzapp.baseClass.ActivityCollector.TitleCilckListener;
import static com.sys8.sqjzapp.subModule.xlzx.XlzxListData.list_Xlzx;

public class XlzxDetailActivity extends BaseActivity {

    @BindView(R.id.tb_xlzx_detail)
    TitleBar tbXlzxDetail;
    @BindView(R.id.iv_xlzx_detail_head)
    ImageView ivXlzxDetailHead;
    @BindView(R.id.tv_xlzx_detail_name)
    TextView tvXlzxDetailName;
    @BindView(R.id.tv_xlzx_detail_zc)
    TextView tvXlzxDetailZc;
    @BindView(R.id.tv_xlzx_detail_des)
    TextView tvXlzxDetailDes;
    @BindView(R.id.bt_xlzx_detail_order)
    Button btXlzxDetailOrder;
    private Xlzx xlzx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xlzx_detail);
        ButterKnife.bind(this);
        TitleCilckListener(tbXlzxDetail, this);
        bindData();
    }

    private void bindData(){
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String zc = intent.getStringExtra("zc");
        String des = intent.getStringExtra("des");

        for (Xlzx xlzxs : list_Xlzx) {
            if (xlzxs.getName().equals(name)) {
                xlzx = xlzxs;
                break; }
        }
        ivXlzxDetailHead.setImageDrawable(getDrawable(xlzx.getHead()));
        tvXlzxDetailName.setText(name);
        tvXlzxDetailZc.setText(zc);
        tvXlzxDetailDes.setText(des);
    }
}
