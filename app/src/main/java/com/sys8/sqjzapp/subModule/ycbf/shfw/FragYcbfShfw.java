package com.sys8.sqjzapp.subModule.ycbf.shfw;

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

import static com.sys8.sqjzapp.subModule.ycbf.shfw.ShfwlListData.list_Shfw;
import static com.sys8.sqjzapp.utils.DataUtils.getRevertTimeLineData;

public class FragYcbfShfw extends Fragment {

    private static FragYcbfShfw fragInstanse = null;
    @BindView(R.id.lv_ycbf_shfw)
    ListView lvYcbfShfw;
    private ShfwListViewAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_ycbf_shfw, container, false);
        // Inflate the layout for this fragment
        ButterKnife.bind(this, view);
        bindData();
        return view;
    }

    private void bindData(){
        adapter = new ShfwListViewAdapter(getView(),getContext(),list_Shfw,getActivity());
        lvYcbfShfw.setAdapter(adapter);
        //设置列表监听事件
        lvYcbfShfw.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(getActivity(), YcbfShfwDetailActivity.class); //参数1:Fragment所依存的Activity,参数2：要跳转的Activity
                Bundle bundle = new Bundle();
                Shfw shfw = (Shfw) getRevertTimeLineData(list_Shfw).get(position);
                bundle.putString("title",shfw.getTitle() ); //放入所需要传递的值
                bundle.putString("content", shfw.getContent());
                intent.putExtras(bundle);
                getActivity().startActivity(intent);
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        /* 刷新数据 */
        lvYcbfShfw.setAdapter(adapter);
    }

    private FragYcbfShfw() {
    }

    public static FragYcbfShfw getInstance() {
        if (fragInstanse == null) {
            fragInstanse = new FragYcbfShfw();
        }
        return fragInstanse;
    }

}
