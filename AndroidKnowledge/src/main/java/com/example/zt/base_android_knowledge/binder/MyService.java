package com.example.zt.base_android_knowledge.binder;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.zt.base_android_knowledge.binder.data.MyAidlBean;
import com.example.zt.base_android_knowledge.binder.inter.MyAidlManagerStub;

/**
 * @author zhutao
 * @time 2022/2/14 11:48
 * @describe Binder Service
 */
public class MyService extends Service {

    private static final String TAG = "qmsggg";

    @Override
    public void onCreate() {
        Log.i(TAG, "MyService is oncreate");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG, "MyProcessActivity is created: ");
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        Log.i(TAG, "ODestroy");
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }

    private Binder binder = new MyAidlManagerStub() {
        @Override
        public void modifyData(MyAidlBean myAidlBean) throws RemoteException {
            Log.d(TAG, " MyService " + myAidlBean);
            super.modifyData(myAidlBean);
        }
    };

}