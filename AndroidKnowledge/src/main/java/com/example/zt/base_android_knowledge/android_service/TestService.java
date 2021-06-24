package com.example.zt.base_android_knowledge.android_service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import com.example.zt.base_android_knowledge.base.MyLogUtil;

/**
 * @author taozhu5
 * @date 2019/7/9 08:49
 * @description Android Service类
 */
public class TestService extends Service {
    private static final String TAG = "TestService";
    private IBinder myBinder;

    public class MyBinder extends Binder {
        TestService getService() {
            return TestService.this;
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();
        MyLogUtil.d(TAG, "onCreate");
        myBinder = new MyBinder();
    }

    /**
     * 通过bindService的方式启动
     */
    @Override
    public IBinder onBind(Intent intent) {
        MyLogUtil.d(TAG, "onBind");
        return myBinder;
    }

    /**
     * 通过startService的方式启动
     */
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        MyLogUtil.d(TAG, "onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }

    /*        onBind启动方式特有方法               */

    @Override
    public boolean onUnbind(Intent intent) {
        MyLogUtil.d(TAG, "onUnbind");
        return super.onUnbind(intent);
    }

    @Override
    public void onRebind(Intent intent) {
        MyLogUtil.d(TAG, "onRebind");
        super.onRebind(intent);
    }

    /*        onBind启动方式特有方法               */

    @Override
    public void onDestroy() {
        MyLogUtil.d(TAG, "onDestroy");
        super.onDestroy();
    }
}