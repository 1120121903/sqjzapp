package com.sys8.sqjzapp.subModule.wcqj;

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

import static com.sys8.sqjzapp.subModule.wcqj.QjjlListData.list_Qjjl;
import static com.sys8.sqjzapp.utils.DataUtils.getRevertTimeLineData;

public class FragWcqj_qjjl extends Fragment {

    private static FragWcqj_qjjl fragInstanse = null;
    private QjjlListViewAdapter adapter;
    @BindView(R.id.lv_qjjl)
    ListView lvQjjl;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_wcqj_qjjl, container, false);
        // Inflate the layout for this fragment
        ButterKnife.bind(this, view);
        bindData();
        return view;
    }

    private void bindData(){
        adapter = new QjjlListViewAdapter(getView(),getContext(),list_Qjjl,getActivity());
        lvQjjl.setAdapter(adapter);
        //设置列表监听事件
        lvQjjl.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(getActivity(),WcqjDetailActivity.class); //参数1:Fragment所依存的Activity,参数2：要跳转的Activity
                Bundle bundle = new Bundle();
                Qjjl qjjl = (Qjjl) getRevertTimeLineData(list_Qjjl).get(position);
                bundle.putString("title",qjjl.getTitle() ); //放入所需要传递的值
                bundle.putString("timeApply", qjjl.getTimeApply());
                bundle.putString("timeStart", qjjl.getTimeStart());
                bundle.putString("timeEnd", qjjl.getTimeEnd());
                bundle.putString("days", qjjl.getDays());
                bundle.putString("place", qjjl.getPlace());
                bundle.putString("reason", qjjl.getReason());
                intent.putExtras(bundle);
                getActivity().startActivity(intent);
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        /* 刷新数据 */
        lvQjjl.setAdapter(adapter);
    }

    private FragWcqj_qjjl() {
    }

    public static FragWcqj_qjjl getInstance() {
        if (fragInstanse == null) {
            fragInstanse = new FragWcqj_qjjl();
        }
        return fragInstanse;
    }

}
