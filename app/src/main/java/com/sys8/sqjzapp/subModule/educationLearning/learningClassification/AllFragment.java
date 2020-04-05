package com.sys8.sqjzapp.subModule.educationLearning.learningClassification;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.sys8.sqjzapp.R;
import com.sys8.sqjzapp.subModule.educationLearning.LearningClassificationBaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

import static com.sys8.sqjzapp.utils.Constant.MEDIA_TYPE_AUDIO;
import static com.sys8.sqjzapp.utils.Constant.MEDIA_TYPE_PICTURE;
import static com.sys8.sqjzapp.utils.Constant.MEDIA_TYPE_VIDEO;

public class AllFragment extends LearningClassificationBaseFragment {
    @BindView(R.id.all_test_tv)
    TextView allTestTv;
    private Unbinder unbinder;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_learning_content_all, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public int setLayoutResourceID() {
        return R.layout.fragment_learning_content_all;
    }

    @Override
    public void FilterMediaType(int MediaType) {
        switch (MediaType){
            case MEDIA_TYPE_VIDEO:
                allTestTv.setText("视频");
                break;
            case MEDIA_TYPE_AUDIO:
                allTestTv.setText("音频");
                break;
            case MEDIA_TYPE_PICTURE:
                allTestTv.setText("图文");
                break;
            default:
                break;
        }

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


}
