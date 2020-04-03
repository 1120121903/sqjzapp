package com.sys8.sqjzapp.subModule.jzdbg;

import android.os.Bundle;
import android.text.InputType;
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
import com.sys8.sqjzapp.subModule.zjwbj.BjState;
import com.sys8.sqjzapp.subModule.zjwbj.Bjjl;
import com.sys8.sqjzapp.subModule.zjwbj.ZjwbjActivity;

import java.util.Calendar;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.sys8.sqjzapp.subModule.zjwbj.BjjlListData.list_BjState;
import static com.sys8.sqjzapp.subModule.zjwbj.BjjlListData.list_BjState2;
import static com.sys8.sqjzapp.subModule.zjwbj.BjjlListData.list_Bjjl;
import static com.sys8.sqjzapp.utils.DataUtils.dateToString;
import static com.sys8.sqjzapp.utils.DataUtils.getDate;

public class FragJzdbg_bgsq extends Fragment {

    private static FragJzdbg_bgsq fragInstanse = null;
    private static boolean SAVE_CLICK_UNABLE;//保存按钮的状态
    private ZjwbjActivity parentActivity = null;

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
        parentActivity = (ZjwbjActivity) getActivity();
        return view;
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
