package com.sys8.sqjzapp.subModule.ycbf.wdbf;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.hjq.bar.TitleBar;
import com.sys8.sqjzapp.R;
import com.sys8.sqjzapp.baseClass.BaseActivity;
import com.sys8.sqjzapp.subModule.ycbf.shbz.Shbz;
import com.sys8.sqjzapp.subModule.ycbf.shbz.ShbzListViewAdapter;
import com.sys8.sqjzapp.subModule.ycbf.shbz.YcbfShbzDetailActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.sys8.sqjzapp.baseClass.ActivityCollector.TitleCilckListener;
import static com.sys8.sqjzapp.subModule.ycbf.shbz.ShbzlListData.list_ShbzYsq;
import static com.sys8.sqjzapp.utils.DataUtils.getRevertTimeLineData;

public class YcbfWdbfActivity extends BaseActivity {

    @BindView(R.id.tb_ycbf_wdbf)
    TitleBar tbYcbfWdbf;
    @BindView(R.id.lv_ycbf_wdbf)
    ListView lvYcbfWdbf;
    private ShbzListViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ycbf_wdbf);
        ButterKnife.bind(this);
        TitleCilckListener(tbYcbfWdbf, this);/*title按钮监听*/
        bindData();
    }

    private void bindData() {
        adapter = new ShbzListViewAdapter(this, list_ShbzYsq,this);
        lvYcbfWdbf.setAdapter(adapter);
        //设置列表监听事件
        lvYcbfWdbf.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(YcbfWdbfActivity.this,YcbfShbzDetailActivity.class); //参数1:Fragment所依存的Activity,参数2：要跳转的Activity
                Bundle bundle = new Bundle();
                Shbz shbz = (Shbz) getRevertTimeLineData(list_ShbzYsq).get(position);
                bundle.putString("title",shbz.getTitle() ); //放入所需要传递的值
                bundle.putString("jzsj", shbz.getJzsj());
                bundle.putString("content", shbz.getContent());
                bundle.putString("state", shbz.getState());
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
}
