package com.nykaa.tradeScheme.test;

import java.util.ArrayList;
import java.util.List;

public class RightLeftViewOfBinaryTree {
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
        List<Integer> leftView = leftView(root);
        System.out.println("The left view is : ");
        for (int i = 0; i < leftView.size(); i++) {
            System.out.print(leftView.get(i) + " ");
        }
        System.out.println();
        List<Integer> rightView = rightView(root);
        System.out.println("The right view is : ");
        for (int i = 0; i < rightView.size(); i++) {
            System.out.print(rightView.get(i) + " ");
        }
    }

    private static List<Integer> rightView(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        rightSideView(root, result, 0);
        return result;
    }

    private static void rightSideView(TreeNode node, List<Integer> result, int depth) {
        if (node == null) {
            return;
        }
        if (depth == result.size()) {
            result.add(node.data);
        }
        rightSideView(node.right, result, depth + 1);
        rightSideView(node.left, result, depth + 1);
    }

    private static List<Integer> leftView(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        leftSideView(root, result, 0);
        return result;
    }

    private static void leftSideView(TreeNode node, List<Integer> result, int depth) {
        if (node == null) {
            return;
        }
        if (depth == result.size()) {
            result.add(node.data);
        }
        leftSideView(node.left, result, depth + 1);
        leftSideView(node.right, result, depth + 1);
        
    }

}
