package com.nykaa.tradeScheme.test;

public class HeightOfBinaryTree {

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
        int height = findHeight(root);
        System.out.println(height);
    }

    private static int findHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int lh = findHeight(node.left);
        int rh = findHeight(node.right);
        return Math.max(lh, rh) + 1;
    }

}
