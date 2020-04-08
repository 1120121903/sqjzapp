package com.sys8.sqjzapp.subModule.ycbf.shbz;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.hjq.bar.TitleBar;
import com.kingja.supershapeview.view.SuperShapeTextView;
import com.sys8.sqjzapp.R;
import com.sys8.sqjzapp.baseClass.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.sys8.sqjzapp.baseClass.ActivityCollector.TitleCilckListener;
import static com.sys8.sqjzapp.utils.Constant.STATE_YCBF_SHBZ_YBM;

public class YcbfShbzDetailActivity extends BaseActivity {

    @BindView(R.id.tb_ycbf_shbz)
    TitleBar tbYcbfShbz;
    @BindView(R.id.tv_ycbf_shbz_title)
    TextView tvYcbfShbzTitle;
    @BindView(R.id.tv_ycbf_shbz_jzsj)
    TextView tvYcbfShbzJzsj;
    @BindView(R.id.tv_ycbf_shbz_content)
    SuperShapeTextView tvYcbfShbzContent;
    @BindView(R.id.bt_ycbf_shbz_bm)
    Button btYcbfShbzBm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ycbf_shbz);
        ButterKnife.bind(this);
        TitleCilckListener(tbYcbfShbz, this);/*title按钮监听*/
        bindData();
    }

    private void bindData(){
        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        String jzsj = intent.getStringExtra("jzsj");
        String content = intent.getStringExtra("content");
        String type = intent.getStringExtra("state");

        if(type.equals(STATE_YCBF_SHBZ_YBM)){
            btYcbfShbzBm.setText(getString(R.string.ycbf_bt_shbz_ybm));
            btYcbfShbzBm.setEnabled(false);
        }else{
            btYcbfShbzBm.setText(getString(R.string.ycbf_bt_shbz_bm));
            btYcbfShbzBm.setEnabled(true);
        }

        tvYcbfShbzTitle.setText(title);
        tvYcbfShbzJzsj.setText(jzsj);
        tvYcbfShbzContent.setText(content);
    }

    @OnClick(R.id.bt_ycbf_shbz_bm)
    public void shbzBm(){
        Intent intent=new Intent(this,YcbfShbzBmActivity.class); //参数1:Fragment所依存的Activity,参数2：要跳转的Activity
        Bundle bundle = new Bundle();
        bundle.putString("title",tvYcbfShbzTitle.getText().toString()); //放入所需要传递的值
        intent.putExtras(bundle);
        this.startActivity(intent);
    }

}
