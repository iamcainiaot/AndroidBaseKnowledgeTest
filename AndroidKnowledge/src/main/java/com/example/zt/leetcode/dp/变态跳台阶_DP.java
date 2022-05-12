package com.example.zt.leetcode.dp;

public class 变态跳台阶_DP {
    public static void main(String[] args) {
        System.out.println(getFib(5));
    }

    private static int getFib(int n) {
        int[] fib = new int[n];
        /*
         * 0  1  dp[0];
         * 1  1  dp[1];
         * 2  2  dp[2] = dp[1] + dp[0]
         * 3  4  dp[3] = dp[2] + dp[1] + dp[0];
         * 4  8  dp[]
         * f[i] = f[i-1]+f[i-2]+...+f[0];
         * f[i-1] = f[i-2]+f[i-3]+...+f[0];
         *
         */

        // int sum = 1;
        // for (int i = 1; i < n; i++) {
        //     sum = sum * 2;
        // }
        // return sum;

        /*
         * jie xi :
         * 跳上 n-1 级台阶，可以从 n-2 级跳 1 级上去，也可以从 n-3 级跳 2 级上去...，那么
         *
         * f(n-1) = f(n-2) + f(n-3) + ... + f(0)
         * 同样，跳上 n 级台阶，可以从 n-1 级跳 1 级上去，也可以从 n-2 级跳 2 级上去... ，那么
         *
         * f(n) = f(n-1) + f(n-2) + ... + f(0)
         * 综上可得
         *
         * f(n) - f(n-1) = f(n-1)
         * 即
         *
         * f(n) = 2*f(n-1)
         */
        int dp[] = new int[n + 1];

        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                // 1 1 2 4 8
                dp[i] += dp[j - 1];
            }
        }
        return dp[n];
    }

}
