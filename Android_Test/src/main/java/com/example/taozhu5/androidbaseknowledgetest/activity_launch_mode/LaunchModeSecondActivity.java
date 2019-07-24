package com.example.taozhu5.androidbaseknowledgetest.activity_launch_mode;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.example.taozhu5.androidbaseknowledgetest.R;
import com.example.taozhu5.androidbaseknowledgetest.base.BaseMvpActivity;
import com.example.taozhu5.androidbaseknowledgetest.base.MyLogUtil;

/**
 * @author taozhu5
 * @date 2019/7/3 16:55
 * @description 描述
 */
public class LaunchModeSecondActivity extends BaseMvpActivity {

    @Override
    protected void onStart() {
        super.onStart();
        MyLogUtil.d("SecondActivity", "2222 onStart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        MyLogUtil.d("SecondActivity", "2222 onDestroy");
    }

    /**
     * 启动此页面
     *
     * @param context 上下文
     */
    public static void start(Context context) {
        Intent intent = new Intent(context, LaunchModeSecondActivity.class);
        context.startActivity(intent);
    }

    @Override
    public int layoutId() {
        return R.layout.activity_second;
    }

    @Override
    public void initData() {

    }

    @Override
    public void initView() {
        $(R.id.tv_second).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LaunchModeThirdActivity.start(LaunchModeSecondActivity.this);
            }
        });
    }

    @Override
    public void initEvent() {

    }
}
