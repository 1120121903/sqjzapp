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

import static com.sys8.sqjzapp.subModule.gyhd.GyhdListData.list_GyhdYbm;
import static com.sys8.sqjzapp.utils.Constant.topTabs_gyhd;
import static com.sys8.sqjzapp.utils.DataUtils.getRevertTimeLineData;

public class FragGyhdWdList extends Fragment {

    private static FragGyhdWdList fragInstanse = null;
    @BindView(R.id.lv_gyhd_wdlist)
    ListView lvGyhdWdlist;
    private GyhdListViewAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_gyhd_wdlist, container, false);
        // Inflate the layout for this fragment
        ButterKnife.bind(this, view);
        bindData();
        return view;
    }

    private void bindData() {
        adapter = new GyhdListViewAdapter(getView(), getContext(), list_GyhdYbm, getActivity());
        lvGyhdWdlist.setAdapter(adapter);
        //设置列表监听事件
        lvGyhdWdlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(getActivity(), GyhdDetailActivity.class); //参数1:Fragment所依存的Activity,参数2：要跳转的Activity
                Bundle bundle = new Bundle();
                Gyhd gyhdYbm = (Gyhd) getRevertTimeLineData(list_GyhdYbm).get(position);
                bundle.putString("title",gyhdYbm.getTitle() ); //放入所需要传递的值
                bundle.putString("type",topTabs_gyhd[1]);
                intent.putExtras(bundle);
                getActivity().startActivity(intent);
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        /* 刷新数据 */
        System.out.println("ybmListSize:"+list_GyhdYbm.size());
        adapter = new GyhdListViewAdapter(getView(), getContext(), list_GyhdYbm, getActivity());
        lvGyhdWdlist.setAdapter(adapter);
    }

    private FragGyhdWdList() {
    }

    public static FragGyhdWdList getInstance() {
        if (fragInstanse == null) {
            fragInstanse = new FragGyhdWdList();
        }
        return fragInstanse;
    }

}
