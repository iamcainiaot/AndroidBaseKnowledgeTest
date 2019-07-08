package com.example.taozhu5.androidbaseknowledgetest.LaunchMode;

import android.content.Context;
import android.content.Intent;
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
public class ThirdActivity extends BaseMvpActivity {

    @Override
    protected void onStart() {
        super.onStart();
        MyLogUtil.d("ThirdActivity", "3333 onStart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        MyLogUtil.d("ThirdActivity", "3333 onDestroy");
    }


    public static void start(Context context) {
        Intent intent = new Intent(context, ThirdActivity.class);
        context.startActivity(intent);
    }

    @Override
    public int layoutId() {
        return R.layout.activity_third;
    }

    @Override
    public void initData() {
        // do nothing
    }

    @Override
    public void initView() {
        $(R.id.tv_third).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // finish();
                SecondActivity.start(ThirdActivity.this);
            }
        });
    }

    @Override
    public void initEvent() {
        // do nothing
    }
}