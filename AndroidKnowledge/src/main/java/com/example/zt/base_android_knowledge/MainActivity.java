package com.example.zt.base_android_knowledge;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import com.example.zt.android.knowledge.R;
import com.example.zt.base_android_knowledge.activity_launch_mode.LaunchModeFirstActivity;
import com.example.zt.base_android_knowledge.activity_life_cycle.LifeCycleActivity;
import com.example.zt.base_android_knowledge.android_activity_for_result.ActivityManagerActivity11;
import com.example.zt.base_android_knowledge.android_fragment.FragmentOneActivity;
import com.example.zt.base_android_knowledge.android_service.TestServiceActivity;
import com.example.zt.base_android_knowledge.android_system.CallPhoneActivity;
import com.example.zt.base_android_knowledge.base.BaseMvpActivity;
import com.example.zt.base_android_knowledge.usb_client.UsbTestClientActivity;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

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

        tvTest.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
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

        String url = "m.zhuanzhuan.com/u/zzfinance/zzttt";

        int index = url.indexOf("/");
        String host = url.substring(0, index);
        String path = url.substring(index);

        List<String> list = new ArrayList<>();
        int i = -1;
        while (true) {
            path = path.substring(1);
            int indexTemp = path.indexOf("/");
            if (indexTemp == -1) {
                list.add(i == -1 ? (host + "/" + path) : (list.get(i) + "/" + path));
                break;
            }
            String tempStr = i == -1 ? (host + "/" + path.substring(0, indexTemp + 1)) : (list.get(i) + "/" + path.substring(0, indexTemp + 1));
            if (tempStr.endsWith("/")) {
                tempStr = tempStr.substring(0, tempStr.length() - 1);
            }
            list.add(tempStr);
            path = path.substring(indexTemp);
            i++;
        }
        String sss = "";
        for (String listStr : list) {
            if (listStr.endsWith("/")) {
                listStr = listStr.substring(0, listStr.length() - 1);
            }
        }

        Solution solution = new Solution();
        int[] arr = new int[]{
                1, 3, 2, 5, 25, 24, 5
        };
        solution.maxArea(arr);


        String uuu = "m.zhuanzhuan.com/zlj/zlj_tiny_mall_detail/";
        String[] strings = uuu.split("\\.");
        String s = "";

        Intent intent = new Intent(MainActivity.this, ActivityForResultTestActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        ActivityResultLauncher activityResultLauncher = registerForActivityResult(new ActivityResultContract<Object, Object>() {
            @NonNull
            @Override
            public Intent createIntent(@NonNull Context context, Object input) {
                return intent;
            }

            @Override
            public Object parseResult(int resultCode, @Nullable Intent intent) {
                return null;
            }
        }, new ActivityResultCallback<Object>() {
            @Override
            public void onActivityResult(Object result) {
                Log.d(TAG, "onActivityResult zt22");
            }
        });
        activityResultLauncher.launch(activityResultLauncher.getContract());



    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d(TAG, "onActivityResult zt1 ");
    }

    class Solution {
        public int maxArea(int[] height) {
            int area = 0;
            int left = 0;

            int right = height.length - 1;

            while (left < right) { // 1, 3, 2, 5, 25, 24, 5
                area = Math.max(area, Math.min(height[left], height[right]) * (right - left));
                if (height[left] <= height[right]) {
                    left++;
                } else if (height[right] < height[left]) {
                    right--;
                } else {
                    left++;
                }
            }
            return area;
        }
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