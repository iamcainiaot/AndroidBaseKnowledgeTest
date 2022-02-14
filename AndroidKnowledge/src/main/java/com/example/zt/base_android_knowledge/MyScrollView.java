package com.example.zt.base_android_knowledge;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;

import java.util.logging.Logger;

public class MyScrollView extends NestedScrollView {
    public static final String TAG = "MyScrollView";
    private View mImageView1;
    private View mImageView2;

    private View mFiltrateConditionView;
    private View mQuickSelectView;

    public MyScrollView(@NonNull Context context) {
        this(context, null);
    }

    public MyScrollView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyScrollView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mImageView1 = findViewWithTag("img_1");
        mImageView2 = findViewWithTag("img_2");
        Log.d(TAG, "mImageView1  " + mImageView1);
        Log.d(TAG, "mImageView2  " + mImageView2);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return super.onTouchEvent(ev);
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        Log.d(TAG, "l : " + l + "  t : " + t + "  oldl : " + oldl + "  oldt : " + oldt);
        super.onScrollChanged(l, t, oldl, oldt);
    }

    @Override
    public void onNestedScroll(@NonNull View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed) {
        super.onNestedScroll(target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed);
    }

    @Override
    public boolean onNestedFling(@NonNull View target, float velocityX, float velocityY, boolean consumed) {
        return super.onNestedFling(target, velocityX, velocityY, consumed);
    }
}
