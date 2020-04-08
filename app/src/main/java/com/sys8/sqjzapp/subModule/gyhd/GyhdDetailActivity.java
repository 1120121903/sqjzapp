package com.sys8.sqjzapp.subModule.gyhd;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.hjq.bar.TitleBar;
import com.kingja.supershapeview.view.SuperShapeTextView;
import com.sys8.sqjzapp.R;
import com.sys8.sqjzapp.baseClass.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.sys8.sqjzapp.baseClass.ActivityCollector.TitleCilckListener;
import static com.sys8.sqjzapp.subModule.gyhd.GyhdListData.list_Gyhd;
import static com.sys8.sqjzapp.subModule.gyhd.GyhdListData.list_GyhdYbm;
import static com.sys8.sqjzapp.utils.Constant.STATE_GYHD;
import static com.sys8.sqjzapp.utils.Constant.topTabs_gyhd;

public class GyhdDetailActivity extends BaseActivity {

    @BindView(R.id.tb_gyhd_detail)
    TitleBar tbGyhdDetail;
    @BindView(R.id.tv_gyhd_detail_title)
    TextView tvGyhdDetailTitle;
    @BindView(R.id.tv_gyhd_detail_kssj)
    TextView tvGyhdDetailKssj;
    @BindView(R.id.tv_gyhd_detail_hddd)
    TextView tvGyhdDetailHddd;
    @BindView(R.id.tv_gyhd_detail_bmrs)
    TextView tvGyhdDetailBmrs;
    @BindView(R.id.tv_gyhd_detail_jtnr)
    SuperShapeTextView tvGyhdDetailJtnr;
    @BindView(R.id.bt_gyhd_detail_bm)
    Button btGyhDetaildBm;
    private int gyhdDataLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gyhd_detail);
        ButterKnife.bind(this);
        TitleCilckListener(tbGyhdDetail, this);/*title按钮监听*/
        bindData();
    }

    private void bindData(){
        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        String type = intent.getStringExtra("type");
        List<Gyhd> list;
        if(type.equals(topTabs_gyhd[0])){
            list = list_Gyhd;
        }else{
            list = list_GyhdYbm;
        }
        for(int i=0;i<list.size();i++){
            if(list.get(i).getTitle().equals(title)){
                gyhdDataLocation = i;
                tvGyhdDetailTitle.setText(list.get(i).getTitle());
                tvGyhdDetailKssj.setText(list.get(i).getKssj());
                tvGyhdDetailHddd.setText(list.get(i).getHddd());
                tvGyhdDetailBmrs.setText(list.get(i).getBmrs());
                tvGyhdDetailJtnr.setText(list.get(i).getCotent());
                btGyhDetaildBm.setText(list.get(i).getState());
                if(list.get(i).getState().equals(STATE_GYHD)){
                    btGyhDetaildBm.setEnabled(true);
                }else{
                    btGyhDetaildBm.setEnabled(false);
                }
                break;
            }
        }
    }

    @OnClick(R.id.bt_gyhd_detail_bm)
    public void saveGyhdBmData(){
        btGyhDetaildBm.setEnabled(false);
        btGyhDetaildBm.setText("已报名");
        list_Gyhd.get(gyhdDataLocation).setState("已报名");
        list_Gyhd.get(gyhdDataLocation).setBmrs("报名3/5人（未满）");
        list_GyhdYbm.add(list_Gyhd.get(gyhdDataLocation));
    }
}
