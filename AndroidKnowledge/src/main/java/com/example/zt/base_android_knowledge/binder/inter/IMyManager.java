package com.example.zt.base_android_knowledge.binder.inter;

import android.os.IInterface;
import android.os.RemoteException;

import com.example.zt.base_android_knowledge.binder.data.MyAidlBean;

/**
 * @author zhutao
 * @time 2022/2/14 14:12
 * @describe AIDL接口
 */
public interface IMyManager extends IInterface {

    /**
     * 修改数据
     *
     * @param myAidlBean bean类
     */
    void modifyData(MyAidlBean myAidlBean) throws RemoteException;

}