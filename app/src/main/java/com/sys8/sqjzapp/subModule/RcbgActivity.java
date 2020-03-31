package com.sys8.sqjzapp.subModule;

import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;

import com.hjq.bar.TitleBar;
import com.sys8.sqjzapp.R;
import com.sys8.sqjzapp.baseClass.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.sys8.sqjzapp.baseClass.ActivityCollector.TitleCilckListener;

public class RcbgActivity extends BaseActivity {

    @BindView(R.id.tb_rcbg)
    TitleBar tbRcbg;
    @BindView(R.id.fl_rcbg)
    FrameLayout flRcbg;
    @BindView(R.id.et_rcbg_content)
    EditText etRcbgContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rcbg);
        ButterKnife.bind(this);
        TitleCilckListener(tbRcbg, this);/*title按钮监听*/

    }


}
