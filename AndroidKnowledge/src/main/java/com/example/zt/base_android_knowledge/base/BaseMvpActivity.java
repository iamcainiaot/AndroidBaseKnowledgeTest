package com.example.zt.base_android_knowledge.base;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import androidx.annotation.IdRes;
import androidx.appcompat.app.AppCompatActivity;

import com.example.zt.util.BarUtils;

/**
 * @author taozhu5
 * @date 2019/7/3 17:02
 * @description 基类
 */
public abstract class BaseMvpActivity extends AppCompatActivity implements IBaseActivity {

    protected String TAG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (isNeedFullScreen()) {
            setFullScreen();
        } else {
            // 状态栏透明，布局会挤上去
            BarUtils.setStatusBarColor(this, Color.TRANSPARENT);
            BarUtils.setStatusBarLightMode(this, true);
        }

        super.onCreate(savedInstanceState);
        setContentView(layoutId());
        initData();
        initView();
        initEvent();
        TAG = getLocalClassName();
    }

    private boolean isNeedFullScreen() {
        return false;
    }

    private void setFullScreen() {
        WindowManager.LayoutParams layoutParams = getWindow().getAttributes();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            layoutParams.layoutInDisplayCutoutMode = WindowManager.LayoutParams.LAYOUT_IN_DISPLAY_CUTOUT_MODE_SHORT_EDGES;
            getWindow().setAttributes(layoutParams);
        }

        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_IMMERSIVE
                        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        // Hide the nav bar and status bar
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN);

    }

    public <T extends View> T $(@IdRes int id) {
        return (T) findViewById(id);
    }
}