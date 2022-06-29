package com.example.zt.leetcode;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.HashMap;

public class 和为k的子数组 {
    @RequiresApi(api = Build.VERSION_CODES.N)
    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 1};
        System.out.println(subarraySum(arr, 2));
    }

    /**
     * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。
     * 示例 1：
     * 输入：nums = [1,1,1], k = 2
     * 输出：2
     * 示例 2：
     * 输入：nums = [1,2,3], k = 3
     * 输出：2
     * 提示：
     * 1 <= nums.length <= 2 * 104
     * -1000 <= nums[i] <= 1000
     * -107 <= k <= 107
     */
    @RequiresApi(api = Build.VERSION_CODES.N)
    public static int subarraySum(int[] nums, int k) {
        int count = 0;
        // 找出前序和
        HashMap<Integer, Integer> map = new HashMap<>(16);
        int frontSum = 0;
        // 这一步一定不能少......不然在 [1,1,2]，k=2，的情况下，会出现 前序和 - K = 0 的情况
        map.put(0, 1);
        for (int num : nums) {
            // 计算前序和   1 2 3 6
            /*
            frontSum = 1
            frontSum = 3
            frontSum = 6
            frontSum = 12
             */
            frontSum += num;
            // 如果其中包含 前序和-k，则加上其出现的次数
            if (map.containsKey(frontSum - k)) {
                count += map.get(frontSum - k);
            }
            // 取出次数，大于0直接加上，否则初始值为1，即出现一次
            map.put(frontSum, map.getOrDefault(frontSum, 0) + 1);
        }
        return count;
    }
}
