package com.sys8.sqjzapp.subModule.ycbf.wdbf;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import com.sys8.sqjzapp.R;
import com.sys8.sqjzapp.subModule.ycbf.shbz.Shbz;
import com.sys8.sqjzapp.subModule.ycbf.shbz.ShbzListViewAdapter;
import com.sys8.sqjzapp.subModule.ycbf.shbz.YcbfShbzDetailActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.sys8.sqjzapp.subModule.ycbf.shbz.ShbzlListData.list_Shbz;
import static com.sys8.sqjzapp.subModule.ycbf.shbz.ShbzlListData.list_ShbzYsq;
import static com.sys8.sqjzapp.utils.DataUtils.getRevertTimeLineData;

public class FragYcbfWdbf extends Fragment {

    private static FragYcbfWdbf fragInstanse = null;
    @BindView(R.id.lv_ycbf_wdbf)
    ListView lvYcbfWdbf;
    private ShbzListViewAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_ycbf_wdbf, container, false);
        // Inflate the layout for this fragment
        ButterKnife.bind(this, view);
        bindData();
        return view;
    }

    private void bindData() {
        adapter = new ShbzListViewAdapter(getView(), getContext(), list_ShbzYsq, getActivity());
        lvYcbfWdbf.setAdapter(adapter);
        //设置列表监听事件
        lvYcbfWdbf.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(getActivity(), YcbfShbzDetailActivity.class); //参数1:Fragment所依存的Activity,参数2：要跳转的Activity
                Bundle bundle = new Bundle();
                Shbz shbz = (Shbz) getRevertTimeLineData(list_ShbzYsq).get(position);
                bundle.putString("title",shbz.getTitle() ); //放入所需要传递的值
                bundle.putString("jzsj", shbz.getJzsj());
                bundle.putString("content", shbz.getContent());
                bundle.putString("state", shbz.getState());
                intent.putExtras(bundle);
                getActivity().startActivity(intent);
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        /* 刷新数据 */
        lvYcbfWdbf.setAdapter(adapter);
    }

    private FragYcbfWdbf() {
    }

    public static FragYcbfWdbf getInstance() {
        if (fragInstanse == null) {
            fragInstanse = new FragYcbfWdbf();
        }
        return fragInstanse;
    }

}
