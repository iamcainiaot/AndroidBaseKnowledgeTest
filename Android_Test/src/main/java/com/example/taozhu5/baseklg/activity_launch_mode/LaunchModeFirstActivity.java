package com.example.taozhu5.baseklg.activity_launch_mode;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.example.taozhu5.baseklg.R;
import com.example.taozhu5.baseklg.base.BaseMvpActivity;
import com.example.taozhu5.baseklg.base.MyLogUtil;

/**
 * @author taozhu5
 * @date 2019/7/3 16:55
 * @description 描述
 */
public class LaunchModeFirstActivity extends BaseMvpActivity {

    /**
     * 启动此页面
     *
     * @param context 上下文
     */
    public static void start(Context context) {
        Intent intent = new Intent(context, LaunchModeFirstActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
        MyLogUtil.d("FirstActivity", "1111 onStart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        MyLogUtil.d("FirstActivity", "1111 onDestroy");
    }

    @Override
    public int layoutId() {
        return R.layout.activity_first;
    }

    @Override
    public void initData() {

    }

    @Override
    public void initView() {
        $(R.id.tv_first).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LaunchModeSecondActivity.start(LaunchModeFirstActivity.this);
            }
        });
    }

    @Override
    public void initEvent() {

    }
}
