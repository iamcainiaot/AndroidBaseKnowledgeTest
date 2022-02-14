package com.example.zt.base_android_knowledge.android_service;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.IBinder;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.RequiresApi;

import com.example.zt.android.knowledge.R;
import com.example.zt.base_android_knowledge.base.BaseMvpActivity;
import com.example.zt.base_android_knowledge.base.MyLogUtil;
import com.example.zt.util.Bom.BomKt;

/**
 * @author taozhu5
 * @date 2019/7/9 09:25
 * @description 服务测试类
 */
public class TestServiceActivity extends BaseMvpActivity {

    private static final String TAG = "TestServiceActivity";

    /**
     * 启动此页面
     *
     * @param context 上下文
     */
    public static void start(Context context) {
        Intent intent = new Intent(context, TestServiceActivity.class);
        context.startActivity(intent);
    }

    @Override
    public int layoutId() {
        return R.layout.activity_test_service;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void initData() {
        TextView textView = findViewById(R.id.tv_stop);

        BomKt.setHighlightTextV2(textView, "最高可卖22元", "22", R.color.colorAccent, false);
    }

    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            MyLogUtil.d(TAG, "onServiceConnected，service连接了~");
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            MyLogUtil.d(TAG, "onServiceDisconnected，service断开连接了~");
        }
    };

    @Override
    public void initView() {
        // 显式调用
        final Intent intent1 = new Intent(TestServiceActivity.this, TestService.class);

        // 隐式调用
        final Intent intent2 = new Intent();
        intent2.setAction("android.intent.action.TEST_SERVICE");
        intent2.setPackage(getPackageName());

        $(R.id.tv_start).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startService(intent1);
                //   bindService(intent1, serviceConnection, Context.BIND_ADJUST_WITH_ACTIVITY);
            }
        });
        $(R.id.tv_stop).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopService(intent1);
            }
        });
    }

    @Override
    public void initEvent() {

    }
}