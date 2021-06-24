package com.example.zt.leetcode;

/**
 * @user taozhu
 * @date 2020/6/24 10:39
 * @description 数字范围按位与
 **/
public class BitwiseANDofNumbersRange数字范围按位与 {
    /*
    给定范围 [m, n]，其中 0 <= m <= n <= 2147483647，返回此范围内所有数字的按位与（包含 m, n 两端点）。

    示例 1:

    输入: [5,7]
    输出: 4
    示例 2:

    输入: [0,1]
    输出: 0
     */
    public static void main(String[] args) {
        int m = 2147483646;
        int n = 2147483647;
        int s = rangeBitwiseAnd(m, n);
        System.out.println("s：" + s);
    }

    /**
     * 按位与
     */
//    private static int rangeBitwiseAnd(int m, int n) {
//        if (m == Integer.MAX_VALUE) {
//            return m;
//        }
//        int s = m;
//        for (int i = m + 1; i <= n; i++) {
//            s &= i;
//            // 这儿 i = m + 1，若m== Integer.MAX_VALUE ，即 m=2147483647的时候，m+1就不是2147483648，而是1000000000000，二进制是100000000000；
//            if (s == 0 || s == Integer.MAX_VALUE) {
//                return 0;
//            }
//        }
//        return s;
//    }

    /**
     * 按位与
     */
    private static int rangeBitwiseAnd(int m, int n) {
        int zeros = 0;
        while (n > m) {
            zeros++;
            // >> 和 >>> 相比，>>是带符号右移，若为正数，右移后高位补0，负数右移后高位补1，>>>则表示无符号右移，高位全部补0
            m >>= 1;
            n >>= 1;
        }
        return m << zeros;
    }
}