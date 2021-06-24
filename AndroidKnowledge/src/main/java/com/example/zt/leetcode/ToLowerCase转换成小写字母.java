package com.example.zt.leetcode;

public class ToLowerCase转换成小写字母 {
    /*
   实现函数 ToLowerCase()，该函数接收一个字符串参数 str，并将该字符串中的大写字母转换成小写字母，之后返回新的字符串。

   示例 1：

   输入: "Hello"
   输出: "hello"
   示例 2：

   输入: "here"
   输出: "here"
   示例 3：

   输入: "LOVELY"
   输出: "lovely"
   */
    public static void main(String[] args) {
        String ch = toLowerCase("LOVELY");
        System.out.println(ch);
    }

    /**
     * 思路：大写字母和小写字母差距为32，即'A' + 32 = 'a'
     */
    private static String toLowerCase(String str) {
        char[] ch = str.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] >= 'A' && ch[i] <= 'Z') {
                ch[i] += 32;
            }

        }
        return new String(ch);
    }
}
