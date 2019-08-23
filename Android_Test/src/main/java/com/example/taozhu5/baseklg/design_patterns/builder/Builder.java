package com.example.taozhu5.baseklg.design_patterns.builder;

/**
 * @author taozhu5
 * @date 2019/8/21 11:01
 * @description 描述
 */
public abstract class Builder {
    public abstract void buildCPU(String cpu);

    public abstract void buildMemory(String memory);

    public abstract void buildHd(String hd);

    public abstract Computer create();
}