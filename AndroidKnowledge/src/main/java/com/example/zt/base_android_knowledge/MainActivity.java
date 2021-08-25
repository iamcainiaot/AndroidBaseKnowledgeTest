package com.example.zt.base_android_knowledge;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.example.zt.base_android_knowledge.android_activity_for_result.ActivityManagerActivity11;
import com.example.zt.base_android_knowledge.activity_launch_mode.LaunchModeFirstActivity;
import com.example.zt.base_android_knowledge.activity_life_cycle.LifeCycleActivity;
import com.example.zt.base_android_knowledge.android_fragment.FragmentOneActivity;
import com.example.zt.base_android_knowledge.android_service.TestServiceActivity;
import com.example.zt.android.knowledge.R;
import com.example.zt.base_android_knowledge.android_system.CallPhoneActivity;
import com.example.zt.base_android_knowledge.base.BaseMvpActivity;
import com.example.zt.base_android_knowledge.usb_client.UsbTestClientActivity;

import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * @author taozhu5
 * @date 2019/7/8 09:26
 * @description 描述
 */
public class MainActivity extends BaseMvpActivity implements View.OnClickListener {
    private PieView mPieView;

    @Override
    public int layoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initData() {
        // do nothing
    }

    @SuppressLint("ResourceType")
    @Override
    public void initView() {
        // 去启动模式
        $(R.id.tv_go_2_launch_mode).setOnClickListener(this);
        // Activity生命周期
        TextView textView = $(R.id.tv_go_2_activity_life_cycle);
        textView.setOnClickListener(this);

        TextView tvTest = $(R.id.tv_express_hint);
        tvTest.setVisibility(View.VISIBLE);
        tvTest.setText("你好你");
        tvTest.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        tvTest.setSingleLine(true);
        tvTest.setSelected(true);
//        tvTest.setFocusable(true);
//        tvTest.setFocusableInTouchMode(true);

        // android Service
        $(R.id.tv_go_2_android_service).setOnClickListener(this);
        // android Fragment
        $(R.id.tv_go_2_android_fragment).setOnClickListener(this);
        // RecyclerView
        $(R.id.tv_go_2_recycler_view).setOnClickListener(this);
        // 饼图
        mPieView = $(R.id.pw_pie_view);
        mPieView.setData(10, 20, 30, 20);
        // ActivityForResult
        $(R.id.tv_go_2_activity_activity_manager).setOnClickListener(this);
        $(R.id.tv_go_2_usb_test_view).setOnClickListener(this);
        $(R.id.tv_go_2_call_phone_activity).setOnClickListener(this);

        // WifiManager wifiMgr = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        // WifiInfo connectionInfo = wifiMgr.getConnectionInfo();
        // if (connectionInfo != null && connectionInfo.getNetworkId() != -1) {
//
        // }
//
        // ConnectivityManager connManager = (ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        // assert connManager != null;
        // NetworkInfo networkInfo = connManager.getActiveNetworkInfo();
        // if (networkInfo.isConnected()) {
        //     if (networkInfo.getExtraInfo() != null) {
//
        //     }
        // }

        getSimCard();

        // go2Call();
    }

    private void getSimCard() {
        final SubscriptionManager subscriptionManager;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP_MR1) {
            subscriptionManager = SubscriptionManager.from(this);
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return;
            }
            final ArrayList activeSubscriptionInfoList = (ArrayList) subscriptionManager.getActiveSubscriptionInfoList();
            if (activeSubscriptionInfoList == null || activeSubscriptionInfoList.isEmpty()) {
                return;
            }
        }
        TelephonyManager telephonyManager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        // 获取卡槽数量
        int simsLotCount = 0;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            simsLotCount = telephonyManager.getPhoneCount();
        }
        Log.d(TAG, "卡槽数量为：" + simsLotCount);


    }

    private void go2Call() {
        getIMEI(this);
    }


    @SuppressLint("HardwareIds")
    public static String getIMEI(Context context) {
        TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            return tm.getImei();
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            try {
                Class<?> clazz = tm.getClass();
                Method getImeiMethod = clazz.getDeclaredMethod("getImei", int.class);
                getImeiMethod.setAccessible(true);
                String imei = (String) getImeiMethod.invoke(tm, 0);
                if (imei != null && imei.length() == 15) {
                    Toast.makeText(context, imei, Toast.LENGTH_SHORT).show();
                    return imei;
                }
            } catch (Exception e) {
                Log.e("PhoneUtils", "getIMEI: ", e);
            }
        }
        String imei = tm.getDeviceId();
        if (imei != null && imei.length() == 15) {
            Toast.makeText(context, imei, Toast.LENGTH_SHORT).show();
            return imei;
        }
        return "";
    }

    @Override
    public void initEvent() {
        // do nothing
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        Context context = MainActivity.this;
        switch (v.getId()) {
            case R.id.tv_go_2_launch_mode:
                // 启动模式
                LaunchModeFirstActivity.start(context);
                break;
            case R.id.tv_go_2_activity_life_cycle:
                // Activity生命周期
                LifeCycleActivity.start(context);
                break;
            case R.id.tv_go_2_android_service:
                // Service   startService  And  bindService
                TestServiceActivity.start(context);
                break;
            case R.id.tv_go_2_android_fragment:
                // Fragment Fragment Life Cycle
                FragmentOneActivity.start(context);
                break;
            case R.id.tv_go_2_recycler_view:
                // RecyclerView
                RecyclerViewActivity.start(context);
                break;
            case R.id.tv_go_2_activity_activity_manager:
                // ActivityForResult
                ActivityManagerActivity11.start(context);
                break;
            case R.id.tv_go_2_usb_test_view:
                UsbTestClientActivity.StateParam.start(context);
                break;
            case R.id.tv_go_2_call_phone_activity:
                CallPhoneActivity.start(context);
            default:
                break;
        }
    }
}