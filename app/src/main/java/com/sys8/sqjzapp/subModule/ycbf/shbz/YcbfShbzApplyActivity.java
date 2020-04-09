package com.sys8.sqjzapp.subModule.ycbf.shbz;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.hjq.bar.TitleBar;
import com.kingja.supershapeview.view.SuperShapeEditText;
import com.sys8.sqjzapp.R;
import com.sys8.sqjzapp.baseClass.BaseActivity;
import com.sys8.sqjzapp.subModule.ycbf.wdbf.YcbfWdbfActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.sys8.sqjzapp.baseClass.ActivityCollector.TitleCilckListener;
import static com.sys8.sqjzapp.subModule.ycbf.shbz.ShbzlListData.list_Shbz;
import static com.sys8.sqjzapp.subModule.ycbf.shbz.ShbzlListData.list_ShbzYsq;

public class YcbfShbzApplyActivity extends BaseActivity {

    @BindView(R.id.tb_ycbf_shbz_bm)
    TitleBar tbYcbfShbzBm;
    @BindView(R.id.et_ycbf_shbz_title)
    EditText etYcbfShbzTitle;
    @BindView(R.id.et_ycbf_shbz_sqly)
    SuperShapeEditText etYcbfShbzSqly;
    @BindView(R.id.bt_ycbf_shbz_save)
    Button btYcbfShbzSave;
    private YcbfShbzApplyActivity parentActivity = null;
    private int LOCATION = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ycbf_shbz_apply);
        ButterKnife.bind(this);
        TitleCilckListener(tbYcbfShbzBm, this);/*title按钮监听*/
        bindData();
    }

    private void bindData() {
        Intent intent = this.getIntent();
        String title = intent.getStringExtra("title");
        for (LOCATION =0;LOCATION<list_Shbz.size();LOCATION++) {
            if (list_Shbz.get(LOCATION).getTitle().equals(title)) {
                break;
            }
        }
        etYcbfShbzTitle.setText(list_Shbz.get(LOCATION).getTitle());
    }

    @OnClick(R.id.bt_ycbf_shbz_save)
    public void saveData(){
        list_Shbz.get(LOCATION).setState("1");
        list_ShbzYsq.add(list_Shbz.get(LOCATION));
        Intent intent = new Intent(this, YcbfWdbfActivity.class);
        this.startActivity(intent);
        finish();
    }

}
