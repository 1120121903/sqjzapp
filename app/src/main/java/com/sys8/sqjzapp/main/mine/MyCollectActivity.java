package com.sys8.sqjzapp.main.mine;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hjq.bar.TitleBar;
import com.sys8.sqjzapp.R;
import com.sys8.sqjzapp.adapters.TimeLineAdapter;
import com.sys8.sqjzapp.baseClass.ActivityCollector;
import com.sys8.sqjzapp.baseClass.BaseActivity;
import com.sys8.sqjzapp.module.LearningListItem;
import com.sys8.sqjzapp.module.TimelineItem;
import com.sys8.sqjzapp.subModule.educationLearning.learningDetailList.LearningAudioDetailListActivity;
import com.sys8.sqjzapp.subModule.educationLearning.learningDetailList.LearningPictureDetailListActivity;
import com.sys8.sqjzapp.subModule.educationLearning.learningDetailList.LearningVideoDetailListActivity;
import com.sys8.sqjzapp.utils.DataSource;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.sys8.sqjzapp.utils.Constant.MEDIA_TYPE_AUDIO;
import static com.sys8.sqjzapp.utils.Constant.MEDIA_TYPE_PICTURE;
import static com.sys8.sqjzapp.utils.Constant.MEDIA_TYPE_VIDEO;
import static com.sys8.sqjzapp.utils.DataUtils.getRevertTimeLineData;

public class MyCollectActivity extends BaseActivity {

    @BindView(R.id.recycler_mine_collect)
    RecyclerView recyclerMineCollect;
    @BindView(R.id.tb_mine_collect_titlebar)
    TitleBar tbMineCollectTitlebar;
    private TimeLineAdapter adapter;
    private List<TimelineItem> mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_collect);
        ButterKnife.bind(this);
        ActivityCollector.TitleCilckListener(tbMineCollectTitlebar, this);
        intRv();
        getListData();
        setupAdapter();
    }
    private void intRv() {
        recyclerMineCollect.setLayoutManager(new LinearLayoutManager(this));
    }

    private void getListData() {
        mData = getRevertTimeLineData(DataSource.mCollectData);
    }
    private void setupAdapter() {
        adapter = new TimeLineAdapter(this, mData);
        adapter.setOnItemClickListener(new TimeLineAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                LearningListItem learningListItem = adapter.getItem(position).getLearningListItem();
                toDetailPage(learningListItem.getMediaType(),learningListItem.getTitle());
            }
        });
        recyclerMineCollect.setAdapter(adapter);
    }

    //页面跳转
    public void toDetailPage(int mediatype,String title){
        switch (mediatype){
            case MEDIA_TYPE_VIDEO:
                Intent intent_video=new Intent(this, LearningVideoDetailListActivity.class); //参数1:Fragment所依存的Activity,参数2：要跳转的Activity
                Bundle bundle_video = new Bundle();
                bundle_video.putString("title",title); //放入所需要传递的值
                intent_video.putExtras(bundle_video);
                this.startActivity(intent_video); //这里一定要获取到所在Activity再startActivity()；
                break;
            case MEDIA_TYPE_AUDIO:
                Intent intent_audio=new Intent(this, LearningAudioDetailListActivity.class); //参数1:Fragment所依存的Activity,参数2：要跳转的Activity
                Bundle bundle_audio = new Bundle();
                bundle_audio.putString("title",title); //放入所需要传递的值
                intent_audio.putExtras(bundle_audio);
                this.startActivity(intent_audio); //这里一定要获取到所在Activity再startActivity()；
                break;
            case MEDIA_TYPE_PICTURE:
                Intent intent_picture=new Intent(this, LearningPictureDetailListActivity.class); //参数1:Fragment所依存的Activity,参数2：要跳转的Activity
                Bundle bundle_picture = new Bundle();
                bundle_picture.putString("title",title); //放入所需要传递的值
                intent_picture.putExtras(bundle_picture);
                this.startActivity(intent_picture); //这里一定要获取到所在Activity再startActivity()；
                break;
            default:break;
        }
    }
}
