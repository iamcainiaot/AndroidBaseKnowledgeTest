package com.example.zt.leetcode;

public class x的平方根 {
    /*
            实现 int sqrt(int x) 函数。
            计算并返回 x 的平方根，其中 x 是非负整数。
            由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。

            示例 1:
            输入: 4
            输出: 2
            示例 2:
            输入: 8
            输出: 2

            说明: 8 的平方根是 2.82842...,
             由于返回类型是整数，小数部分将被舍去。
            来源：力扣（com.example.zt.leetcode）
            链接：https://com.example.zt.leetcode-cn.com/problems/sqrtx
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static void main(String[] args) {
        int x = 2;
        System.out.println(mySqrt(x));
    }

    /**
     * 执行用时 :　50 ms ,在所有 Java 提交中击败了 6.60% 的用户
     * 内存消耗 : 34.2 MB , 在所有 Java 提交中击败了 75.02% 的用户
     */
    private static int mySqrt(int x) {
        if (x == 1) {
            return 1;
        }
        long s = x / 2;
        long sqrt = 0;
        for (long i = 1; i <= s; i++) {
            long s1 = i * i;
            if (s1 > x) {
                return (int) i - 1;
            } else if (s1 <= x) {
                sqrt = i;
            }
        }
        return (int) sqrt;
    }

    /**
     * 执行用时三毫秒
     * 二分查找法
     */
    private static int mySqrt2(int x) {
        // 注意：针对特殊测试用例，例如 2147395599
        // 要把搜索的范围设置成长整型
        // 为了照顾到 0 把左边界设置为 0
        long left = 0;
        // # 为了照顾到 1 把右边界设置为 x // 2 + 1
        long r = x / 2 + 1;
        while (left < r) {
            // 注意：这里一定取右中位数，如果取左中位数，代码可能会进入死循环
            long mid = left + (r - left + 1) / 2;
            long square = mid * mid;
            if (square > x) {
                r = mid - 1;
            } else {
                left = mid;
            }
        }
        return (int) left;
    }
}