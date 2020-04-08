package com.sys8.sqjzapp.subModule.ycbf.jyfw;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.hjq.bar.TitleBar;
import com.kingja.supershapeview.view.SuperShapeTextView;
import com.sys8.sqjzapp.R;
import com.sys8.sqjzapp.baseClass.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.sys8.sqjzapp.baseClass.ActivityCollector.TitleCilckListener;
import static com.sys8.sqjzapp.subModule.ycbf.jyfw.JyfwlListData.list_Jyfw;

public class YcbfJyfwDetailActivity extends BaseActivity {

    @BindView(R.id.tb_ycbf_jyfw)
    TitleBar tbYcbfJyfw;
    @BindView(R.id.tv_ycbf_jyfw_title)
    TextView tvYcbfJyfwTitle;
    @BindView(R.id.tv_ycbf_jyfw_jzsj)
    TextView tvYcbfJyfwJzsj;
    @BindView(R.id.tv_ycbf_jyfw_xzfw)
    TextView tvYcbfJyfwXzfw;
    @BindView(R.id.tv_ycbf_jyfw_zprs)
    TextView tvYcbfJyfwZprs;
    @BindView(R.id.tv_ycbf_jyfw_gzdd)
    TextView tvYcbfJyfwGzdd;
    @BindView(R.id.tv_ycbf_jyfw_gwms)
    TextView tvYcbfJyfwGwms;
    @BindView(R.id.tv_ycbf_jyfw_gwyq)
    SuperShapeTextView tvYcbfJyfwGwyq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ycbf_jyfw_detail);
        ButterKnife.bind(this);
        TitleCilckListener(tbYcbfJyfw, this);/*title按钮监听*/
        bindData();
    }

    private void bindData(){
        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        Jyfw jyfw = new Jyfw();
        for(Jyfw jyfws:list_Jyfw){
            if(jyfws.getTitle().equals(title)){
                jyfw = jyfws;
            }
        }
        tvYcbfJyfwTitle.setText(jyfw.getTitle());
        tvYcbfJyfwJzsj.setText(jyfw.getJzsj());
        tvYcbfJyfwXzfw.setText(jyfw.getXzfw());
        tvYcbfJyfwZprs.setText(jyfw.getZprs());
        tvYcbfJyfwGzdd.setText(jyfw.getGzdd());
        tvYcbfJyfwGwms.setText(jyfw.getGwms());
        tvYcbfJyfwGwyq.setText(jyfw.getGwyq());
    }
}
