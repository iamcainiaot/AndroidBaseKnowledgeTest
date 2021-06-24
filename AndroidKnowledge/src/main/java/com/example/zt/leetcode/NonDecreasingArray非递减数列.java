package com.example.zt.leetcode;

public class NonDecreasingArray非递减数列 {
    /*
    给定一个长度为 n 的整数数组，你的任务是判断在最多改变 1 个元素的情况下，该数组能否变成一个非递减数列。
    我们是这样定义一个非递减数列的： 对于数组中所有的 i (1 <= i < n)，满足 array[i] <= array[i + 1]。

    示例 1:
    输入: [4,2,3]
    输出: True
    解释: 你可以通过把第一个4变成1来使得它成为一个非递减数列。

    示例 2:
    输入: [4,2,1]
    输出: False
    解释: 你不能在只改变一个元素的情况下将其变为非递减数列。
     */
    public static void main(String[] args) {
        int[] numbs = {3, 4, 2, 3};
        System.out.println(checkPossibility(numbs));
    }

    private static boolean checkPossibility(int[] nums) {
        /**
         *  思路：首先将最前面的第一个、第二个数进行比较
         *  若左边大于右边，则更换方法有：左边变小或者右边变大
         *  若是最前面的两个数，因为左边没数了，所以第一个数变小即可实现目标功能。
         */
        int size = nums.length;
        if (size < 3) {
            return true;
        }
        int count = 0;
        if (nums[0] > nums[1]) {
            nums[0] = nums[1];
            count++;
        }
        for (int i = 1; i < size - 1; i++) {
            /**
             * 若是后面的数据，当左边大于右边的时候，判断count
             * 大于1：返回false
             *
             *   if (left > right) {
             *            nums[i + 1] = nums[i];
             *        } else {
             *            nums[i] = right;
             *        }
             * 小于1：则可以将nums[i]设为num[i-1]
             */
            if (nums[i] > nums[i + 1]) {
                count++;
                if (count > 1) {
                    return false;
                }
                int left = nums[i - 1];
                int right = nums[i + 1];
                if (left > right) {
                    nums[i + 1] = nums[i];
                } else {
                    nums[i] = right;
                }
                // 最后一次比对完成后，需要将该数更换为前一个数
                nums[i] = nums[i - 1];
            }
        }
        return true;


        /**
         *  第一步：对比 第一个数和第二个数
         *  第二步：若第一个数大于第二个数，则将第一个数赋值为第二个数即可（count++）
         *                                    若第一个数小于第二个数则继续
         *  第三步：若还存在前一个数大于后一个数的情况，则直接返回false
         *  第四步：否则，将这个数的左右两数进行比较，若左边大于右边，则更改右边数为该数
         *                                            若右边小于左边，则更改该数为右边数
         *  第五步：
         */


    }
}