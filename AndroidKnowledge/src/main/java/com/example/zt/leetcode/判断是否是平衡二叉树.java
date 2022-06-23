package com.example.zt.leetcode;

import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 判断是否是平衡二叉树 {

    private static int mCount;

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);

        treeNode1.right = treeNode2;
        treeNode2.right = treeNode3;

        getNode(treeNode1);

        System.out.println(isFlag);
    }


    private static boolean isFlag = true;


    private static int getNode(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        } else {
            int left = getNode(root.left);
            int right = getNode(root.right);
            if (Math.abs(left - right) > 1) {
                System.out.println(" --- 不是平衡二叉树");
                isFlag = false;
                return 0;
            } else {
                return Math.max(left, right) + 1;
            }
        }
    }

}
