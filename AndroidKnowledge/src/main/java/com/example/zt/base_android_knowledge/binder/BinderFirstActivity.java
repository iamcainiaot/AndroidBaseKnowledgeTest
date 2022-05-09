package com.example.zt.base_android_knowledge.binder;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;

import com.example.zt.android.knowledge.R;
import com.example.zt.base_android_knowledge.activity_launch_mode.LaunchModeFirstActivity;
import com.example.zt.base_android_knowledge.base.BaseMvpActivity;
import com.example.zt.base_android_knowledge.binder.data.MyAidlBean;
import com.example.zt.base_android_knowledge.binder.inter.IMyManager;
import com.example.zt.base_android_knowledge.binder.inter.MyAidlManagerStub;
import com.example.zt.util.CommonUtil;

/**
 * @author zhutao
 * @time 2022/2/14 10:40
 * @describe binder的第二个页面
 */
public class BinderFirstActivity extends BaseMvpActivity {
    /**
     * 启动此页面
     *
     * @param context 上下文
     */
    public static void start(Context context) {
        Intent intent = new Intent(context, BinderFirstActivity.class);
        context.startActivity(intent);
    }

    @Override
    public int layoutId() {
        return R.layout.activity_binder_first;
    }

    @Override
    public void initData() {

    }

    @Override
    public void initView() {
        int pid = android.os.Process.myPid();
        Log.i(TAG, "MyApplication is oncreate====" + "pid=" + pid);
        View v = $(R.id.tv_binder_first_2_second);
        v.setOnClickListener(v1 -> {
            BinderSecondActivity.start(this);
            Intent MyServiceIntent = new Intent(this, MyService.class);
            this.startService(MyServiceIntent);
            v.postDelayed(() -> {
                MyAidlBean myAidlBean = new MyAidlBean("zt", "24");
                try {
                    mService.modifyData(myAidlBean);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }, 300);
        });
    }

    @Override
    public void initEvent() {
        bindService(new Intent(this, MyService.class), mServiceConnection, 0);
    }

    private IMyManager mService;

    private ServiceConnection mServiceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.d(TAG, "开启连接 onServiceConnected name: " + name);
            mService = MyAidlManagerStub.asInterface(service);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.d(TAG, "断开连接 onServiceDisconnected name: " + name);
            mService = null;
        }
    };
}
