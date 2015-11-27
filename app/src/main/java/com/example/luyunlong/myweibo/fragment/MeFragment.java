package com.example.luyunlong.myweibo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.luyunlong.myweibo.BaseFragment;
import com.example.luyunlong.myweibo.R;

/**
 * Created by luyunlong on 15/11/26.
 */
public class MeFragment extends BaseFragment {

    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        View root = View.inflate(activity,R.layout.fragment_me,null);


        return root;
    }
}
