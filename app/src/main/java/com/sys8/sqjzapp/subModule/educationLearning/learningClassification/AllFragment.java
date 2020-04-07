package com.sys8.sqjzapp.subModule.educationLearning.learningClassification;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sys8.sqjzapp.R;
import com.sys8.sqjzapp.adapters.LearningListViewHolder;
import com.sys8.sqjzapp.adapters.TimeLineAdapter;
import com.sys8.sqjzapp.module.LearningListItem;
import com.sys8.sqjzapp.module.TimelineItem;
import com.sys8.sqjzapp.subModule.educationLearning.LearningClassificationBaseFragment;
import com.sys8.sqjzapp.utils.DataSource;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

import static com.sys8.sqjzapp.utils.Constant.MEDIA_TYPE_ALLMEDIA;
import static com.sys8.sqjzapp.utils.Constant.MEDIA_TYPE_AUDIO;
import static com.sys8.sqjzapp.utils.Constant.MEDIA_TYPE_PICTURE;
import static com.sys8.sqjzapp.utils.Constant.MEDIA_TYPE_VIDEO;

public class AllFragment extends LearningClassificationBaseFragment {

    @BindView(R.id.recycler_learningeducation_page_all)
    RecyclerView recyclerLearningeducationPageAll;

    private TimeLineAdapter adapter;
    private List<TimelineItem> mData;
    private Unbinder unbinder;
    View view;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_learning_content_all, container, false);
        unbinder = ButterKnife.bind(this, view);

        intRv();
        getListData();
        setupAdapter();


        return view;
    }

    private void intRv() {
        recyclerLearningeducationPageAll.setLayoutManager(new LinearLayoutManager(view.getContext()));
    }

    private void getListData() {
        mData = DataSource.getLearningEducationListData();
    }

    private void setupAdapter() {
        adapter = new TimeLineAdapter(view.getContext(), mData);
        recyclerLearningeducationPageAll.setAdapter(adapter);
    }

    @Override
    public int setLayoutResourceID() {
        return R.layout.fragment_learning_content_all;
    }

    @Override
    public void FilterMediaType(int MediaType) {
        switch (MediaType) {
            case MEDIA_TYPE_ALLMEDIA:
                getListData();
                break;
            case MEDIA_TYPE_VIDEO:
                mData=DataSource.getLearningEducationListVideoData();
                break;
            case MEDIA_TYPE_AUDIO:
                mData=DataSource.getLearningEducationListAudioData();
                break;
            case MEDIA_TYPE_PICTURE:
                mData=DataSource.getLearningEducationListPictureData();
                break;
            default:
                break;
        }
        setupAdapter();

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


}
