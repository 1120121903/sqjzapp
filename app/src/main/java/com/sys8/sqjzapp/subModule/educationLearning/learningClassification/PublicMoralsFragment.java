package com.sys8.sqjzapp.subModule.educationLearning.learningClassification;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sys8.sqjzapp.R;
import com.sys8.sqjzapp.subModule.educationLearning.LearningClassificationBaseFragment;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public class PublicMoralsFragment extends LearningClassificationBaseFragment {
    private Unbinder unbinder;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_learning_conent_public_morals, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public int setLayoutResourceID() {
        return R.layout.fragment_learning_conent_public_morals;
    }

    @Override
    public void FilterMediaType(int MediaType) {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

}
