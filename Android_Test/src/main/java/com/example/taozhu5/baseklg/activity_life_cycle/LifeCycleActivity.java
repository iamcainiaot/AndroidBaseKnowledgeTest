package com.example.taozhu5.baseklg.activity_life_cycle;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.example.taozhu5.baseklg.R;
import com.example.taozhu5.baseklg.base.BaseMvpActivity;
import com.example.taozhu5.baseklg.base.MyLogUtil;

/**
 * @author taozhu5
 * @date 2019/7/8 9:22
 * @description 生命周期
 */
public class LifeCycleActivity extends BaseMvpActivity {
    public static String TAG = "LifeCycleActivity";

    /**
     * 启动此页面
     *
     * @param context 上下文
     */
    public static void start(Context context) {
        Intent intent = new Intent(context, LifeCycleActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyLogUtil.d(TAG, "onCreate");
        setContentView(layoutId());
    }

    @Override
    protected void onStart() {
        super.onStart();
        MyLogUtil.d(TAG, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        MyLogUtil.d(TAG, "onResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        MyLogUtil.d(TAG, "onRestart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        MyLogUtil.d(TAG, "onStop");
    }

    @Override
    protected void onPause() {
        super.onPause();
        MyLogUtil.d(TAG, "onPause");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        MyLogUtil.d(TAG, "onDestroy");
    }

    @Override
    public int layoutId() {
        return R.layout.activity_life_cycle;
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