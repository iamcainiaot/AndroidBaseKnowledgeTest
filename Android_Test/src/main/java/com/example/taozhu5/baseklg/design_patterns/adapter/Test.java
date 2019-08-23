package com.example.taozhu5.baseklg.design_patterns.adapter;

/**
 * @author taozhu5
 * @date 2019/8/20 15:06
 * @description 描述
 */
public class Test {
    /**
     * 对象适配器的测试类
     */
    public void test1() {
        Electric electric = new Electric();
        System.out.println("默认电压：" + electric.output220v());

        // 传递一个对象给适配器
        Adapter phoneAdapter = new PhoneAdapter1(electric);
        System.out.println("适配转换后的电压：" + phoneAdapter.convert5v());
    }

    /**
     * 对象适配器的测试类
     */
    class PhoneAdapter1 implements Adapter {
        /**
         * 适配器持有源目标对象
         */
        private Electric mElectric;

        PhoneAdapter1(Electric electric) {//通过构造方法传入对象
            mElectric = electric;
        }

        @Override
        public int convert5v() {
            System.out.println("适配器开始工作：");
            System.out.println("输入电压：" + mElectric.output220v());
            System.out.println("输出电压：" + 5);
            return 5;
        }
    }
    /*             ------------------------            */
    /*             ------------------------            */
    /*             ------------------------            */
    /*             ------------------------            */

    /**
     * 类适配器的测试类
     */
    public void test() {
        Adapter phoneAdapter = new PhoneAdapter();
        System.out.println("适配转换后的电压：" + phoneAdapter.convert5v());
    }

    /**
     * 类适配器的测试类
     */
    class PhoneAdapter extends Electric implements Adapter {//通过继承源目标类的方式，不持有源目标对象

        @Override
        public int convert5v() {
            System.out.println("适配器开始工作：");
            System.out.println("输入电压：" + output220v());
            System.out.println("输出电压：" + 5);
            return 5;
        }
    }

    /**
     * 适配器接口
     */
    interface Adapter {
        int convert5v();//装换成5V
    }
}