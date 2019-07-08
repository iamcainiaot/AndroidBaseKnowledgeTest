package com.example.taozhu5.androidbaseknowledgetest.base;

import android.view.View;
import com.example.taozhu5.androidbaseknowledgetest.activity_launch_mode.LaunchModeFirstActivity;
import com.example.taozhu5.androidbaseknowledgetest.R;
import com.example.taozhu5.androidbaseknowledgetest.activity_life_cycle.LifeCycleActivity;

/**
 * @author taozhu5
 * @date 2019/7/8 09:26
 * @description 描述
 */
public class MainActivity extends BaseMvpActivity implements View.OnClickListener {
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
    }

    @Override
    public void initEvent() {
        // do nothing
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_go_2_launch_mode:
                // 启动模式
                LaunchModeFirstActivity.start(MainActivity.this);
                break;
            case R.id.tv_go_2_activity_life_cycle:
                LifeCycleActivity.start(MainActivity.this);
                break;
            default:
                break;
        }
    }
}
