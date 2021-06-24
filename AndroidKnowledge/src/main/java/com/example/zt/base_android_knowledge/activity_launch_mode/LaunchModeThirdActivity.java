package com.example.zt.base_android_knowledge.activity_launch_mode;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.example.zt.android.knowledge.R;
import com.example.zt.base_android_knowledge.base.BaseMvpActivity;
import com.example.zt.base_android_knowledge.base.MyLogUtil;

/**
 * @author taozhu5
 * @date 2019/7/3 16:55
 * @description 描述
 */
public class LaunchModeThirdActivity extends BaseMvpActivity {

    @Override
    protected void onStart() {
        super.onStart();
        MyLogUtil.d("ThirdActivity", "3333 onStart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        MyLogUtil.d("ThirdActivity", "3333 onDestroy");
    }

    /**
     * 启动此页面
     *
     * @param context 上下文
     */
    public static void start(Context context) {
        Intent intent = new Intent(context, LaunchModeThirdActivity.class);
        context.startActivity(intent);
    }

    @Override
    public int layoutId() {
        return R.layout.activity_third;
    }

    @Override
    public void initData() {
        // do nothing
    }

    @Override
    public void initView() {
        $(R.id.tv_third).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // finish();
                LaunchModeSecondActivity.start(LaunchModeThirdActivity.this);
            }
        });
    }

    @Override
    public void initEvent() {
        // do nothing
    }
}