package com.sys8.sqjzapp.subModule.ycbf.jyfw;

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

import static com.sys8.sqjzapp.subModule.ycbf.jyfw.JyfwlListData.list_Jyfw;
import static com.sys8.sqjzapp.utils.DataUtils.getRevertTimeLineData;

public class FragYcbfJyfw extends Fragment {

    private static FragYcbfJyfw fragInstanse = null;
    @BindView(R.id.lv_ycbf_jyfw)
    ListView lvYcbfJyfw;
    private JyfwListViewAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_ycbf_jyfw, container, false);
        // Inflate the layout for this fragment
        ButterKnife.bind(this, view);
        bindData();
        return view;
    }

    private void bindData(){
        adapter = new JyfwListViewAdapter(getView(),getContext(),list_Jyfw,getActivity());
        lvYcbfJyfw.setAdapter(adapter);
        //设置列表监听事件
        lvYcbfJyfw.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(getActivity(), YcbfJyfwDetailActivity.class); //参数1:Fragment所依存的Activity,参数2：要跳转的Activity
                Bundle bundle = new Bundle();
                Jyfw jyfw = (Jyfw) getRevertTimeLineData(list_Jyfw).get(position);
                bundle.putString("title",jyfw.getTitle() ); //放入所需要传递的值
                intent.putExtras(bundle);
                getActivity().startActivity(intent);
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        /* 刷新数据 */
//        lvQjjl.setAdapter(adapter);
    }

    private FragYcbfJyfw() {
    }

    public static FragYcbfJyfw getInstance() {
        if (fragInstanse == null) {
            fragInstanse = new FragYcbfJyfw();
        }
        return fragInstanse;
    }

}
