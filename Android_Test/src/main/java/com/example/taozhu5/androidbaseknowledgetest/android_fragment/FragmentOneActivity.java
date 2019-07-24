package com.example.taozhu5.androidbaseknowledgetest.android_fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import com.example.taozhu5.androidbaseknowledgetest.R;
import com.example.taozhu5.androidbaseknowledgetest.base.BaseMvpActivity;
import com.example.taozhu5.androidbaseknowledgetest.base.MyLogUtil;

/**
 * @author taozhu5
 * @date 2019/7/16 08:59
 * @description Fragment生命周期Activity
 */
public class FragmentOneActivity extends BaseMvpActivity {
    private static String TAG = "FragmentOneActivity";

    /**
     * 启动此页面
     *
     * @param context 上下文
     */
    public static void start(Context context) {
        Intent intent = new Intent(context, FragmentOneActivity.class);
        context.startActivity(intent);
    }

    @Override
    public int layoutId() {
        MyLogUtil.d(TAG, "onCreate");
        return R.layout.activity_fragment_one;
    }

    @Override
    public void initData() {

    }

    @Override
    public void initView() {

    }

    @Override
    public void initEvent() {

    }


    @Override
    protected void onStart() {
        MyLogUtil.d(TAG, "onStart");
        super.onStart();
    }

    @Override
    protected void onStop() {
        MyLogUtil.d(TAG, "onStop");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        MyLogUtil.d(TAG, "onDestroy");
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        MyLogUtil.d(TAG, "onPause");
        super.onPause();
    }

    @Override
    protected void onResume() {
        MyLogUtil.d(TAG, "onResume");
        super.onResume();
    }

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        MyLogUtil.d(TAG, "onCreate");
        super.onCreate(savedInstanceState, persistentState);
    }

    @Override
    protected void onRestart() {
        MyLogUtil.d(TAG, "onRestart");
        super.onRestart();
    }
}