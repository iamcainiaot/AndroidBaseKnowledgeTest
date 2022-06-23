package com.example.zt.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 长度最小的子数组 {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 1, 2, 4, 3};

        minSubArrayLen(7, nums);
    }

    /**
     * 给定一个含有 n 个正整数的数组和一个正整数 target 。
     * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，
     * 并返回其长度。如果不存在符合条件的子数组，返回 0 。
     * 示例 1：
     * 输入：target = 7, nums = [2,3,1,2,4,3]
     * 输出：2
     * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
     * 示例 2：
     * 输入：target = 4, nums = [1,4,4]
     * 输出：1
     * 示例 3：
     * 输入：target = 11, nums = [1,1,1,1,1,1,1,1]
     * 输出：0
     * 提示：
     * 1 <= target <= 109
     * 1 <= nums.length <= 105
     * 1 <= nums[i] <= 105
     */
    public static int minSubArrayLen(int target, int[] nums) {
        // 滑动窗口
        int length = nums.length;
        if (length == 0) {
            return 0;
        }
        int max = 10000000;
        // 窗口开始和结束索引
        int start = 0, end = 0;
        int sum = 0;
        while (end < length) {
            sum += nums[end];
            while (sum >= target) {
                // 索引 0 1 2 3 4  ，length = 1 - 0   + 1
                max = Math.min(max, end - start + 1);
                sum -= nums[start];
                start++;
            }
            end++;
        }
        System.out.println("length : " + max);
        return max == 10000000 ? 0 : max;
    }
}
