package com.example.zt.leetcode;

/**
 * @user taozhu
 * @date 2020/6/29 9:39
 * @description 实现strStr()方法
 **/
public class ImplementStrStr实现strStr {
    /*
    实现 strStr() 函数。
    给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回 -1。
    示例 1:
    输入: haystack = "hello", needle = "ll"
    输出: 2
    示例 2:
    输入: haystack = "aaaaa", needle = "bba"
    输出: -1
    说明:
    当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
    对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
     */
    public static void main(String[] args) {
        String haystack = "hello";
        String needle = "ll";
        int s = ss(haystack, needle);
        System.out.println("s：" + s);
    }

    private static int ss(String haystack, String needle) {
        int L = needle.length(), n = haystack.length();

        for (int start = 1; start < n - L + 1; start++) {
            if (haystack.substring(start, start + L).equals(needle)) {
                return start;
            }
        }
        return -1;
    }
}

