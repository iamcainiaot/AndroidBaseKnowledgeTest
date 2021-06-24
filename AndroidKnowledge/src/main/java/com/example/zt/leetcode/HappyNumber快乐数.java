package com.example.zt.leetcode;

public class HappyNumber快乐数 {

    public static void main(String[] args) {
        /*
         * 编写一个算法来判断一个数是不是“快乐数”。
         * <p>
         * 一个“快乐数”定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，
         * 然后重复这个过程直到这个数变为 1，也可能是无限循环但始终变不到1。如果可以变为 1，那么这个数就是快乐数。
         * 输入: 19 输出: true
         * 解释: 12 + 92 = 82
         * 82 + 22 = 68
         * 62 + 82 = 100
         * 12 + 02 + 02 = 1
         */
        int n = 32;
        System.out.println(isHappy(n) ? "是快乐数" : "不是快乐数");
    }

    private static boolean isHappy(int n) {
        int fast = n;
        int slow = n;
        do {
            slow = squareSum(slow);
            System.out.print("slow" + slow + "  ");
            fast = squareSum(fast);
            fast = squareSum(fast);
            System.out.println("fast" + fast + "  ");
        } while (slow != fast);
        // 当平方和为1的时候，表示是快乐数
        return fast == 1;
    }

    private static int squareSum(int m) {
        // 平方和
        int squaresum = 0;
        while (m != 0) {
            squaresum += (m % 10) * (m % 10);
            m /= 10;
        }
        return squaresum;
    }

        /*
         * class Solution {
         public boolean isHappy(int n) {
         for(int j=0;j<100;j++){
         int sum=0;
         int i=0;
         while(n>0){
         i=n % 10;
         n=n/10;
         sum+=i*i;
         }
         if(sum==1) return true;
         n=sum;
         }
         return false;
         }
         }
         */
}
