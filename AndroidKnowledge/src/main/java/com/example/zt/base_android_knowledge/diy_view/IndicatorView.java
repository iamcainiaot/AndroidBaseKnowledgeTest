package com.example.zt.base_android_knowledge.diy_view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import java.util.zip.Inflater;

/**
 * @author 祝涛
 * @time 2021/6/25 17:19
 * @describe 指示器view eg：14/16
 */
public class IndicatorView extends View {
    public IndicatorView(Context context) {
        super(context);
    }

    public IndicatorView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public IndicatorView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void init(Context context, AttributeSet attrs) {
//        TypedArray ta = inflate(context,);
    }

}