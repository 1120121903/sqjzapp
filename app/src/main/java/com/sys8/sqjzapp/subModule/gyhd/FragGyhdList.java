package com.sys8.sqjzapp.subModule.gyhd;

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

import static com.sys8.sqjzapp.subModule.gyhd.GyhdListData.list_Gyhd;
import static com.sys8.sqjzapp.utils.Constant.topTabs_gyhd;
import static com.sys8.sqjzapp.utils.DataUtils.getRevertTimeLineData;

public class FragGyhdList extends Fragment {

    private static FragGyhdList fragInstanse = null;
    @BindView(R.id.lv_gyhd_list)
    ListView lvGyhdList;
    private GyhdListViewAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_gyhd_list, container, false);
        // Inflate the layout for this fragment
        ButterKnife.bind(this, view);
        bindData();
        return view;
    }

    private void bindData(){
        adapter = new GyhdListViewAdapter(getView(),getContext(),list_Gyhd,getActivity());
        lvGyhdList.setAdapter(adapter);
        //设置列表监听事件
        lvGyhdList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(getActivity(), GyhdDetailActivity.class); //参数1:Fragment所依存的Activity,参数2：要跳转的Activity
                Bundle bundle = new Bundle();
                Gyhd gyhd = (Gyhd) getRevertTimeLineData(list_Gyhd).get(position);
                bundle.putString("title",gyhd.getTitle()); //放入所需要传递的值
                bundle.putString("type",topTabs_gyhd[0]);
                intent.putExtras(bundle);
                getActivity().startActivity(intent);
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        /* 刷新数据 */
        lvGyhdList.setAdapter(adapter);
    }

    private FragGyhdList() {
    }

    public static FragGyhdList getInstance() {
        if (fragInstanse == null) {
            fragInstanse = new FragGyhdList();
        }
        return fragInstanse;
    }

}
