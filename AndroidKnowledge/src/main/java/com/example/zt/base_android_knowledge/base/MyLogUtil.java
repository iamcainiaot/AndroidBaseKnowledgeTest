package com.example.zt.base_android_knowledge.base;

import android.util.Log;

/**
 * @author taozhu5
 * @date 2019/7/3 17:26
 * @description 日志
 */
public final class MyLogUtil {
    private static final String TAG = "MyLog";

    public static void d(String s1, String s2) {
        Log.d(TAG + "：" + s1, s2);
    }
}