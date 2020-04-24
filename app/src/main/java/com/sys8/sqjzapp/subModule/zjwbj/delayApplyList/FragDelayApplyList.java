package com.sys8.sqjzapp.subModule.zjwbj.delayApplyList;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import com.barnettwong.dragfloatactionbuttonlibrary.view.DragFloatActionButton;
import com.sys8.sqjzapp.R;
import com.sys8.sqjzapp.subModule.zjwbj.ZjwbjDetailActivity;
import com.sys8.sqjzapp.subModule.zjwbj.adapter.DelayApplyListViewAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.sys8.sqjzapp.subModule.zjwbj.delayApplyList.DelayApplyListData.list_DelayApply;
import static com.sys8.sqjzapp.utils.DataUtils.getRevertTimeLineData;

public class FragDelayApplyList extends Fragment {

    private static FragDelayApplyList fragInstanse = null;
    @BindView(R.id.lv_delay_apply)
    ListView lvDelayApply;
    @BindView(R.id.bt_zjwbj_delay_add)
    DragFloatActionButton btZjwbjDelayAdd;
    private DelayApplyListViewAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_zjwbj_delay_list, container, false);
        // Inflate the layout for this fragment
        ButterKnife.bind(this, view);
        bindData();
        return view;
    }

    private void bindData() {
        adapter = new DelayApplyListViewAdapter(getContext(), list_DelayApply, getActivity());
        lvDelayApply.setAdapter(adapter);
        //设置列表监听事件
        lvDelayApply.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), ZjwbjDelayDetailActivity.class); //参数1:Fragment所依存的Activity,参数2：要跳转的Activity
                Bundle bundle = new Bundle();
                DelayApply delayApply = (DelayApply) getRevertTimeLineData(list_DelayApply).get(position);
                bundle.putString("timeApply", delayApply.getTimeApply());
                bundle.putString("timeDelay", delayApply.getTimeDelay());
                bundle.putString("reasonDelay", delayApply.getReasonDelay());
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }

    @OnClick(R.id.bt_zjwbj_delay_add)
    public void delayApplyAdd(){
        Intent intent = new Intent(getContext(), ZjwbjDelayAddActivity.class);
        startActivity(intent);
    }

    @Override
    public void onResume() {
        super.onResume();
        /* 刷新数据 */
        lvDelayApply.setAdapter(adapter);
    }

    private FragDelayApplyList() {
    }

    public static FragDelayApplyList getInstance() {
        if (fragInstanse == null) {
            fragInstanse = new FragDelayApplyList();
        }
        return fragInstanse;
    }
}
