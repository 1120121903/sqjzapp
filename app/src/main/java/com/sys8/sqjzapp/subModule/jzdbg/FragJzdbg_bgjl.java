package com.sys8.sqjzapp.subModule.jzdbg;

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

import static com.sys8.sqjzapp.subModule.jzdbg.JzdbgListData.list_Jzdbg;
import static com.sys8.sqjzapp.utils.DataUtils.getRevertTimeLineData;

public class FragJzdbg_bgjl extends Fragment {

    private static FragJzdbg_bgjl fragInstanse = null;
    @BindView(R.id.lv_bgjl)
    ListView lvBgjl;
    private JzdbgListViewAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_jzdbg_bgjl, container, false);
        // Inflate the layout for this fragment
        ButterKnife.bind(this, view);
        bindData();
        return view;
    }

    private void bindData() {
        adapter = new JzdbgListViewAdapter(getView(), getContext(), list_Jzdbg, getActivity());
        lvBgjl.setAdapter(adapter);
        //设置列表监听事件
        lvBgjl.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), JzdbgDetailActivity.class); //参数1:Fragment所依存的Activity,参数2：要跳转的Activity
                Bundle bundle = new Bundle();
                Jzdbg jzdbg = (Jzdbg) getRevertTimeLineData(list_Jzdbg).get(position);
                bundle.putString("timeApply", jzdbg.getTimeApply());
                bundle.putString("jsdw", jzdbg.getJsdw());
                bundle.putString("xjzd", jzdbg.getXjzd());
                bundle.putString("bgyy", jzdbg.getBgyy());
                intent.putExtras(bundle);
                getActivity().startActivity(intent);
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        /* 刷新数据 */
        lvBgjl.setAdapter(adapter);
    }

    private FragJzdbg_bgjl() {
    }

    public static FragJzdbg_bgjl getInstance() {
        if (fragInstanse == null) {
            fragInstanse = new FragJzdbg_bgjl();
        }
        return fragInstanse;
    }

}
