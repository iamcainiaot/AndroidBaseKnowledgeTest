package com.example.zt.leetcode;

import java.util.ArrayList;
import java.util.List;

public class FibonacciNumber斐波那契数 {
    /*
        斐波那契数，通常用 F(n) 表示，形成的序列称为斐波那契数列。该数列由 0 和 1 开始，
        后面的每一项数字都是前面两项数字的和。也就是：
        F(0) = 0,   F(1) = 1
        F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
        给定 N，计算 F(N)。

        示例 1：

        输入：2
        输出：1
        解释：F(2) = F(1) + F(0) = 1 + 0 = 1.
        示例 2：

        输入：3
        输出：2
        解释：F(3) = F(2) + F(1) = 1 + 1 = 2.
        示例 3：

        输入：4
        输出：3
        解释：F(4) = F(3) + F(2) = 2 + 1 = 3.

        1  1  2  3  5  8  13  21  34  55 89  144
      */
    public static void main(String[] args) {
        int s = fib2(11);
        System.out.println(s);
    }

    /**
     * 集合比尾递归快
     */
    static int fib(int N) {
        if (N < 2) {
            return N;
        } else {
            return fib(N - 1) + fib(N - 2);
        }
    }

    /**
     * f3
     * 3  f2    +   1 f1
     * 1 f1
     */
        /*
         // 用集合比直接递归还要快
         */
    static int fib2(int a) {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);
        for (int i = 1; i < a; i++) {
            list.add(list.get(i - 1) + list.get(i));
        }
        return list.get(a);
    }
}
