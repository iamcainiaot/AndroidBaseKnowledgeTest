package com.example.taozhu5.baseklg.design_patterns.builder;

/**
 * @author taozhu5
 * @date 2019/8/21 10:59
 * @description 电脑类
 */
public class Computer {
    private String mCpu;
    private String mMemory;
    private String mHd;

    public void setmCpu(String mCpu) {
        this.mCpu = mCpu;
    }

    public void setmMemory(String mMemory) {
        this.mMemory = mMemory;
    }

    public void setmHd(String mHd) {
        this.mHd = mHd;
    }
}