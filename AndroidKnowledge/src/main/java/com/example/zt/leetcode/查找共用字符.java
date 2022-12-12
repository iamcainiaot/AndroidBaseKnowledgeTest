package com.example.zt.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class 查找共用字符 {

    public static void main(String[] args) {
        String[] strings = new String[]{
                "bella", "label", "roller"
        };
        commonChars(strings);
    }

    public static List<String> commonChars(String[] words) {
        if (words.length == 0) {
            return null;
        }
        // String[] words = new String[3];
        HashMap<Character, Integer> map = new HashMap();
        HashMap<Character, Integer> map2 = new HashMap();

        int count = 0;
        for (String temp : words) {
            for (int i = 0; i < temp.length(); i++) {
                char c = temp.charAt(i);
                if (count == 0) {
                    if (map.containsKey(c)) {
                        map.put(c, map.get(c) + 1);
                    } else {
                        map.put(c, 1);
                    }
                } else {
                    // 对map2同样保存数据
                    if (map2.containsKey(c)) {
                        map2.put(c, map2.get(c) + 1);
                    } else {
                        map2.put(c, 1);
                    }
                }
            }
            // 遍历完成之后，对两个map的每一个key取较小的数据的
            if (count != 0) {
                for (char key : map.keySet()) {
                    int value1 = map.get(key) == null ? 0 : map.get(key);
                    int value2 = map2.get(key) == null ? 0 : map2.get(key);
                    map.put(key, Math.min(value1, value2));
                }
            }
            map2.clear();
            count++;
        }

        List<String> strings = new ArrayList();

        for (char key : map.keySet()) {
            int value = map.get(key);
            for (int i = 0; i < value; i++) {
                strings.add(key + "");
            }

        }
        return strings;
    }

}
