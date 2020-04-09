package com.sys8.sqjzapp.subModule.rcbg;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.barnettwong.dragfloatactionbuttonlibrary.view.DragFloatActionButton;
import com.hjq.bar.TitleBar;
import com.sys8.sqjzapp.R;
import com.sys8.sqjzapp.baseClass.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.sys8.sqjzapp.baseClass.ActivityCollector.TitleCilckListener;
import static com.sys8.sqjzapp.subModule.rcbg.RcbgListData.list_RCBG;
import static com.sys8.sqjzapp.utils.DataUtils.getRevertTimeLineData;

public class RcbgActivity extends BaseActivity {

    @BindView(R.id.tb_rcbg)
    TitleBar tbRcbg;
    @BindView(R.id.bt_rcbg_txbg)
    DragFloatActionButton btRcbgTxbg;
    @BindView(R.id.lv_rcbg)
    ListView lvRcbg;
    private   RcbgnListViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rcbg);
        ButterKnife.bind(this);
        TitleCilckListener(tbRcbg, this);/*title按钮监听*/
        bindData();
    }

    @Override
    protected void onPostResume() {
        adapter = new RcbgnListViewAdapter(this,list_RCBG,this);
        super.onPostResume();
        lvRcbg.setAdapter(adapter);
    }

    private void bindData(){
        adapter = new RcbgnListViewAdapter(this,list_RCBG,this);
        lvRcbg.setAdapter(adapter);
        lvRcbg.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(RcbgActivity.this,RcbgDetailActivity.class); //参数1:Fragment所依存的Activity,参数2：要跳转的Activity
                Bundle bundle = new Bundle();
                Rcbg rcbg = (Rcbg) getRevertTimeLineData(list_RCBG).get(position);
                bundle.putString("title", rcbg.getTitle()); //放入所需要传递的值
                bundle.putString("content", rcbg.getContent());
                bundle.putString("time", rcbg.getTime());
                bundle.putString("place", rcbg.getPlace());
                intent.putExtras(bundle);
                startActivity(intent); //这里一定要获取到所在Activity再startActivity()；
            }
        });
    }

    @OnClick(R.id.bt_rcbg_txbg)
    public void rcbgTxbg() {
        Intent intent = new Intent(RcbgActivity.this,RcbgAddActivity.class);
        startActivity(intent);
    }

}
