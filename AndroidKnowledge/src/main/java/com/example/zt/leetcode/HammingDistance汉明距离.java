package com.example.zt.leetcode;

public class HammingDistance汉明距离 {
    /*
     * 两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
     * 给出两个整数 x 和 y，计算它们之间的汉明距离。
     * 注意：
     * 0 ≤ x, y < 231.
     * 示例:
     * 输入: x = 1, y = 4
     * 输出: 2
     * 解释:
     * 1   (0 0 0 1)
     * 5   (0 1 0 1)
     * ↑   ↑
     * 上面的箭头指出了对应二进制位不同的位置。
     */
    public static void main(String[] args) {
        hammingDistance(1, 4);
    }

    public static int hammingDistance(int x, int y) {
        // k = 5
        int k = x ^ y;
        System.out.println(k);
        int count = 0;
        while (k != 0) {

            //这儿的｛｝括号，多了会多运行6ms
            if (k % 2 == 1) {
                count++;
            }
            k = k / 2;
        }
        System.out.println(count);
        return count;
    }
}