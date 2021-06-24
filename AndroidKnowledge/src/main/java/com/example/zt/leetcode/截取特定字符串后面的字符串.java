package com.example.zt.leetcode;

public class 截取特定字符串后面的字符串 {
    public static void main(String[] args) {
        subStringggg();
    }

    public static void subStringggg() {
        String s = "&token=";
        String str = "sfalkenv,neomsren&token=nishgfoxzn";

        char sArr[] = s.toCharArray();
        char strArr[] = str.toCharArray();
        int i = 0;
        int length = strArr.length;
        int j = 0;
        int length2 = sArr.length;
        for (; j < length2; i++) {
            if (i < length) {
                if (strArr[i] == sArr[j]) {
                    j++;
                }
            }
        }
        System.out.println(str.substring(i, length));
        // nishgfoxzn
    }
}
