package com.sys8.sqjzapp.subModule.ycbf.shbz;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

import com.kingja.supershapeview.view.SuperShapeEditText;
import com.sys8.sqjzapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.sys8.sqjzapp.subModule.ycbf.shbz.ShbzlListData.list_Shbz;
import static com.sys8.sqjzapp.subModule.ycbf.shbz.ShbzlListData.list_ShbzSq;

public class FragYcbfShbzSqbm extends Fragment {

    private static FragYcbfShbzSqbm fragInstanse = null;
    @BindView(R.id.et_ycbf_shbz_title)
    EditText etYcbfShbzTitle;
    @BindView(R.id.et_ycbf_shbz_sqly)
    SuperShapeEditText etYcbfShbzSqly;
    @BindView(R.id.bt_ycbf_shbz_save)
    Button btYcbfShbzSave;
    private YcbfShbzBmActivity parentActivity = null;
    private int LOCATION = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_ycbf_shbz_bmsq, container, false);
        // Inflate the layout for this fragment
        ButterKnife.bind(this, view);
        parentActivity =  (YcbfShbzBmActivity)getActivity();
        bindData();
        return view;
    }

    private void bindData() {
        Intent intent = getActivity().getIntent();
        String title = intent.getStringExtra("title");
        for (LOCATION =0;LOCATION<list_Shbz.size();LOCATION++) {
            if (list_Shbz.get(LOCATION).getTitle().equals(title)) {
                break;
            }
        }
        etYcbfShbzTitle.setText(list_Shbz.get(LOCATION).getTitle());
    }

    @OnClick(R.id.bt_ycbf_shbz_save)
    public void saveData(){
        list_Shbz.get(LOCATION).setState("1");
        list_ShbzSq.add(new ShbzSq(
                etYcbfShbzTitle.getText().toString(),
                etYcbfShbzSqly.getText().toString(),
                "已申请", list_Shbz.get(LOCATION)));
        parentActivity.replaceFragment(FragYcbfShbzSqbmList.getInstance());
        parentActivity.tbYcbfShbzBm.setTitle(R.string.ycbf_bt_shbz_bm_list);
    }

    private FragYcbfShbzSqbm() {
    }

    public static FragYcbfShbzSqbm getInstance() {
        if (fragInstanse == null) {
            fragInstanse = new FragYcbfShbzSqbm();
        }
        return fragInstanse;
    }

}
