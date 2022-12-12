package com.example.zt.leetcode;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class 算24点 {

    public static void main(String[] args) {

    }


    private boolean get24() {
        List<Integer> set = new ArrayList(4);
        set.add(3);
        set.add(4);
        set.add(1);
        set.add(5);

        HashMap<String, String> map = new HashMap(16);

        calc(map, set);

        return false;
    }

    private void calc(HashMap<String, String> map, List<Integer> list) {
        int first = list.get(0);
        calc(map, first);

    }

    private int index = 1;

    private void calc(HashMap map, Integer integer) {

        index++;
    }
}
