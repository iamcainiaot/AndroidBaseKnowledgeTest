package com.example.zt.base_android_knowledge.android_activity_for_result;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import androidx.annotation.Nullable;

import com.example.zt.android.knowledge.R;
import com.example.zt.base_android_knowledge.base.BaseMvpActivity;
import com.example.zt.base_android_knowledge.base.MyLogUtil;

/**
 * @author taozhu5
 * @date 2019/12/31 08:55
 * @description setActivityForResult的使用1
 */
public class ActivityManagerActivity11 extends BaseMvpActivity implements View.OnClickListener {

    /**
     * 启动此页面
     *
     * @param context 上下文
     */
    public static void start(Context context) {
        Intent intent = new Intent(context, ActivityManagerActivity11.class);
        context.startActivity(intent);
    }

    public static final int GO_TO_SECOND_REQUEST_CODE = 0x001;

    @Override
    public int layoutId() {
        return R.layout.activity_activity_manager11;
    }

    @Override
    public void initData() {

    }

    @Override
    public void initView() {
        $(R.id.bt_first_page).setOnClickListener(this);
    }

    @Override
    public void initEvent() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_first_page:
                // 点击去第二个页面
                clickButton();
            default:
                break;
        }
    }

    /**
     * 点击去第二个页面
     */
    private void clickButton() {
        ActivityManagerActivity22.startActivityForResult(this, GO_TO_SECOND_REQUEST_CODE);
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode != BaseMvpActivity.RESULT_OK) {
            return;
        }
        if (data == null) {
            return;
        }
        String s = data.getStringExtra("EXTRA");
        if (requestCode == GO_TO_SECOND_REQUEST_CODE) {
            MyLogUtil.d(TAG, "-- onActivityResult--" + s);
        }
    }
}