package com.example.zt.leetcode;

public class 平方数之和 {
    /*
     *      给定一个非负整数c，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c。
     *      示例1:
     *      输入: 5
     *      输出: True
     *      解释: 1 * 1 + 2 * 2 = 5
     *      示例2:
     *      输入: 3
     *      输出: False
     */
    public static void main(String[] args) {
        int c = 384;
        boolean flag = judgeSquareSum(c);
        System.out.println(flag);
    }

    /**
     *
     */
    private static boolean judgeSquareSum(int c) {
        int a = 0;
        int b = (int) Math.sqrt(c);
        while (a <= b) {
            if (a * a + b * b == c) {
                System.out.println("a=" + a + "，b=" + b);
                return true;
            } else if (a * a + b * b < c) {
                ++a;
            } else {
                --b;
            }
            if (b <= 0 || a >= c) {
                System.out.println("a=" + a + "，b=" + b);
                return false;
            }
        }
        System.out.println("a=" + a + "，b=" + b);
        return false;
    }
}