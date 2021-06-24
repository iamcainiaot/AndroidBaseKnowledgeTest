package com.example.zt.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @user taozhu
 * @date 2020/6/4 11:05
 * @description 尾递归  不死神兔系列
 **/
public class 尾递归 {

    public static void main(String[] args) {
        // 普通递归时间
        //   long timeStart = System.currentTimeMillis();
        //   ss(1, 1, 10);
        //   long timeAfter = System.currentTimeMillis();
        //   long s = (timeAfter - timeStart);
        //   System.out.println("s" + s);

        // 尾递归时间
        // long timeStart = System.currentTimeMillis();
        // ss(1, 1, 10);
        // long timeAfter = System.currentTimeMillis();
        // System.out.println("第一个" + (timeAfter - timeStart));

        // 集合时间
        long startTime = System.currentTimeMillis();
        System.out.println("time1：" + startTime);
        System.out.println(ss(1, 1, 10));
    }

    /**
     * @param lastMonth  上个月的兔子数量
     * @param count      总的兔子数
     * @param monthCount 一共多少个月
     * @return 函数本身
     */
    private static int ss(int lastMonth, int count, int monthCount) {
        if (monthCount == 0) {
            System.out.println("time2：" + System.currentTimeMillis());
            return count;
        }
        return ss(count, count + lastMonth, --monthCount);
    }


    /**
     * 集合比尾递归快
     */
    private static int ss1(int N) {
        if (N < 2) {
            return N;
        } else {
            return ss1(N - 1) + ss1(N - 2);
        }
    }

    /**
     * 集合的方式求斐波那契数列
     *
     * @param a 最大的月份
     * @return 兔子数量
     */
    private static int ss2(int a) {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);
        for (int i = 1; i < a; i++) {
            list.add(list.get(i - 1) + list.get(i));
        }
        return list.get(a);
    }
}