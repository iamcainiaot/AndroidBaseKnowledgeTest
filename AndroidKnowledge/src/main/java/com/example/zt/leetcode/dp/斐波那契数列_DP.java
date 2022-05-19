package com.example.zt.leetcode.dp;

public class 斐波那契数列_DP {

    public static void main(String[] args) {
        System.out.println(getFib(12));
    }

    public static int getFib(int n) {
        if (n == 0) {
            return 0;
        }

        if (n == 1 || n == 2) {
            return 1;
        }
        int result = 0;

        /* 1 1
         * 2 1
         * 3 2
         * 4 3
         * 5 5
         * 6 8
         * 7 13
         * 8 21
         * 9 34
         * 10 55
         * 11 89
         * 12 144
         */
        int front = 0;
        int after = 1;
        // f[i] = f[i] + f[i+1];

        for (int i = 2; i <= n; i++) {
            result = front + after;
            front = after;
            after = result;
        }

        return result;
    }
}
