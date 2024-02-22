package com.nykaa.tradeScheme.test;

public class IdenticalTree {
    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.right.left = new TreeNode(4);
        root1.right.right = new TreeNode(5);

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);
        root2.right.left = new TreeNode(4);

        if (isIdentical(root1, root2))
            System.out.println("Two Trees are identical");
        else System.out.println("Two trees are non-identical");
    }

    private static boolean isIdentical(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        } else if (node1 == null || node2 == null) {
            return false;
        }
        return (node1.data == node2.data) && isIdentical(node1.left, node2.left)
                && isIdentical(node1.right, node2.right);
    }
}
