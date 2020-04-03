package com.sys8.sqjzapp.subModule.zjwbj;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import com.sys8.sqjzapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.sys8.sqjzapp.subModule.zjwbj.BjjlListData.list_Bjjl;
import static com.sys8.sqjzapp.utils.DataUtils.getRevertTimeLineData;

public class FragZjwbj_bjjl extends Fragment {

    private static FragZjwbj_bjjl fragInstanse = null;
    private BjjlListViewAdapter adapter;
    @BindView(R.id.lv_bjjl)
    ListView lvBjjl;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_zjwbj_bjjl, container, false);
        // Inflate the layout for this fragment
        ButterKnife.bind(this, view);
        bindData();
        return view;
    }
    private void bindData(){
        adapter = new BjjlListViewAdapter(getView(),getContext(),list_Bjjl,getActivity());
        lvBjjl.setAdapter(adapter);
        //设置列表监听事件
        lvBjjl.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(getActivity(),ZjwbjDetailActivity.class); //参数1:Fragment所依存的Activity,参数2：要跳转的Activity
                Bundle bundle = new Bundle();
                Bjjl bjjl = (Bjjl) getRevertTimeLineData(list_Bjjl).get(position);
                bundle.putString("timeApply", bjjl.getTimeApply());
                bundle.putString("timeStart", bjjl.getTimeStart());
                bundle.putString("bjsm", bjjl.getBjsm());
                intent.putExtras(bundle);
                getActivity().startActivity(intent);
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        /* 刷新数据 */
        lvBjjl.setAdapter(adapter);
    }

    private FragZjwbj_bjjl() {
    }

    public static FragZjwbj_bjjl getInstance() {
        if (fragInstanse == null) {
            fragInstanse = new FragZjwbj_bjjl();
        }
        return fragInstanse;
    }

}
