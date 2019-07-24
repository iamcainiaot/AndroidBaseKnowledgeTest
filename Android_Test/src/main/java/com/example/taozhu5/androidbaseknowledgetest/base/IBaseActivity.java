package com.example.taozhu5.androidbaseknowledgetest.base;

import android.os.Bundle;

/**
 * Created by zdj on 2017/10/07.
 */

public interface IBaseActivity {

    int layoutId();

    void initData();

    void initView();

    void initEvent();
}
