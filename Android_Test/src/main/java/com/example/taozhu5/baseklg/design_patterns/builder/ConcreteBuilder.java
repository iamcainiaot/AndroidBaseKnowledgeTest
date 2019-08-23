package com.example.taozhu5.baseklg.design_patterns.builder;

/**
 * @author taozhu5
 * @date 2019/8/21 11:03
 * @description 描述
 */
public class ConcreteBuilder extends Builder {
    /**
     * 创建产品实例
     */
    private Computer mComputer = new Computer();

    @Override
    public void buildCPU(String cpu) {
        mComputer.setmCpu(cpu);
    }

    @Override
    public void buildMemory(String memory) {
        mComputer.setmMemory(memory);
    }

    @Override
    public void buildHd(String hd) {
        mComputer.setmHd(hd);
    }

    @Override
    public Computer create() {
        return mComputer;
    }
}