package com.example.taozhu5.baseklg.design_patterns.builder;

/**
 * @author taozhu5
 * @date 2019/8/21 11:09
 * @description 描述
 */
public class Test {
    public void test() {
        //创建建造者实例，（装机人员）
        Builder builder = new ConcreteBuilder();
        //创建指挥者实例，并分配相应的建造者，（老板分配任务）
        // 组装电脑
        builder.buildCPU("i9-9200");
        builder.buildMemory("Kingston");
        builder.buildHd("华硕硬盘");
        builder.create();
    }
}