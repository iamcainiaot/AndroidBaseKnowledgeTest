package com.example.zt.leetcode;

import java.util.Arrays;

public class 两数之和 {
    /*
         给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
         你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
         示例:
         给定 nums = [2, 7, 11, 15], target = 9
         因为 nums[0] + nums[1] = 2 + 7 = 9
         所以返回 [0, 1]
     */
    public static void main(String[] args) {
        int[] nums = new int[]{1, 4, 6, 3};
        int target = 7;
        int[] num = twoSum(nums, target);
        System.out.println(Arrays.toString(num));
    }

    private static int[] twoSum(int[] nums, int target) {
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }
}