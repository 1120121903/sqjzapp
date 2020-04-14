package com.sys8.sqjzapp.subModule.educationLearning.learningDetailList;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hjq.bar.TitleBar;
import com.sys8.sqjzapp.R;
import com.sys8.sqjzapp.adapters.TimeLineAdapter;
import com.sys8.sqjzapp.baseClass.ActivityCollector;
import com.sys8.sqjzapp.baseClass.BaseActivity;
import com.sys8.sqjzapp.module.LearningAudioDetailListItem;
import com.sys8.sqjzapp.module.TimelineItem;
import com.sys8.sqjzapp.utils.DataSource;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LearningAudioDetailListActivity extends BaseActivity {

    @BindView(R.id.tb_educationlearning_audio_detail_list_titlebar)
    TitleBar tbEducationlearningAudioDetailListTitlebar;
    @BindView(R.id.recycler_educationlearning_audio_detail_list_page)
    RecyclerView recyclerEducationlearningAudioDetailListPage;
    @BindView(R.id.frag_educationlearning_audio_detail_list_main_page)
    FrameLayout fragEducationlearningAudioDetailListMainPage;
    private List<TimelineItem> mData;
    private TimeLineAdapter adapter;
    String title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learning_audio_detail_list);
        ButterKnife.bind(this);
        ActivityCollector.TitleCilckListener(tbEducationlearningAudioDetailListTitlebar, this);
        bindData();
        intRv();
        getListData();
        setupAdapter();
    }
    public void bindData() {
        Intent intent = getIntent();
        title= intent.getStringExtra("title");
        tbEducationlearningAudioDetailListTitlebar.setTitle(title);
    }
    public void intRv(){
        recyclerEducationlearningAudioDetailListPage.setLayoutManager(new LinearLayoutManager(this));
    }
    public void getListData(){
        mData= DataSource.getLearningEducationAudioDetailRvData();
        //修改标题
        for(int i=0;i<mData.size();i++){
            TimelineItem item = mData.get(i);
            LearningAudioDetailListItem learningAudioDetailListItem = item.getLearningAudioDetailListItem();
            learningAudioDetailListItem.setTitle(title+"第"+(i+1)+"集");
        }
    }
    public void setupAdapter(){
        adapter = new TimeLineAdapter(this, mData);
        adapter.setOnItemClickListener(new TimeLineAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                LearningAudioDetailListItem learningAudioDetailListItem = adapter.getItem(position).getLearningAudioDetailListItem();
                toAudioPlayPage(learningAudioDetailListItem.getTitle());
            }
        });
        recyclerEducationlearningAudioDetailListPage.setAdapter(adapter);
    }
    public void toAudioPlayPage(String title){
        Intent intent =new Intent(this, LearningAudioPlayActivity.class); //参数1:Fragment所依存的Activity,参数2：要跳转的Activity
        Bundle bundle = new Bundle();
        bundle.putString("title",title); //放入所需要传递的值
        intent.putExtras(bundle);
        this.startActivity(intent); //这里一定要获取到所在Activity再startActivity()；
    }
}
