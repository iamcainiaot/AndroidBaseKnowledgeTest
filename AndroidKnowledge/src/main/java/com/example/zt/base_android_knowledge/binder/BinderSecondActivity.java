package com.example.zt.base_android_knowledge.binder;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.example.zt.android.knowledge.R;
import com.example.zt.base_android_knowledge.activity_launch_mode.LaunchModeFirstActivity;
import com.example.zt.base_android_knowledge.base.BaseMvpActivity;
import com.example.zt.util.CommonUtil;

/**
 * @author zhutao
 * @time 2022/2/14 10:40
 * @describe binder的第二个页面
 */
public class BinderSecondActivity extends BaseMvpActivity {
    /**
     * 启动此页面
     *
     * @param context 上下文
     */
    public static void start(Context context) {
        Intent intent = new Intent(context, BinderSecondActivity.class);
        context.startActivity(intent);
    }

    @Override
    public int layoutId() {
        return R.layout.activity_binder_second;
    }

    @Override
    public void initData() {

    }

    @Override
    public void initView() {
        int pid = android.os.Process.myPid();
        Log.i(TAG, "MyApplication is oncreate===="+"pid="+pid);
    }

    @Override
    public void initEvent() {

    }
}
