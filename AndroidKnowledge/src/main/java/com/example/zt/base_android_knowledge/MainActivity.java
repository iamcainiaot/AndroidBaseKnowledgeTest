package com.example.zt.base_android_knowledge;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.ContentObserver;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.provider.MediaStore;
import android.telephony.TelephonyManager;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.example.zt.android.knowledge.R;
import com.example.zt.base_android_knowledge.activity_launch_mode.LaunchModeFirstActivity;
import com.example.zt.base_android_knowledge.activity_life_cycle.LifeCycleActivity;
import com.example.zt.base_android_knowledge.android_activity_for_result.ActivityManagerActivity11;
import com.example.zt.base_android_knowledge.android_fragment.FragmentOneActivity;
import com.example.zt.base_android_knowledge.android_service.TestServiceActivity;
import com.example.zt.base_android_knowledge.android_system.CallPhoneActivity;
import com.example.zt.base_android_knowledge.base.BaseMvpActivity;
import com.example.zt.base_android_knowledge.binder.BinderFirstActivity;
import com.example.zt.base_android_knowledge.diy_view.PieView;
import com.example.zt.base_android_knowledge.file.FileDirActivity;
import com.example.zt.base_android_knowledge.scroll_activity.RecyclerViewActivity;
import com.example.zt.base_android_knowledge.scroll_activity.ScrollActivity;
import com.example.zt.base_android_knowledge.usb_client.UsbTestClientActivity;
import com.google.android.flexbox.FlexboxLayout;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

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
        $(R.id.tv_go_2_binder_test).setOnClickListener(this);
        $(R.id.tv_go_2_scroll_activity).setOnClickListener(this);
        $(R.id.tv_go_2_file_activity).setOnClickListener(this);
        Log.d("MainAp222p", "---------");
        System.out.println("MainAp222p ------");
    }

    @Override
    protected void onNewIntent(Intent intent) {
        Log.d(TAG, "  onNewIntent  ");
        super.onNewIntent(intent);
    }

    /**
     * 返回日期字符串
     *
     * @param date 日期
     * @return 解析后的字符串格式
     */
    public static String getStringWithDate(Date date) {
        String format;
        if (date == null) {
            date = getCurrentDate();
        }
        format = "yyyy.MM.dd";
        return new SimpleDateFormat(format, locale).format(date);
    }

    private static final Locale locale = Locale.getDefault();

    /**
     * 获取当前日期
     *
     * @return
     */
    public static Date getCurrentDate() {
        return new Date();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Toast.makeText(this, "zzzz 1", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onActivityResult zzzz 11 ");
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

    /**
     * 内部存储器内容观察者
     */
    private MediaContentObserver mInternalObserver;

    /**
     * 外部存储器内容观察者
     */
    private MediaContentObserver mExternalObserver;
    /**
     * 运行在 UI 线程的 Handler, 用于运行监听器回调
     */
    private final Handler mUiHandler = new Handler(Looper.getMainLooper());

    @Override
    public void initEvent() {

        // 创建内容观察者
        mInternalObserver = new MediaContentObserver(MediaStore.Images.Media.INTERNAL_CONTENT_URI, mUiHandler);
        mExternalObserver = new MediaContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, mUiHandler);

        // 注册内容观察者
        getApplication().getContentResolver().registerContentObserver(
                MediaStore.Images.Media.INTERNAL_CONTENT_URI,
                notifyForDescendants(),
                mInternalObserver
        );
        getApplication().getContentResolver().registerContentObserver(
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                notifyForDescendants(),
                mExternalObserver
        );
    }

    /**
     * android Q ContentObserver 不回调 onChange
     * 我们在注册 ContentObserver 时，会传两个重要的参数，Uri 和 notifyForDescendants，
     * 其中 Uri 就是系统发生变化的文件对应的 Uri，比如想监听系统图片变化，就使用 MediaStore.Images.Media.EXTERNAL_CONTENT_URI，
     * 第二个参数比较重要，大概意思就是是否要精确匹配 Uri，如果 false 代表要精确匹配，true 就不要
     *
     * @return
     */
    private boolean notifyForDescendants() {
        return Build.VERSION.SDK_INT > Build.VERSION_CODES.P;
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
                break;
            case R.id.tv_go_2_binder_test:
                BinderFirstActivity.start(context);
                break;
            case R.id.tv_go_2_scroll_activity:
                ScrollActivity.start(context);
                break;
            case R.id.tv_go_2_file_activity:
                // FileDirActivity.start(context);

                Intent intent = new Intent(this, FileDirActivity.class);
                startActivityForResult(intent, 10086);
                break;
            default:
                break;
        }
    }

    /**
     * 媒体内容观察者(观察媒体数据库的改变)
     */
    private class MediaContentObserver extends ContentObserver {

        private Uri mContentUri;

        public MediaContentObserver(Uri contentUri, Handler handler) {
            super(handler);
            mContentUri = contentUri;
        }

        @Override
        public void onChange(boolean selfChange) {
            super.onChange(selfChange);
            Log.d(TAG, "selfChange : " + selfChange);
        }

        @Override
        public void onChange(boolean selfChange, Uri uri) {
            super.onChange(selfChange, uri);
            Log.d(TAG, "selfChange : " + selfChange + "   uri : " + uri);
        }
    }

}