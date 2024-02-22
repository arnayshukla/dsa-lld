package com.nykaa.tradeScheme.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


public class BottomAndTopViewOfBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(8);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.right.right.left = new TreeNode(9);
        root.right.right.right = new TreeNode(10);
        List<Integer> bottomView = bottomView(root, 0);
        System.out.println("The bottom view is : ");
        for (int i = 0; i < bottomView.size(); i++) {
            System.out.print(bottomView.get(i) + " ");
        }
        System.out.println();
        List<Integer> topView = topView(root, 0);
        System.out.println("The top view is : ");
        for (int i = 0; i < topView.size(); i++) {
            System.out.print(topView.get(i) + " ");
        }
    }

    private static List<Integer> topView(TreeNode root, int level) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> map = new TreeMap<>();
        topSideView(result, map, root, level);
        for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
            result.add(entry.getValue()); 
        }
        return result; 
    }

    private static void topSideView(List<Integer> result, Map<Integer, Integer> map, TreeNode node, int level) {
        if (node == null) {
            return;
        }
        if (!map.containsKey(level)) {
            map.put(level, node.data);
        }
        topSideView(result, map, node.left, level-1);
        topSideView(result, map, node.right, level+1);
    }

    private static List<Integer> bottomView(TreeNode root, int level) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> map = new TreeMap<>();
        bottomSideView(result, map, root, level);
        for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
            result.add(entry.getValue()); 
        }
        return result; 
    }

    private static void bottomSideView(List<Integer> result, Map<Integer, Integer> map, TreeNode node, int level) {
        if (node == null) {
            return;
        }
        map.put(level, node.data);
        bottomSideView(result, map, node.left, level-1);
        bottomSideView(result, map, node.right, level+1);
    }
}
