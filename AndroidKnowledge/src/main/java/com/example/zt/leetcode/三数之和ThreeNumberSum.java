package com.example.zt.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 三数之和ThreeNumberSum {

    /*
     * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
     * 注意：答案中不可以包含重复的三元组。
     * 示例 1：
     * 输入：nums = [-1,0,1,2,-1,-4]
     * 输出：[[-1,-1,2],[-1,0,1]]
     * 示例 2：
     * 输入：nums = []
     * 输出：[]
     * 示例 3：
     * 输入：nums = [0]
     * 输出：[]
     * 提示：
     * 0 <= nums.length <= 3000
     * -105 <= nums[i] <= 105
     */

    public static void main(String[] args) {

        int[] nums = new int[]{
                -1, 0, 1, 2, -1, -4
        };
        threeSum(nums);
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();

        if (nums.length < 3) {
            return list;
        }
        Arrays.sort(nums);
        int length = nums.length - 2;
        //  -1, 0, 1, 2, -1, -4
        // -4 -1 -1 0 1 2
        for (int i = 0; i < length; i++) {
            if (nums[i] > 0) {
                break;
            }
            // 防止出现   1,1,3 此类数据
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // 取第i个数的相反数，num[i]一定为负数或0，所以flag一定 >=0
            int flag = -nums[i];
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                if (nums[left] + nums[right] == flag) {
                    // 添加数据
                    List<Integer> list1 = new ArrayList<>();
                    list1.add(-flag);
                    list1.add(nums[left]);
                    list1.add(nums[right]);
                    list.add(list1);
                    System.out.println("---- " + list1);
                    left++;
                    right--;
                    while (left < right && nums[left] == nums[left - 1]) left++;
                    while (left < right && nums[right] == nums[right + 1]) right--;
                } else if (nums[left] + nums[right] < flag) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return list;
    }

}