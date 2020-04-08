package com.sys8.sqjzapp.subModule.educationLearning.learningClassification;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sys8.sqjzapp.R;
import com.sys8.sqjzapp.subModule.educationLearning.LearningClassificationBaseFragment;

public class LegalKnowledgeFragment extends LearningClassificationBaseFragment {
    View view;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_learning_content_legal_knowledge, container, false);
        return view;
    }

    @Override
    public int setLayoutResourceID() {
        return R.layout.fragment_learning_content_legal_knowledge;
    }

    @Override
    public void FilterMediaType(int MediaType) {

    }
}
