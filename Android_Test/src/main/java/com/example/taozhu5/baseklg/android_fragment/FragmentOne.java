package com.example.taozhu5.baseklg.android_fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.taozhu5.baseklg.R;
import com.example.taozhu5.baseklg.base.MyLogUtil;

/**
 * @author taozhu5
 * @date 2019/7/16 10:17
 * @description 第一个fragment
 */
public class FragmentOne extends Fragment {

    private static String TAG = "FragmentOne";

    @Override
    public void onAttach(Context context) {
        MyLogUtil.d(TAG, "onAttach");
        super.onAttach(context);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        MyLogUtil.d(TAG, "onActivityCreated");
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onAttachFragment(Fragment childFragment) {
        MyLogUtil.d(TAG, "onAttachFragment");
        super.onAttachFragment(childFragment);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        MyLogUtil.d(TAG, "onCreateView");
        View view = inflater.inflate(R.layout.fragment_fragment_one, container, false);
        return view;
    }

    @Override
    public void onDestroyView() {
        MyLogUtil.d(TAG, "onDestroyView");
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        MyLogUtil.d(TAG, "onDestroy");
        super.onDestroy();
    }

    @Override
    public void onPause() {
        MyLogUtil.d(TAG, "onPause");
        super.onPause();
    }

    @Override
    public void onStop() {
        MyLogUtil.d(TAG, "onStop");
        super.onStop();
    }

    @Override
    public void onResume() {
        MyLogUtil.d(TAG, "onResume");
        super.onResume();
    }

    @Override
    public void onStart() {
        MyLogUtil.d(TAG, "onStart");
        super.onStart();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        MyLogUtil.d(TAG, "onCreate");
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        MyLogUtil.d(TAG, "onViewCreated");
        super.onViewCreated(view, savedInstanceState);
    }
}