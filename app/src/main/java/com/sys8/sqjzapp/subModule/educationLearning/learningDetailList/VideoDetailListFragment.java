package com.sys8.sqjzapp.subModule.educationLearning.learningDetailList;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.sys8.sqjzapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


public class VideoDetailListFragment extends Fragment {
    private static final String COURSE_TITLE = "课程";//课程标题
    @BindView(R.id.tv_learning_education_video_detail_list_title)
    TextView tvLearningEducationVideoDetailListTitle;

    private String mCourseTitle;
    private Unbinder unbinder;

    public VideoDetailListFragment() {
        // Required empty public constructor
    }

    public static VideoDetailListFragment newInstance(String courseTitle) {
        VideoDetailListFragment fragment = new VideoDetailListFragment();
        Bundle args = new Bundle();
        args.putString(COURSE_TITLE, courseTitle);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mCourseTitle = getArguments().getString(COURSE_TITLE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_video_detail_list, container, false);
        unbinder = ButterKnife.bind(this, view);
        tvLearningEducationVideoDetailListTitle.setText(mCourseTitle);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
