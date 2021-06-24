package com.example.zt.leetcode;

public class SortArrayByParity按奇偶排序数组 {
    /*
     * 给定一个非负整数数组 A，返回一个由 A 的所有偶数元素组成的数组，后面跟 A 的所有奇数元素。
     *
     * 你可以返回满足此条件的任何数组作为答案。
     *
     * 示例：
     *
     * 输入：[3,1,2,4] 输出：[2,4,3,1] 输出 [4,2,3,1]，[2,4,1,3] 和 [4,2,1,3] 也会被接受。
     *
     * 提示： 1 <= A.length <= 5000 0 <= A[i] <= 5000
     */

    public static void main(String[] args) {
        int a[] = {3, 1, 2, 4};
        int[] s = sortArrayByParity2(a);
        for (int s1 : s) {
            System.out.println(s1);
        }

    }

    /**
     * int[] N = {1,2,3,4};
     * new[] b = new [N.length];
     * 思路1：对数组遍历两次，偶数先放进去，再放奇数进去
     */
    private static int[] sortArrayByParity(int[] A) {
        int N = A.length;
        int[] ans = new int[N];
        int t = 0;
        for (int x : A) {
            if (x % 2 == 0) {
                ans[t] = x;
                t += 1;
            }
        }
        for (int x : A) {
            if (x % 2 == 1) {
                ans[t] = x;
                t += 1;
            }
        }
        return ans;
    }

    /**
     * 思路2；对数组遍历一次，将数组的偶数往b中放，偶数从前放，奇数从后开始放
     */
    private static int[] sortArrayByParity2(int[] A) {
        int N = A.length;
        int[] b = new int[N];
        int ouCount = 0;
        int jiCount = N - 1;
        for (int x : A) {
            // 是偶数
            if (x % 2 == 0) {
                b[ouCount] = x;
                ouCount++;
            } else {
                // 是奇数
                b[jiCount] = x;
                jiCount--;
            }
        }
        return b;
    }
}