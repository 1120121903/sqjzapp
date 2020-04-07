package com.sys8.sqjzapp.subModule.educationLearning.learningClassification;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.sys8.sqjzapp.R;
import com.sys8.sqjzapp.subModule.educationLearning.LearningClassificationBaseFragment;


public class CurrentPolicyFragment extends LearningClassificationBaseFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_learning_content_current_policy, container, false);
    }

    @Override
    public int setLayoutResourceID() {
        return R.layout.fragment_learning_content_current_policy;
    }

    @Override
    public void FilterMediaType(int MediaType) {

    }

}
