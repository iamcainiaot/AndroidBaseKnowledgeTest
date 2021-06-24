package com.example.zt.leetcode;

public class BuddyStrings亲密字符串 {
    /*
        给定两个由小写字母构成的字符串 A 和 B ，只要我们可以通过交换 A 中的两个字母得到与 B 相等的结果，
    就返回 true ；否则返回 false 。

    示例 1：
          输入： A = "ab", B = "ba"
          输出： true
    示例 2：
          输入： A = "ab", B = "ab"
          输出： false
    示例 3:
          输入： A = "aa", B = "aa"
          输出： true
    示例 4：
          输入： A = "aaaaaaabc", B = "aaaaaaacb"
          输出： true
    示例 5：
          输入： A = "", B = "aa"
          输出： false
    提示：
        0 <= A.length <= 20000
        0 <= B.length <= 20000
        A 和 B 仅由小写字母构成。
        charAt : 返回指定索引下的值
     */
    public static void main(String[] args) {
        String A = "aad";
        String B = "aad";
        System.out.println(buddyStrings(A, B));

        /*
         * 这样的写法，是一种语法糖（简化写法）
         */
        int aa[] = {1, 2, 3};
    }

    private static boolean buddyStrings(String A, String B) {
        if (A.length() != B.length()) return false;
        if (A.equals(B)) {
            int[] count = new int[26];
            // 获取每一个字符出现的个数
            for (int i = 0; i < A.length(); ++i) {
                count[A.charAt(i) - 'a']++;
            }
            // 以 add add 为例，若是这样的字符串，可以通过更换后面的d 和d 来实现字符串相同
            for (int c : count) {
                // 目的是 相同的字符串里面，如果有相同的字符，则可以通过调换这相同的字符来实现效果
                if (c > 1) return true;
            }
            return false;
        } else {
            int first = -1, second = -1;
            int count = 1;

            for (int i = 0; i < A.length(); ++i) {
                // 若两个字符串相同索引位置上数据不相等
                if (A.charAt(i) != B.charAt(i)) {
                    // 若存在一个字符不相等，先给first赋值为当前索引
                    //         first = i;
                    //         // 若存在两个字符不相等，则给second赋值为当前索引
                    //     } else if (second == -1) {
                    //         second = i;
                    //         // 若超过两个字符不相等的话，则一定不能通过一次交换实现相同
                    //     } else {
                    //         return false;
                    //     }
                    if (count == 1) {
                        first = count;
                        ++count;
                    } else if (count == 2) {
                        second = count;
                        ++count;
                    } else {
                        return false;
                    }
                }
            }

            if (second == -1) {
                return false;
            }
            // 若第一个字符串的第一个不同位置和第二个字符串的
            return (A.charAt(first) == B.charAt(second) && A.charAt(second) == B.charAt(first));

        }
    }
}