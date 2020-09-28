package com.sys8.sqjzapp.subModule.educationLearning.learningClassification;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sys8.sqjzapp.R;
import com.sys8.sqjzapp.adapters.TimeLineAdapter;
import com.sys8.sqjzapp.module.LearningListItem;
import com.sys8.sqjzapp.module.TimelineItem;
import com.sys8.sqjzapp.subModule.educationLearning.EducationLearningActivity;
import com.sys8.sqjzapp.subModule.educationLearning.LearningClassificationBaseFragment;
import com.sys8.sqjzapp.subModule.educationLearning.learningDetailList.LearningAudioDetailListActivity;
import com.sys8.sqjzapp.subModule.educationLearning.learningDetailList.LearningPictureDetailListActivity;
import com.sys8.sqjzapp.subModule.educationLearning.learningDetailList.LearningVideoDetailListActivity;
import com.sys8.sqjzapp.utils.DataSource;

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
    private EducationLearningActivity parentActivity = null;
    private TimeLineAdapter adapter;
    private List<TimelineItem> mData;
    private Unbinder unbinder;
    private View view;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if(view ==null){
            view = inflater.inflate(R.layout.fragment_learning_content_all, container, false);
        }
        unbinder = ButterKnife.bind(this, view);
        parentActivity = (EducationLearningActivity) getActivity();
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
        adapter.setOnItemClickListener(new TimeLineAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                LearningListItem learningListItem = adapter.getItem(position).getLearningListItem();
                toDetailPage(learningListItem.getMediaType(),learningListItem.getTitle());
                }
        });
        recyclerLearningeducationPageAll.setAdapter(adapter);
    }

    //页面跳转
    public void toDetailPage(int mediatype,String title){
        switch (mediatype){
            case MEDIA_TYPE_VIDEO:
                Intent intent_video=new Intent(parentActivity, LearningVideoDetailListActivity.class); //参数1:Fragment所依存的Activity,参数2：要跳转的Activity
                Bundle bundle_video = new Bundle();
                bundle_video.putString("title",title); //放入所需要传递的值
                intent_video.putExtras(bundle_video);
                parentActivity.startActivity(intent_video); //这里一定要获取到所在Activity再startActivity()；
                break;
            case MEDIA_TYPE_AUDIO:
                Intent intent_audio=new Intent(parentActivity, LearningAudioDetailListActivity.class); //参数1:Fragment所依存的Activity,参数2：要跳转的Activity
                Bundle bundle_audio = new Bundle();
                bundle_audio.putString("title",title); //放入所需要传递的值
                intent_audio.putExtras(bundle_audio);
                parentActivity.startActivity(intent_audio); //这里一定要获取到所在Activity再startActivity()；
                break;
            case MEDIA_TYPE_PICTURE:
                Intent intent_picture=new Intent(parentActivity, LearningPictureDetailListActivity.class); //参数1:Fragment所依存的Activity,参数2：要跳转的Activity
                Bundle bundle_picture = new Bundle();
                bundle_picture.putString("title",title); //放入所需要传递的值
                intent_picture.putExtras(bundle_picture);
                parentActivity.startActivity(intent_picture); //这里一定要获取到所在Activity再startActivity()；
                break;
                default:break;
        }
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

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            Log.d("TAG", "setUserVisibleHint:  AllFragment");
        }
    }
}
