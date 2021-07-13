package com.example.zt.base_android_knowledge;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.view.View;

import com.example.zt.base_android_knowledge.android_activity_for_result.ActivityManagerActivity11;
import com.example.zt.base_android_knowledge.activity_launch_mode.LaunchModeFirstActivity;
import com.example.zt.base_android_knowledge.activity_life_cycle.LifeCycleActivity;
import com.example.zt.base_android_knowledge.android_fragment.FragmentOneActivity;
import com.example.zt.base_android_knowledge.android_service.TestServiceActivity;
import com.example.zt.android.knowledge.R;
import com.example.zt.base_android_knowledge.android_system.CallPhoneActivity;
import com.example.zt.base_android_knowledge.base.BaseMvpActivity;
import com.example.zt.base_android_knowledge.usb_client.UsbTestClientActivity;

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

    @Override
    public void initView() {
        // 去启动模式
        $(R.id.tv_go_2_launch_mode).setOnClickListener(this);
        // Activity生命周期
        $(R.id.tv_go_2_activity_life_cycle).setOnClickListener(this);
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

        WifiManager wifiMgr = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        WifiInfo connectionInfo = wifiMgr.getConnectionInfo();
        if (connectionInfo != null && connectionInfo.getNetworkId() != -1) {

        }

        ConnectivityManager connManager = (ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        assert connManager != null;
        NetworkInfo networkInfo = connManager.getActiveNetworkInfo();
        if (networkInfo.isConnected()) {
            if (networkInfo.getExtraInfo() != null) {

            }
        }
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