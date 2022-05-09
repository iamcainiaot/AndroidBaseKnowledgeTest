package com.example.zt.base_android_knowledge.binder.inter;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.zt.base_android_knowledge.binder.data.MyAidlBean;

public class MyAidlManagerStub extends Binder implements IMyManager {
    public static final String TAG = "MyAidlManagerStub";
    public static final String DESCRIPTOR = "com.example.zt.base_android_knowledge.binder.inter.MyAidlManagerStub";

    public static IMyManager asInterface(IBinder binder) {
        if (binder == null) {
            return null;
        }
        // 通过DESCRIPTOR查询本地binder，如果存在则说明调用方和service在同一进程间，直接本地调用
        IInterface iin = binder.queryLocalInterface(DESCRIPTOR);
        if (iin instanceof IMyManager) {
            return (IMyManager) iin;
        }
        // 本地没有，返回一个远程代理对象
        return new MyAidlProxy(binder);
    }

    @Override
    public void modifyData(MyAidlBean myAidlBean) throws RemoteException {
        Log.d(TAG, "modifyData ");
    }

    @Override
    public IBinder asBinder() {
        return this;
    }

    @Override
    protected boolean onTransact(int code, @NonNull Parcel data, @Nullable Parcel reply, int flags) throws RemoteException {
        switch (code) {
            case 1:
                // data.enforceInterface(DESCRIPTOR);
                MyAidlBean myAidlBean = MyAidlBean.CREATOR.createFromParcel(data);
                reply.writeString("i am result");
                Log.d(TAG, " case 1  data : " + myAidlBean + " reply : " + reply);
                return true;
            default:
                break;
        }

        return super.onTransact(code, data, reply, flags);
    }
}