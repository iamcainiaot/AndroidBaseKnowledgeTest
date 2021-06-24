package com.example.zt.leetcode;

public class FlippingAnImage翻转图像 {

    /*
     * 给定一个二进制矩阵 A，我们想先水平翻转图像，然后反转图像并返回结果。
     * 水平翻转图片就是将图片的每一行都进行翻转，即逆序。例如，水平翻转 [1, 1, 0] 的结果是 [0, 1, 1]。
     * 反转图片的意思是图片中的 0 全部被 1 替换， 1 全部被 0 替换。例如，反转 [0, 1, 1] 的结果是 [1, 0, 0]。
     *
     * 示例 1:
     * 输入: [[1,1,0],[1,0,1],[0,0,0]] 输出: [[1,0,0],[0,1,0],[1,1,1]] 解释: 首先翻转每一行:
     *
     * [[0,1,1],[1,0,1],[0,0,0]]； 然后反转图片: [[1,0,0],[0,1,0],[1,1,1]]
     *
     * 示例 2:
     * 输入: [[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]] 输出:
     * [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
     *
     * 解释: 首先翻转每一行:
     * [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]]；
     * 然后反转图片:
     * [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
     *
     * 说明:
     * 1 <= A.length = A[0].length <= 20 0 <= A[i][j] <= 1
     */
    public static void main(String[] args) {
        int[][] A = {{1, 1, 1}, {1, 0, 1}, {0, 1, 1}};
        flipAndInvertImage(A);
    }

    private static int[][] flipAndInvertImage(int[][] A) {
        for (int a[] : A) {
            for (int b : a) {
                System.out.print(b);
            }
            System.out.println();
        }
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length / 2; j++) {
                int temp = A[i][j];
                A[i][j] = A[i][A[i].length - j - 1];
                A[i][A[i].length - j - 1] = temp;
            }

            for (int j = 0; j < A[i].length; j++) {
                if (A[i][j] == 1) {
                    A[i][j] = 0;
                } else {
                    A[i][j] = 1;
                }
            }
        }


        return A;

        /*
         * int count = b.length % 2; int lengthCount = b.length / 2; int blength
         * = b.length; if (count == 0) {// 说明个数是整数个数
         * System.out.println("Ssssss"); for (int i = 0; i < lengthCount; i++) {
         * b[i] = b[blength - i];// 数据交换 } } else { System.out.println("sss");
         * for (int i = 0; i < lengthCount; i++) { b[i] = b[blength - i - 1];//
         * 数据交换 } // System.out.print(b); }
         *
         * for (int j = 0; j < blength; j++) { if (b[j] == 0) { b[j] = 1; } else
         * { b[j] = 0; } }
         */
        /*
         * } for (int b[] : a) { for (int i = 0; i < b.length; i++) {
         * System.out.print(b[i]); } System.out.println(); }
         */

    }
}
