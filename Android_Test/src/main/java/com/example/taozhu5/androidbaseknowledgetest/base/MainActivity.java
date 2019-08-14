package com.example.taozhu5.androidbaseknowledgetest.base;

import android.content.Context;
import android.view.View;
import com.example.taozhu5.androidbaseknowledgetest.PieView;
import com.example.taozhu5.androidbaseknowledgetest.RecyclerViewActivity;
import com.example.taozhu5.androidbaseknowledgetest.activity_launch_mode.LaunchModeFirstActivity;
import com.example.taozhu5.androidbaseknowledgetest.R;
import com.example.taozhu5.androidbaseknowledgetest.activity_life_cycle.LifeCycleActivity;
import com.example.taozhu5.androidbaseknowledgetest.android_fragment.FragmentOneActivity;
import com.example.taozhu5.androidbaseknowledgetest.android_service.TestServiceActivity;

/**
 * @author taozhu5
 * @date 2019/7/8 09:26
 * @description 描述
 */
public class MainActivity extends BaseMvpActivity implements View.OnClickListener {
    private PieView mPieView;

    @Override
    public int layoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initData() {
        // do nothing
    }

    @Override
    public void initView() {
        // 去启动模式
        $(R.id.tv_go_2_launch_mode).setOnClickListener(this);
        // Activity生命周期
        $(R.id.tv_go_2_activity_life_cycle).setOnClickListener(this);
        // android Service
        $(R.id.tv_go_2_android_service).setOnClickListener(this);
        // android Fragment
        $(R.id.tv_go_2_android_fragment).setOnClickListener(this);
        // RecyclerView
        $(R.id.tv_go_2_recycler_view).setOnClickListener(this);
        // 饼图
        mPieView = $(R.id.pw_pie_view);
        mPieView.setData(10, 20, 30, 20);
    }

    @Override
    public void initEvent() {
        // do nothing
    }

    @Override
    public void onClick(View v) {
        Context context = MainActivity.this;
        switch (v.getId()) {
            case R.id.tv_go_2_launch_mode:
                // 启动模式
                LaunchModeFirstActivity.start(context);
                break;
            case R.id.tv_go_2_activity_life_cycle:
                // Activity生命周期
                LifeCycleActivity.start(context);
                break;
            case R.id.tv_go_2_android_service:
                // Service   startService  And  bindService
                TestServiceActivity.start(context);
                break;
            case R.id.tv_go_2_android_fragment:
                // Fragment Fragment Life Cycle
                FragmentOneActivity.start(context);
                break;
            case R.id.tv_go_2_recycler_view:
                // RecyclerView
                RecyclerViewActivity.start(context);
                break;
            default:
                break;
        }
    }
}