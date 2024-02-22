package com.nykaa.tradeScheme.test;

import java.util.ArrayList;
import java.util.Stack;

public class TreeTraversal {
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

        ArrayList <Integer> preOrder = new ArrayList<>();
        ArrayList <Integer> inOrder = new ArrayList<>();
        ArrayList <Integer> postOrder = new ArrayList<>();
        preOrderTrav(root, preOrder);
        inOrderTrav(root, inOrder);
        postOrderTrav(root, postOrder);

        System.out.println("The preOrder Traversal is : ");
        for (int i = 0; i < preOrder.size(); i++) {
            System.out.print(preOrder.get(i) + " ");
        }
        System.out.println();
        System.out.println("The inOrder Traversal is : ");
        for (int i = 0; i < inOrder.size(); i++) {
            System.out.print(inOrder.get(i) + " ");
        }
        System.out.println();
        System.out.println("The postOrder Traversal is : ");
        for (int i = 0; i < postOrder.size(); i++) {
            System.out.print(postOrder.get(i) + " ");
        }
    }

    private static void preOrderTrav(TreeNode node, ArrayList<Integer> preOrder) {
        if (node == null) {
            return;
        }
        preOrder.add(node.data);
        preOrderTrav(node.left, preOrder);
        preOrderTrav(node.right, preOrder);
        
    }

    private static void inOrderTrav(TreeNode node, ArrayList<Integer> inOrder) {
        if (node == null) {
            return;
        }
        inOrderTrav(node.left, inOrder);
        inOrder.add(node.data);
        inOrderTrav(node.right, inOrder);
    }

    private static void postOrderTrav(TreeNode node, ArrayList<Integer> postOrder) {
        if (node == null) {
            return;
        }
        postOrderTrav(node.left, postOrder);
        postOrderTrav(node.right, postOrder);
        postOrder.add(node.data);
    }
}
