package com.example.taozhu5.androidbaseknowledgetest.LaunchMode;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import com.example.taozhu5.androidbaseknowledgetest.R;
import com.example.taozhu5.androidbaseknowledgetest.base.BaseMvpActivity;
import com.example.taozhu5.androidbaseknowledgetest.base.MyLogUtil;

/**
 * @author taozhu5
 * @date 2019/7/3 16:55
 * @description 描述
 */
public class FirstActivity extends BaseMvpActivity {

    public static void start(Context context) {
        Intent intent = new Intent(context, FirstActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
        MyLogUtil.d("FirstActivity", "1111 onStart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        MyLogUtil.d("FirstActivity", "1111 onDestroy");
    }

    @Override
    public int layoutId() {
        return R.layout.activity_first;
    }

    @Override
    public void initData() {

    }

    @Override
    public void initView() {
        $(R.id.tv_first).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SecondActivity.start(FirstActivity.this);
            }
        });
    }

    @Override
    public void initEvent() {

    }
}
