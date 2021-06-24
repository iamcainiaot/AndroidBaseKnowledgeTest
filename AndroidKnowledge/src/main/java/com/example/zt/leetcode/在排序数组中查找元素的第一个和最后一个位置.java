package com.example.zt.leetcode;

public class 在排序数组中查找元素的第一个和最后一个位置 {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 9, 5, 7, 6, 4, 8, 3, 4,};
        int target = 4;
        searchRange(arr, target);
    }

    static int[] searchRange(int[] nums, int target) {
        int[] returnArr = new int[2];
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                int x = left;
                while (nums[x] == target) {
                    returnArr[0] = x;
                    x--;
                }
                int j = left;
                while (nums[j] == target) {
                    returnArr[1] = x;
                    j++;
                }
            } else if (nums[mid] < target) {
                left++;
            } else {
                right--;
            }
        }
        return returnArr;
    }
}