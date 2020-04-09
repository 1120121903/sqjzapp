package com.sys8.sqjzapp.main.tztx;

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
import static com.sys8.sqjzapp.main.tztx.ListData.list_TZTX;
import static com.sys8.sqjzapp.utils.DataUtils.getRevertTimeLineData;

public class FragTztx extends Fragment {

    @BindView(R.id.lv_tztx)
    ListView lvTztx;
    private TztxListViewAdapter adapter;
    private View view;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        if(view == null){
            view = inflater.inflate(R.layout.frag_tztx, container, false);
        }
        ButterKnife.bind(this, view);
        bindData();
        return view;
    }

    private void bindData(){
        adapter = new TztxListViewAdapter(getView(),getContext(),list_TZTX,getActivity());
        lvTztx.setAdapter(adapter);
        lvTztx.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(),TzxxDetailActivity.class);
                Bundle bundle = new Bundle();
                Tzxx gyhdYbm = (Tzxx) getRevertTimeLineData(list_TZTX).get(position);
                bundle.putString("title",gyhdYbm.getTitle() );
                intent.putExtras(bundle);
                getActivity().startActivity(intent);
            }
        });
    }

    @Override
    public void onResume() {
        lvTztx.setAdapter(adapter);//刷新数据
        super.onResume();
    }

}
