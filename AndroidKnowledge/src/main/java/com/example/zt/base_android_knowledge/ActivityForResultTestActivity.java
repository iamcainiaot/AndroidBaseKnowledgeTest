package com.example.zt.base_android_knowledge;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.zt.android.knowledge.R;
import com.example.zt.base_android_knowledge.base.BaseMvpActivity;

public class ActivityForResultTestActivity extends BaseMvpActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate zt1 ");

      //  startActivityForResult(new Intent(ActivityForResultTestActivity.this, ActivityForResultTestActivity.class), 2);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.d(TAG, "onNewIntent zt1 ");
    }

    @Override
    public int layoutId() {
        return R.layout.activity_for_result_test;
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
}
