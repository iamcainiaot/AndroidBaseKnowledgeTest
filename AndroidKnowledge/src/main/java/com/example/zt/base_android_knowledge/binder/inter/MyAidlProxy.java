package com.example.zt.base_android_knowledge.binder.inter;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import android.util.Log;

import com.example.zt.base_android_knowledge.binder.data.MyAidlBean;

public class MyAidlProxy implements IMyManager {
    private static final String TAG = "MyAidlProxy";
    private IBinder mIBinder;
    public static final String DESCRIPTOR = "com.example.zt.base_android_knowledge.binder.MyProxy";

    public MyAidlProxy(IBinder mIBinder) {
        this.mIBinder = mIBinder;
    }

    public String getDescriptor() {
        return DESCRIPTOR;
    }

    @Override
    public void modifyData(MyAidlBean myAidlBean) throws RemoteException {
        Log.d(TAG, "modifyData");
        Parcel parcel = Parcel.obtain();
        parcel.writeString(myAidlBean.getName());
        parcel.writeString(myAidlBean.getAge());
        mIBinder.transact(1, parcel, parcel, 0);
    }

    @Override
    public IBinder asBinder() {
        return mIBinder;
    }
}
