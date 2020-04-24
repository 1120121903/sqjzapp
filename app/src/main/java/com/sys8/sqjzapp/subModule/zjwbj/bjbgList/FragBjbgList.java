package com.sys8.sqjzapp.subModule.zjwbj.bjbgList;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import com.sys8.sqjzapp.R;
import com.sys8.sqjzapp.subModule.zjwbj.data.Bjjl;
import com.sys8.sqjzapp.subModule.zjwbj.adapter.BjjlListViewAdapter;
import com.sys8.sqjzapp.subModule.zjwbj.ZjwbjAddActivity;
import com.sys8.sqjzapp.subModule.zjwbj.ZjwbjDetailActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.sys8.sqjzapp.subModule.zjwbj.data.BjjlListData.list_Bjjl;
import static com.sys8.sqjzapp.utils.DataUtils.getRevertTimeLineData;

public class FragBjbgList extends Fragment {

    private static FragBjbgList fragInstanse = null;
    @BindView(R.id.lv_bjbg)
    ListView lvBjbg;
    private BjjlListViewAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_zjwbj_bjbg_list, container, false);
        // Inflate the layout for this fragment
        ButterKnife.bind(this, view);
        bindData();
        return view;
    }

    private void bindData() {
        adapter = new BjjlListViewAdapter(getContext(), list_Bjjl, getActivity());
        lvBjbg.setAdapter(adapter);
        //设置列表监听事件
        lvBjbg.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), ZjwbjDetailActivity.class); //参数1:Fragment所依存的Activity,参数2：要跳转的Activity
                Bundle bundle = new Bundle();
                Bjjl bjjl = (Bjjl) getRevertTimeLineData(list_Bjjl).get(position);
                bundle.putString("timeApply", bjjl.getTimeApply());
                bundle.putString("timeStart", bjjl.getTimeStart());
                bundle.putString("bjsm", bjjl.getBjsm());
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        /* 刷新数据 */
        lvBjbg.setAdapter(adapter);
    }

    private FragBjbgList() {
    }

    public static FragBjbgList getInstance() {
        if (fragInstanse == null) {
            fragInstanse = new FragBjbgList();
        }
        return fragInstanse;
    }

    @OnClick(R.id.bt_zjwbj_bjbg_tbbj)
    public void zjwbjBjbgAdd() {
        Intent intent = new Intent(getContext(), ZjwbjAddActivity.class);
        startActivity(intent);
    }

}
