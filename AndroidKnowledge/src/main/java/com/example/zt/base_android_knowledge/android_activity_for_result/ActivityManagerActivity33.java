package com.example.zt.base_android_knowledge.android_activity_for_result;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import com.example.zt.android.knowledge.R;
import com.example.zt.base_android_knowledge.base.BaseMvpActivity;

/**
 * @author taozhu5
 * @date 2019/12/31 08:55
 * @description setActivityForResult的使用2
 */
public class ActivityManagerActivity33 extends BaseMvpActivity implements View.OnClickListener {

    /**
     * 启动此页面
     *
     * @param activity Activity
     */
    public static void startActivityForResult(Activity activity, int requestCode) {
        Intent intent = new Intent(activity, ActivityManagerActivity33.class);
        activity.startActivityForResult(intent, requestCode);
    }

    public static final int GO_TO_SECOND_REQUEST_CODE = 0x001;

    @Override
    public int layoutId() {
        return R.layout.activity_activity_manager33;
    }

    @Override
    public void initData() {

    }

    @Override
    public void initView() {
        $(R.id.bt_second_page).setOnClickListener(this);
    }

    @Override
    public void initEvent() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_second_page:
                // 点击去第三个页面
                clickButton();
            default:
                break;
        }
    }

    /**
     * 点击去第二个页面
     */
    private void clickButton() {
        putData();
        finish();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        putData();
    }

    private void putData() {
        Intent intent = new Intent();
        intent.putExtra("EXTRA", TAG);
        setResult(Activity.RESULT_OK, intent);
    }
}