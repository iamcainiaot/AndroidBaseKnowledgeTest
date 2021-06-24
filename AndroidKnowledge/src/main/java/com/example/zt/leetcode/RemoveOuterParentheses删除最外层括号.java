package com.example.zt.leetcode;

public class RemoveOuterParentheses删除最外层括号 {
    /*
     * 有效括号字符串为空 ("")、"(" + A + ")" 或 A + B，其中 A 和 B 都是有效的括号字符串，+
     * 代表字符串的连接。例如，""，"()"，"(())()" 和 "(()(()))" 都是有效的括号字符串。
     *
     * 如果有效字符串 S 非空，且不存在将其拆分为 S = A+B 的方法，我们称其为原语（primitive），其中 A 和 B
     * 都是非空有效括号字符串。
     *
     * 给出一个非空有效字符串 S，考虑将其进行原语化分解，使得：S = P_1 + P_2 + ... + P_k，其中 P_i 是有效括号字符串原语。
     * 对 S 进行原语化分解，删除分解中每个原语字符串的最外层括号，返回 S 。
     *
     * 示例 1：
     * 输入："(()())(())" 输出："()()()" 解释： 输入字符串为 "(()())(())"，原语化分解得到 "(()())" +
     * "(())"， 删除每个部分中的最外层括号后得到 "()()" + "()" = "()()()"。 示例 2：
     *
     * 输入："(()())(())(()(()))" 输出："()()()()(())" 解释： 输入字符串为
     * "(()())(())(()(()))"，原语化分解得到 "(()())" + "(())" + "(()(()))"，
     * 删除每隔部分中的最外层括号后得到 "()()" + "()" + "()(())" = "()()()()(())"。 示例 3：
     * 输入："()()" 输出："" 解释： 输入字符串为 "()()"，原语化分解得到 "()" + "()"， 删除每个部分中的最外层括号后得到
     * "" + "" = ""。
     *
     * 提示：
     * S.length <= 10000 S[i] 为 "(" 或 ")" S 是一个有效括号字符串
     */
    public static void main(String[] args) {
        String S = "(())";
        System.out.println(removeOuterParentheses(S));
    }

    /**
     * 思路：1、首先定义count = 0 ，用来计数'('的个数，
     * 2、从左往右遍历，若字符为'('，则count++，若不等于1，才将其添加进StringBuffer
     * 3、若出现')'，则将count-1，
     */
    private static String removeOuterParentheses(String S) {
        StringBuilder sb = new StringBuilder();
        char[] charArray = S.toCharArray();
        int count = 0;
        for (char c : charArray) {
            if (c == '(') {
                count++;
                if (count != 1)
                    sb.append(c);
            } else {
                count--;
                if (count != 0)
                    sb.append(c);
            }
        }
        return sb.toString();
    }
}