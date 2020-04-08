package com.sys8.sqjzapp.subModule.ycbf.shbz;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import com.sys8.sqjzapp.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.sys8.sqjzapp.subModule.ycbf.shbz.ShbzlListData.list_ShbzSq;
import static com.sys8.sqjzapp.utils.DataUtils.getRevertTimeLineData;

public class FragYcbf_shbz_sqbm_list extends Fragment {

    private static FragYcbf_shbz_sqbm_list fragInstanse = null;
    private ShbzSqbmListViewAdapter adapter;
    @BindView(R.id.lv_ycbf_shbz_bmsq_list)
    ListView lvYcbfShbzBmsqList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_ycbf_shbz_bmsq_list, container, false);
        // Inflate the layout for this fragment
        ButterKnife.bind(this, view);
        bindData();
        return view;
    }

    private void bindData(){
        List<Shbz> shbzs = new ArrayList<Shbz>();
        for(ShbzSq shbzSq : list_ShbzSq){
            shbzs.add(shbzSq.getShbz());
        }
        adapter = new ShbzSqbmListViewAdapter(getView(),getContext(),shbzs,getActivity());
        lvYcbfShbzBmsqList.setAdapter(adapter);
        //设置列表监听事件
        lvYcbfShbzBmsqList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(getActivity(), YcbfShbzDetailActivity.class); //参数1:Fragment所依存的Activity,参数2：要跳转的Activity
                Bundle bundle = new Bundle();
                Shbz shbz = (Shbz) getRevertTimeLineData(shbzs).get(position);
                bundle.putString("title",shbz.getTitle() ); //放入所需要传递的值
                bundle.putString("jzsj", shbz.getJzsj());
                bundle.putString("content", shbz.getContent());
                bundle.putString("state", shbz.getState());
                intent.putExtras(bundle);
                getActivity().startActivity(intent);
            }
        });
    }

    private FragYcbf_shbz_sqbm_list() {
    }

    public static FragYcbf_shbz_sqbm_list getInstance() {
        if (fragInstanse == null) {
            fragInstanse = new FragYcbf_shbz_sqbm_list();
        }
        return fragInstanse;
    }

}
