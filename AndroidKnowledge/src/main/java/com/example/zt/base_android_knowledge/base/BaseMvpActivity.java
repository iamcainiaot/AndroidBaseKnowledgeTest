package com.example.zt.base_android_knowledge.base;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.IdRes;
import androidx.appcompat.app.AppCompatActivity;

/**
 * @author taozhu5
 * @date 2019/7/3 17:02
 * @description 基类
 */
public abstract class BaseMvpActivity extends AppCompatActivity implements IBaseActivity {

    protected String TAG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layoutId());
        initData();
        initView();
        initEvent();
        TAG = getLocalClassName();
    }

    public <T extends View> T $(@IdRes int id) {
        return (T) findViewById(id);
    }
}