package com.sys8.sqjzapp.subModule.jzdbg;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

import com.bigkoo.pickerview.builder.TimePickerBuilder;
import com.bigkoo.pickerview.listener.OnTimeSelectListener;
import com.bigkoo.pickerview.view.TimePickerView;
import com.kingja.supershapeview.view.SuperShapeEditText;
import com.sys8.sqjzapp.R;
import com.sys8.sqjzapp.module.LocationItem;
import com.sys8.sqjzapp.module.TimelineItem;

import java.util.Calendar;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.sys8.sqjzapp.subModule.jzdbg.JzdbgListData.list_Jzdbg;
import static com.sys8.sqjzapp.subModule.jzdbg.JzdbgListData.list_JzdbgState;
import static com.sys8.sqjzapp.subModule.jzdbg.JzdbgListData.list_JzdbgState2;
import static com.sys8.sqjzapp.utils.DataUtils.dateToString;
import static com.sys8.sqjzapp.utils.DataUtils.getDate;

public class FragJzdbg_bgsq extends Fragment {

    private static FragJzdbg_bgsq fragInstanse = null;
    private static boolean SAVE_CLICK_UNABLE;//保存按钮的状态
    private JzdbgActivity parentActivity = null;
    @BindView(R.id.et_jzdbg_sqbg_szdq)
    EditText etJzdbgSqbgSzdq;
    @BindView(R.id.et_jzdbg_sqbg_xxdz)
    EditText etJzdbgSqbgXxdz;
    @BindView(R.id.et_jzdbg_sqbg_bgyy)
    SuperShapeEditText etJzdbgSqbgBgyy;
    @BindView(R.id.bt_jzdbg_sqbg_save)
    Button btJzdbgSqbgSave;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SAVE_CLICK_UNABLE = false;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_jzdbg_sqbg, container, false);
        // Inflate the layout for this fragment
        ButterKnife.bind(this, view);
        parentActivity = (JzdbgActivity) getActivity();
        return view;
    }

    @OnClick(R.id.bt_jzdbg_sqbg_save)
    public void saveData() {
        list_Jzdbg.add(new Jzdbg(
                getDate("yyyy-MM-dd"),
                etJzdbgSqbgSzdq.getText().toString()+"司法局",
                etJzdbgSqbgSzdq .getText().toString()+etJzdbgSqbgXxdz.getText().toString(),
                etJzdbgSqbgBgyy.getText().toString(),
                "审批中"
        ));
        list_JzdbgState2.add(new TimelineItem(new LocationItem("张海洋提交居住地变更申请" + "\n" + getDate("yyyy-MM-dd"), R.drawable.ic_homt_jzdbg)));
        list_JzdbgState.add(new JzdbgState(getDate("yyyy-MM-dd"), list_JzdbgState2));
        SAVE_CLICK_UNABLE = true;//保存按钮不可点击
        parentActivity.jzdbgBgjlFragment();
    }

    private FragJzdbg_bgsq() {
    }

    public static FragJzdbg_bgsq getInstance() {
        if (fragInstanse == null) {
            fragInstanse = new FragJzdbg_bgsq();
        }
        return fragInstanse;
    }

}
